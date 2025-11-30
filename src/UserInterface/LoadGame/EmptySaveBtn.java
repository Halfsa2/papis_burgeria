package UserInterface.LoadGame;

import javax.swing.*;
import java.awt.*;

public class EmptySaveBtn extends JButton {
    public EmptySaveBtn() {
        setBackground(Color.WHITE);
        setLayout(new GridLayout(3,1));
        JLabel label = new JLabel("New Save");
        JLabel label2 = new JLabel();
        JLabel label3 = new JLabel();
        label.setHorizontalAlignment(SwingConstants.CENTER);
        add(label2);
        add(label);
        add(label3);

    }
}
