package main.java.middleware;

import main.java.Button;
import main.java.engine.World;

/** Begin click behaviour class */
public class BeginClick implements ButtonClick {
    private final World world;

    public BeginClick(World world) {
        this.world = world;
    }

    @Override
    public Response execute(Button button) {
        world.init();
        return new Response(
                world,
                world.getOpenedTiles() == World.WORLD_SIZE_X * World.WORLD_SIZE_Y,
                false,
                world.getLastClickedTile()
        );
    }
}
