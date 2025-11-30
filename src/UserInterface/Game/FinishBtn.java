package UserInterface.Game;

import UserInterface.Window.Window;
import Game.Day.Burger.Burger;
import Customer.Customer;
import Game.Day.Order.Order;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FinishBtn extends JButton{
    Window window;
    Burger burger;
    Customer customer;
    Order order;
    public FinishBtn(Window window,Burger burger,Customer customer, Order order){
        super("Finish");
        this.window = window;
        this.burger = burger;
        this.customer = customer;
        this.order = order;
        this.addActionListener(new FinishButtonListener());
    }
    protected class FinishButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            window.finishAssembling(burger);
        }
    }
}
