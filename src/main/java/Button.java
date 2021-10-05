package main.java;

public class Button {
    private Position position;
    private final String name;

    public Button(Position position, String name) {
        this.position = position;
        this.name = name;
    }

    public Button(int x, int y, String name){
        this.position.x = x;
        this.position.y = y;
        this.name = name;
    }

    public Position getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
}
