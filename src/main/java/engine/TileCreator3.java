package main.java.engine;

public class TileCreator3 implements TileCreator{
    @Override
    public Tile create(int x, int y, int type) {
        return new Tile3(x, y);
    }
}