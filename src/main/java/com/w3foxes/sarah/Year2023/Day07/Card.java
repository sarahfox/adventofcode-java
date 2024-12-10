package com.w3foxes.sarah.Year2023.Day07;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public enum Card {
    ACE("A"), 
    KING("K"), 
    QUEEN("Q"), 
    TEN("T"), 
    NINE("9"), 
    EIGHT("8"), 
    SEVEN("7"), 
    SIX("6"), 
    FIVE("5"), 
    FOUR("4"), 
    THREE("3"), 
    TWO("2"),
    JOKER("J"); 

    public String symbol;
    private static final Map<String,Card> ENUM_MAP;

    Card(String symbol){
        this.symbol = symbol;
    }

    public String getSymbol() { return symbol; }

    // Build an immutable map of String name to enum pairs.
    // Any Map impl can be used.

    static {
        Map<String,Card> map = new ConcurrentHashMap<String, Card>();
        for (Card instance : Card.values()) {
            map.put(instance.getSymbol(),instance);
        }
        ENUM_MAP = Collections.unmodifiableMap(map);
    }

    public static Card get (String name) {
        return ENUM_MAP.get(name);
    }
}
