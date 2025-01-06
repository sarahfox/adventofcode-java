package com.w3foxes.sarah.Year2024.Day15;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class Problem2Test {
    @Test
    public void testGrid() {
        List<String> lines = Arrays.asList("##########",
                "#..O..O.O#",
                "#......O.#",
                "#.OO..O.O#",
                "#..O@..O.#",
                "#O#..O...#",
                "#O..O..O.#",
                "#.OO.O.OO#",
                "#....O...#",
                "##########",
                "",
                "<vv>^<v^>v>^vv^v>v<>v^v<v<^vv<<<^><<><>>v<vvv<>^v^>^<<<><<v<<<v^vv^v>^",
                "vvv<<^>^v^^><<>>><>^<<><^vv^^<>vvv<>><^^v>^>vv<>v<<<<v<^v>^<^^>>>^<v<v",
                "><>vv>v^v^<>><>>>><^^>vv>v<^^^>>v^v^<^^>v^^>v^<^v>v<>>v^v^<v>v^^<^^vv<",
                "<<v<^>>^^^^>>>v^<>vvv^><v<<<>^^^vv^<vvv>^>v<^^^^v<>^>vvvv><>>v^<<^^^^^",
                "^><^><>>><>^^<<^^v>>><^<v>^<vv>>v>>>^v><>^v><<<<v>>v<v<v>vvv>^<><<>^><",
                "^>><>^v<><^vvv<^^<><v<<<<<><^v<<<><<<^^<v<^^^><^>>^<v^><<<^>>^v<v^v<v^",
                ">^>>^v>vv>^<<^v<>><<><<v<<v><>v<^vv<<<>^^v^>^^>>><<^v>>v^v><^^>>^<>vv^",
                "<><^^>^^^<><vvvvv^v<v<<>^v<v>v<<^><<><<><<<^^<<<^<<>><<><^^^>^^<>^>v<>",
                "^^>vv<^v^v<vv>^<><v<^v>^^^>>>^^vvv^>vvv<>>>^<^>>>>>^<<^v>^vvv<>^<><<v>",
                "v^^>>><<^^<>>^v^<v^vv<>v^<<>^<^v^v><^<<<><<^<v><v<>vv>>v><v^<vv<>v^<<^",
                "");
        ExtendedGrid g = new ExtendedGrid(lines);
        Path p = new Path(lines);
        g.printGrid();
        Problem2.moveBoxes(g, p);
        g.printGrid();
        assertEquals(9021, g.scoreGrid());
    }

    @Test
    public void testSmallGrid() {
        List<String> lines = Arrays.asList("#######",
                "#...#.#",
                "#.....#",
                "#..OO@#",
                "#..O..#",
                "#.....#",
                "#######",
                "",
                "<vv<<^^<<^^");
        ExtendedGrid g = new ExtendedGrid(lines);
        Path p = new Path(lines);
        g.printGrid();
        Problem2.moveBoxes(g, p);
        g.printGrid();

        assertEquals(105 + 207 + 306, g.scoreGrid());
    }

    @Test
    public void testCornerCase() {
        List<String> lines = Arrays.asList("#####",
                "#...#",
                "#O..#",
                "#...#",
                "#O..#",
                "#@..#",
                "#####",
                "",
                "^^");
        ExtendedGrid g = new ExtendedGrid(lines);
        Path p = new Path(lines);
        g.printGrid();
        Problem2.moveBoxes(g, p);
        g.printGrid();

        assertEquals(102 + 202, g.scoreGrid());
    }

    @Test
    public void testFloatingWall() {
        List<String> lines = Arrays.asList("#####",
                "#...#",
                "#.#.#",
                "#...#",
                "#.O.#",
                "#.@.#",
                "#####",
                "",
                "<^>v>^^>^");
        ExtendedGrid g = new ExtendedGrid(lines);
        Path p = new Path(lines);
        g.printGrid();
        Problem2.moveBoxes(g, p);
        g.printGrid();

        assertEquals(305, g.scoreGrid());

    }
}
