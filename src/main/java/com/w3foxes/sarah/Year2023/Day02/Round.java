package com.w3foxes.sarah.Year2023.Day02;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Round {
     List<BallCount> ballCounts;

    Round(String roundData){
        ballCounts = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(roundData, ",", false);
        while(st.hasMoreTokens()){
            ballCounts.add(new BallCount(st.nextToken()));
        }
    }
    
    public boolean isPossible() {
        return ballCounts.stream().allMatch(BallCount::isPossible);
    }
}
