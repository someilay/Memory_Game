package main.java.gui;

import main.java.Button;
import main.java.engine.Tile;
import main.java.engine.World;

import java.util.List;

/**
 * Class for simulation widget redrawing
 * Also this class responsible for user notifications about ongoing processes
 */
public class Drawer {
    private List<Button> components;

    /**
     * Constructor for the drawer object
     * @param components list if tile buttons
     */
    public Drawer(List<Button> components) {
        this.components = components;
    }

    /**
     * Function outputs information about available unopened tiles
     * @param world  receive object that handle operations on tile
     * @param lastClickedTile last chosen tile, null if it has first chosen
     */
    public void draw(World world, Tile lastClickedTile){
        if (lastClickedTile != null){
            System.out.printf(
                    "Last clicked tile is %d and has coordinates (%d, %d)%n",
                    lastClickedTile.getType(),
                    lastClickedTile.getPosition().x,
                    lastClickedTile.getPosition().y
            );
        }

        if (world != null){
            System.out.println("Field:");
            showField(world);
        }

        System.out.println("Available buttons: ");
        printButtons(0, 2);
        printButtons(2, components.size());

        System.out.println("Input format: BUTTON_NAME or BUTTON_NAME <x> <y>. " +
                "Last one are needed for specifying concrete button");
    }

    /**
     * Simulation of user clicking
     */
    public void printPreInput(){
        System.out.println("CLICK:");
    }

    /**
     * Handler for button fault
     */
    public void printNoSuchButtonError(){
        System.out.println("No such button!");
    }

    /**
     * Handler for printing Winning event
     */
    public void printWin(){
        System.out.println("YOU WIN");
    }

    public void printBuyMessage(){
        System.out.println("Buy");
    }

    /**
     * Function for printing board with tiles
     * @param world receive object that handle operations on tile
     */
    private void showField(World world){
        System.out.print("  ");
        for (int x = 0; x < World.WORLD_SIZE_X; x++) {
            System.out.print(x + " ");
        }
        System.out.println();

        Tile[][] board = world.getBoard();
        for (int y = 0; y < World.WORLD_SIZE_Y; y++) {
            System.out.print(y + " ");
            for (int x = 0; x < World.WORLD_SIZE_X; x++) {
                if (board[y][x].isOpen()) {
                    System.out.print(board[y][x].getType() + " ");
                } else {
                    System.out.print("X ");
                }
            }
            System.out.println();
        }
    }

    /**
     * Function for printing button type
     * @param start
     * @param end
     */
    private void printButtons(int start, int end){
        int k = 1;
        boolean needToPrintNewLine = false;

        for (int i = start; i < end; i++) {
            System.out.print(components.get(i) + " ");
            needToPrintNewLine = true;

            if (k % World.WORLD_SIZE_X == 0){
                System.out.println();
                needToPrintNewLine = false;
            }
            k++;
        }

        if (needToPrintNewLine){
            System.out.println();
        }
    }
}
