import java.awt.*;

public class Tile {
    int value = 0;
    int id;
    boolean isWinTile = false;

    public void setId(int id) {
        this.id = id;
    }

    public Tile(int value) {
        this.value = value;
    }

    public Tile() {
    }

    public boolean isEmpty() {
        if (value == 0) {
            return true;
        } else return false;
    }

    public Color getFontColor() {
        Color color = new Color(0x776e65);
        return color;
    }

    public Color getTileColor() {
        Color color = new Color(0xf9f6f2);
        return color;
    }

    public Color getWinColor() {
        Color color = new Color(0x61fe27);
        return color;
    }


}
