package main.java.gui;

import main.java.Button;
import main.java.ButtonNames;
import main.java.engine.World;

import java.util.ArrayList;
import java.util.List;

/**
 * Class for emulating widget components
 * Contains list of tiles and initiation screen
 * Also reflects game stage: uninitialized, in process and finished
 */
public class Components {
    private List<Button> components;
    private boolean isGameButtonsInitialized = false;
    private boolean isMenuButtonsInitialized = false;


    /**
     * Constructor for the component object.
     * It initializes list of tiles by default
     */
    public Components() {
        this.components = new ArrayList<>();
    }

    /**
     * Function used for preparing table for new game
     */
    public void resetComponents(){
        components = new ArrayList<>();
        isGameButtonsInitialized = false;
        isMenuButtonsInitialized = false;
    }

    /**
     * Function initialize menu button user
     */
    public void initMenuButtons(){
        if (!isMenuButtonsInitialized){
            components.add(new Button(0, 0, ButtonNames.BEGIN));
            components.add(new Button(0, 0, ButtonNames.EXIT));

            isMenuButtonsInitialized = true;
        }
    }

    /**
     * Function initialize button for game staring
     */
    public void initGameButtons(){
        if (!isGameButtonsInitialized){
            for (int x = 0; x < World.WORLD_SIZE_X; x++) {
                for (int y = 0; y < World.WORLD_SIZE_Y; y++) {
                    components.add(new Button(x, y, ButtonNames.DEFAULT));
                }
            }

            isGameButtonsInitialized = true;
        }
    }

    /**
     * @return list of all tile buttons
     */
    public List<Button> getComponents() {
        return components;
    }
}
