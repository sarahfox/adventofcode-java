package com.w3foxes.sarah.Year2024.Day03;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.w3foxes.sarah.util.FileReaderUtil;

public class Problem1 {
    
        public static void main( String[] args ) throws IOException
    {
        // Find the data file and read it in
        List<String> lines = FileReaderUtil.readLines(Problem1.class, "Problem1.txt");
        
        List<String> mulLines = findMulLines(lines);

        System.out.println(multiplyValues(mulLines));
    }

    public static List<String> findMulLines(List<String> lines){
        List<String> mulLines = new ArrayList<>();
        Pattern stringPattern = Pattern.compile("mul\\(\\d{1,3},\\d{1,3}\\)");

        for(String line : lines){
            Matcher m = stringPattern.matcher(line);
            while(m.find()){
                String mul = m.group();
                System.out.println(mul);
                mulLines.add(mul);
            }
        }
        return mulLines;
    }

    public static long multiplyValues(List<String> mulLines){
        long total = 0;
        Pattern digitPattern = Pattern.compile("\\d{1,3}");

        for(String line : mulLines){
            Matcher m = digitPattern.matcher(line);
            m.find();
            long d1 = Long.parseLong(m.group());
            m.find();
            long d2 = Long.parseLong(m.group());
            total += d1 * d2;
        }

        return total;
    }
}
