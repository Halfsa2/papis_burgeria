package UserInterface.Game.Customer.Order;

import Order.Order;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.util.Collections;
import java.util.List;

import Customer.Customer;
import Component.Component;
import UserInterface.Game.ContinueBtn;
import UserInterface.Window.Window;

public class CustomerOrderUI extends JLayeredPane {
    JLabel customerLabel;
    JList<Component> orderList;
    ContinueBtn continueBtn;
    Window window;
    Customer customer;
    int customerNumber;
    public CustomerOrderUI(Window window) {
        this.customerNumber = 0;
        this.window = window;
        initComponents();

    }
    protected void initComponents() {
        this.setLayout(null);

        orderList = new JList<>();

        this.customerLabel = new JLabel();
        customerSetup();
        pultSetup();
        setupOrderList();
        JPanel container = new JPanel();
        container.setLayout(null);
        container.setOpaque(false);
        container.setBounds(0, 0, window.getWidth(), window.getHeight());
        container.add(orderList);
        JPanel continueBtnPanel = new JPanel();
        JPanel buttonPanel = new JPanel();

        setupContinueBtn();
        continueBtnPanel.setLayout(new BorderLayout());
        buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.add(continueBtn);
        buttonPanel.setOpaque(false);

        continueBtnPanel.add(buttonPanel,BorderLayout.SOUTH);
        continueBtnPanel.setOpaque(false);
        continueBtnPanel.setBounds(new Rectangle(0,0,window.getWidth()-20, window.getHeight()-continueBtn.getPreferredSize().height-20));

        this.add(continueBtnPanel,JLayeredPane.DRAG_LAYER);
        this.add(container, JLayeredPane.POPUP_LAYER);
        this.add(this.customerLabel, JLayeredPane.DEFAULT_LAYER);
        this.setVisible(true);
    }
    protected void pultSetup(){
        ImageIcon pultImage = new ImageIcon(getClass().getResource("/images/pult.png"));
        JLabel pultLabel = new JLabel(pultImage);
        pultLabel.setBounds(3, -17, pultImage.getIconWidth()-20, pultImage.getIconHeight()-20);
        this.add(pultLabel, JLayeredPane.MODAL_LAYER);
    }
    protected void customerSetup(){
        System.out.println(customerNumber);
        this.customer = window.getGame().getToday().getCustomer(customerNumber);
        window.getGame().getToday().setCurrentCustomer(customer);
        customer.placeOrder();
        ImageIcon customerImage = new ImageIcon(customer.getImage().getImage().getScaledInstance(customer.getImage().getIconWidth()/2,customer.getImage().getIconHeight()/2,Image.SCALE_SMOOTH));
        System.out.println(customerImage.getImageLoadStatus());
        customerLabel.setBounds(400, 20, customerImage.getIconWidth(), customerImage.getIconHeight());
        customerLabel.setIcon(customerImage);
    }
    protected void setupContinueBtn(){
        continueBtn = new ContinueBtn(window);

    }
    public void cycleToNextCustomer(){
        customerNumber++;
        customerSetup();
        setupOrderList();
        this.revalidate();
        this.repaint();
    }
    public void newDay(){
        customerNumber = 0;
        customerSetup();
        setupOrderList();
        this.revalidate();
        this.repaint();
    }
    protected void setupOrderList(){
        Order order = customer.getOrder();
        List<Component> burgerComponents = order.getBurger().getComponents();
        Collections.reverse(burgerComponents);
        DefaultListModel<Component> model = new DefaultListModel<Component>();
        burgerComponents.forEach(model::addElement);
        orderList.setModel(model);
        makeOrderListStriped();
        System.out.println(order.getBurger().getComponents());
        orderList.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.ORANGE,3),"ORDER", TitledBorder.CENTER,TitledBorder.TOP));
        orderList.setBackground(Color.WHITE);
        orderList.setFixedCellHeight(30);
        int visibleRows = orderList.getModel().getSize()+1;
        int rowHeight = orderList.getFixedCellHeight();

        orderList.setPreferredSize(new Dimension(200, visibleRows * rowHeight));
        orderList.revalidate();

        orderList.setBounds(50,50,orderList.getPreferredSize().width, orderList.getPreferredSize().height);
    }
//    public void updateCustomer(Customer customer) {
//        this.customer = customer;
//        this.revalidate();
//        this.repaint();
//    }
    protected void makeOrderListStriped(){
        orderList.setCellRenderer(new DefaultListCellRenderer() {
            //ez ilyen bézs színű (úgyis látszik oldalt)
            private final Color evenColor = new Color(245, 245, 220);
            private final Color oddColor = Color.WHITE;

            @Override
            public java.awt.Component getListCellRendererComponent(
                    JList<?> list, Object value, int index,
                    boolean isSelected, boolean cellHasFocus) {

                java.awt.Component c = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

                if (!isSelected) {
                    if (index % 2 == 0) {
                        c.setBackground(evenColor);
                    } else {
                        c.setBackground(oddColor);
                    }
                }

                return c;
            }
        });
    }
    @Override
    protected void paintComponent(Graphics g) {
        ImageIcon bg = new ImageIcon(getClass().getResource("/images/customer_background.png"));
        Image img = bg.getImage();
        super.paintComponent(g);
        g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
    }
}
