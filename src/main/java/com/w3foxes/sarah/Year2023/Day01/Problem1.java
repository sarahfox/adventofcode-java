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
public class Problem1 
{
    public static void main( String[] args ) throws IOException
    {
        long total = 0;

        // Find the data file and read it in
        try(InputStream is = Problem1.class.getResourceAsStream("Problem1Input.txt");
            InputStreamReader isReader = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isReader);){
            
            for(String line; (line = br.readLine()) != null; ) {
                int firstDigit = 0;
                int lastDigit = 0;
                boolean foundFirst = false;

        
            // For each line, find the first and last digit on the line
            // If there's only one digit, the first and last are the same.
            // Use the first and last digits to make a 2 digit number.
                for(int i = 0; i < line.length(); i++){
                    if(Character.isDigit(line.charAt(i))){
                        if(!foundFirst){
                            firstDigit = Character.digit(line.charAt(i), 10);
                        }
                        lastDigit = Character.digit(line.charAt(i), 10);
                        foundFirst = true;
                    }
                }
                System.out.println(line + "\t" + firstDigit + lastDigit);
        
                // Add up all those numbers and print the result
                total += firstDigit * 10 + lastDigit;
            }
        }

        System.out.println("Total: " + total);
    }
}
