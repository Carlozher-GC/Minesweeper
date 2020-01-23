package minesweeper.presenter;

import java.util.HashMap;
import java.util.Map;
import minesweeper.model.Board;
import minesweeper.model.Board.Cell;
import minesweeper.model.Size;
import minesweeper.view.BoardViewer;
import minesweeper.view.GameViewer;
import minesweeper.view.OptionsGUI;

public class GamePresenter {
    
    public static final int REVEALED = 0;
    public static final int UNREVEALED = 1;
    public static final int FLAG = 2;
    public static final int UNKNOWN = 3;

    enum CellState {
        
        REVEALED(0),UNREVEALED(1),FLAG(2),UNKNOWN(3);
    
        protected String image;
        protected int state;
        
        private CellState(int type) {
            state = type;
            switch (type) {
                case 0: 
                    image = null;
                    break;
                case 1: 
                    image = "src/pictures/unrevealed.png";
                    break;
                case 2: 
                    image = "src/pictures/flag.png";
                    break;
                case 3:
                    image = "src/pictures/unknown.png";
                    break;
            }
        }
     
    }
    
    private int restingCells;
    private GameViewer gameViewer;
    private BoardViewer boardViewer;
    private Board board;
    private Map<Cell,CellState> cellsStates;
    private Size size;
    private int numberOfMines;
    
    public GamePresenter(GameViewer gameViewer) {
        this.size = new Size(9, 9);
        this.numberOfMines = 10;
        this.board = new Board(size, numberOfMines);
        this.restingCells = board.getSize().height*board.getSize().width-board.getNumberOfMines();
        this.gameViewer = gameViewer;
        this.boardViewer = new BoardViewer(board.getSize());
        this.gameViewer.setBoard(boardViewer);
        this.cellsStates = new HashMap();
        for (int i = 0; i < board.getSize().width; i++)
            for (int j = 0; j < board.getSize().height; j++)
                this.cellsStates.put(board.cellAt(i, j), CellState.UNREVEALED);
    }
    
    public void manageLeftClick(int x, int y) {
            if (!board.hasBeenInitialized())
                board.initialize(board.cellAt(x, y));
            if (canBeRevealed(board.cellAt(x, y)))
                revealCell(board.cellAt(x, y));
            else
                gameViewer.setResetButtonImage("src/pictures/face_happy.png");
        if (restingCells == 0)
            victory();
    }
    
    public void manageRightClick(int x, int y) {
            if (board != null)
                if (canStateBeChanged(board.cellAt(x, y)))
                    changeCellState(board.cellAt(x, y));
    }
    
    private void revealCell(Cell cell) {       
        cellsStates.put(cell, CellState.REVEALED);
        if (cell.hasMine()) 
            gameOver(cell);
        else {
            if (cell.neighbourMines() == 0)
                reveallNeighbours(cell);
            boardViewer.paintCell(cell.x, cell.y, "src/pictures/number_" + cell.neighbourMines() + ".png");
            this.restingCells--;
            gameViewer.setResetButtonImage("src/pictures/face_happy.png");
        }    
    }
    
    private void reveallNeighbours(Cell cell) {
        for (int x = cell.x-1; x < cell.x+2; x++)
            for (int y = cell.y-1; y < cell.y+2; y++)
                if (board.isCellInsideBoard(board.cellAt(x, y)) && canBeRevealed(board.cellAt(x, y)))
                    revealCell(board.cellAt(x, y));
    }
    
    private void changeCellState(Cell cell) {
        switch (cellsStates.get(cell).state) {
            case UNREVEALED:
                
                cellsStates.put(cell, CellState.FLAG);
                break;
            case FLAG:
                cellsStates.put(cell, CellState.UNKNOWN);
                break;
            case UNKNOWN:
                cellsStates.put(cell, CellState.UNREVEALED);
                break;
        }
        boardViewer.paintCell(cell.x, cell.y, cellsStates.get(cell).image);
    }
    
    private boolean canStateBeChanged(Cell cell) {
        return cellsStates.get(cell).state != REVEALED;
    }
    
    private boolean canBeRevealed(Cell cell) {
        return cellsStates.get(cell).state == UNREVEALED || cellsStates.get(cell).state == UNKNOWN;
    }
    
    private void victory() {
        gameViewer.victory();
        this.reset();
    }
    
    public void changeGameOptions(Size size, int numberOfMines) {
        this.size = size;
        this.numberOfMines = numberOfMines;
        reset();
    }
    
    public void reset() {
        this.board = new Board(size, numberOfMines);
        for (int i = 0; i < board.getSize().width; i++)
            for (int j = 0; j < board.getSize().height; j++)
                this.cellsStates.put(board.cellAt(i, j), CellState.UNREVEALED);
        this.restingCells = board.getSize().height*board.getSize().width-board.getNumberOfMines();
        this.gameViewer.setSize(size);
        this.gameViewer.setup();
        this.boardViewer.setSize(size);
        this.boardViewer.repaint();
        this.gameViewer.execute();
    }
    
    private void gameOver(Cell cell) {
        this.revealBoard();
        this.boardViewer.paintCell(cell.x, cell.y, "src/pictures/mine_clicked.png");
        this.gameViewer.gameOver();
        this.reset();
    }
    
    private void revealBoard() {
        for (int x = 0; x < this.board.getSize().width; x++)
            for (int y = 0; y < this.board.getSize().height; y++) {
                if (board.cellAt(x, y).hasMine())
                    boardViewer.paintCell(x, y, "src/pictures/mine.png");
                else if (cellsStates.get(board.cellAt(x, y)) != CellState.REVEALED)
                    boardViewer.paintCell(x, y, "src/pictures/number_" + board.cellAt(x, y).neighbourMines() + ".png");
                this.cellsStates.put(board.cellAt(x, y), CellState.REVEALED);
            }
    }
    
    public Size getSize() {
        return size;
    }
    
}
