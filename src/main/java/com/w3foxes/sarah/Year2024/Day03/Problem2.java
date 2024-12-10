package com.w3foxes.sarah.Year2024.Day03;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.w3foxes.sarah.util.FileReaderUtil;

public class Problem2 {
            public static void main( String[] args ) throws IOException
    {
        // Find the data file and read it in
        List<String> lines = FileReaderUtil.readLines(Problem1.class, "Problem1.txt");
        String line = String.join("", lines);

        List<String> mulLines = findEnabledMulLines(line);

        System.out.println(multiplyValues(mulLines));
    }

    // So we need to find only the ones that are enabled
    // The first one is enabled by default
    // A don't() instruction disables until a do() is encountered
    public static List<String> findEnabledMulLines(String line){
        List<String> mulLines = new ArrayList<>();
        Pattern stringPattern = Pattern.compile("mul\\(\\d{1,3},\\d{1,3}\\)|don\\'t\\(\\)|do\\(\\)");
        Matcher m = stringPattern.matcher(line);
        boolean enabled = true;
        while(m.find()){
            String mul = m.group();
            if(mul.startsWith("mul") && enabled){
                mulLines.add(mul);
            }
            else if(mul.equals("don't()")){
                enabled = false;
            }
            else if(mul.equals("do()")){
                enabled = true;
            }
            System.out.println(mul);
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
