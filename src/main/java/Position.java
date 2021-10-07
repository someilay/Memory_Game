package main.java;

import java.util.Objects;

/**
 * Class for Position.
 */
public class Position {
    public int x;
    public int y;

    /**
     * Constructor for Position.
     */
    public Position() {}

    /**
     * Constructor Position with parameter .
     * @param x the x
     * @param y the y
     */
    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * check validity
     * @param o button name
     * @return Position
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return x == position.x &&
                y == position.y;
    }

}
