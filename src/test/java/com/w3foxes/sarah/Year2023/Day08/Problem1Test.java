package com.w3foxes.sarah.Year2023.Day08;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class Problem1Test {
    @Test
    public void testStepThroughMap(){
        // Make the simple map from the example
        Node a = new Node("AAA = (BBB, BBB)");
        Node b = new Node("BBB = (AAA, ZZZ)");
        Node z = new Node("ZZZ = (ZZZ, ZZZ)");
        Map<String, Node> nodes = new HashMap<>();
        nodes.put(a.getName(), a);
        nodes.put(b.getName(), b);
        nodes.put(z.getName(), z);

        List<Step> steps = new ArrayList<>();
        steps.add(Step.L);
        steps.add(Step.L);
        steps.add(Step.R);

        assertEquals(6, Problem1.stepThroughMap(steps, nodes));
    }
}
