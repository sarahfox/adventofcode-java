package com.w3foxes.sarah.Year2023.Day13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class SomeoneElsesSolution {
    public static void main(String[] args)  throws IOException {
        List<String> input = new ArrayList<>();
        try (InputStream is = SomeoneElsesSolution.class.getResourceAsStream("Problem1Input.txt");
                InputStreamReader isReader = new InputStreamReader(is);
                BufferedReader br = new BufferedReader(isReader);) {
                    for (String line; (line = br.readLine()) != null;) {
                        input.add(line);
                    }
        }

        part1(input);
        part2(input);
    }

    public static void part1(List<String> input) {
        System.out.println("Part 1:");
        List<Reflector> reflectors = Reflector.parseList(input);
        System.out.println(Reflector.computeResult(reflectors));
    }

    public static void part2(List<String> input) {
        System.out.println("Part 2:");
        List<Reflector> reflectors = SmudgedReflector.parseList(input);
        System.out.println(Reflector.computeResult(reflectors));
    }

} 
