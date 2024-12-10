package com.w3foxes.sarah.Year2024.Day07;

import java.io.IOException;
import java.util.List;

import com.w3foxes.sarah.util.FileReaderUtil;

public class Problem1 {
    
    public static void main( String[] args ) throws IOException
    {
        // Find the data file and read it in
        List<String> lines = FileReaderUtil.readLines(Problem1.class, "Problem1.txt");
        long total = 0;

        for(String s : lines){
            total += canBeSolved(s);
        }
        System.out.println(total);
    }

    public static long canBeSolved(String line){
        // Parse the arguments
        String[] arguments = line.split(":");
        long answer = Long.parseLong(arguments[0]);
        // System.out.println("answer: " + answer);
        // System.out.println("remaining args: " + arguments[1]);
        String[] operandStrs = arguments[1].trim().split("\\s+");
        long[] operands = new long[operandStrs.length];
        for(int i = 0; i < operandStrs.length; i++){
            // System.out.println("Parsing: " + operandStrs[i]);
            operands[i] = Long.parseLong(operandStrs[i]);
        }

        // Try every possible combo of + and *
        long initial = operands[0];
        long[] lessRemaining = new long[operands.length - 1];
        System.arraycopy(operands,1,lessRemaining,0,operands.length - 1);

        if(canBeSolvedRecursively(answer, initial, lessRemaining)){
            return answer;
        }
        else {
            return 0l;
        }
    }

    public static boolean canBeSolvedRecursively(long answer, long intermediate, long[] remaining){
        if(remaining.length == 0){
            return intermediate == answer;
        }

        long add = intermediate + remaining[0];
        long multiply = intermediate * remaining[0];
        long[] lessRemaining = new long[remaining.length - 1];
        System.arraycopy(remaining,1,lessRemaining,0,remaining.length - 1);

        return canBeSolvedRecursively(answer, add, lessRemaining) || canBeSolvedRecursively(answer, multiply, lessRemaining);
    }
}
