package main.java.engine;

import main.java.Button;
import main.java.ButtonNames;

import java.util.concurrent.ThreadLocalRandom;

public class World {
    public static final int WORLD_SIZE_X = 8;
    public static final int WORLD_SIZE_Y = 8;

    private Tile lastOpenTile;
    private int openedTiles;

    public Tile[][] board;
    private int isWin;
    private int isExit;

    private void init(){
        TileCreator tileCreator1 = new TileCreator1();
        TileCreator tileCreator2 = new TileCreator2();
        TileCreator tileCreator3 = new TileCreator3();
        TileCreator tileCreator4 = new TileCreator4();
        setWin(0);
        setExit(0);
        int[] count = {16, 16, 16, 16};

        for (int i = 0; i < WORLD_SIZE_X; i++) {
            for (int j = 0; j < WORLD_SIZE_Y; j++) {
                while(true){
                    int type = randInt(0, 3);
                    if(count[type] != 0){
                        if(type == 0){
                            board[i][j] = tileCreator1.create(i ,j);
                            count[type]--;
                            break;
                        }
                        else if(type == 1){
                            board[i][j] = tileCreator2.create(i ,j);
                            count[type]--;
                            break;
                        }
                        else if(type == 2){
                            board[i][j] = tileCreator3.create(i ,j);
                            count[type]--;
                            break;
                        }
                        else if(type == 3){
                            board[i][j] = tileCreator4.create(i ,j);
                            count[type]--;
                            break;
                        }
                    }
                }
            }
        }

        lastOpenTile = null;
    }

    public void setWin(int win) {
        this.isWin = win;
    }

    public void setExit(int exit) {
        this.isExit = exit;
    }

    public int getExit() {
        return isExit;
    }

    public int getWin() {
        return isWin;
    }

    private void winChek(){
        if(openedTiles == 64)
            isWin = 1;
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
                    if(lastOpenTile.getType() == board[x][y].getType()){
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

