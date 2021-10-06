package main.java.gui;

import main.java.Button;
import main.java.engine.Controller;
import main.java.engine.World;

import java.util.ArrayList;
import java.util.List;


public class GUI {
    private final Controller controller;
    private final ComponentsInitializer componentsInitializer;
    private final InputHandler inputHandler;
    private final Drawer drawer;
    private List<Button> components;

    public GUI(){
        components = new ArrayList<>();
        controller = new Controller();
        inputHandler = new InputHandler(components);
        drawer = new Drawer(components);
        componentsInitializer = new ComponentsInitializer(components);
    }

    public void start(){
        componentsInitializer.initMenuButtons();
        drawer.draw(null);
        while (true){
            drawer.printPreInput();
            Button button = inputHandler.findButton();

            if (button != null){
                World world = controller.request(button);

                if (world.getExit()){
                    break;
                }

                componentsInitializer.initGameButtons();
                drawer.draw(world);
            } else {
                drawer.printNoSuchButtonError();
            }
        }
    }
}
