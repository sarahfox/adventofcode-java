package com.w3foxes.sarah.Year2023.Day16;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public enum GridComponent {
    VERTICAL_SPLITTER('|'),
    HORIZONTAL_SPLITTER('-'),
    MIRROR_LEFT('\\'),
    MIRROR_RIGHT('/'),
    GROUND('.');

    private char symbol;
    private static final Map<Character, GridComponent> ENUM_MAP;

    GridComponent(char symbol) {
        this.symbol = symbol;
    }

    public char getSymbol() {
        return symbol;
    }

    static {
        Map<Character, GridComponent> map = new ConcurrentHashMap<>();
        for (GridComponent instance : GridComponent.values()) {
            map.put(instance.getSymbol(), instance);
        }
        ENUM_MAP = Collections.unmodifiableMap(map);
    }

    public static GridComponent get(char name) {
        return ENUM_MAP.get(name);
    }

    public static List<BeamDirection> transmitLight(GridComponent component, BeamDirection inDirection) {
        List<BeamDirection> outDirections = new ArrayList<>();

        switch (component) {
            case GROUND:
                outDirections.add(inDirection);
                break;
            case VERTICAL_SPLITTER:
                if (inDirection == BeamDirection.LEFT || inDirection == BeamDirection.RIGHT) {
                    outDirections.add(BeamDirection.DOWN);
                    outDirections.add(BeamDirection.UP);
                } else {
                    outDirections.add(inDirection);
                }
                break;
            case HORIZONTAL_SPLITTER:
                if (inDirection == BeamDirection.UP || inDirection == BeamDirection.DOWN) {
                    outDirections.add(BeamDirection.LEFT);
                    outDirections.add(BeamDirection.RIGHT);
                } else {
                    outDirections.add(inDirection);
                }
                break;
            case MIRROR_LEFT:
                switch (inDirection) {
                    case UP:
                        outDirections.add(BeamDirection.LEFT);
                        break;
                    case DOWN:
                        outDirections.add(BeamDirection.RIGHT);
                        break;
                    case LEFT:
                        outDirections.add(BeamDirection.UP);
                        break;
                    case RIGHT:
                        outDirections.add(BeamDirection.DOWN);
                }
                break;
            case MIRROR_RIGHT:
                switch (inDirection) {
                    case UP:
                        outDirections.add(BeamDirection.RIGHT);
                        break;
                    case DOWN:
                        outDirections.add(BeamDirection.LEFT);
                        break;
                    case LEFT:
                        outDirections.add(BeamDirection.DOWN);
                        break;
                    case RIGHT:
                        outDirections.add(BeamDirection.UP);
                }
                break;

        }

        return outDirections;
    }
}
