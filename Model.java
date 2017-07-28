

public class Model {
    private static final int FIELD_WIDTH = 3;
    private Tile[][] gameTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];

    public Model() {
        resetGameTiles();
    }

    public Tile[][] getGameTiles() {
        return gameTiles;
    }


    protected void resetGameTiles() {
        int k = 1;
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                Tile tile = new Tile();
                tile.setId(k);
                gameTiles[i][j] = tile;
                k++;
            }
        }
    }

    private boolean isWin(Tile[] tiles) {
        boolean isWin = false;
        boolean contin = true;
        for (Tile tile : tiles) {
            if (tile.value == 0) {
                contin = false;
            }
        }
        if (contin) {
            if ((tiles[0].value == tiles[1].value) && (tiles[0].value == tiles[2].value))
                isWin = true;
        }
        if (isWin) {
            for (Tile tile : tiles) {
                tile.isWinTile = true;
            }
        }
        else {
            for (Tile tile : tiles) {
                tile.isWinTile = false;
            }
        }
        return isWin;
    }

    private void rotate(Tile[][] gameTiles) {
        Tile tmp;
        for (int i = 0; i < FIELD_WIDTH / 2; i++) {
            for (int j = i; j < FIELD_WIDTH - 1 - i; j++) {
                tmp = gameTiles[i][j];
                gameTiles[i][j] = gameTiles[FIELD_WIDTH - j - 1][i];
                gameTiles[FIELD_WIDTH - j - 1][i] = gameTiles[FIELD_WIDTH - i - 1][FIELD_WIDTH - j - 1];
                gameTiles[FIELD_WIDTH - i - 1][FIELD_WIDTH - j - 1] = gameTiles[j][FIELD_WIDTH - i - 1];
                gameTiles[j][FIELD_WIDTH - i - 1] = tmp;
            }
        }
    }

    private boolean checkWinner() {
        boolean win = false;
        for (int i = 0; i < FIELD_WIDTH; i++) {
            if (isWin(gameTiles[i]))
                win = true;
        }
        if (isDiagWin(gameTiles))
        {
            win = true;
        }
        return win;
    }

    private boolean isDiagWin(Tile[][] gameTiles) {
        boolean isWin = false;
        boolean cont = true;
        for (int i = 0; i < gameTiles[0].length; i++) {
            if (gameTiles[i][i].value ==0)
                cont = false;
        }
        if (cont)
        {
            if ((gameTiles[0][0].value == gameTiles[1][1].value) && (gameTiles[0][0].value == gameTiles[2][2].value))
            {
                for (int i = 0; i < gameTiles[0].length; i++) {
                    gameTiles[i][i].isWinTile = true;
                    isWin = true;
                }
            }
            else
            {
                for (int i = 0; i < gameTiles[0].length; i++) {
                    gameTiles[i][i].isWinTile = false;
                }
            }
        }
        return isWin;
    }

    public boolean check() {
        boolean hasWinner = false;
        hasWinner = checkWinner();
        rotate(gameTiles);
        if (!hasWinner)
            hasWinner = checkWinner();
        rotate(gameTiles);
        rotate(gameTiles);
        rotate(gameTiles);
        return hasWinner;
    }


    public void changeTile(int n, int button) {
        if (button == 1)
            changeTileButton1(n);
        if (button == 3)
            changeTileButton2(n);
    }

    private void changeTileButton1(int k) {
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                if (gameTiles[i][j].id == k) {
                    if (gameTiles[i][j].value == 1)
                        gameTiles[i][j].value = 0;
                    else gameTiles[i][j].value = 1;
                }
            }
        }
    }

    private void changeTileButton2(int k) {
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                if (gameTiles[i][j].id == k) {
                    if (gameTiles[i][j].value == 2)
                        gameTiles[i][j].value = 0;
                    else gameTiles[i][j].value = 2;
                }
            }
        }
    }
}
