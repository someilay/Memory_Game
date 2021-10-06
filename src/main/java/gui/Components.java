package main.java.gui;

import main.java.Button;
import main.java.ButtonNames;
import main.java.engine.World;

import java.util.ArrayList;
import java.util.List;

public class Components {
    private List<Button> components;
    private boolean isGameButtonsInitialized = false;
    private boolean isMenuButtonsInitialized = false;

    public Components() {
        this.components = new ArrayList<>();
    }

    public void resetComponents(){
        components = new ArrayList<>();
        isGameButtonsInitialized = false;
        isMenuButtonsInitialized = false;
    }

    public void initMenuButtons(){
        if (!isMenuButtonsInitialized){
            components.add(new Button(0, 0, ButtonNames.BEGIN));
            components.add(new Button(0, 0, ButtonNames.EXIT));

            isMenuButtonsInitialized = true;
        }
    }

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

    public List<Button> getComponents() {
        return components;
    }
}
