package Game;

import Game.Day.Day;
import Upgrade.Upgrade;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Game implements Serializable {
    private final List<Day> days;
    private int money;
    private final List<Upgrade> upgradesList;
    public Game(){
        this.days = new ArrayList<>();
        newDay();
        this.money = 0;
        this.upgradesList = new ArrayList<Upgrade>();
    }
    public Game(List<Day> days, int money, List<Upgrade> upgradesList) {
        this.days = days;
        newDay();
        this.money = money;
        this.upgradesList = upgradesList;
    }
    public List<Day> getDays(){
        return days;
    }
    public Day getToday() {
        return days.getLast();
    }
    public int getDay(){
        return days.size();
    }
    public Day getPastDay(int which){
        return days.get(which-1);
    }
    public void newDay(){
        days.add(new Day(days.size()+1));
    }
    public int getMoney() {
        return money;
    }
    public void setMoney(int money) {
        this.money = money;
    }
    public List<Upgrade> getUpgradesList() {
        return upgradesList;
    }
    public void addUpgrade(Upgrade upgrade) {
        this.upgradesList.add(upgrade);
    }
    public void increaseMoney(int amount) {
        this.money += amount;
    }
    public void decreaseMoney(int amount) {
        this.money -= amount;
    }
    public int increaseMoneyBasedOnScore(int score){
        int increaseBy = 0;
        if (score >= 2){
            increaseBy = score*100;
        }
        this.money += increaseBy;
        getToday().increaseIncome(increaseBy);
        return increaseBy;
    }
    @Override
    public String toString(){
        return "Game [day=" + getDay() + ", money=" + money + ", upgradesList=" + upgradesList + "]";
    }
}
