package com.w3foxes.sarah.Year2024.Day15;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public enum GridElement {
    WALL('#'),
    BOX('O'),
    ROBOT('@'),
    GROUND('.'),
    LEFT_BOX('['),
    RIGHT_BOX(']');

    private char symbol;
    private static final Map<Character, GridElement> ENUM_MAP;

    GridElement(char symbol) {
        this.symbol = symbol;
    }

    public char getSymbol() {
        return symbol;
    }

    static {
        Map<Character, GridElement> map = new ConcurrentHashMap<>();
        for (GridElement instance : GridElement.values()) {
            map.put(instance.getSymbol(), instance);
        }
        ENUM_MAP = Collections.unmodifiableMap(map);
    }

    public static GridElement get(char name) {
        return ENUM_MAP.get(name);
    }

}
