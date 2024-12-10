package com.w3foxes.sarah.Year2023.Day07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Problem1 {
    /**
     * Camel Cards
     * https://adventofcode.com/2023/day/7
     *
     */
    public static void main(String[] args) throws IOException {
        List<HandAndBid> hands = new ArrayList<>();
        long total = 0;

        // Find the data file and read it in
        try (InputStream is = Problem1.class.getResourceAsStream("Problem1Input.txt");
                InputStreamReader isReader = new InputStreamReader(is);
                BufferedReader br = new BufferedReader(isReader);) {

            // Read in the race data
            for (String line; (line = br.readLine()) != null;) {
                hands.add(new HandAndBid(line));
            }
        }

        Collections.sort(hands, new SortByHand());
        Collections.reverse(hands);

        for(int i = 0; i < hands.size(); i++){
            HandAndBid h = hands.get(i);
            System.out.println("Rank: " + i + " Hand: " + h.getHand().toString());
            total += (i + 1) * h.getBid();
        }

        System.out.println("Total: " + total);
    }   
    
    // Helper class extending Comparator interface
    static class SortByHand implements Comparator<HandAndBid> {
        // Used for sorting by hand type, and then by cards in the hand
        public int compare(HandAndBid a, HandAndBid b)
        {
            if(a.getHand().getHandType() != b.getHand().getHandType()){
                return a.getHand().getHandType().compareTo(b.getHand().getHandType());
            }

            for(int i = 0; i < a.getHand().getHandSize(); i++){
                if(a.getHand().getCardAt(i) == b.getHand().getCardAt(i)){
                    continue;
                }
                return a.getHand().getCardAt(i).compareTo(b.getHand().getCardAt(i));
            }

            return 0;
        }
    }

}
