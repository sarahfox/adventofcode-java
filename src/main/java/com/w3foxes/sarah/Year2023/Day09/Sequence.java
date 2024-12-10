package com.w3foxes.sarah.Year2023.Day09;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Sequence {
    private List<Long> inputs;
    private long prediction;
    private long previous;

    Sequence(String line){
        inputs = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(line, " ", false);
        while(st.hasMoreTokens()){
            inputs.add(Long.parseLong(st.nextToken()));
        }

        calculatePredictions();

        System.out.println("Prediction: " + prediction);
    }

    private void calculatePredictions() {
        List<List<Long>> listOfLists = new ArrayList<>();
        listOfLists.add(inputs);
        List<Long> differences = calculateDifferences(inputs);
        listOfLists.add(differences);
        while(!differences.stream().allMatch(n -> n == 0)){
            differences = calculateDifferences(differences);
            listOfLists.add(differences);
        }

        // We've hit a point where the differences are 0, so now go back up the tree
        long nextPrediction = 0;
        long previousPrediction = 0;
        // x + previousPrediction = first item in nextList
        for(int i = listOfLists.size() - 1; i >= 0; i--){
            List<Long> nextList = listOfLists.get(i);
            nextPrediction += nextList.get(nextList.size() - 1);
            previousPrediction = nextList.get(0) - previousPrediction;
        }

        this.prediction = nextPrediction;
        this.previous = previousPrediction;
    }

    private List<Long> calculateDifferences(List<Long> list){
        List<Long> differences = new ArrayList<>();
        for(int i = 0; i < list.size() - 1; i++){
            differences.add(list.get(i + 1) - list.get(i));
        }

        return differences;
    }

    public long getPrediction() {
        return prediction;
    }

    public long getPrevious() {
        return previous;
    }
}
