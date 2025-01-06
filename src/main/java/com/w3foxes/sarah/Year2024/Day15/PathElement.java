package com.w3foxes.sarah.Year2024.Day15;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public enum PathElement {
    UP('^', -1, 0),
    DOWN('v', 1, 0),
    LEFT('<', 0, -1),
    RIGHT('>', 0, 1);

    private char symbol;
    private int rowMove;
    private int columnMove;
    private static final Map<Character, PathElement> ENUM_MAP;

    PathElement(char symbol, int rowMove, int columnMove) {
        this.symbol = symbol;
        this.rowMove = rowMove;
        this.columnMove = columnMove;
    }

    public char getSymbol() {
        return symbol;
    }

    public int getRowMove() {
        return rowMove;
    }

    public int getColumnMove() {
        return columnMove;
    }

    static {
        Map<Character, PathElement> map = new ConcurrentHashMap<>();
        for (PathElement instance : PathElement.values()) {
            map.put(instance.getSymbol(), instance);
        }
        ENUM_MAP = Collections.unmodifiableMap(map);
    }

    public static PathElement get(char name) {
        return ENUM_MAP.get(name);
    }

}
