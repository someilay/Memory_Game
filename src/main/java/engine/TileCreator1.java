package main.java.engine;

public class TileCreator1 implements TileCreator {
    @Override
    public Tile create(int x, int y) {
        return new Tile1(x, y);
    }
}
