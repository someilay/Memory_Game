package main.java;

import main.java.middleware.Controller;
import main.java.gui.GUI;

/**
 * Main class
 */
public class Main {
    public static void main(String[] args) {
        Controller controller = new Controller();
        GUI gui = new GUI(controller);
        gui.start();
    }
}
