package main.java;

/**
 * Class Button.
 */
public class Button {
    private final Position position;
    private final ButtonNames name;

    /**
     * Constructor for the component Button.
     * @param position the position
     * @param name     the name
     */
    public Button(Position position, ButtonNames name) {
        this.position = position;
        this.name = name;
    }

    /**
     * Constructor for the componentButton.
     *
     * @param x    the x
     * @param y    the y
     * @param name the name
     */
    public Button(int x, int y, ButtonNames name){
        this.position = new Position();
        this.position.x = x;
        this.position.y = y;
        this.name = name;
    }

    /**
     * Gets position
     * @return the position
     */
    public Position getPosition() {
        return position;
    }

    /**
     * Gets name
     * @return the name
     */
    public ButtonNames getName() {
        return name;
    }

    /**
     * String format
     * @return string format
     */
    @Override
    public String toString() {
        return String.format("%s(%d, %d)", name, position.x, position.y);
    }
}
