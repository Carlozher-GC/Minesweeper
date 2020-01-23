package minesweeper.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import minesweeper.model.Point;
import minesweeper.model.Size;
import minesweeper.presenter.GamePresenter;

public class GameViewer extends JFrame {
    
    private Size size;
    private Point leftTopCornerPosition;
    private GamePresenter gamePresenter;
    private JButton resetButton;
    private JMenu game, info;
    
    public GameViewer(Size size) {
        this.leftTopCornerPosition = new Point(27, 128);
        this.size = size;
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        JMenuBar toolBar = new JMenuBar();
        game = new JMenu("Game");
        JMenuItem options = new JMenuItem("Options");
        options.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openOptionsDialog();
            }
        });
        JMenuItem reset = new JMenuItem("Reset");
        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gamePresenter.reset();  
            }
            
        });
        game.add(options);
        game.add(reset);
        info = new JMenu("Info");
        JMenuItem infoItem = new JMenuItem("Info");
        infoItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Done by Carlos Lozano Herrera", "Information", JOptionPane.INFORMATION_MESSAGE);
            }
            
        });
        info.add(infoItem);
        toolBar.add(game);
        toolBar.add(info);
        setJMenuBar(toolBar);
        
        resetButton = new JButton();
        resetButton.setSize(40, 40);
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gamePresenter.reset();
            }
        });
        this.setup();
        add(resetButton);
        
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent evt) {
                if (isBoardClick(evt.getX(), evt.getY()))
                    if (SwingUtilities.isLeftMouseButton(evt))
                        setResetButtonImage("src/pictures/face_worried.png");
            }
            
            @Override
            public void mouseReleased(MouseEvent evt) {
                if (isBoardClick(evt.getX(), evt.getY()))
                    if (SwingUtilities.isLeftMouseButton(evt))
                        gamePresenter.manageLeftClick(normalizeXCoordinate(evt.getX()), normalizeYCoordinate(evt.getY()));
                    else if (SwingUtilities.isRightMouseButton(evt))
                        gamePresenter.manageRightClick(normalizeXCoordinate(evt.getX()), normalizeYCoordinate(evt.getY()));
            }
        });
    }
    
    private void openOptionsDialog() {
        new OptionsGUI(this, gamePresenter);
    }
    
    public void setup() {
        setSize(size.width*24+58, size.height*24+150);
        resetButton.setLocation(getWidth()/2-28, 15);
        setResetButtonImage("src/pictures/face_happy.png");
    }
    
    public void setSize(Size size) {
        this.size = size;
    }
    
    public void setResetButtonImage(String image) {
        resetButton.setIcon(new ImageIcon(image));
    }
    
    public void victory() {
        setResetButtonImage("src/pictures/face_winner.png");
        JOptionPane.showMessageDialog(null, "Enhorabuena! Has ganado.");
    }
    
    public void gameOver() {
        setResetButtonImage("src/pictures/face_loser.png");
        JOptionPane.showMessageDialog(null, "Vaya! Has perdido.");
    }
    
    public void setBoard(BoardViewer boardViewer) {
        this.add(boardViewer);
    }
    
    public void setGamePresenter(GamePresenter gamePresenter) {
        this.gamePresenter = gamePresenter;
    }
    
    public void execute() {
        setVisible(true);
    }
    
    private int normalizeXCoordinate(int x) {
        return (x-27)/24;
    }
    
    private int normalizeYCoordinate(int y) {
        return (y-128)/24;
    }
    
    private boolean isBoardClick(int x, int y) {
        return x > this.leftTopCornerPosition.x && x < this.leftTopCornerPosition.x+size.width*24 && y > this.leftTopCornerPosition.y && y < this.leftTopCornerPosition.y+size.height*24;
    }
    
}
