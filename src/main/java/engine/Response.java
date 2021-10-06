package main.java.engine;

public class Response {
    private World world;
    private boolean isWin;
    private boolean isExit;
    private Tile lastClickedTile;

    public Response(World world, boolean isWin, boolean isExit, Tile tile) {
        this.world = world;
        this.isWin = isWin;
        this.isExit = isExit;
        this.lastClickedTile = tile;
    }

    public World getWorld() {
        return world;
    }

    public boolean isWin() {
        return isWin;
    }

    public boolean isExit() {
        return isExit;
    }

    public Tile getLastClickedTile() {
        return lastClickedTile;
    }
}
