package com.w3foxes.sarah.Year2023.Day03;

import java.util.ArrayList;
import java.util.List;

public class PartNumber {
    private int partNumber;
    private int rowNumber;
    private int startIndex;

    PartNumber(int partNumber, int rowNumber, int startIndex) {
        this.partNumber = partNumber;
        this.rowNumber = rowNumber;
        this.startIndex = startIndex;
    }

    public int getPartNumber() {
        return partNumber;
    }

    public int getRowNumber() {
        return rowNumber;
    }

    public int getStartIndex() {
        return startIndex;
    }

    /**
     * List out coordinates for the spots adjacent to the part numbers.
     * -1 is a valid value for a coordinate, as are values inside the number, or off
     * the end of the schema. They're only used to lookup potential symbols.
     * 
     * @return
     */
    public List<Coordinate> getAdjacentCoordinates() {
        int partNumberLength = (int) (Math.log10(partNumber) + 1);
        List<Coordinate> adjacentCoordinates = new ArrayList<>();

        // List out coordinates, don't bother the check for if they could really exist
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= partNumberLength; j++) {
                adjacentCoordinates.add(new Coordinate(j + startIndex, i + rowNumber));
            }
        }

        return adjacentCoordinates;
    }

    public List<Coordinate> getPartNumberCoordinates() {
        int partNumberLength = (int) (Math.log10(partNumber) + 1);
        List<Coordinate> partNumberCoordinates = new ArrayList<>();

        for(int i = 0; i < partNumberLength; i++){
            partNumberCoordinates.add(new Coordinate(i + startIndex, rowNumber));
        }
        return partNumberCoordinates;
    }
}
