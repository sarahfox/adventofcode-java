package com.w3foxes.sarah.Year2023.Day04;

import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Scratchcard {
    private int gameNumber;
    private Set<Integer> winningNumbers = new HashSet<>();
    private Set<Integer> yourNumbers = new HashSet<>();
    private int numCopies = 1;

    Scratchcard(String line) {
        StringTokenizer st = new StringTokenizer(line, ":", false);
        String gameString = st.nextToken();
        String numberString = st.nextToken();

        gameNumber = Integer.parseInt(gameString.replace("Card ", "").trim());

        StringTokenizer st2 = new StringTokenizer(numberString, "|", false);
        String winString = st2.nextToken();
        String yourString = st2.nextToken();

        StringTokenizer st3 = new StringTokenizer(winString, " ", false);
        while (st3.hasMoreTokens()) {
            winningNumbers.add(Integer.parseInt(st3.nextToken()));
        }

        StringTokenizer st4 = new StringTokenizer(yourString, " ", false);
        while (st4.hasMoreTokens()) {
            yourNumbers.add(Integer.parseInt(st4.nextToken()));
        }
    }

    public int getGameNumber() {
        return gameNumber;
    }

    public Set<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public Set<Integer> getYourNumbers() {
        return yourNumbers;
    }

    public int getScore() {
        Set<Integer> intersection = new HashSet<Integer>(yourNumbers); // use the copy constructor
        intersection.retainAll(winningNumbers);

        if(intersection.size() == 0){
            return 0;
        }

        return (int) Math.pow(2, (intersection.size() - 1));
    }

    public int getNumMatches() {
        Set<Integer> intersection = new HashSet<Integer>(yourNumbers); // use the copy constructor
        intersection.retainAll(winningNumbers);

        return intersection.size();
    }

    public void addCopy() {
        numCopies++;
    }

    public int getNumCopies() {
        return numCopies;
    }
}