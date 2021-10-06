package main.java.gui;

import main.java.Button;
import main.java.ButtonNames;
import main.java.engine.Controller;
import main.java.engine.Tile;
import main.java.engine.World;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class GUI {
    private final Controller controller;
    private final InputHandler inputHandler;
    private List<Button> components;

    public GUI(){
        controller = new Controller();
        initMenuButtons();
        inputHandler = new InputHandler(components);
    }

    public void start(){
        while (true){
            Button button = inputHandler.findButton();

            if (button != null){
                World world = controller.request(button);

                if (world.getExit()){
                    break;
                }
            } else {
                System.out.println("Error!");
            }
        }
    }

    private void initMenuButtons(){
        if (components == null){
            components = new ArrayList<>();
        }

        components.add(new Button(0, 0, ButtonNames.BEGIN));
        components.add(new Button(0, 0, ButtonNames.EXIT));
    }

    private void initGameButtons(){
        if (components == null){
            components = new ArrayList<>();
        }

        for (int x = 0; x < World.WORLD_SIZE_X; x++) {
            for (int y = 0; y < World.WORLD_SIZE_Y; y++) {
                components.add(new Button(x, y, ButtonNames.DEFAULT));
            }
        }
    }
}
