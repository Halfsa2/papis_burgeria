package UserInterface.Window;

import FileHandler.SaveToFile.SaveToFile;
import Game.Game;
import UserInterface.Game.BurgerAssembler.AssembleBurgerUI;
import UserInterface.Game.CookingStation.CookingStationUI;
import UserInterface.Game.Customer.GradeBurger.GradeBurgerUI;
import UserInterface.Game.Customer.Order.CustomerOrderUI;
import UserInterface.Game.EndOfDayUI.EndOfDayUI;
import UserInterface.Game.NewDay.NewDayUI;
import UserInterface.LoadGame.LoadGameUI;
import UserInterface.Menu.MenuUI;
import Component.Patty;
import Burger.Burger;


import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {
    CardLayout layout;
    private JPanel mainPanel;
    MenuUI menuUI;
    LoadGameUI loadGameUI;
    NewDayUI newDayUI;
    CustomerOrderUI customerOrderUI;
    AssembleBurgerUI assembleBurgerUI;
    GradeBurgerUI gradeBurgerUI;
    CookingStationUI cookingStationUI;
    EndOfDayUI endOfDayUI;
    Game game;
    int slotOfCurrentGame;
    String current;
    int width;
    int height;
    public Window(){
        setup();
    }
    public void setup() {
        width = 800;
        height = 500;
        current = "menu";
        layout = new CardLayout();
        mainPanel = new JPanel(layout);
        this.game = new Game();
        setTitle("Papi's Burgeria");
        ImageIcon icon = new ImageIcon(getClass().getResource("/images/icon.png"));
        setIconImage(icon.getImage());
        setSize(width, height);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setContentPane(mainPanel);
        setVisible(true);
        addCards();
    }
    @Override
    public int getWidth(){
        return width;
    }
    @Override
    public int getHeight(){
        return height;
    }
    public void addCards(){
        menuUI = new MenuUI(this);
        mainPanel.add(menuUI, "menu");
        loadGameUI = new LoadGameUI(this);
        mainPanel.add(loadGameUI, "loadGame");
        newDayUI = new NewDayUI(this);
        mainPanel.add(newDayUI, "newDay");
        cookingStationUI = new CookingStationUI(this);
        mainPanel.add(cookingStationUI, "cookingStation");
        endOfDayUI = new EndOfDayUI(this);
        mainPanel.add(endOfDayUI, "dailySummary");
    }
    public void finishCooking(Patty patty, int heat, int time){
        patty.setCookingLevel(patty.getCookingLevelBasedOnHeatAndTime(heat, time));
        assembleBurgerUI = new AssembleBurgerUI(this, patty);
        mainPanel.add(assembleBurgerUI, "assembleBurger");
        showScreen("assembleBurger");
        System.out.println(patty);
    }
    public void finishAssembling(Burger burger){
        game.getToday().addBurger(burger);
        int profit = game.increaseMoneyBasedOnScore(game.getToday().getCurrentCustomer().getOrder().compareBurgerToOrder(burger));
        gradeBurgerUI = new GradeBurgerUI(this, profit);
        mainPanel.add(gradeBurgerUI, "gradeBurger");
    }
    public void showScreen(String name){
        layout.show(mainPanel, name);
        current = name;
    }
    public void startGame(Game game, int slot){
        System.out.println("Game starting: "+game);
        this.game = game;
        customerOrderUI = new CustomerOrderUI(this);
        mainPanel.add(customerOrderUI, "customerOrder");
        newDayUI.updateDay();
        showScreen("newDay");
        if(slotOfCurrentGame != 0){
            SaveToFile.saveGameToAlreadyExistingFile(game,slotOfCurrentGame);
        }
        if(slot == 0){
            slot = SaveToFile.saveGameToFile(game);
        }else{
            SaveToFile.saveGameToAlreadyExistingFile(game,slot);
        }
        slotOfCurrentGame = slot;
    }
    public void nextDay(){
        game.newDay();
        newDayUI.updateDay();
        showScreen("newDay");
        if(slotOfCurrentGame != 0){
            SaveToFile.saveGameToAlreadyExistingFile(game,slotOfCurrentGame);
        }
        customerOrderUI.newDay();
    }
    public void nextCustomer(){
        cookingStationUI.reset();
        if(game.getToday().isDone()){
            endOfDayUI.update();
            showScreen("dailySummary");
            return;
        }
        if(game.getToday().getCustomers().size()<game.getToday().getCount()){
            game.getToday().generateCustomer();
        }
        customerOrderUI.cycleToNextCustomer();
        showScreen("customerOrder");
    }
    public void showNextScreen(){
        switch (current){
            case "newDay": showScreen("customerOrder"); break;
            case "customerOrder": showScreen("cookingStation"); break;
            case "assembleBurger": showScreen("gradeBurger"); break;
            case "gradeBurger": nextCustomer(); break;
            case "dailySummary": nextDay(); break;
            default:break;
        }
    }
    public Game getGame(){
        return game;
    }
}
