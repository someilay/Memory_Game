package main.java.engine;

/**
 * Interface that represent a creation function for the tiles.
 */
public interface TileCreator {
    Tile create(int x, int y);
}
