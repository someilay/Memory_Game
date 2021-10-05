package main.java.engine;

import java.util.concurrent.ThreadLocalRandom;

public class World {
    final int WORLD_SIZE_X = 8;
    final int WORLD_SIZE_Y = 8;

    private Tile[][] board;
    private int win;
    private int exit;

    public World(){
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
    }

    public void setWin(int win) {
        this.win = win;
    }

    public void setExit(int exit) {
        this.exit = exit;
    }

    public int getExit() {
        return exit;
    }

    public int getWin() {
        return win;
    }

    int randInt(int min, int max){
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    public Tile[][] getBoard() {
        return board;
    }
}

