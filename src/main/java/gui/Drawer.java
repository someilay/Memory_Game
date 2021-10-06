package main.java.gui;

import main.java.Button;
import main.java.engine.Tile;
import main.java.engine.World;

import java.util.List;

public class Drawer {
    private List<Button> components;

    public Drawer(List<Button> components) {
        this.components = components;
    }

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

    public void printPreInput(){
        System.out.println("CLICK:");
    }

    public void printNoSuchButtonError(){
        System.out.println("No such button!");
    }

    public void printWin(){
        System.out.println("YOU WIN");
    }

    public void printBuyMessage(){
        System.out.println("Buy");
    }

    private void showField(World world){
        Tile[][] board = world.getBoard();
        for (int y = 0; y < World.WORLD_SIZE_Y; y++) {
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
