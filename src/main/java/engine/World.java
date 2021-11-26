package main.java.engine;

import main.java.Position;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

/** The Receiver class */
public class World {
    public static final int WORLD_SIZE_X = 4;
    public static final int WORLD_SIZE_Y = 4;

    private Tile lastOpenTile;
    private Tile lastClickedTile;
    private int openedTiles;
    private Tile[][] board;


    /**
     * The function that creates board and fills it with tiles.
     */
    private void initBoard() {
        board = new Tile[WORLD_SIZE_Y][WORLD_SIZE_X];

        for (int i = 0; i < WORLD_SIZE_Y; i++) {
            board[i] = new Tile[WORLD_SIZE_X];
        }

        TileCreator[] tileCreator = { new TileCreator1(), new TileCreator2(), new TileCreator3(), new TileCreator4() };
        ArrayList<Position> pos = new ArrayList<>(WORLD_SIZE_X * WORLD_SIZE_Y);

        for (int y = 0; y < WORLD_SIZE_Y; y++) {
            for (int x = 0; x < WORLD_SIZE_X; x++) {
                pos.add(new Position(x, y));
            }
        }

        for (TileCreator creator : tileCreator) {
            for (int j = 0; j < WORLD_SIZE_X * WORLD_SIZE_Y / tileCreator.length; j++) {
                Position position = pos.remove(randInt(0, pos.size() - 1));
                board[position.y][position.x] = creator.create(position.x, position.y);
            }
        }
    }

    /**
     * The function called to initialize all values in the World.
     */
    public void init() {
        initBoard();
        lastOpenTile = null;
        lastClickedTile = null;
        openedTiles = 0;
    }

    /**
     * Getter for number of opened tiles overall.
     * @return Number of opened tiles.
     */
    public int getOpenedTiles() {
        return openedTiles;
    }

    /**
     * Getter for the prevoiusly clicked tile.
     * @return last tile that was clicked, or null if there are none.
     */
    public Tile getLastClickedTile() {
        return lastClickedTile;
    }

    /**
     * The function for random integer generation.
     * @param min - Minimum integer to get in return.
     * @param max - Maximum integer to get in return.
     * @return Random integer in range [min, max].
     */
    int randInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    /**
     * Getter for the current board state.
     * @return current board state.
     */
    public Tile[][] getBoard() {
        return board;
    }

    /**
     * Function to update the board after some button was cliked.
     * @param position - position of the button that was clicked.
     */
    public void update(Position position) {
        int x = position.x;
        int y = position.y;

        lastClickedTile = board[y][x];

        if (lastOpenTile != null) {
            if (!board[y][x].isOpen()) {
                if (lastOpenTile.getType() == board[y][x].getType()) {
                    board[y][x].open();
                    openedTiles += 2;
                } else {
                    board[lastOpenTile.getPosition().y][lastOpenTile.getPosition().x].hide();
                }

                lastOpenTile = null;
            }
        } else {
            board[y][x].open();
            lastOpenTile = board[y][x];
        }
    }
}

