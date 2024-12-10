package com.w3foxes.sarah.Year2023.Day07;

import java.util.StringTokenizer;

public class HandAndBid {
    private Hand hand;
    private long bid;

    HandAndBid(String line){
        StringTokenizer st = new StringTokenizer(line, " ", false);
        hand = new Hand(st.nextToken());
        bid = Long.parseLong(st.nextToken());
    }

    public Hand getHand() { return hand;}
    public long getBid() { return bid;}
}
