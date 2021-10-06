package main.java.engine;

import main.java.Button;

public class Controller {
    private World world;

    public Controller(){
        world = new World();
    }

    public World request(Button button){
        this.world.update(button);
        return this.world;
    }
}
