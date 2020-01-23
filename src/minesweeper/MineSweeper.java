package minesweeper;

import minesweeper.model.Size;
import minesweeper.presenter.GamePresenter;
import minesweeper.view.GameViewer;

public class MineSweeper {

    public static void main(String[] args) {
        GameViewer gameViewer = new GameViewer(new Size(9, 9));
        gameViewer.setGamePresenter(new GamePresenter(gameViewer));
        gameViewer.execute();
    }
    
}
