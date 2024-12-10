package com.w3foxes.sarah.Year2023.Day14;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public enum Symbol {
    ROCK('O'),
    GROUND('.'),
    CUBE('#');

    private char symbol;
    private static final Map<Character,Symbol> ENUM_MAP;

    Symbol(char symbol) {
        this.symbol = symbol;
    }

    public char getSymbol() { return symbol; }

    static {
        Map<Character,Symbol> map = new ConcurrentHashMap<Character,Symbol>();
        for (Symbol instance : Symbol.values()) {
            map.put(instance.getSymbol(), instance);
        }
        ENUM_MAP = Collections.unmodifiableMap(map);
    }

    public static Symbol get (char name) {
        return ENUM_MAP.get(name);
    }
}
