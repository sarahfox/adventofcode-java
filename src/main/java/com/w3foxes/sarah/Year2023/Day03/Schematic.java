package com.w3foxes.sarah.Year2023.Day03;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Schematic {
    List<PartNumber> partNumbers = new ArrayList<>();
    Map<Coordinate, Character> symbols = new HashMap<>();
    List<Coordinate> gearSymbols = new ArrayList<>();
    Map<Coordinate, PartNumber> partNumberCoordinates = new HashMap<>();

    public void readLine(int lineNumber, String line) {
        // Go through the line, character by character.
        String currentPartNumber = "";
        int currentPartNumberStartIndex = -1;
        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            // If it's a digit, start keeping track of the partNumber
            if (Character.isDigit(c)) {
                currentPartNumber += c;
                if (currentPartNumberStartIndex == -1) {
                    currentPartNumberStartIndex = i;
                }
            }
            // If it's a something else, end the partNumber if one was started
            else {
                if (!currentPartNumber.equals("")) {
                    int partNumber = Integer.parseInt(currentPartNumber);
                    PartNumber pn = new PartNumber(partNumber, lineNumber, currentPartNumberStartIndex);
                    partNumbers.add(pn);
                    for(Coordinate pnc : pn.getPartNumberCoordinates()){
                        partNumberCoordinates.put(pnc, pn);
                    }
                    
                    currentPartNumber = "";
                    currentPartNumberStartIndex = -1;
                }
                // Ignore periods, but save symbols
                if (c != '.') {
                    symbols.put(new Coordinate(i, lineNumber), c);
                    if(c == '*'){
                        gearSymbols.add(new Coordinate(i, lineNumber));
                    }
                }
            }
        }
        // Finish off any number at the end of the line
        if (!currentPartNumber.equals("")) {
            int partNumber = Integer.parseInt(currentPartNumber);
            PartNumber pn = new PartNumber(partNumber, lineNumber, currentPartNumberStartIndex);
            partNumbers.add(pn);
            for(Coordinate pnc : pn.getPartNumberCoordinates()){
                partNumberCoordinates.put(pnc, pn);
            }

            currentPartNumber = "";
            currentPartNumberStartIndex = -1;
        }
    }

    public List<PartNumber> getPartNumbers() {
        return partNumbers;
    }

    public Map<Coordinate, Character> getSymbolsMap() {
        return symbols;
    }

    public List<Coordinate> getGearSymbols() {
        return gearSymbols;
    }

    public Map<Coordinate, PartNumber> getPartNumberMap() {
        return partNumberCoordinates;
    }

    public boolean hasSymbol(Coordinate c) {
        return symbols.get(c) != null;
    }
}
