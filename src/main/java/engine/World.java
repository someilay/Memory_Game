package main.java.engine;

import main.java.Button;
import main.java.ButtonNames;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class World {
    public static final int WORLD_SIZE_X = 8;
    public static final int WORLD_SIZE_Y = 8;

    private Tile lastOpenTile;
    private int openedTiles;

    private Tile[][] board;
    private int isWin;
    private int isExit;

    private void initBoard(Tile[][] board){
        TileCreator[] tileCreator = {new TileCreator1(), new TileCreator2(), new TileCreator3(), new TileCreator4()};
        ArrayList<Integer> X = new ArrayList<Integer>(8);
        ArrayList<Integer> Y = new ArrayList<Integer>(8);
        for (int i = 0; i < 8; i++) {
            X.add(i);
            Y.add(i);
        }

        for (int i = 0; i < tileCreator.length; i++) {
            for (int j = 0; j < WORLD_SIZE_X + WORLD_SIZE_Y; j++) {
                int x = X.remove(randInt(0, X.size() - 1));
                int y = Y.remove(randInt(0, Y.size() - 1));
                board[x][y] = tileCreator[i].create(x, y);
            }
        }
    }

    private void init(){
        setWin(0);
        setExit(0);

        initBoard(this.board);

        this.lastOpenTile = null;
    }

    public void setWin(int win) {
        this.isWin = win;
    }

    public void setExit(int exit) {
        this.isExit = exit;
    }

    public int getExit() {
        return this.isExit;
    }

    public int getWin() {
        return this.isWin;
    }

    private void winChek(){
        if(openedTiles == 64)
            this.isWin = 1;
    }

    int randInt(int min, int max){
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    public Tile[][] getBoard() {
        return board;
    }

    public void update(Button button){
        if(button.getName() == ButtonNames.BEGIN)
            init();
        else if(button.getName() == ButtonNames.EXIT)
            isExit = 1;
        else{
            int x = button.getPosition().x;
            int y = button.getPosition().y;

            if(lastOpenTile != null){
                if(!lastOpenTile.getPosition().equals(button.getPosition())){
                    if(lastOpenTile.getType() == board[x][y].getType() && !board[x][y].isOpen()){
                        board[x][y].open();
                        openedTiles++;
                    }
                    else{
                        board[lastOpenTile.getPosition().x][lastOpenTile.getPosition().y].hide();
                        openedTiles--;
                    }
                    lastOpenTile = null;
                }
            } else {
                board[x][y].open();
                lastOpenTile = board[x][y];
            }
        }

        winChek();
    }
}

