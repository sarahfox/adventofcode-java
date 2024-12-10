package com.w3foxes.sarah.Year2023.Day08;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class NodeTest {
    @Test
    public void testCreateNode(){
        Node n = new Node("AAA = (BBB, CCC)");
        assertEquals("AAA", n.getName());
        assertEquals("BBB", n.getLeft());
        assertEquals("CCC", n.getRight());
    }
}
