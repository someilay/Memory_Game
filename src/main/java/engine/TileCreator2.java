package main.java.engine;

public class TileCreator2 implements TileCreator {
    @Override
    public Tile create(int x, int y) {
        return new Tile2(x, y);
    }
}
