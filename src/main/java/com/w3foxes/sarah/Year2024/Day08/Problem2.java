package com.w3foxes.sarah.Year2024.Day08;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.w3foxes.sarah.util.FileReaderUtil;

public class Problem2 {

    public static void main(String[] args) throws IOException {
        // Find the data file and read it in
        char[][] grid = FileReaderUtil.readChars(Problem1.class, "Problem1.txt");
        long total = countAntiNodes(grid);

        System.out.println(total);
    }

    public static long countAntiNodes(char[][] grid) {
        Set<Point> antiNodes = new HashSet<>();
        Map<Character, List<Point>> antennas = new HashMap<>();

        // Make a list of where the antennas are for each frequency
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] != '.') {
                    List<Point> points = antennas.getOrDefault(grid[r][c], new ArrayList<>());
                    points.add(new Point(r, c));
                    antennas.put(grid[r][c], points);
                }
            }
        }

        // Then looking at each frequency, pair up the antennas in the list
        for (List<Point> nodes : antennas.values()) {
            for (int i = 0; i < nodes.size(); i++) {
                for (int j = i + 1; j < nodes.size(); j++) {
                    Point node1 = nodes.get(i);
                    Point node2 = nodes.get(j);
                    // If there's 2 nodes on a frequency, they're also antiNodes
                    Point antiNode1 = node1;
                    Point antiNode2 = node2;

                    // System.out.println("Calculating for (" + node1.row + "," + node1.column + "),
                    // (" + node2.row + "," + node2.column + ")");
                    int rowDif = node1.row - node2.row;
                    int colDif = node1.column - node2.column;

                    // Project the line of antinodes out one direction
                    do {
                        antiNodes.add(antiNode1);
                        antiNode1 = new Point(antiNode1.row + rowDif, antiNode1.column + colDif);
                    } while (isWithinGrid(grid, antiNode1));

                    // And then the other
                    do {
                        antiNodes.add(antiNode2);
                        antiNode2 = new Point(antiNode2.row - rowDif, antiNode2.column - colDif);
                    } while (isWithinGrid(grid, antiNode2));
                }
            }
        }

        return antiNodes.size();
    }

    public static boolean isWithinGrid(char[][] grid, Point point) {
        return point.row >= 0 && point.row < grid.length && point.column >= 0 && point.column < grid[0].length;
    }

    public record Point(int row, int column) {
    }
}
