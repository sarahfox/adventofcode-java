package com.w3foxes.sarah.Year2023.Day08;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class Problem2Test {
        @Test
    public void testStepThroughMap(){
        // Make the simple map from the example
        Node a = new Node("11A = (11B, XXX)");
        Node b = new Node("11B = (XXX, 11Z)");
        Node c = new Node("11Z = (11B, XXX)");
        Node d = new Node("22A = (22B, XXX)");
        Node e = new Node("22B = (22C, 22C)");
        Node f = new Node("22C = (22Z, 22Z)");
        Node g = new Node("22Z = (22B, 22B)");
        Node h = new Node("XXX = (XXX, XXX)");

        Map<String, Node> nodes = new HashMap<>();
        nodes.put(a.getName(), a);
        nodes.put(b.getName(), b);
        nodes.put(c.getName(), c);
        nodes.put(d.getName(), d);
        nodes.put(e.getName(), e);
        nodes.put(f.getName(), f);
        nodes.put(g.getName(), g);
        nodes.put(h.getName(), h);

        List<Step> steps = new ArrayList<>();
        steps.add(Step.L);
        steps.add(Step.R);

        assertEquals(6, Problem2.stepThroughMap(steps, nodes));
    }
}
