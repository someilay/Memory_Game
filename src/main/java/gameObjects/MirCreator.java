package main.java.gameObjects;

public class MirCreator implements GameObjectCreator{
    @Override
    public GameObject create(int x, int y) {
        return new Mir(x, y);
    }
}