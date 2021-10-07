package main.java.engine;

public class Response {
    private World world;
    private boolean isWin;
    private boolean isExit;
    private Tile lastClickedTile;

    /**
     * The function that saves parameters returned after an action was done.
     * @param world - current state of the world.
     * @param isWin - variable that indicates if the game has ended.
     * @param isExit - variable that indicates exit from GUI.
     * @param tile - information about last active tile, or null if there are currently none.
     */
    public Response(World world, boolean isWin, boolean isExit, Tile tile) {
        this.world = world;
        this.isWin = isWin;
        this.isExit = isExit;
        this.lastClickedTile = tile;
    }

    /**
     * Getter for current world state.
     * @return current world state.
     */
    public World getWorld() {
        return world;
    }

    /**
     * Getter for the current game state.
     * @return true if the game should end.
     */
    public boolean isWin() {
        return isWin;
    }

    /**
     * Getter for the 'exit' status.
     * @return true if program should stop.
     */
    public boolean isExit() {
        return isExit;
    }

    /**
     * Getter for the tile opened in the previous action.
     * @return null previously opened tile was closed, otherwise opened tile.
     */
    public Tile getLastClickedTile() {
        return lastClickedTile;
    }
}
