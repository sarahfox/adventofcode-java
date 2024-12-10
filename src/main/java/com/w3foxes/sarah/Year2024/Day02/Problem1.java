package com.w3foxes.sarah.Year2024.Day02;

import java.io.IOException;
import java.util.List;

import com.w3foxes.sarah.util.FileReaderUtil;

public class Problem1 {
    private static final long UNSAFE_LIMIT = 3l;

        public static void main( String[] args ) throws IOException
    {
        // Find the data file and read it in
        List<String> lines = FileReaderUtil.readLines(Problem1.class, "Problem1.txt");
        
        long total = countSafeLines(lines);
        System.out.println("Total: " + total);
    }

    public static long countSafeLines(List<String> lines){
        long total = 0;

        for(String line : lines){
            if(isSafe(line)){
                total++;
            }
        }

        return total;
    }

    public static boolean isSafe(String line){
        String[] values = line.split("\\s+");
        long lastValue = -1;
        Boolean isDescending = null;
        for(String value : values){
            long currentValue = Long.parseLong(value);
            if(lastValue == -1){
                lastValue = currentValue;
                continue;
            }
            if(Math.abs(lastValue - currentValue) > UNSAFE_LIMIT || Math.abs(lastValue - currentValue) == 0){
                //System.out.println("A");
                return false;
            }
            // First pair of numbers, set isDescending
            if(isDescending == null){
                if(currentValue > lastValue){
                    isDescending = Boolean.FALSE;
                }
                else {
                    isDescending = Boolean.TRUE;
                }
            }
            // Check if we are continuing to descend or ascend
            else {
                if(currentValue < lastValue && !isDescending){
                    //System.out.println("B cur: " + currentValue + " last: " + lastValue + " isDecs: " + isDescending);
                    return false;
                }
                else if(currentValue > lastValue && isDescending){
                    //System.out.println("C");
                    return false;
                }
            }
            lastValue = currentValue;
        }

        return true;
    }
}
