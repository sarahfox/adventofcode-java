package com.w3foxes.sarah.Year2023.Day01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Trebuchet?!
 * https://adventofcode.com/2023/day/1
 *
 */
public class Problem2 
{
    enum SpelledDigit {
        ONE("one", 1), 
        TWO("two", 2), 
        THREE("three", 3), 
        FOUR("four", 4), 
        FIVE("five", 5), 
        SIX("six", 6), 
        SEVEN("seven", 7), 
        EIGHT("eight", 8), 
        NINE("nine", 9), 
        ZERO("zero", 0);
    
        public String spelling;
        public int value;

        SpelledDigit(String spelling, int value){
            this.spelling = spelling;
            this.value = value;
        }
    }

    public static void main( String[] args ) throws IOException
    {
        long total = 0;

        // Find the data file and read it in
        try(InputStream is = Problem1.class.getResourceAsStream("Problem1Input.txt");
            InputStreamReader isReader = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isReader);){
            
            for(String line; (line = br.readLine()) != null; ) {
                // For each line, find the first and last digit on the line
                int firstDigit = findFirstDigit(line);
                int lastDigit = findLastDigit(line);

        
                // Use the first and last digits to make a 2 digit number.
                 System.out.println(line + "\t" + firstDigit + lastDigit);
        
                // Add up all those numbers and print the result
                total += firstDigit * 10 + lastDigit;
            }
        }

        System.out.println("Total: " + total);
    }

    public static int findFirstDigit(String line){
        int firstDigit = 0;
        int firstDigitIndex = -1;
        boolean foundFirst = false;
        
        // If there's only one digit, the first and last are the same.
        // If there are no digits, the first digit is 0.
        for(int i = 0; i < line.length(); i++){
            if(Character.isDigit(line.charAt(i))){
                int digit = Character.digit(line.charAt(i), 10);
                if(!foundFirst){
                    firstDigit = digit;
                    firstDigitIndex = i;
                }
                foundFirst = true;
            }
        }

        // But digits can be spelled out, so check those, and update the first digit if it's before the numeric first digit
        for(SpelledDigit spelledDigit : SpelledDigit.values()){
            int indexOf = line.indexOf(spelledDigit.spelling);

            if(indexOf >= 0 && indexOf < firstDigitIndex){
                firstDigitIndex = indexOf;
                firstDigit = spelledDigit.value;
            }
        }

        return firstDigit;
    }

    public static int findLastDigit(String line){
        int lastDigit = 0;
        int lastDigitIndex = line.length() + 1;

        // For each line, find the last digit on the line
        for(int i = 0; i < line.length(); i++){
            if(Character.isDigit(line.charAt(i))){
                int digit = Character.digit(line.charAt(i), 10);
                lastDigit = digit;
                lastDigitIndex = i;
            }
        }

        // But digits can be spelled out, so check those, and update the first digit if it's before the numeric first digit
        for(SpelledDigit spelledDigit : SpelledDigit.values()){
            int lastIndexOf = line.lastIndexOf(spelledDigit.spelling);

             if(lastIndexOf >= 0 && lastIndexOf > lastDigitIndex){
                lastDigitIndex = lastIndexOf;
                lastDigit = spelledDigit.value;
            }
        }

        return lastDigit;
    }
}
