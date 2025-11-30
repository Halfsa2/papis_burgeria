package Customer;

import Game.Day.Order.Order;

import javax.swing.*;
import java.io.Serializable;
import java.util.Random;

public class Customer implements Serializable {
    private Order order;
    private final int difficulty;
    private transient final ImageIcon image;
    private final int easyImageCount = 5;
    private final int normalImageCount = 5;
    private final int hardImageCount = 5;

    public Customer(int d) {
        difficulty = d;
        image = randomiseImageBasedOnDifficulty();
    }
    public void placeOrder(){
        order = new Order(difficulty);
    }
    public Order getOrder() {
        return order;
    }
    public int getDifficulty(){
        return difficulty;
    }
    public ImageIcon getImage() {
        return image;
    }
    private ImageIcon randomiseImageBasedOnDifficulty() {
        return switch (difficulty) {
            case 1 -> generateEasyImage();
            case 2 -> generateNormalImage();
            case 3 -> generateHardImage();
            default -> null;
        };
    }
    private ImageIcon generateEasyImage() {
        ImageIcon image;
        Random r = new Random();
        int customerNumber = r.nextInt(easyImageCount)+1;
        image = new ImageIcon(getClass().getResource("/images/customers/easy/" + customerNumber + ".png"));
        return image;
    }
    private ImageIcon generateNormalImage() {
        ImageIcon image;
        Random r = new Random();
        int customerNumber = r.nextInt(normalImageCount)+1;
        image = new ImageIcon(getClass().getResource("/images/customers/normal/" + customerNumber + ".png"));
        return image;
    }
    private ImageIcon generateHardImage() {
        ImageIcon image;
        Random r = new Random();
        int customerNumber = r.nextInt(hardImageCount)+1;
        image = new ImageIcon(getClass().getResource("/images/customers/hard/" + customerNumber + ".png"));
        return image;
    }
}
