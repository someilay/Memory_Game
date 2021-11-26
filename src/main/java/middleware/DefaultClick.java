package main.java.middleware;

import main.java.Button;
import main.java.engine.World;

/** Default click behaviour class */
public class DefaultClick implements ButtonClick {
    private final World world;

    public DefaultClick(World world) {
        this.world = world;
    }

    @Override
    public Response execute(Button button) {
        world.update(button.getPosition());
        return new Response(
                world,
                world.getOpenedTiles() == World.WORLD_SIZE_X * World.WORLD_SIZE_Y,
                false,
                world.getLastClickedTile()
        );
    }
}
