import java.awt.event.*;

public class Controller extends MouseAdapter implements KeyListener {
    private Model model;
    private View view;

    public View getView() {
        return view;
    }

    public Tile[][] getGameTiles() {
        return model.getGameTiles();
    }

    public Controller(Model model) {
        this.model = model;
        this.view = new View(this);
    }

    public void resetGame() {
        view.isGameWon = false;
        model.resetGameTiles();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        if (x > 10 && x < 145 && y > 10 && y < 145)
            model.changeTile(1, e.getButton());
        if (x > 155 && x < 290 && y > 10 && y < 145)
            model.changeTile(2, e.getButton());
        if (x > 300 && x < 435 && y > 10 && y < 145)
            model.changeTile(3, e.getButton());
        if (x > 10 && x < 145 && y > 155 && y < 290)
            model.changeTile(4, e.getButton());
        if (x > 155 && x < 290 && y > 155 && y < 290)
            model.changeTile(5, e.getButton());
        if (x > 300 && x < 435 && y > 155 && y < 290)
            model.changeTile(6, e.getButton());
        if (x > 10 && x < 145 && y > 300 && y < 435)
            model.changeTile(7, e.getButton());
        if (x > 155 && x < 290 && y > 300 && y < 435)
            model.changeTile(8, e.getButton());
        if (x > 300 && x < 435 && y > 300 && y < 435)
            model.changeTile(9, e.getButton());
        if (model.check())
            view.isGameWon = true;

        view.repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE)
            resetGame();
        view.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
