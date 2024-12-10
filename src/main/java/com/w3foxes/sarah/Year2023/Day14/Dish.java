package com.w3foxes.sarah.Year2023.Day14;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Dish {
    private Symbol[][] data = null;
    private int dishMaxY = 0;

    Dish(List<String> lines) {
        data = new Symbol[lines.get(0).length()][lines.size()];
        for (String line : lines) {
            for (int i = 0; i < line.length(); i++) {
                data[i][dishMaxY] = Symbol.get(line.charAt(i));
            }
            dishMaxY++;
        }
    }

    public void spinCycle(int numCycles) {
        // If the numCycles number is huge, this'll take forever
        // Check and see if there's a cycle in the data, then calculate from there what the state will be on the numCycles repetition
        Map<String, Integer> cycleDetector = new HashMap<>();
        long step = 0;

        for(int i = 0; i < numCycles; i++){
            String startingState = this.toString();
            if(!cycleDetector.containsKey(startingState)){
                cycleDetector.put(startingState, i);
                spinCycle();
             }
            else {
                // We've hit the start of the cycle
                // Figure out the period
                long period = i - cycleDetector.get(startingState);
                System.out.println("Period: " + period);
                // Now how long do we have left in numCycles?
                long remainingCycles = numCycles - i;
                System.out.println("Remaining cycles: " + remainingCycles);
                // At what step of the cycle will this be in?
                step = remainingCycles % period;
                System.out.println("Step in cycle: " + step);

                break;
            }
        }
        // Just run it till the (hopefully) smaller step
        for(int i = 0; i < step; i++){
            spinCycle();
        }
    }

    public void spinCycle(){
               moveRocksNorth();
                //System.out.println(this.toString());
                moveRocksWest();
                //System.out.println(this.toString());
                moveRocksSouth();
                //System.out.println(this.toString());
                moveRocksEast();
                //System.out.println(this.toString());
   }

    public void moveRocksNorth() {
        for (int i = 0; i < data.length; i++) {
            // First row doesn't move
            for (int j = 1; j < dishMaxY; j++) {
                // If the symbol is a rock, move it into the most northern space you can move it
                // to.
                if (data[i][j] == Symbol.ROCK) {
                    // Find an empty space
                    int moveToY = j;
                    for (int k = j - 1; k >= 0; k--) {
                        if (data[i][k] == Symbol.GROUND) {
                            moveToY = k;
                        } else {
                            // Can't move past a cube or another rock
                            break;
                        }
                    }
                    if (moveToY != j) {
                        data[i][moveToY] = Symbol.ROCK;
                        data[i][j] = Symbol.GROUND;
                    }
                }
            }
        }
    }

    public void moveRocksSouth() {
        for (int i = 0; i < data.length; i++) {
            // Last row doesn't move
            for (int j = dishMaxY - 1; j >= 0; j--) {
                // If the symbol is a rock, move it into the most southern space you can move it
                // to.
                if (data[i][j] == Symbol.ROCK) {
                    // Find an empty space
                    int moveToY = j;
                    for (int k = j + 1; k < dishMaxY; k++) {
                        if (data[i][k] == Symbol.GROUND) {
                            moveToY = k;
                        } else {
                            // Can't move past a cube or another rock
                            break;
                        }
                    }
                    if (moveToY != j) {
                        data[i][moveToY] = Symbol.ROCK;
                        data[i][j] = Symbol.GROUND;
                    }
                }
            }
        }
    }

    public void moveRocksWest() {
        // First column doesn't move
        for (int i = 1; i < data.length; i++) {
            for (int j = 0; j < dishMaxY; j++) {
                // If the symbol is a rock, move it into the most western space you can move it
                // to.
                if (data[i][j] == Symbol.ROCK) {
                    // Find an empty space
                    int moveToX = i;
                    for (int k = i - 1; k >= 0; k--) {
                        if (data[k][j] == Symbol.GROUND) {
                            moveToX = k;
                        } else {
                            // Can't move past a cube or another rock
                            break;
                        }
                    }
                    if (moveToX != i) {
                        data[moveToX][j] = Symbol.ROCK;
                        data[i][j] = Symbol.GROUND;
                    }
                }
            }
        }
    }

    public void moveRocksEast() {
        // Last column doesn't move
        for (int i = data.length - 1; i >= 0; i--) {
            for (int j = 0; j < dishMaxY; j++) {
                // If the symbol is a rock, move it into the most eastern space you can move it
                // to.
                if (data[i][j] == Symbol.ROCK) {
                    // Find an empty space
                    int moveToX = i;
                    for (int k = i + 1; k < data.length; k++) {
                        if (data[k][j] == Symbol.GROUND) {
                            moveToX = k;
                        } else {
                            // Can't move past a cube or another rock
                            break;
                        }
                    }
                    if (moveToX != i) {
                        data[moveToX][j] = Symbol.ROCK;
                        data[i][j] = Symbol.GROUND;
                    }
                }
            }
        }
    }

    public long calculateWeightOnNorthSide(){
        long total = 0;

        for(int j = 0; j < dishMaxY; j++){
            int weight = dishMaxY - j;
            for(int i = 0; i < data.length; i++){
                if(data[i][j] == Symbol.ROCK){
                    total += weight;
                }
            }
        }
        return total;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer();
        for (int j = 0; j < dishMaxY; j++) {
            for (int i = 0; i < data.length; i++) {
                sb.append(data[i][j].getSymbol());
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
