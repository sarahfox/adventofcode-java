package com.w3foxes.sarah.Year2023.Day16;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EnergyGrid {
    private GridComponent[][] grid;
    private boolean[][] energized;
    private Map<String, Boolean> memo = new HashMap<>();

    EnergyGrid(List<String> lines){
        grid = new GridComponent[lines.get(0).length()][lines.size()];
        energized = new boolean[lines.get(0).length()][lines.size()];

        for(int i = 0; i < lines.size(); i++){
            for(int j = 0; j < grid.length; j++){
                grid[j][i] = GridComponent.get(lines.get(i).charAt(j));
                energized[j][i] = false;
            }
        }
    }

    @Override
    public String toString(){
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < grid[0].length; i++){
            for(int j = 0; j < grid.length; j++){
                sb.append(grid[j][i].getSymbol());
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public void lightUp(int x, int y, BeamDirection direction){
        // Base case - x or y has gone off the end of the grid
        if(x < 0 || x >= grid.length || y < 0 || y >= grid[0].length){
            return;
        }
        // Base case - we've hit this square before from the same direction (loops are possible)
        String memoKey = x + "," + y + direction;
        if(memo.containsKey(memoKey)){
            return;
        }
        else {
            memo.put(memoKey, Boolean.TRUE);
        }

        // Mark the current square as energized
        energized[x][y] = true;
        System.out.println("Energized " +x+ ", " + y + " from: " + direction);
        // Get the list of where the beam goes from here
        List<BeamDirection> outDirections = GridComponent.transmitLight(grid[x][y], direction);

        // Transmit the light to the next squares
        for(BeamDirection outDirection : outDirections){
            switch(outDirection){
                case UP:
                    lightUp(x, y - 1, outDirection);
                    break;
                case DOWN:
                    lightUp(x, y + 1, outDirection);
                    break;
                case LEFT:
                    lightUp(x - 1, y, outDirection);
                    break;
                case RIGHT:
                    lightUp(x + 1, y, outDirection);
                    break;
            }
        }
    }

    public long countLightedSquares() {
        long count = 0;

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(energized[i][j]){
                    count++;
                }
            }
        }
        return count;
    }
}
