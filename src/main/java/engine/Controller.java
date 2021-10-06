package main.java.engine;

import main.java.Button;
import main.java.ButtonNames;

public class Controller {
    private World world;

    public Controller() {
        world = new World();
    }

    private boolean winChek() {
        return (world.getOpenedTiles() == 64);
    }

    public Response request(Button button){
        boolean isExit = false;
        if (button.getName() == ButtonNames.BEGIN)
            world.init();
        else if (button.getName() == ButtonNames.EXIT)
            isExit = true;
        else {
            world.update(button.getPosition());
        }
        return new Response(world, winChek(), isExit);
    }
}
