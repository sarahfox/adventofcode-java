package com.w3foxes.sarah.Year2023.Day04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Problem2 {
    /**
     * Scratchcards
     * https://adventofcode.com/2023/day/4
     *
     */
    public static void main(String[] args) throws IOException {
        long total = 0;
        Map<Integer, Scratchcard> cards = new HashMap<>();

        // Find the data file and read it in
        try (InputStream is = Problem1.class.getResourceAsStream("Problem1Input.txt");
                InputStreamReader isReader = new InputStreamReader(is);
                BufferedReader br = new BufferedReader(isReader);) {

            // Read in the list of scratchcards
            for (String line; (line = br.readLine()) != null;) {
                Scratchcard s = new Scratchcard(line);
                cards.put(s.getGameNumber(), s);
            }
        }

        playGame(cards);

        for(Scratchcard card : cards.values()){
            total += card.getNumCopies();
        }
        
        System.out.println("Total: " + total);
    }

    public static void playGame(Map<Integer, Scratchcard> cards) {
        // Go through the list of cards
        for (int i = 1; i <= cards.size(); i++) {
            // For each copy of the card, see how many matches there are
            Scratchcard card = cards.get(i);
            for (int j = card.getNumCopies(); j > 0; j--) {
                // Add a copy to the next <number of matches> cards
                int numMatches = card.getNumMatches();
                for (int k = 1; k <= numMatches; k++) {
                    cards.get(i + k).addCopy();
                }
            }
        }
    }
}
