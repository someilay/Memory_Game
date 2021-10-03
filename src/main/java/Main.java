package main.java;

import main.java.gameObjects.*;

public class Main {
    public static void main(String[] args) {
        GameObjectCreator gameObjectCreator = new MirCreator();
        GameObject gameObject = gameObjectCreator.create(0, 0);

        System.out.println(gameObject.getClass());
    }


}
