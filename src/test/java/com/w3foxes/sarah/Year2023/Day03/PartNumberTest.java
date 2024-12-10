package com.w3foxes.sarah.Year2023.Day03;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

public class PartNumberTest {

    @Test
    public void testGetAdjacentCoordinates_1digitAt00() {
        PartNumber p1 = new PartNumber(5, 0, 0);

        List<Coordinate> actual = p1.getAdjacentCoordinates();
        assertEquals(9, actual.size());
        assertTrue(actual.contains(new Coordinate(-1, -1)));
        assertTrue(actual.contains(new Coordinate(-1, 0)));
        assertTrue(actual.contains(new Coordinate(-1, 1)));

        assertTrue(actual.contains(new Coordinate(0, -1)));
        assertTrue(actual.contains(new Coordinate(0, 0)));
        assertTrue(actual.contains(new Coordinate(0, 1)));

        assertTrue(actual.contains(new Coordinate(1, -1)));
        assertTrue(actual.contains(new Coordinate(1, 0)));
        assertTrue(actual.contains(new Coordinate(1, 1)));
    }

    @Test
    public void testGetAdjacentCoordinates_2digitAt1030() {
        PartNumber p1 = new PartNumber(15, 10, 30);

        List<Coordinate> actual = p1.getAdjacentCoordinates();
        assertEquals(12, actual.size());
        assertTrue(actual.contains(new Coordinate(29, 9)));
        assertTrue(actual.contains(new Coordinate(29, 10)));
        assertTrue(actual.contains(new Coordinate(29, 11)));

        assertTrue(actual.contains(new Coordinate(30, 9)));
        assertTrue(actual.contains(new Coordinate(30, 10)));
        assertTrue(actual.contains(new Coordinate(30, 11)));

        assertTrue(actual.contains(new Coordinate(31, 9)));
        assertTrue(actual.contains(new Coordinate(31, 10)));
        assertTrue(actual.contains(new Coordinate(31, 11)));

        assertTrue(actual.contains(new Coordinate(32, 9)));
        assertTrue(actual.contains(new Coordinate(32, 10)));
        assertTrue(actual.contains(new Coordinate(32, 11)));
    }

    @Test
    public void testGetPartNumberCoordinates_1digitAt00() {
        PartNumber p1 = new PartNumber(5, 0, 0);

        List<Coordinate> actual = p1.getPartNumberCoordinates();
        assertEquals(1, actual.size());
        assertTrue(actual.contains(new Coordinate(0, 0)));
    }

    @Test
    public void testGetPartNumberCoordinates_2digitAt1030() {
        PartNumber p1 = new PartNumber(15, 10, 30);

        List<Coordinate> actual = p1.getPartNumberCoordinates();
        assertEquals(2, actual.size());
        assertTrue(actual.contains(new Coordinate(30, 10)));
        assertTrue(actual.contains(new Coordinate(31, 10)));
    }
}
