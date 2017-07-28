import javax.swing.*;
import java.awt.*;

public class View extends JPanel {
    private static final String FONT_NAME = "Arial";
    private static final int TILE_SIZE = 135;
    private static final int TILE_MARGIN = 10;
    private static final Color BG_COLOR = new Color(0x505050);

    private Controller controller;

    boolean isGameWon = false;
    boolean isGameLost = false;

    public View(Controller controller) {
        setFocusable(true);
        this.controller = controller;
        addMouseListener(controller);
        addKeyListener(controller);
        JButton button = new JButton();
        button.addMouseListener(controller);
        button.setVisible(false);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(BG_COLOR);
        g.fillRect(0, 0, this.getSize().width, this.getSize().height);
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                drawTile(g, controller.getGameTiles()[y][x], x, y);
            }
        }
        if (isGameWon)
            JOptionPane.showMessageDialog(this, "Game over");
    }

    private void drawTile(Graphics g2, Tile tile, int x, int y) {
        Graphics2D g = ((Graphics2D) g2);
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int value = tile.value;

        int xOffset = offsetCoors(x);
        int yOffset = offsetCoors(y);
        if (tile.isWinTile)
            g.setColor(tile.getWinColor());
        else g.setColor(tile.getTileColor());

        g.fillRoundRect(xOffset, yOffset, TILE_SIZE, TILE_SIZE, 10, 10);
        g.setColor(tile.getFontColor());
        final Font font = new Font(FONT_NAME, Font.BOLD, 90);
        g.setFont(font);
        String s ="";
        if (value == 1)
            s = "X";
        if (value == 2)
            s = "O";

        final FontMetrics fm = getFontMetrics(font);

        final int w = fm.stringWidth(s);
        final int h = -(int) fm.getLineMetrics(s, g).getBaselineOffsets()[2];

        if (value != 0)
            g.drawString(s, xOffset + (TILE_SIZE - w) / 2, yOffset + TILE_SIZE - (TILE_SIZE - h) / 2 - 2);
    }

    private static int offsetCoors(int arg) {
        return arg * (TILE_MARGIN + TILE_SIZE) + TILE_MARGIN;
    }

}
