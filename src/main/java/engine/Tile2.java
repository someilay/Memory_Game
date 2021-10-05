package main.java.engine;

import main.java.Position;

public class Tile2 implements Tile{
    private boolean isOpen;
    private int type;
    private Position position;

    public Tile2(int x, int y){
        this.type = 2;
        this.position.x = x;
        this.position.y = y;
    }

    public Position getPosition(){
        return this.position;
    }

    @Override
    public void hide() {
        isOpen = false;
    }

    @Override
    public void open() {
        isOpen = true;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public int getType(){
        return type;
    }
}