package main.java.engine;

public class Response {
    private World world;
    private boolean isWin;
    private boolean isExit;

    public Response(World world, boolean isWin, boolean isExit){
        this.world = world;
        this.isWin = isWin;
        this.isExit = isExit;
    }

    public World getWorld() {
        return world;
    }

    public boolean isWin(){
        return isWin;
    }

    public boolean isExit() {
        return isExit;
    }
}
