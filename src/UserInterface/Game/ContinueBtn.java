package UserInterface.Game;

import UserInterface.Game.NewDay.NewDayUI;
import UserInterface.Window.Window;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ContinueBtn extends JButton {
    Window window;
    public ContinueBtn(Window window) {
        this.window = window;
        this.setText("Continue");
        this.setBackground(Color.WHITE);
        this.addActionListener(new ContinueButtonListener());
    }
    public class ContinueButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            window.showNextScreen();
        }
    }
}
