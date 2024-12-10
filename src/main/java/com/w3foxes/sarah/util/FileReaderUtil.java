package com.w3foxes.sarah.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class FileReaderUtil {
    // Files are read from the resource directory of the calling class, so I need to know what that class is.
    public static List<String> readLines(Class clazz, String fileName) throws IOException{
        List<String> lines = new ArrayList<>();

        // Find the data file and read it in
        try (InputStream is = clazz.getResourceAsStream(fileName);
                InputStreamReader isReader = new InputStreamReader(is);
                BufferedReader br = new BufferedReader(isReader);) {

            // Read in the spring data
            for (String line; (line = br.readLine()) != null;) {
                lines.add(line);
            }
        }

        return lines;
    }

    // Files are read from the resource directory of the calling class, so I need to know what that class is.
    // Sometimes the data is a grid, it's just easier to create an array
    public static char[][] readChars(Class clazz, String fileName) throws IOException{
        List<String> lines = readLines(clazz, fileName);
        int lineLength = lines.get(0).length();
        char[][] grid = new char[lines.size()][lineLength];

        for(int i = 0; i < lines.size(); i++){
            String s = lines.get(i);
            s.getChars(0, s.length(), grid[i], 0);
        }

        return grid;
    }

    // Files are read from the resource directory of the calling class, so I need to know what that class is.
    // Sometimes the data is an integer grid, it's just easier to create an array
    public static int[][] readInts(Class clazz, String fileName) throws IOException{
        List<String> lines = readLines(clazz, fileName);
        int lineLength = lines.get(0).length();
        int[][] grid = new int[lines.size()][lineLength];

        for(int i = 0; i < lines.size(); i++){
            String s = lines.get(i);
            for(int j = 0; j < s.length(); j++){
                grid[i][j] = s.charAt(j) - '0';
            }
        }

        return grid;
    }
}
