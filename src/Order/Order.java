package Order;

import Burger.Burger;
import Component.*;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Order implements Serializable {
    private final Burger burger;
    //1 = easy - 3 components
    //2 = medium - 5 components
    //3 = hard - 7 components
    private final int difficulty;
    public Order(int difficulty) {
        this.difficulty = difficulty;
        burger = generateOrder();
    }
    private Burger generateOrder() {
        Burger burger = new Burger();
        System.out.println("generating order of difficulty: " + difficulty);
        switch (difficulty) {
            case 1:
                fillOrder(burger,2);break;
            case 2:
                fillOrder(burger,4);break;
            case 3:
                fillOrder(burger,6);break;
            default:break;
        }
        return burger;
    }
    private void fillOrder(Burger burger, int howManyComponents){
        Random r = new Random();
        int next;
        int cookedTo = r.nextInt(3)+1;
        Patty patty = new Patty();
        patty.setCookingLevel(cookedTo);
        burger.addComponent(patty);
        for(int i = 0;i<howManyComponents;i++){
            next = r.nextInt(6);
            switch(next){
                case 0: burger.addComponent(new Bun(true));break;
                case 1: burger.addComponent(new Cheese());break;
                case 2: burger.addComponent(new Lettuce());break;
                case 3: burger.addComponent(new Onion());break;
                case 4: burger.addComponent(new Pickle());break;
                case 5: burger.addComponent(new Tomato());break;
            }
        }
    }
    //TODO: maybe ha magasabb a burger akkor levonhatnánk pontot
    public int compareBurgerToOrder(Burger burgerToCompare){
        List<Component> thisComponents = this.burger.getComponents();
        List<Component> otherComponents = burgerToCompare.getComponents();
        Collections.reverse(thisComponents);
        System.out.println(thisComponents);
        System.out.println(otherComponents);
        int sizeOfSmaller = Math.min(otherComponents.size(), thisComponents.size());
        int numberOfMatches = 0;
        for(int i = 0; i<sizeOfSmaller;i++){
            if(thisComponents.get(i).getClass() == Patty.class){
                if( ((Patty) thisComponents.get(i)).getCookingLevel() == ((Patty) otherComponents.get(i)).getCookingLevel()){
                    numberOfMatches++;
                }
            }else if(thisComponents.get(i).getClass().equals(otherComponents.get(i).getClass())){
                numberOfMatches++;
            }
        }
        return numberOfMatches;
    }
    public Burger getBurger() {
        return burger;
    }
    public int getDifficulty() {
        return difficulty;
    }

}
