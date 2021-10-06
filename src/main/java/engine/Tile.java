package main.java.engine;

import main.java.Position;

/**
 * Interface that represents a tile.
 */
public interface Tile {
    void hide();

    void open();

    boolean isOpen();

    Position getPosition();

    int getType();
}
