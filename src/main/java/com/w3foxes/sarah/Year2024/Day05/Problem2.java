package com.w3foxes.sarah.Year2024.Day05;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.w3foxes.sarah.util.FileReaderUtil;

public class Problem2 {
        public static void main( String[] args ) throws IOException
    {
        // Find the data file and read it in
        List<String> lines = FileReaderUtil.readLines(Problem1.class, "Problem1.txt");
        
        System.out.println(addInvalidCenters(lines));
    }

    public static long addInvalidCenters(List<String> lines){
        long total = 0;
        
        Map<Integer, List<Integer>> rules = parseRules(lines);
        List<List<Integer>> updates = parseUpdates(lines);

        for(List<Integer> update : updates){
            if(!isValidUpdate(update, rules)){
                update = repairUpdate(update, rules);
                total += findCenter(update);
            }
        }
        return total;
    }

    public static List<Integer> repairUpdate(List<Integer> update, Map<Integer, List<Integer>> rules){
        List<Integer> repaired = new ArrayList<>();

        for(Integer updatePage : update){
            int offset = 0;
            do {
                repaired.remove(updatePage);
                repaired.add(repaired.size() - offset, updatePage);
                offset++;
            } while(!isValidUpdate(repaired, rules));
        }
        return repaired;
    }

    public static boolean isValidUpdate(List<Integer> update, Map<Integer, List<Integer>> rules){
        // Walk through the update
        for(int i = 0; i < update.size(); i++){
            Integer pageNum = update.get(i);

            // Find any rules that apply to each page
            if(rules.containsKey(pageNum)){
                // If there are rules, walk through the rules.
                List<Integer> pageRules = rules.get(pageNum);
                for(Integer blah : pageRules){
                    // Check the indexes of each page in the rules.  If it's before the current index, it's an invalid update.
                    if(update.indexOf(blah) >= 0 && update.indexOf(blah) < i){
                            return false;
                        }
                    }
            }
        }

        return true;
    }

    public static List<List<Integer>> parseUpdates(List<String> lines){
        List<List<Integer>> updates = new ArrayList<>();

        for(String line : lines){
            if(line.isBlank() || line.contains("|")){
                continue;
            }

            String[] bits = line.split(",");
            List<Integer> update = new ArrayList<>();
            for(String bit : bits){
                Integer page = Integer.parseInt(bit);
                update.add(page);
            }
            updates.add(update);
        }

        return updates;
    }

    public static Map<Integer, List<Integer>> parseRules(List<String> lines){
        Map<Integer, List<Integer>> rules = new HashMap<>();

        for(String line : lines){
            if(line.isBlank()){
                break;
            }
            String[] pieces = line.split("\\|");
            Integer before = Integer.parseInt(pieces[0]);
            Integer after = Integer.parseInt(pieces[1]);
            List<Integer> r = rules.getOrDefault(before, new ArrayList<>());
            r.add(after);
            rules.put(before, r);
        }

        return rules;
    }

    public static long findCenter(List<Integer> update){
        return update.get(update.size() / 2);
    }
}
