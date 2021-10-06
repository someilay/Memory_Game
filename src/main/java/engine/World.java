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

    private void initBoard(Tile[][] board){
        board = new Tile[WORLD_SIZE_X][WORLD_SIZE_X];
        for (int i = 0; i < WORLD_SIZE_Y; i++) {
            board[i] = new Tile[WORLD_SIZE_X];
        }

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

    public void init() {
        initBoard(this.board);
        this.lastOpenTile = null;
    }

    public int getOpenedTiles() {
        return openedTiles;
    }

    int randInt(int min, int max){
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    public Tile[][] getBoard() {
        return board;
    }

    public void update(Position position) {
        int x = position.x;
        int y = position.y;

        if (lastOpenTile != null) {
            if ( !lastOpenTile.getPosition().equals(position) ) {
                if ( lastOpenTile.getType() == board[x][y].getType() && !board[x][y].isOpen() ) {
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
}

