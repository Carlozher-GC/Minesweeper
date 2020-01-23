package minesweeper.view;


import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import minesweeper.model.Point;
import minesweeper.model.Size;


public class BoardViewer extends JPanel {
    
    private Size size;
    private final Point position;
    
    public BoardViewer(Size size) {
        this.size = size;
        this.position = new Point(20, 75);
    }
    
    public void setSize(Size size) {
        this.size = size;
    }
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawRect(position.x-1, position.y-1, size.width*24+1, size.height*24+1);
        for (int i = 0; i < size.width; i++) 
            for (int j = 0; j < size.height; j++)
                g.drawImage(new ImageIcon("src/pictures/unrevealed.png").getImage(), i*24+position.x, j*24+position.y, this);
    }
    
    public void paintCell(int x, int y, String image) {
        Graphics g = this.getGraphics();
        g.clearRect(x*24+position.x, y*24+position.y, 20, 20);
        g.drawImage(new ImageIcon(image).getImage(), x*24+position.x, y*24+position.y, this);
    }
}
