package com.w3foxes.sarah.Year2024.Day13;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.w3foxes.sarah.util.FileReaderUtil;

public class Problem2 {
    
    public static void main(String[] args) throws IOException {
        // Find the data file and read it in
        List<String> lines = FileReaderUtil.readLines(Problem1.class, "Problem1.txt");
        long total = 0;
        List<String> game = new ArrayList<>();

        for(int i = 0; i < lines.size(); i++){
            // Game data is 3 lines, then a break
            if(i % 4 == 0){
                game = new ArrayList<>();
                game.add(lines.get(i));
            }
            if(i % 4 == 1) {
                game.add(lines.get(i));
            }
            if(i % 4 == 2){
                game.add(lines.get(i));
                long gameTotal = findFewestTokens(game);
                total += gameTotal;
            }
        }

        System.out.println(total);
    }

    public static long findFewestTokens(List<String> lines){
        // Parse the button inputs and prize locations
        String[] buttonA = lines.get(0).split(":")[1].trim().split(",");
        String[] buttonB = lines.get(1).split(":")[1].trim().split(",");
        String[] prize = lines.get(2).split(":")[1].trim().split(",");
        long ax = Long.parseLong(buttonA[0].split("\\+")[1]);
        long ay = Long.parseLong(buttonA[1].split("\\+")[1]);
        long bx = Long.parseLong(buttonB[0].split("\\+")[1]);
        long by = Long.parseLong(buttonB[1].split("\\+")[1]);
        long px = Long.parseLong(prize[0].split("\\=")[1]);
        long py = Long.parseLong(prize[1].split("\\=")[1]);

        // Prize position changes for part 2
        px += 10000000000000l;
        py += 10000000000000l;
        
        // System.out.println("ax: " + ax + " ay: " + ay);
        // System.out.println("bx: " + bx + " by: " + by);
        // System.out.println("px: " + px + " py: " + py);
        return solveEquations(ax, bx, px, ay, by, py);
    }

    // Many thanks to marcinbator who kindly posted his solution publicly.  I did not remember enough linear algebra to solve this.
    public static long solveEquations(long ax, long bx, long px,
                                        long ay, long by, long py) {
        long det = ax * by - bx * ay;
        if (det == 0) {
            return 0;
        }

        long detX = px * by - bx * py;
        long detY = ax * py - px * ay;
        if (detX % det != 0 || detY % det != 0) {
            return 0;
        }

        return detX / det * 3 + detY / det;
    }
}
