package com.w3foxes.sarah.Year2023.Day02;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Game {
    private int gameNumber;
        List<Round> rounds;

        Game(String gameData){
            StringTokenizer st = new StringTokenizer(gameData, ":", false);
            String gameName = st.nextToken();
            String roundData = st.nextToken();
            gameNumber = parseGameNumber(gameName);
            rounds = parseRounds(roundData);
        }

        private int parseGameNumber(String gameName){
            return Integer.parseInt(gameName.replace("Game ", ""));
        }

        private List<Round> parseRounds(String roundData){
            List<Round> rounds = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(roundData, ";", false);
            while(st.hasMoreTokens()){
                rounds.add(new Round(st.nextToken()));
            }
            return rounds;
        }

        public int getGameNumber(){ return gameNumber; }
        public List<Round> getRounds() { return rounds; }

        public boolean isPossible(){
            return rounds.stream().allMatch(Round::isPossible);
        }

        public int getPower() {
            Map<BallColor, Integer> maxCounts = new HashMap<>();
            int power = 1;

            for(Round r : rounds){
                for(BallCount bc : r.ballCounts){
                    Integer currentMax = maxCounts.get(bc.getColor());
                    if(currentMax == null || currentMax < bc.getCount()){
                        maxCounts.put(bc.getColor(), bc.getCount());
                    }
                }
            }
            for(Integer colorMax : maxCounts.values()){
                power *= colorMax;
            }
            
            return power;
        }
}
