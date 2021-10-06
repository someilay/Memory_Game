package main.java.engine;

import main.java.Button;
import main.java.ButtonNames;

public class Controller {
    private World world;

    /**
     *  Constructor for the controller, that creates new world.
     */
    public Controller() {
        world = new World();
    }


    /**
     * The function that checks in the player has won and the game should end.
     * @return true if the game is over, false otherwise.
     */
    private boolean winChek() {
        return (world.getOpenedTiles() == World.WORLD_SIZE_X * World.WORLD_SIZE_Y);
    }

    /**
     * The function that process the last action and gives a response.
     * @param button - button that was clicked.
     * @return response that indicates current change applied to the game.
     */
    public Response request(Button button) {
        boolean isExit = false;

        if (button.getName() == ButtonNames.BEGIN)
            world.init();
        else if (button.getName() == ButtonNames.EXIT)
            isExit = true;
        else {
            world.update(button.getPosition());
        }

        return new Response(world, winChek(), isExit, world.getLastClickedTile());
    }
}
