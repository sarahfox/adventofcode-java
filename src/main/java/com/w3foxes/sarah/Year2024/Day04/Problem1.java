package com.w3foxes.sarah.Year2024.Day04;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.w3foxes.sarah.util.FileReaderUtil;

public class Problem1 {
    private static final String SEARCH_TERM = "XMAS";

    public static void main( String[] args ) throws IOException
    {
        // Find the data file and read it in
        List<String> lines = FileReaderUtil.readLines(Problem1.class, "Problem1.txt");
        
        System.out.println(searchForWord(lines, SEARCH_TERM));
    }

    public static long searchForWord(List<String> lines, String searchTerm){
        long total = 0;

        Pattern stringPattern = Pattern.compile("XMAS");
        Pattern stringPatternBackwards = Pattern.compile("SAMX");
        for(String line : lines){
            Matcher m = stringPattern.matcher(line);
            while(m.find()){
                total++;
            }
            Matcher m2 = stringPatternBackwards.matcher(line);
            while(m2.find()){
                total++;
            }
        }

        // Flip the lines 90 degrees and search again
        List<String> flipped = rotate90(lines);
        for(String line : flipped){
            Matcher m = stringPattern.matcher(line);
            while(m.find()){
                total++;
            }
            Matcher m2 = stringPatternBackwards.matcher(line);
            while(m2.find()){
                total++;
            }
        }

        // Flip the lines diagonally and search again
        List<String> flopped = rotate45(lines);
        for(String line : flopped){
            Matcher m = stringPattern.matcher(line);
            while(m.find()){
                total++;
            }
            Matcher m2 = stringPatternBackwards.matcher(line);
            while(m2.find()){
                total++;
            }
       }

        // Flip the lines diagonally the other way and search again
        List<String> flapped = rotateOther45(lines);
        for(String line : flapped){
            Matcher m = stringPattern.matcher(line);
            while(m.find()){
                total++;
            }
            Matcher m2 = stringPatternBackwards.matcher(line);
            while(m2.find()){
                total++;
            }
        }

        return total;
    }

    private static List<String> rotate90(List<String> lines){
        List<String> flipped = new ArrayList<>();
        List<StringBuffer> buffers = new ArrayList<>();

        for(int j = 0; j < lines.get(0).length(); j++){
            buffers.add(new StringBuffer());
        }

        for(int i = 0; i < lines.size(); i++){
            for(int j = 0; j < lines.get(i).length(); j++){
                buffers.get(j).append(lines.get(i).charAt(j));
            }
        }

        for(StringBuffer sb : buffers){
            flipped.add(sb.toString());
        }

        return flipped;
    }


    private static List<String> rotate45(List<String> lines){
        List<String> flipped = new ArrayList<>();
        List<StringBuffer> buffers = new ArrayList<>();

        for(int j = 0; j < lines.get(0).length() + lines.size(); j++){
            buffers.add(new StringBuffer());
        }

        for(int i = 0; i < lines.size(); i++){
            for(int j = 0; j < lines.get(i).length(); j++){
                buffers.get(j + i).append(lines.get(i).charAt(j));
            }
        }

        for(StringBuffer sb : buffers){
            String str = sb.toString();
            System.out.println(str);
            flipped.add(str);
        }
        

        return flipped;
    }


    private static List<String> rotateOther45(List<String> lines){
        List<String> flipped = new ArrayList<>();
        List<StringBuffer> buffers = new ArrayList<>();
        int lineLength = lines.get(0).length();

        for(int j = 0; j < lineLength + lines.size(); j++){
            buffers.add(new StringBuffer());
        }

        for(int i = 0; i < lines.size(); i++){
            for(int j = 0; j < lines.get(i).length(); j++){
                System.out.println("i: " + i + " j: " + j);
                buffers.get(lineLength - j + i).append(lines.get(i).charAt(j));
            }
        }

        for(StringBuffer sb : buffers){
            String str = sb.toString();
            //System.out.println(str);
            flipped.add(str);
        }
        

        return flipped;
    }

}
