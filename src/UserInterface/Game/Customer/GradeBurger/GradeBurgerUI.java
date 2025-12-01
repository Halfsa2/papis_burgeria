package UserInterface.Game.Customer.GradeBurger;

import Customer.Customer;
import UserInterface.Game.BurgerAssembler.BurgerDisplayer;
import UserInterface.Game.ContinueBtn;
import UserInterface.Window.Window;
import Burger.Burger;

import javax.swing.*;
import java.awt.*;

public class GradeBurgerUI extends JLayeredPane {
    Burger burger;
    Window window;
    int profit;
    Customer customer;
    JLabel customerLabel;
    JPanel gradePanel;
    JLabel profitLabel;
    BurgerDisplayer burgerDisplayer;
    public GradeBurgerUI(Window window,int profit) {
        this.window = window;
        this.customer = window.getGame().getToday().getCurrentCustomer();
        this.burger = window.getGame().getToday().getLastBurger();
        this.profit = profit;
        this.setLayout(null);

        JPanel continueBtnPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        ContinueBtn continueBtn = new ContinueBtn(window);
        continueBtnPanel.add(continueBtn);
        continueBtnPanel.setOpaque(false);

        gradePanel = new JPanel();
        gradePanel.setLayout(new BorderLayout());
        gradePanel.setOpaque(false);
        gradePanel.setBounds(0,0,window.getWidth(),window.getHeight());
        gradePanel.setBorder(BorderFactory.createEmptyBorder(0,0,40,25));
        JPanel profitPanel = new JPanel();
        profitPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        profitPanel.setOpaque(false);
        //profitPanel.setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));


        JPanel burgerPanel = new JPanel();
        burgerPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        burgerPanel.setOpaque(false);

        pultSetup();
        customerSetup();
        burgerSetup();
        labelSetup();

        profitPanel.add(profitLabel);
        burgerPanel.add(burgerDisplayer);

        gradePanel.add(burgerPanel, BorderLayout.CENTER);
        gradePanel.add(profitPanel, BorderLayout.WEST);
        gradePanel.add(continueBtnPanel, BorderLayout.SOUTH);

        this.add(gradePanel,DRAG_LAYER);
    }
    protected void labelSetup(){
        profitLabel = new JLabel("+ " + profit+"$");
        profitLabel.setForeground(Color.green);
        profitLabel.setPreferredSize(new Dimension(200,50));
        profitLabel.setFont(profitLabel.getFont().deriveFont(Font.BOLD,30));
        //profitLabel.setBorder(BorderFactory.createLineBorder(Color.RED, 3));
    }
    protected void burgerSetup(){
        burgerDisplayer = new BurgerDisplayer(window, burger);
        burgerDisplayer.setBorder(BorderFactory.createEmptyBorder(0,0,100,0));
    }
    protected void pultSetup(){
        ImageIcon pultImage = new ImageIcon(getClass().getResource("/images/pult.png"));
        JLabel pultLabel = new JLabel(pultImage);
        pultLabel.setBounds(3, -17, pultImage.getIconWidth()-20, pultImage.getIconHeight()-20);
        this.add(pultLabel, JLayeredPane.MODAL_LAYER);
    }
    protected void customerSetup(){
        customer.placeOrder();
        ImageIcon customerImage = new ImageIcon(customer.getImage().getImage().getScaledInstance(customer.getImage().getIconWidth()/2,customer.getImage().getIconHeight()/2,Image.SCALE_SMOOTH));
        System.out.println(customerImage.getImageLoadStatus());
        this.customerLabel = new JLabel(customerImage);
        customerLabel.setBounds(400, 20, customerImage.getIconWidth(), customerImage.getIconHeight());
        this.add(customerLabel);
    }
    @Override
    protected void paintComponent(Graphics g) {
        ImageIcon bg = new ImageIcon(getClass().getResource("/images/customer_background.png"));
        Image img = bg.getImage();
        super.paintComponent(g);
        g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
    }
}
