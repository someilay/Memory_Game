package main.java.middleware;

import main.java.Button;
import main.java.engine.World;

/** Exit click behaviour class */
public class ExitClick implements ButtonClick {
    private final World world;

    public ExitClick(World world) {
        this.world = world;
    }

    @Override
    public Response execute(Button button) {
        return new Response(
                world,
                world.getOpenedTiles() == World.WORLD_SIZE_X * World.WORLD_SIZE_Y,
                true,
                world.getLastClickedTile()
        );
    }
}
