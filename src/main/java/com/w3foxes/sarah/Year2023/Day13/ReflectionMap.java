package com.w3foxes.sarah.Year2023.Day13;

import java.util.ArrayList;
import java.util.List;

public class ReflectionMap {
    List<String> lines = new ArrayList<>();
    List<StringBuffer> pivoting = new ArrayList<>();
    List<String> pivoted = new ArrayList<>();

    public void readLine(String line) {
        lines.add(line);

        // Initialize the pivoting list, if needed
        if (pivoting.size() == 0) {
            for (int i = 0; i < line.length(); i++) {
                pivoting.add(new StringBuffer());
            }
        }
        for (int i = 0; i < line.length(); i++) {
            pivoting.get(i).append(line.charAt(i));
        }
    }

    public long findReflection() {
        // Could be both vertical and horizontal reflections, add them up
        long horizonalReflectionIndex = findReflectionIndexHorizontal();
        long verticalReflectionIndex = findReflectionIndexVertical();

        return verticalReflectionIndex + (100 * horizonalReflectionIndex);
    }

    private long findReflectionIndexHorizontal() {
        // Look for a pair of lines that are the same
        for (int i = 1; i < lines.size(); i++) {
            if (lines.get(i).equals(lines.get(i - 1))) {
                int downIndex = i - 2;
                int upIndex = i + 1;
                boolean stillReflecting = true;
                // Once found, go back and forward till you reach the end of the array and see
                // if the reflections match
                while (downIndex >= 0 && upIndex < lines.size() && stillReflecting) {
                    if (lines.get(downIndex).equals(lines.get(upIndex))) {
                        downIndex--;
                        upIndex++;
                    } else {
                        stillReflecting = false;
                    }
                }

                // If we walk off the end, it's a match
                if (stillReflecting) {
                    return i;
                }
            }
        }

        // Not found, call it 0
        return 0;
    }

    private long findReflectionIndexVertical() {
        // Ok, if I just do lines.get(0...n).charAt(0...m) I am going to be doing a
        // whole bunch of list retrievals, which isn't going to be very efficient.
        // I think it would be better to pivot the data when it's read in, and then only
        // have to do that pass once.

        // Done reading in data at this point, finish the pivot
        if (pivoted.size() == 0) {
            for (int i = 0; i < pivoting.size(); i++) {
                pivoted.add(pivoting.get(i).toString());
            }
        }

        // Now the logic should be exactly the same as for the horizontal, just using
        // the pivoted list
        // Look for a pair of lines that are the same
        for (int i = 1; i < pivoted.size(); i++) {
            if (pivoted.get(i).equals(pivoted.get(i - 1))) {
                int downIndex = i - 2;
                int upIndex = i + 1;
                boolean stillReflecting = true;
                // Once found, go back and forward till you reach the end of the array and see
                // if the reflections match
                while (downIndex >= 0 && upIndex < pivoted.size() && stillReflecting) {
                    if (pivoted.get(downIndex).equals(pivoted.get(upIndex))) {
                        downIndex--;
                        upIndex++;
                    } else {
                        stillReflecting = false;
                    }
                }

                // If we walk off the end, it's a match
                if (stillReflecting) {
                    return i;
                }
            }
        }

        // Not found, call it 0
        return 0;
    }

    public long findSmudgedReflection() {
        // Could be both vertical and horizontal reflections, add them up
        long horizonalReflectionIndex = findSmudgedReflectionIndexHorizontal();
        long verticalReflectionIndex = findSmudgedReflectionIndexVertical();

        return verticalReflectionIndex + (100 * horizonalReflectionIndex);
    }

    // Should be one and only one smudge
    private boolean smudgedMatch(String s1, String s2) {
        int smudgeCount = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                smudgeCount++;
            }
        }

        return smudgeCount == 1;
    }

    private long findSmudgedReflectionIndexHorizontal() {
        // Look for a pair of lines that are the same
        for (int i = 1; i < lines.size(); i++) {
            if (lines.get(i).equals(lines.get(i - 1)) || smudgedMatch(lines.get(i), lines.get(i - 1))) {
                int downIndex = i - 2;
                int upIndex = i + 1;
                int smudgeCount = lines.get(i).equals(lines.get(i - 1)) ? 0 : 1;
                boolean stillReflecting = true;
                // Once found, go back and forward till you reach the end of the array and see
                // if the reflections match
                while (downIndex >= 0 && upIndex < lines.size() && stillReflecting) {
                    if (lines.get(downIndex).equals(lines.get(upIndex))) {
                        downIndex--;
                        upIndex++;
                    } else if (smudgedMatch(lines.get(downIndex), lines.get(upIndex))) {
                        smudgeCount++;
                        downIndex--;
                        upIndex++;
                    } else {
                        stillReflecting = false;
                    }
                }

                // If we walk off the end, it's a match
                if (stillReflecting && smudgeCount == 1) {
                    return i;
                }
            }
        }

        // Not found, call it 0
        return 0;
    }

    private long findSmudgedReflectionIndexVertical() {
        // Ok, if I just do lines.get(0...n).charAt(0...m) I am going to be doing a
        // whole bunch of list retrievals, which isn't going to be very efficient.
        // I think it would be better to pivot the data when it's read in, and then only
        // have to do that pass once.

        // Done reading in data at this point, finish the pivot
        if (pivoted.size() == 0) {
            for (int i = 0; i < pivoting.size(); i++) {
                pivoted.add(pivoting.get(i).toString());
            }
        }

        // Now the logic should be exactly the same as for the horizontal, just using
        // the pivoted list
        // Look for a pair of lines that are the same
        for (int i = 1; i < pivoted.size(); i++) {
            if (pivoted.get(i).equals(pivoted.get(i - 1)) || smudgedMatch(pivoted.get(i), pivoted.get(i - 1))) {
                int downIndex = i - 2;
                int upIndex = i + 1;
                int smudgeCount = pivoted.get(i).equals(pivoted.get(i - 1)) ? 0 : 1;
                boolean stillReflecting = true;
                // Once found, go back and forward till you reach the end of the array and see
                // if the reflections match
                while (downIndex >= 0 && upIndex < pivoted.size() && stillReflecting) {
                    if (pivoted.get(downIndex).equals(pivoted.get(upIndex))) {
                        downIndex--;
                        upIndex++;
                    } else if (smudgedMatch(pivoted.get(downIndex), pivoted.get(upIndex))) {
                        smudgeCount++;
                        downIndex--;
                        upIndex++;
                    } else {
                        stillReflecting = false;
                    }
                }

                // If we walk off the end, it's a match
                if (stillReflecting && smudgeCount == 1) {
                    return i;
                }
            }
        }

        // Not found, call it 0
        return 0;
    }
}
