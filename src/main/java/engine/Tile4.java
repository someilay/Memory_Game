package main.java.engine;

import main.java.Position;

public class Tile4 implements Tile {
    private boolean isOpen;
    private final int type;
    private final Position position;

    public Tile4(int x, int y) {
        isOpen = false;
        this.type = 4;
        position = new Position(x, y);
    }

    @Override
    public Position getPosition() {
        return this.position;
    }

    @Override
    public void hide() {
        this.isOpen = false;
    }

    @Override
    public void open() {
        this.isOpen = true;
    }

    @Override
    public boolean isOpen() {
        return this.isOpen;
    }

    @Override
    public int getType() {
        return this.type;
    }
}