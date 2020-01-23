package minesweeper.model;

import java.util.HashSet;
import java.util.Random;

public class Board {
    
    private final Size size;
    private final int numberOfMines;
    private HashSet<Cell> mines;
    private HashSet<Cell> excludedCells;
    
    public Board(Size size, int numberOfMines) {
        this.size = size;
        this.numberOfMines = numberOfMines;
        this.excludedCells = new HashSet();
    }
    
    public Size getSize() {
        return this.size;
    }
    
    public int getNumberOfMines() {
        return this.numberOfMines;
    }
    
    public void exclude(Cell cell) {
        excludedCells.add(cell);
    }
    
    public boolean hasBeenInitialized() {
        return mines != null;
    }
    
    public void initialize(Cell excludedCell) {
        exclude(excludedCell);
        this.mines = new HashSet(this.numberOfMines);
        while (mines.size() < numberOfMines) {
            Cell cell = new Cell(getRandomInt(size.height), getRandomInt(size.width));
            if (excludedCells.contains(cell) || mines.contains(cell)) continue;
            mines.add(cell);
        }
    }
    
    private int getRandomInt(int max) {
        return new Random().nextInt(max);
    }
    
    public Cell cellAt(int x, int y) {
        return new Cell(x, y);
    }
    
    public boolean isCellInsideBoard(Cell cell) {
        return cell.x > -1 && cell.x < 9 && cell.y > -1 && cell.y < 9;
    }
    
    public class Cell  {
        public final int x;
        public final int y;
        
        public Cell(int x, int y) {
            this.x = x;
            this.y = y;
        }
        
        public int neighbourMines() {
            int count = 0;
            for (int i = this.x-1; i <= this.x+1; i++)
                for (int j = this.y-1; j <= this.y+1; j++)
                    if (mines.contains(new Cell(i, j)))
                        count++;
            return count;
        }
        
        public boolean hasMine() {
            return mines.contains(this);
        }

        @Override
        public int hashCode() {
            int hash = 7;
            hash = 79 * hash + this.x;
            hash = 79 * hash + this.y;
            return hash;
        }
        

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            final Cell other = (Cell) obj;
            if (this.x != other.x) {
                return false;
            }
            if (this.y != other.y) {
                return false;
            }
            return true;
        }

        @Override
        public String toString() {
            return "Cell{" + "x=" + x + ", y=" + y + '}';
        }
    }

    
}
