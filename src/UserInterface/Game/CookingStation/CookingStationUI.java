package UserInterface.Game.CookingStation;

import Component.Patty;
import UserInterface.Window.Window;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CookingStationUI extends JPanel {
    Window window;
    Patty pattyToCook;
    JLabel pattyLabel;
    JSlider heatSlider;
    JButton cookButton;
    JTextField timeTf;
    public CookingStationUI(Window window) {
        this.window = window;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        pattyToCook = new Patty();
        ImageIcon pattyIcon = new ImageIcon(pattyToCook.getImg().getScaledInstance(170,70,Image.SCALE_SMOOTH));
        pattyLabel = new JLabel(pattyIcon);
        pattyLabel.setHorizontalAlignment(JLabel.CENTER);
        pattyLabel.setVerticalAlignment(JLabel.BOTTOM);
        pattyLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        cookButton = new JButton("Cook");
        cookButton.addActionListener(new CookButtonListener());
        timeTf = new JTextField();
        cookingSetup();
    }
    protected void cookingSetup(){
        JPanel wrapper = new JPanel();
        wrapper.setOpaque(false);
        JPanel cookingPanel = new JPanel();
        cookingPanel.setLayout(new BoxLayout(cookingPanel,BoxLayout.Y_AXIS));
        cookingPanel.setOpaque(false);
        heatSlider = new JSlider(JSlider.HORIZONTAL, 0, 100, 0);
        heatSlider.setPreferredSize(new Dimension(200,30));
        cookButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        cookButton.setBackground(Color.DARK_GRAY);
        cookButton.setForeground(Color.WHITE);
        JPanel timePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        timeTf.setAlignmentX(Component.CENTER_ALIGNMENT);
        timeTf.setPreferredSize(new Dimension(30,30));
        timeTf.setHorizontalAlignment(JTextField.CENTER);
        JLabel timeLabel = new JLabel("min");
        timeLabel.setForeground(Color.WHITE);
        timePanel.setOpaque(false);
        timePanel.add(timeTf);
        timePanel.add(timeLabel);
        heatSlider.setOpaque(false);
        cookingPanel.setOpaque(false);
        cookingPanel.add(heatSlider);
        cookingPanel.add(timePanel);
        cookingPanel.add(cookButton);
        cookingPanel.add(Box.createVerticalStrut(20));
        wrapper.add(cookingPanel);
        this.add(Box.createVerticalStrut(260));
        this.add(pattyLabel);
        this.add(wrapper);
    }
    public void reset(){
        heatSlider.setValue(0);
        timeTf.setText("");
        this.revalidate();
        this.repaint();
    }
    protected class CookButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try{
                int time = Integer.parseInt(timeTf.getText());
                window.finishCooking(pattyToCook,heatSlider.getValue(),time);
            }catch (NumberFormatException ex){
                JOptionPane.showMessageDialog(window,"Please enter the duration for which you want to cook your patty in minutes (only numbers [0-9] allowed)","Invalid input",JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    @Override
    protected void paintComponent(Graphics g) {
        ImageIcon bg = new ImageIcon(getClass().getResource("/images/cookingStation_background.png"));
        Image img = bg.getImage();
        ImageIcon griddle = new ImageIcon(getClass().getResource("/images/griddle.png"));
        Image img2 = griddle.getImage();
        super.paintComponent(g);
        g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
        g.drawImage(img2, 0, 100, getWidth(), getHeight(), this);
    }
}
