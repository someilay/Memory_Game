package main.java.engine;

import main.java.Button;
import main.java.ButtonNames;
import main.java.Position;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class World {
    public static final int WORLD_SIZE_X = 8;
    public static final int WORLD_SIZE_Y = 8;

    private Tile lastOpenTile;
    private int openedTiles;

    private Tile[][] board;
    private boolean isWin;
    private boolean isExit;

    private void initBoard(Tile[][] board){
        board = new Tile[WORLD_SIZE_X][WORLD_SIZE_X];

        TileCreator[] tileCreator = { new TileCreator1(), new TileCreator2(), new TileCreator3(), new TileCreator4() };
        ArrayList<Position> pos = new ArrayList<Position>(64);

        for (int i = 0; i < WORLD_SIZE_X; i++) {
            for (int j = 0; j < WORLD_SIZE_Y; j++) {
                pos.add(new Position(i, j));
            }
        }

        for (TileCreator creator : tileCreator) {
            for (int j = 0; j < WORLD_SIZE_X + WORLD_SIZE_Y; j++) {
                Position position = pos.remove(randInt(0, pos.size() - 1));
                board[position.x][position.y] = creator.create(position.x, position.y);
            }
        }
    }

    private void init() {
        setWin(false);
        setExit(false);

        initBoard(this.board);

        this.lastOpenTile = null;
    }

    public void setWin(boolean win) {
        this.isWin = win;
    }

    public void setExit(boolean exit) {
        this.isExit = exit;
    }

    public boolean getExit() {
        return this.isExit;
    }

    public boolean getWin() {
        return this.isWin;
    }

    private void winChek() {
        this.isWin = (openedTiles == 64);
    }

    int randInt(int min, int max){
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    public Tile[][] getBoard() {
        return board;
    }

    public void update(Button button){
        if (button.getName() == ButtonNames.BEGIN)
            init();
        else if (button.getName() == ButtonNames.EXIT)
            isExit = true;
        else {
            int x = button.getPosition().x;
            int y = button.getPosition().y;

            if (lastOpenTile != null) {
                if (!lastOpenTile.getPosition().equals(button.getPosition())) {
                    if (lastOpenTile.getType() == board[x][y].getType() && !board[x][y].isOpen()) {
                        board[x][y].open();
                        openedTiles++;
                    } else {
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

