package main.java.engine;

import main.java.Position;

public interface Tile {
    void hide();

    void open();

    boolean isOpen();

    Position getPosition();

    int getType();
}
