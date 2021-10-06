package main.java;

public class Button {
    private final Position position;
    private final ButtonNames name;

    public Button(Position position, ButtonNames name) {
        this.position = position;
        this.name = name;
    }

    public Button(int x, int y, ButtonNames name){
        this.position = new Position();
        this.position.x = x;
        this.position.y = y;
        this.name = name;
    }

    public Position getPosition() {
        return position;
    }

    public ButtonNames getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format("%s(%d, %d)", name, position.x, position.y);
    }
}
