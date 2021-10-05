package main.java.gui;

import main.java.Button;
import main.java.engine.Controller;
import main.java.engine.World;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GUI {
    private final Controller controller;
    private final List<Button> buttons;

    public GUI(){
        controller = new Controller();
        buttons = new ArrayList<>();
    }

    public void start(){
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.print("CLICK: ");
            String nextButtonName = scanner.next();
            Button nextButton = null;

            for (Button button: buttons) {
                if (button.getName().equals(nextButtonName)){
                    nextButton = button;
                }
            }

            if (nextButton != null){
                controller.request();
            } else {
                System.out.println("Button not found");
            }
        }
    }

    private void show(World world){

    }

    private void init(List<Button> buttons){

    }
}
