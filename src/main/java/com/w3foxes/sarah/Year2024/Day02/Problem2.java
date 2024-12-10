package com.w3foxes.sarah.Year2024.Day02;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.w3foxes.sarah.util.FileReaderUtil;

public class Problem2 {
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
            if(isSafeWithProblemDampener(line)){
                total++;
            }
        }

        return total;
    }

    public static boolean isSafeWithProblemDampener(String line){
        String[] values = line.split("\\s+");

        if(isSafe(values)){
            return true;
        }
        // Run through the possibilities, eliminating a different value every time
        for(int i = 0; i < values.length; i++){
            List<String> list = new ArrayList<>(Arrays.asList(values));
            list.remove(i);
            if(isSafe(list.toArray(new String[0]))){
                return true;
            }
            
        }
        return false;
    }

    public static boolean isSafe(String[] values){
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
