package UserInterface.Menu;

import Game.Game;
import UserInterface.Window.Window;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuUI extends JPanel {
    TopPanel topPanel = new TopPanel();
    CenterPanel centerPanel = new CenterPanel();
    JButton loadBtn = new JButton();
    JButton newBtn = new JButton();
    JButton exitBtn = new JButton();
    public MenuUI(Window window){
        setup(window);
    }
    private void newBtnSetup(Window window){
        newBtn.setText("New Game");
        newBtn.setBackground(Color.WHITE);
        newBtn.addActionListener(e->{window.startGame(new Game(),0);});
    }
    private void exitBtnSetup(){
        exitBtn.setText("Exit");
        exitBtn.setBackground(Color.RED);
        exitBtn.setForeground(Color.WHITE);
        exitBtn.addActionListener(new ExitButtonListener());
    }
    private void loadBtnSetup(Window window){
        loadBtn.setText("Load Game");
        loadBtn.setBackground(Color.WHITE);
        loadBtn.addActionListener((e)->{window.showScreen("loadGame");});
    }
    private void centerPanelSetup(Window window){
        newBtnSetup(window);
        exitBtnSetup();
        loadBtnSetup(window);
        centerPanel.add(loadBtn);
        centerPanel.add(newBtn);
        centerPanel.add(exitBtn);
    }
    @Override
    protected void paintComponent(Graphics g) {
        ImageIcon bg = new ImageIcon(getClass().getResource("/images/menu_background.png"));
        Image img = bg.getImage();
        super.paintComponent(g);
        g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
    }
    private void setup(Window window){
        this.setLayout(new BorderLayout());
        centerPanelSetup(window);
        this.add(topPanel, BorderLayout.NORTH);
        this.add(centerPanel, BorderLayout.CENTER);
    }
    private class ExitButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == exitBtn){
                System.exit(0);
            }
        }
    }
}
