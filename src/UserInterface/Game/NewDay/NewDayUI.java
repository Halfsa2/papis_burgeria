package UserInterface.Game.NewDay;

import UserInterface.Game.ContinueBtn;
import UserInterface.Window.Window;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewDayUI extends JPanel {
    int day;
    JLabel lblDay;
    Window window;
    ContinueBtn btnContinue;
    public NewDayUI(Window window){
        this.window = window;
        init();
    }
    public void init(){
        lblDaySetup();
        btnContinue = new ContinueBtn(window);
        this.setBackground(new Color(135, 206, 235));
        this.setLayout(new BorderLayout());
        this.add(lblDay, BorderLayout.CENTER);
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.add(btnContinue);
        buttonPanel.setOpaque(false);
        this.add(buttonPanel, BorderLayout.SOUTH);
    }

    private void lblDaySetup(){
        lblDay = new JLabel("Day "+ day);
        lblDay.setHorizontalAlignment(SwingConstants.CENTER);
        lblDay.setVerticalAlignment(SwingConstants.CENTER);
        lblDay.setFont(new Font("Arial", Font.PLAIN, 90));
    }
    public void updateDay(){
        this.day = window.getGame().getDay();
        lblDay.setText("Day "+ day);
        System.out.println("day: "+day);
    }

}
