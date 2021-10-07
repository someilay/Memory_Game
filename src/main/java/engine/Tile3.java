package main.java.engine;

import main.java.Position;

public class Tile3 implements Tile {
    private boolean isOpen;
    private final int type;
    private final Position position;

    /**
     * Constructor for the tile of the third type.
     * @param x - position of the tile in x coordinate.
     * @param y - position of the tile in y coordinate.
     */
    public Tile3(int x, int y) {
        isOpen = false;
        this.type = 3;
        position = new Position(x, y);
    }

    /**
     * Getter for the position of the tile.
     * @return - position of the tile.
     */
    @Override
    public Position getPosition() {
        return this.position;
    }

    /**
     * A function that changes visibility of the tile for the user to closed.
     */
    @Override
    public void hide() {
        this.isOpen = false;
    }

    /**
     * A function that changes visibility of the tile for the user to open.
     */
    @Override
    public void open() {
        this.isOpen = true;
    }

    /**
     * Getter for the visibility of the tile for the user.
     * @return - true if the tile is opened, false otherwise.
     */
    @Override
    public boolean isOpen() {
        return this.isOpen;
    }

    /**
     * Getter for the type of the tile.
     * @return - type of the tile (3 for the current class).
     */
    @Override
    public int getType() {
        return this.type;
    }
}