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

    public void draw(World world){
        if (world != null){
            showField(world);
        }
    }

    private void showField(World world){
        Tile[][] board = world.getBoard();
        for (int y = 0; y < World.WORLD_SIZE_Y; y++) {
            for (int x = 0; x < World.WORLD_SIZE_X; x++) {
                if (board[y][x].isOpen()) {
                    System.out.print(board[y][x].getType());
                } else {
                    System.out.print("X");
                }
            }
            System.out.println();
        }
    }
}
