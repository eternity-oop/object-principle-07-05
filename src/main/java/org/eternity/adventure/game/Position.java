package org.eternity.adventure.game;

import java.util.Objects;

public class Position {
    private final int x;
    private final int y;

    public static Position of(int x, int y) {
        return new Position(x, y);
    }

    private Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int x() {
        return x;
    }

    public int y() {
        return y;
    }

    public Position shift(Direction direction) {
        return switch (direction) {
            case NORTH -> Position.of(x, y - 1);
            case EAST -> Position.of(x + 1, y);
            case SOUTH -> Position.of(x, y + 1);
            case WEST -> Position.of(x - 1, y);
        };
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return x == position.x && y == position.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "Position{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
