package com.w3foxes.sarah.Year2024.Day05;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class Problem1Test {

    @Test
    public void testSimpleExample() {
        List<String> lines = Arrays.asList("47|53",
                "75|29",
                "75|53",
                "29|13",
                "",
                "75,29,13");

        assertEquals(29, Problem1.addValidCenters(lines));
    }

    @Test
    public void testExample() {
        List<String> lines = Arrays.asList("47|53",
                "97|13",
                "97|61",
                "97|47",
                "75|29",
                "61|13",
                "75|53",
                "29|13",
                "97|29",
                "53|29",
                "61|53",
                "97|53",
                "61|29",
                "47|13",
                "75|47",
                "97|75",
                "47|61",
                "75|61",
                "47|29",
                "75|13",
                "53|13",
                "",
                "75,47,61,53,29",
                "97,61,53,29,13",
                "75,29,13",
                "75,97,47,61,53",
                "61,13,29",
                "97,13,75,29,47");

        assertEquals(143, Problem1.addValidCenters(lines));
    }
}
