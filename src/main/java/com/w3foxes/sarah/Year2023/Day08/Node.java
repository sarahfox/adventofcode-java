package com.w3foxes.sarah.Year2023.Day08;

import java.util.StringTokenizer;

public class Node {
    String name;
    String left;
    String right;

    public String getName(){ return name; }
    public String getLeft() { return left; }
    public String getRight() { return right; }

    Node(String line){
        // line in the format AAA = (BBB, CCC)
        StringTokenizer st = new StringTokenizer(line, " =(,)", false);
        name = st.nextToken();
        left = st.nextToken();
        right = st.nextToken();
    }
}
