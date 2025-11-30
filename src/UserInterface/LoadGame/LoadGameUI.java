package UserInterface.LoadGame;

import FileHandler.LoadFromFile.LoadFromFile;
import Game.Game;
import UserInterface.Window.Window;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class LoadGameUI extends JPanel {
    GridPanel grid;
    JPanel centerPanel;
    JPanel bottomPanel;
    JButton back;
    Window window;
    JButton btn1;
    JButton btn2;
    JButton btn3;
    public LoadGameUI(Window window){
        this.window = window;
        centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.X_AXIS));
        JLabel title = new JLabel("Choose a save file!");
        title.setFont(title.getFont().deriveFont(40f));
        title.setHorizontalAlignment(SwingConstants.CENTER);
        back = new JButton("Back");
        back.setHorizontalAlignment(SwingConstants.RIGHT);
        back.addActionListener(e->{window.showScreen("menu");});
        grid = new GridPanel();

        loadBtnSetup();

        bottomPanel = new JPanel();
        bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.LINE_AXIS));
        bottomPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        bottomPanel.add(Box.createHorizontalGlue());
        bottomPanel.setAlignmentX(Component.RIGHT_ALIGNMENT);
        bottomPanel.add(back);
        this.setLayout(new BorderLayout());
        this.add(centerPanel, BorderLayout.CENTER);
        this.add(title, BorderLayout.NORTH);
        this.add(bottomPanel, BorderLayout.SOUTH);
    }
    private void loadBtnSetup(){
        //Megnézzük, a 3 slot közül melyiken van save
        for(int i = 1; i<4; i++){
            File file = LoadFromFile.loadFileFromSlot(i);
            //Amelyiken van, ott loadBtn-t hozunk létre
            if(file.exists()){
                switch(i){
                    case 1: btn1 = new LoadBtn(i);btn1.addActionListener(new LoadBtnListener());break;
                    case 2: btn2 = new LoadBtn(i);btn2.addActionListener(new LoadBtnListener());break;
                    case 3: btn3 = new LoadBtn(i);btn3.addActionListener(new LoadBtnListener());break;
                }
            //Ahol nincs, ott pedig EmptySave-t.
            // Itt megtehetném azt is, hogy az első után az összes többit is megcsinálom,
            // mert ha az első empty akkor az utána következők is azok lesznek (és a másodiknál is ugyanez)
            }else{
                switch(i){
                    case 1: btn1 = new EmptySaveBtn();btn1.addActionListener(new EmptySaveBtnListener());break;
                    case 2: btn2 = new EmptySaveBtn();btn2.addActionListener(new EmptySaveBtnListener());break;
                    case 3: btn3 = new EmptySaveBtn();btn3.addActionListener(new EmptySaveBtnListener());break;
                }
            }
        }
        centerPanel.add(Box.createRigidArea(new Dimension(10, 0)));
        centerPanel.add(btn1);
        centerPanel.add(Box.createRigidArea(new Dimension(10, 0)));
        centerPanel.add(btn2);
        centerPanel.add(Box.createRigidArea(new Dimension(10, 0)));
        centerPanel.add(btn3);
        centerPanel.add(Box.createRigidArea(new Dimension(10, 0)));
    }
    private class LoadBtnListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource().getClass() == LoadBtn.class){
                window.startGame(((LoadBtn)e.getSource()).getGame(),((LoadBtn) e.getSource()).getSlot());
            }
        }
    }
    private class EmptySaveBtnListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            window.startGame(new Game(),0);
        }
    }
}
