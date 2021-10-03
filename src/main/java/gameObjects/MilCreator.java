package main.java.gameObjects;

public class MilCreator implements GameObjectCreator{
    @Override
    public GameObject create(int x, int y) {
        return new Mil(x, y);
    }
}