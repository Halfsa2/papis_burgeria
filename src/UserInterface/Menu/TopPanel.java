package UserInterface.Menu;

import javax.swing.*;
import java.awt.*;

public class TopPanel extends javax.swing.JPanel {
    public TopPanel() {
        setOpaque(false);
        ImageIcon icon = new ImageIcon(getClass().getResource("/images/logo.png"));
        Image image = icon.getImage();
        image = image.getScaledInstance(200,200,Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(image);
        JLabel label = new JLabel(scaledIcon);
        label.setVisible(true);
        add(label);
        setVisible(true);
    }
}
