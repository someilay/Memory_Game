package main.java.engine;

public class TileCreator2 implements TileCreator{
    @Override
    public Tile create(int x, int y, int type) {
        return new Tile2(x, y);
    }
}
