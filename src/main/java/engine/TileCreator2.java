package main.java.engine;

public class TileCreator2 implements TileCreator {
    /**
     * A function that creates new tile of the type 2.
     * @param x - position of the new tile in x coordinate.
     * @param y - position of the new tile in y coordinate.
     * @return new tile of the type 2.
     */
    @Override
    public Tile create(int x, int y) {
        return new Tile2(x, y);
    }
}
