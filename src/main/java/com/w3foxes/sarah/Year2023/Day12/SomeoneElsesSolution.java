package com.w3foxes.sarah.Year2023.Day12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class SomeoneElsesSolution {
	
	static final boolean test = false;

	public static void main(String[] args) throws IOException {
        List<String> lines = new ArrayList<>();
        try (InputStream is = Problem1.class.getResourceAsStream("Problem1Input.txt");
                InputStreamReader isReader = new InputStreamReader(is);
                BufferedReader br = new BufferedReader(isReader);) {

            // Read in the spring data
            for (String line; (line = br.readLine()) != null;) {
                lines.add(line);
            }
        }

        partOne(lines);
		partTwo(lines);
	}

	static void partOne(List<String> lines) {
		int sum = 0;
		for (String line: lines) {
			String pattern = parsePattern(line);
			int[] rule = parseRules(line);
			sum += countPatterns(pattern, rule);
		}
		System.out.println(sum);
	}

	static void partTwo(List<String> lines) {
		long sum = 0;
		for (String line: lines) {
			String pattern = unfoldPattern(parsePattern(line));
			int[] rule = unfoldRules(parseRules(line));
		
			sum += countPatterns(pattern, rule);
		}
		
		System.out.println(sum);
	}
	
	static long countPatterns(String pattern, int[] rule) {
		return countPatterns(0, 0, 0, pattern, rule, new HashMap<List<Integer>, Long>());
	}
	
	static long countPatterns(int i, int j, int r, String pattern, int[] rule, HashMap<List<Integer>, Long> memo) {
		if (j == pattern.length()) {
			if (i == j && rule.length == r) {
				return 1;
			}
			if (rule.length - 1 == r && j - i == rule[r]) {
				return 1;
			}
			return 0;
		}
		if (i >= pattern.length() || j >= pattern.length() || r > rule.length) {
			return 0;
		}
		
		List<Integer> pos = new ArrayList<Integer>();
		pos.add(i);
		pos.add(j);
		pos.add(r);
		if (memo.containsKey(pos)) {
			return memo.get(pos);
		}
		
		char c = pattern.charAt(j);
		if (c == '#') {
			long result = countPatterns(i, j + 1, r, pattern, rule, memo);
			memo.put(pos, result);
			return result;
		}
		if (c == '.') {
			if (i != j) {
				if (r == rule.length || rule[r] != j - i) {
					return 0;
				}
				i = j;
				r++;
			}
			long result = countPatterns(i + 1, j + 1, r, pattern, rule, memo);
			memo.put(pos, result);
			return result;
		}
		
		long result = countPatterns(i, j + 1, r, pattern, rule, memo);
		if (i != j) {
			if (r == rule.length || rule[r] != j - i) {
				memo.put(pos, result);
				return result;
			}
			i = j;
			r++;
		}
		result += countPatterns(i + 1, j + 1, r, pattern, rule, memo);
		memo.put(pos, result);
		return result;
	}
	
	static int[] parseRules(String line) {
		String pattern[] = line.split(" ", 2)[1].split(","); 
		return Arrays.stream(pattern).mapToInt(Integer::parseInt).toArray();
	}
	
	static String parsePattern(String line) {
		return line.split(" ", 2)[0];
	}

	static String unfoldPattern(String pattern) {
		int i = pattern.length();
		for (int j = 0; j < 4; j++) {
			pattern += "?" + pattern.substring(0, i);
		}
		return pattern;
	}
	
	static int[] unfoldRules(int[] rules) {
		int[] unfolded = new int[rules.length * 5];
		for (int i = 0; i < unfolded.length; i++) {
			unfolded[i] = rules[i%rules.length];
		}
		return unfolded;
	}
}