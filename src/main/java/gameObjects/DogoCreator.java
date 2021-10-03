package main.java.gameObjects;

public class DogoCreator implements GameObjectCreator{
    @Override
    public GameObject create(int x, int y) {
        return new Dogo(x, y);
    }
}
