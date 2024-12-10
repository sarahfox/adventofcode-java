package com.w3foxes.sarah.Year2023.Day08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem1 {
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
                if(steps == null && line.length() > 0){
                    steps = readSteps(line);
                }
                else if(!line.isBlank()){
                    Node n = new Node(line);
                    nodes.put(n.getName(), n);
                }
            }
        }

        long stepCount = stepThroughMap(steps, nodes);

        System.out.println("Step count: " + stepCount);
    }   

    public static long stepThroughMap(List<Step> steps, Map<String, Node> nodes){
        long stepCount = 0;
        String startNode = "AAA";
        String endNode = "ZZZ";
        String currentNode = startNode;

        while(!currentNode.equals(endNode)){
            int stepIndex = (int) (stepCount % steps.size());
            Step step = steps.get(stepIndex);
            Node current = nodes.get(currentNode);
            if(step == Step.L){
                currentNode = current.getLeft();
            }
            else {
                currentNode = current.getRight();
            }
            stepCount++;
        }

        return stepCount;
    }

    public static List<Step> readSteps(String line){
        List<Step> steps = new ArrayList<>();

        for(int i = 0; i < line.length(); i++){
            steps.add(Step.valueOf("" + line.charAt(i)));
        }

        return steps;
    }
}
