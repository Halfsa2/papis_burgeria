package UserInterface.LoadGame;

import FileHandler.LoadFromFile.LoadFromFile;

import javax.swing.*;
import java.awt.*;
import Game.Game;

public class LoadBtn extends JButton {
    private int slotNum;
    private JLabel lblSaveCount;
    private JLabel lblSaveDay;
    private JLabel lblSaveMoney;
    Game game;
    public LoadBtn(int s) {
        slotNum = s;
        game = LoadFromFile.loadGameFromSlot(slotNum);
        lblSaveCount=new JLabel("Save "+s);
        lblSaveDay=new JLabel("Day "+game.getDay());
        lblSaveMoney=new JLabel("$"+game.getMoney());
        lblSaveCount.setVerticalAlignment(SwingConstants.TOP);
        lblSaveCount.setHorizontalAlignment(SwingConstants.CENTER);
        lblSaveDay.setVerticalAlignment(SwingConstants.CENTER);
        lblSaveDay.setHorizontalAlignment(SwingConstants.CENTER);
        lblSaveMoney.setVerticalAlignment(SwingConstants.BOTTOM);
        lblSaveMoney.setHorizontalAlignment(SwingConstants.CENTER);
        add(lblSaveCount);
        add(lblSaveDay);
        add(lblSaveMoney);
        setBackground(Color.WHITE);
        setLayout(new GridLayout(3,1));
    }
    public Game getGame(){
        System.out.println("Game - Slotnum: "+ slotNum+ " Game: "+game);
        return game;
    }
    public int getSlot(){
        return slotNum;
    }

}
