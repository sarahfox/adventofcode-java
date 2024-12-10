package com.w3foxes.sarah.Year2023.Day15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Problem1 {

    /**
     * Lens Library
     * https://adventofcode.com/2023/day/15
     */
    public static void main(String[] args) throws IOException {
        String[] lines = null;

        // Find the data file and read it in
        try (InputStream is = Problem1.class.getResourceAsStream("Problem1Input.txt");
                InputStreamReader isReader = new InputStreamReader(is);
                BufferedReader br = new BufferedReader(isReader);) {

            // Read in the spring data
            for (String line; (line = br.readLine()) != null;) {
                lines = line.split(",");
            }
        }

        long sum = Arrays.stream(lines).mapToLong(Problem1::hashString).reduce(Long::sum).getAsLong();

        System.out.println("HASH: " + sum);

        List<Map<String, String>> boxes = processCommands(lines);
        System.out.println("Sum focal lengths: " + sumFocalLengths(boxes));
    }

    public static List<Map<String, String>> processCommands(String[] lines) {
        // Initialize the list of boxes. There should be 256, one for each possible hash
        // value
        List<Map<String, String>> boxes = new ArrayList<>();
        for (int i = 0; i < 256; i++) {
            boxes.add(new LinkedHashMap<>());
        }

        // Go through all the lines
        for (int i = 0; i < lines.length; i++) {
            // Each command starts with a string that hashes to the box number
            String[] commands = lines[i].splitWithDelimiters("[=-]", 0);
            System.out.println(Arrays.toString(commands));
            String boxName = commands[0];
            String boxOperation = commands[1];
            int boxNumber = hashString(boxName);
            Map<String, String> box = boxes.get(boxNumber);

            // Then if the next character is an =, put the following number into the given
            // box, with the string label
            if (boxOperation.equals("=")) {
                box.put(boxName, commands[2]);
            }
            // If the next character is a -, remove the label from the given box
            else if (boxOperation.equals("-")) {
                box.remove(boxName);
            }
        }

        return boxes;
    }

    public static long sumFocalLengths(List<Map<String, String>> boxes) {
        long sumFocalLengths = 0;

        for (int i = 0; i < boxes.size(); i++) {
            Map<String, String> box = boxes.get(i);
            int j = 1;
            for (String value : box.values()) {
                int focalLength = Integer.parseInt(value);
                sumFocalLengths += ((i + 1) * j * focalLength);
                j++;
            }
        }

        return sumFocalLengths;
    }

    public static int hashString(String toHash) {
        int currentValue = 0;

        for (int i = 0; i < toHash.length(); i++) {
            currentValue += (int) toHash.charAt(i);
            currentValue *= 17;
            currentValue %= 256;
        }
        return currentValue;
    }
}
