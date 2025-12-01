package UserInterface.Game.BurgerAssembler;

import Component.Component;
import Component.Patty;
import Burger.Burger;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class BurgerDisplayer extends JPanel {
    JPanel burgerPanel;
    int height;
    Window window;
    Burger burger;
    public BurgerDisplayer(Patty patty, Window window) {
        setup(window);
        Image setSize = burger.getComponents().getFirst().getImg();
        setSize = setSize.getScaledInstance(100,50,  java.awt.Image.SCALE_SMOOTH);
        ImageIcon icon = new ImageIcon(setSize);
        JLabel label = new JLabel(icon);
        label.setAlignmentX(CENTER_ALIGNMENT);
        burgerPanel.add(label,1);
        addComponent(patty);
    }
    public BurgerDisplayer(Window window, Burger burger) {
        setup(window);
        Image setSize = burger.getComponents().getFirst().getImg();
        setSize = setSize.getScaledInstance(100,50,  java.awt.Image.SCALE_SMOOTH);
        ImageIcon icon = new ImageIcon(setSize);
        JLabel label = new JLabel(icon);
        label.setAlignmentX(CENTER_ALIGNMENT);
        burgerPanel.add(label,1);
        for(int i = 1; i<burger.getComponents().size(); i++) {
            addComponent(burger.getComponents().get(i));
        }
        System.out.println(burger.getComponents());
    }
    protected void addComponent(Component component) {
        if(height >= 8){
            JOptionPane.showMessageDialog(this.getParent(),"Limit reached","Too many components on burger",JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        Image setSize = component.getImg();
        setSize = setSize.getScaledInstance(100,50,  java.awt.Image.SCALE_SMOOTH);
        ImageIcon icon = new ImageIcon(setSize);
        JLabel label = new JLabel(icon);
        label.setAlignmentX(CENTER_ALIGNMENT);
        burgerPanel.add(label,1);
        height++;
        burger.addComponent(component);
        this.revalidate();
        this.repaint();
    }
    protected void setup(Window window){
        this.window = window;
        burger = new Burger();
        this.setPreferredSize(new Dimension(window.getWidth(), window.getHeight()));
        height = 1;
        burgerPanel = new JPanel();
        burgerPanel.setLayout(new BoxLayout(burgerPanel,BoxLayout.Y_AXIS));
        burgerPanel.setOpaque(false);
        burgerPanel.add(Box.createVerticalGlue(),0);
        this.setBorder(new EmptyBorder(0,0,10,0));
        this.setOpaque(false);
        this.setLayout(new BorderLayout());
        this.add(burgerPanel, BorderLayout.CENTER);
    }
    public Burger getBurger(){
        return burger;
    }
}
