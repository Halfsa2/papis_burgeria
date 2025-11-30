package Game.Day;

import Customer.Customer;
import Game.Day.Burger.Burger;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Day implements Serializable {
    List<Customer> customers;
    List<Burger> burgers;
    boolean doneWithToday;
    Customer currentCustomer;
    int count;
    int incomeForTheDay;
    public Day(int count) {
        this.count = count;
        customers = new ArrayList<>();
        doneWithToday = false;
        burgers = new ArrayList<>();
        generateCustomer();
    }
    public void generateCustomer() {
        Random r = new Random();
            if(count <= 2){
                addCustomer(new Customer(1));
            }else if(count <= 4){
                int diff = r.nextInt(2)+1;
                addCustomer(new Customer(diff));
            }else if(count <= 7){
                int diff = r.nextInt(3)+1;
                addCustomer(new Customer(diff));
            }else if(count <= 9){
                int diff = r.nextInt(2)+2;
                addCustomer(new Customer(diff));
            }else{
                addCustomer(new Customer(3));
            }
        if(customers.size() == count){
            doneWithToday = true;
        }
    }
    public boolean isDone(){
        return doneWithToday;
    }
    public void addBurger(Burger burger) {
        burgers.add(burger);
    }
    public void increaseIncome(int amount){
        incomeForTheDay += amount;
    }
    private void addCustomer(Customer customer) {
        customers.add(customer);
    }
    public List<Customer> getCustomers() {
        return customers;
    }
    public Customer getCurrentCustomer(){
        return currentCustomer;
    }
    public void setCurrentCustomer(Customer currentCustomer) {
        this.currentCustomer = currentCustomer;
    }
    public Customer getCustomer(int i){
        return customers.get(i);
    }
    public int getCount(){
        return this.count;
    }
    public Burger getLastBurger(){
        return burgers.getLast();
    }
    public int getProfit(){
        return incomeForTheDay;
    }
}
