package UserInterface.Game.BurgerAssembler;

import Component.Component;
import Component.Patty;
import Component.Bun;
import Component.Cheese;
import Component.Lettuce;
import Component.Onion;
import Component.Pickle;
import Component.Tomato;
import Game.Day.Burger.Burger;
import UserInterface.Game.ContinueBtn;
import UserInterface.Window.Window;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AssembleBurgerUI extends JPanel {
    JComboBox<Component> componentChooser;
    BurgerDisplayer burgerDisplayer;
    JButton addBtn;
    Component[] components;
    Patty patty;
    Window window;
    public AssembleBurgerUI(Window window, Patty patty) {
        this.patty = patty;
        this.window = window;
        this.setLayout(new BorderLayout());
        loadComponents();
        componentChooser = new JComboBox<>(components);
        burgerDisplayer = new BurgerDisplayer(patty,window);
        addBtn = new JButton("Add");
        addBtn.setAlignmentX(CENTER_ALIGNMENT);
        addBtn.addActionListener(new AddComponentListener());

        JPanel continueBtnPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        ContinueBtn continueBtn = new ContinueBtn(window);
        continueBtn.addActionListener((ActionEvent e) -> {window.finishAssembling(burgerDisplayer.getBurger());});
        continueBtnPanel.add(continueBtn);
        continueBtnPanel.setOpaque(false);

        JPanel componentAdder = new JPanel();
        JPanel listAndButton = new JPanel();
        listAndButton.setLayout(new BoxLayout(listAndButton, BoxLayout.Y_AXIS));
        listAndButton.setOpaque(false);
        listAndButton.add(componentChooser);
        listAndButton.add(addBtn);
        componentAdder.setOpaque(false);
        componentAdder.add(listAndButton);
        this.add(componentAdder, BorderLayout.WEST);
        this.add(burgerDisplayer, BorderLayout.CENTER);
        this.add(continueBtnPanel, BorderLayout.SOUTH);

    }
    public void loadComponents() {
        components = new Component[6];
        components[0] = new Bun(true);
        components[1] = new Cheese();
        components[2] = new Tomato();
        components[3] = new Pickle();
        components[4] = new Lettuce();
        components[5] = new Onion();

    }
    protected class AddComponentListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            burgerDisplayer.addComponent((Component)componentChooser.getSelectedItem());
        }
    }
    protected void paintComponent(Graphics g) {
        ImageIcon bg = new ImageIcon(getClass().getResource("/images/assembly_background.png"));
        Image img = bg.getImage();
        super.paintComponent(g);
        g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
    }
}
