package com.w3foxes.sarah.Year2023.Day10;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public enum PointType {
    VERTICAL_PIPE('|'),
    HORIZONTAL_PIPE('-'),
    NORTH_EAST('L'),
    NORTH_WEST('J'),
    SOUTH_WEST('7'),
    SOUTH_EAST('F'),
    GROUND('.'),
    SNAKE('S');

    private char symbol;
    private static final Map<Character,PointType> ENUM_MAP;

    PointType(char symbol) {
        this.symbol = symbol;
    }

    public char getSymbol() { return symbol; }

    static {
        Map<Character,PointType> map = new ConcurrentHashMap<Character,PointType>();
        for (PointType instance : PointType.values()) {
            map.put(instance.getSymbol(), instance);
        }
        ENUM_MAP = Collections.unmodifiableMap(map);
    }

    public static PointType get (char name) {
        return ENUM_MAP.get(name);
    }
}
