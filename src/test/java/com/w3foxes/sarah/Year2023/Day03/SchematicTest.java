package com.w3foxes.sarah.Year2023.Day03;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Map;

import org.junit.Test;

public class SchematicTest {
    @Test
    public void testReadLine_boringLine() {
        Schematic test = new Schematic();
        test.readLine(0, "..........");

        assertEquals(0, test.getPartNumbers().size());
        assertEquals(0, test.getSymbolsMap().size());
        assertEquals(0, test.getGearSymbols().size());
        assertEquals(0, test.getPartNumberMap().size());
    }

    @Test
    public void testReadLine_allNumbers() {
        Schematic test = new Schematic();
        test.readLine(0, "1234.....23...1..12");

        List<PartNumber> partNumbers = test.getPartNumbers();
        assertEquals(4, partNumbers.size());
        assertEquals(1234, partNumbers.get(0).getPartNumber());
        assertEquals(0, partNumbers.get(0).getRowNumber());
        assertEquals(0, partNumbers.get(0).getStartIndex());

        assertEquals(23, partNumbers.get(1).getPartNumber());
        assertEquals(0, partNumbers.get(1).getRowNumber());
        assertEquals(9, partNumbers.get(1).getStartIndex());

        assertEquals(1, partNumbers.get(2).getPartNumber());
        assertEquals(0, partNumbers.get(2).getRowNumber());
        assertEquals(14, partNumbers.get(2).getStartIndex());

        assertEquals(12, partNumbers.get(3).getPartNumber());
        assertEquals(0, partNumbers.get(3).getRowNumber());
        assertEquals(17, partNumbers.get(3).getStartIndex());

        assertEquals(0, test.getSymbolsMap().size());

        assertEquals(0, test.getGearSymbols().size());
        
        Map<Coordinate, PartNumber> partNumberMap = test.getPartNumberMap();
        assertEquals(9, partNumberMap.size());
        assertEquals(1234, partNumberMap.get(new Coordinate(0, 0)).getPartNumber());
        assertEquals(1234, partNumberMap.get(new Coordinate(1, 0)).getPartNumber());
        assertEquals(1234, partNumberMap.get(new Coordinate(2, 0)).getPartNumber());
        assertEquals(1234, partNumberMap.get(new Coordinate(3, 0)).getPartNumber());
        assertEquals(23, partNumberMap.get(new Coordinate(9, 0)).getPartNumber());
        assertEquals(23, partNumberMap.get(new Coordinate(10, 0)).getPartNumber());
        assertEquals(1, partNumberMap.get(new Coordinate(14, 0)).getPartNumber());
        assertEquals(12, partNumberMap.get(new Coordinate(17, 0)).getPartNumber());
        assertEquals(12, partNumberMap.get(new Coordinate(18, 0)).getPartNumber());
   }

    @Test
    public void testReadLine_allSymbols() {
        Schematic test = new Schematic();
        test.readLine(0, "*....#$...@..?");

        assertEquals(0, test.getPartNumbers().size());
        assertEquals(5, test.getSymbolsMap().size());
        assertTrue(test.hasSymbol(new Coordinate(0, 0)));
        assertTrue(test.hasSymbol(new Coordinate(5, 0)));
        assertTrue(test.hasSymbol(new Coordinate(6, 0)));
        assertTrue(test.hasSymbol(new Coordinate(10, 0)));
        assertTrue(test.hasSymbol(new Coordinate(13, 0)));

        assertEquals(1, test.getGearSymbols().size());
        assertTrue(test.getGearSymbols().contains(new Coordinate(0, 0)));

        assertEquals(0, test.getPartNumberMap().size());
    }

    @Test
    public void testReadLine_mixed() {
        Schematic test = new Schematic();
        test.readLine(0, "#1234#..*...23@...1.%.12");

        List<PartNumber> partNumbers = test.getPartNumbers();
        assertEquals(4, partNumbers.size());
        assertEquals(1234, partNumbers.get(0).getPartNumber());
        assertEquals(0, partNumbers.get(0).getRowNumber());
        assertEquals(1, partNumbers.get(0).getStartIndex());

        assertEquals(23, partNumbers.get(1).getPartNumber());
        assertEquals(0, partNumbers.get(1).getRowNumber());
        assertEquals(12, partNumbers.get(1).getStartIndex());

        assertEquals(1, partNumbers.get(2).getPartNumber());
        assertEquals(0, partNumbers.get(2).getRowNumber());
        assertEquals(18, partNumbers.get(2).getStartIndex());

        assertEquals(12, partNumbers.get(3).getPartNumber());
        assertEquals(0, partNumbers.get(3).getRowNumber());
        assertEquals(22, partNumbers.get(3).getStartIndex());

        assertEquals(5, test.getSymbolsMap().size());
        assertTrue(test.hasSymbol(new Coordinate(0, 0)));
        assertTrue(test.hasSymbol(new Coordinate(5, 0)));
        assertTrue(test.hasSymbol(new Coordinate(8, 0)));
        assertTrue(test.hasSymbol(new Coordinate(14, 0)));
        assertTrue(test.hasSymbol(new Coordinate(20, 0)));

        assertEquals(1, test.getGearSymbols().size());
        assertTrue(test.getGearSymbols().contains(new Coordinate(8, 0)));

        Map<Coordinate, PartNumber> partNumberMap = test.getPartNumberMap();
        assertEquals(9, partNumberMap.size());
        assertEquals(1234, partNumberMap.get(new Coordinate(1, 0)).getPartNumber());
        assertEquals(1234, partNumberMap.get(new Coordinate(2, 0)).getPartNumber());
        assertEquals(1234, partNumberMap.get(new Coordinate(3, 0)).getPartNumber());
        assertEquals(1234, partNumberMap.get(new Coordinate(4, 0)).getPartNumber());
        assertEquals(23, partNumberMap.get(new Coordinate(12, 0)).getPartNumber());
        assertEquals(23, partNumberMap.get(new Coordinate(13, 0)).getPartNumber());
        assertEquals(1, partNumberMap.get(new Coordinate(18, 0)).getPartNumber());
        assertEquals(12, partNumberMap.get(new Coordinate(22, 0)).getPartNumber());
        assertEquals(12, partNumberMap.get(new Coordinate(23, 0)).getPartNumber());

    }
}
