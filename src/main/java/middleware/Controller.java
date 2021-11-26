package main.java.middleware;

import main.java.Button;
import main.java.ButtonNames;
import main.java.engine.World;

import java.util.EnumMap;
import java.util.Map;

/** The Invoker class */
public class Controller {
    private final Map<ButtonNames, ButtonClick> poolOfClicks; // Collection of possible clicks

    /**
     *  Constructor for the controller, that creates new world.
     */
    public Controller() {
        World world = new World();
        poolOfClicks = new EnumMap<>(ButtonNames.class);

        poolOfClicks.put(ButtonNames.BEGIN, new BeginClick(world));
        poolOfClicks.put(ButtonNames.EXIT, new ExitClick(world));
        poolOfClicks.put(ButtonNames.DEFAULT, new DefaultClick(world));
    }

    /**
     * The function that process the last action and gives a response.
     * @param button - button that was clicked.
     * @return response that indicates current change applied to the game.
     */
    public Response request(Button button) {
        ButtonClick buttonClick = poolOfClicks.get(button.getName());
        if (buttonClick == null) {
            throw new IllegalStateException("No such action!");
        }
        return buttonClick.execute(button);
    }
}
