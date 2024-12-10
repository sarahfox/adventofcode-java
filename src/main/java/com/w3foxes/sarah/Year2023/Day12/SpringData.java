package com.w3foxes.sarah.Year2023.Day12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SpringData {
    private String springData;
    private List<Integer> checkSums;
    private Map<String, Integer> memo = new HashMap<>();
    
    SpringData(String line) {
        String[] tokens = line.split(" ");
        springData = tokens[0] + "?" + tokens[0] + "?" + tokens[0] + "?" + tokens[0] + "?" + tokens[0];
        checkSums = Arrays.stream(tokens[1].split(",")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> tmp = new ArrayList<>();
        tmp.addAll(checkSums);
        tmp.addAll(checkSums);
        tmp.addAll(checkSums);
        tmp.addAll(checkSums);
        tmp.addAll(checkSums);
        checkSums = tmp;
    }

    public String getSpringData() {
        return springData;
    }

    public List<Integer> getCheckSums() {
        return checkSums;
    }

    public long findNumberOfArrangements() {
        long numberOfArrangements = findNumberOfArrangements(springData, checkSums);

        return numberOfArrangements;
    }

    private long findNumberOfArrangements(String data, List<Integer> sums) {
        // Base case - nothing left in the data, but there are sums left. This is not a
        // solution, return 0.
        if (data.equals("") && sums.size() > 0) {
            return 0;
        }
        // Base case - some bad springs left in the data, but no sums left. This is not
        // a solution, return 0.
        if (data.contains("#") && sums.size() == 0) {
            return 0;
        }
        // Base case - no sums left, but no bad springs left. This is a solution -
        // return 1.
        if (!data.contains("#") && sums.size() == 0) {
            return 1;
        }
        int result = 0;
        // Use the memo first if we've already calculated it
        String memoKey = data + sums;
        if(memo.containsKey(memoKey)){
            return memo.get(memoKey);
        }

        // Inductive case - look at the first character of the data
        // If it's a '.' or '?', go on and search the substring minus the first character
        if (data.charAt(0) == '.' || data.charAt(0) == '?') {
            result += findNumberOfArrangements(data.substring(1), sums);
        }
        // If it's a '#' or '?', looks at the first item on the sums list.
        if (data.charAt(0) == '#' || data.charAt(0) == '?') {
            int firstCheckSum = sums.get(0);
            // Bad case - we've still got checksums, but not enough string left to satisfy it.
            if(firstCheckSum > data.length()){
                return 0;
            }

            // If there are enough '#' and '?' spaces to make up that sum, plus a '.' on the
            // end, remove that sum from the list, and continue searching from
            // data.substring(sums[0] + 1)
            boolean passed = true;
            for (int i = 0; i < firstCheckSum; i++) {
                if (data.charAt(i) == '.') {
                    passed = false;
                }
            }
            // Are we at the end of the data, or is there space for a . at the end?
            if (data.length() > firstCheckSum && data.charAt(firstCheckSum) == '#') {
                passed = false;
            }

            if(passed){
                String nextToSearch;
                if(data.length() > firstCheckSum){
                    // Remove the trailing . if there's enough room
                    nextToSearch = data.substring(firstCheckSum + 1);
                }
                else {
                    nextToSearch = data.substring(firstCheckSum);
                }
                result += findNumberOfArrangements(nextToSearch, sums.subList(1, sums.size()));
            }
            // If we're on a ?, we're already doing the search for the substring - 1 on the other branch, don't do it here
            // If we are starting with a #, but there's not enough to make up the next checksum, this is a bad solution
            // Don't try to recurse further, just return the result we may have calculated for other branches already
        }

        memo.put(memoKey, result);

        return result;
    }
}
