package main.java.gameObjects;

public class GameObject {
    private boolean isOpen;
    private Position position;
    public Type type;

    public void setPosition(int x, int y){
        position = new Position(x, y);
    }

    public void open(){
        isOpen = true;
    }

    public void hide(){
        isOpen = false;
    }

}
