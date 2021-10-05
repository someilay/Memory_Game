package main.java.engine;

public class TileCreator4 implements TileCreator{
    @Override
    public Tile create(int x, int y, int type) {
        return new Tile4(x, y);
    }
}
