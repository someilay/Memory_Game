package main.java.engine;

public class Controller {
    private World world;

    public Controller(){
        world = new World();
    }

    public World request(){
        return world;
    }
}
