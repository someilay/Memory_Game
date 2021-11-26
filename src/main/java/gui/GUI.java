package main.java.gui;

import main.java.Button;
import main.java.middleware.Controller;
import main.java.middleware.Response;


/**
 * Class for simulation of main frame widget
 */
public class GUI {
    private final Controller controller;
    private final Components components;
    private InputHandler inputHandler;
    private Drawer drawer;

    /**
     * Constructor for the Gui object
     */
    public GUI(Controller controller){
        this.controller = controller;
        components = new Components();
        drawer = new Drawer(components.getComponents());
        inputHandler = new InputHandler(components.getComponents());
    }

    /**
     * Function for simulation staring
     */
    public void start(){
        components.initMenuButtons();
        drawer.draw(null, null);

        while (true){
            components.initMenuButtons();
            drawer.printPreInput();

            Button button = inputHandler.findButton();
            if (button != null){
                Response response = controller.request(button);

                if (response.isExit()){
                    drawer.printBuyMessage();
                    break;
                }

                if (response.isWin()){
                    components.resetComponents();
                    components.initMenuButtons();
                    drawer = new Drawer(components.getComponents());
                    inputHandler = new InputHandler(components.getComponents());
                    drawer.printWin();
                } else {
                    components.initGameButtons();
                }

                drawer.draw(response.getWorld(), response.getLastClickedTile());
            } else {
                drawer.printNoSuchButtonError();
            }
        }
    }
}
