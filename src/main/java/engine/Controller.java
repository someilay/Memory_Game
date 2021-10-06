package main.java.engine;

import main.java.Button;
import main.java.ButtonNames;

public class Controller {
    private World world;
    private boolean isWin;
    private boolean isExit;

    public Controller() {
        setWin(false);
        setExit(false);
        world = new World();
    }

    public void setWin(boolean win) {
        this.isWin = win;
    }

    public void setExit(boolean exit) {
        this.isExit = exit;
    }

    public boolean getExit() {
        return this.isExit;
    }

    public boolean getWin() {
        return this.isWin;
    }

    private void winChek() {
        this.isWin = (world.getOpenedTiles() == 64);
    }

    public Response request(Button button){
        if (button.getName() == ButtonNames.BEGIN)
            world.init();
        else if (button.getName() == ButtonNames.EXIT)
            isExit = true;
        else {
            world.update(button.getPosition());
            winChek();
        }
        return new Response(world, isWin, isExit);
    }
}
