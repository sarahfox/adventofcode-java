package com.w3foxes.sarah.Year2023.Day15;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Map;

import org.junit.Test;

public class Problem1Test {
    @Test
    public void testHashString(){
        assertEquals(52, Problem1.hashString("HASH"));
    }

    @Test
    public void testProcessCommandsAndGetFocalLengths(){
        String commandString = "rn=1,cm-,qp=3,cm=2,qp-,pc=4,ot=9,ab=5,pc-,pc=6,ot=7";
        String [] commands = commandString.split(",");
        List<Map<String, String>> boxes = Problem1.processCommands(commands);
        
        assertEquals(145, Problem1.sumFocalLengths(boxes));
    }
}
