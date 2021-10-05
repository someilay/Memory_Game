package main.java;

public class Button {
    private final Position position;
    private final String name;

    public Button(Position position, String name) {
        this.position = position;
        this.name = name;
    }

    public Button(int x, int y, String name){
        this.position = new Position(x, y);
        this.name = name;
    }

    public Position getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
}
