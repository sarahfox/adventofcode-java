package com.w3foxes.sarah.Year2023.Day08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Problem2 {
    /**
     * Haunted Wasteland
     * https://adventofcode.com/2023/day/8
     *
     */
    public static void main(String[] args) throws IOException {
        List<Step> steps = null;
        Map<String, Node> nodes = new HashMap<String, Node>();

        // Find the data file and read it in
        try (InputStream is = Problem1.class.getResourceAsStream("Problem1Input.txt");
                InputStreamReader isReader = new InputStreamReader(is);
                BufferedReader br = new BufferedReader(isReader);) {

            // Read in the race data
            for (String line; (line = br.readLine()) != null;) {
                if (steps == null && line.length() > 0) {
                    steps = readSteps(line);
                } else if (!line.isBlank()) {
                    Node n = new Node(line);
                    nodes.put(n.getName(), n);
                }
            }
        }

        BigInteger stepCount = stepThroughMap(steps, nodes);

        System.out.println("Step count: " + stepCount);
    }

    public static BigInteger stepThroughMap(List<Step> steps, Map<String, Node> nodes) {
        long stepCount = 0;
        List<String> currentNodes = nodes.keySet().stream().filter(n -> n.endsWith("A")).collect(Collectors.toList());
        // Keep track of how long it takes each individual node to reach the end
        Map<Integer, Long> stepCounts = new HashMap<>();
        for (int i = 0; i < currentNodes.size(); i++) {
            stepCounts.put(i, (long) -1);
        }

        System.out.println(currentNodes);
        while (!currentNodes.stream().allMatch(n -> n.endsWith("Z"))) {
            int stepIndex = (int) (stepCount % steps.size());
            Step step = steps.get(stepIndex);
            List<String> nextNodes = new ArrayList<>();
            for (int i = 0; i < currentNodes.size(); i++) {
                String currentNodeName = currentNodes.get(i);
                if (currentNodeName.endsWith("Z")) {
                    if (stepCounts.get(i) < 0) {
                        System.out.println("Found end at index i: " + i + " stepCount: " + stepCount);
                        stepCounts.put(i, stepCount);
                    }
                }
                Node currentNode = nodes.get(currentNodeName);
                if (step == Step.L) {
                    nextNodes.add(currentNode.getLeft());
                } else {
                    nextNodes.add(currentNode.getRight());
                }
            }
            currentNodes = nextNodes;
            stepCount++;

            // If we've found all the step counts break out of the loop
            if (stepCounts.values().stream().allMatch(n -> n > 0)) {
                break;
            }
        }

        BigInteger commonStepCount = BigInteger.ONE;
        for(Long endPoint : stepCounts.values()){
            commonStepCount = lcm(commonStepCount, BigInteger.valueOf(endPoint));
        }

        return commonStepCount;
    }

    public static BigInteger lcm(BigInteger number1, BigInteger number2) {
        BigInteger gcd = number1.gcd(number2);
        BigInteger absProduct = number1.multiply(number2).abs();
        return absProduct.divide(gcd);
    }

    public static List<Step> readSteps(String line) {
        List<Step> steps = new ArrayList<>();

        for (int i = 0; i < line.length(); i++) {
            steps.add(Step.valueOf("" + line.charAt(i)));
        }

        return steps;
    }
}
