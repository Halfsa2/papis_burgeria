package Component;

import javax.swing.*;

public class Patty extends Component{
    //0 = raw
    //1 = rare
    //2 = medium
    //3 = well-done
    //4 = burnt
    private int cooking_level;

    public Patty(){
        img = new ImageIcon(getClass().getResource("/images/components/patty/rawPatty.png"));
        cooking_level = 0;
    }
    public int getCookingLevel() {
        return cooking_level;
    }
    public void setCookingLevel(int cooking_level) {
        this.cooking_level = cooking_level;
        switch(cooking_level){
            case 1: img.setImage(new ImageIcon(getClass().getResource(this.source +"patty/rarePatty.png")).getImage()); break;
            case 2: img.setImage(new ImageIcon(getClass().getResource(this.source+"patty/mediumPatty.png")).getImage());; break;
            case 3: img.setImage(new ImageIcon(getClass().getResource(this.source +"patty/wellDonePatty.png")).getImage()); break;
            case 4: img.setImage(new ImageIcon(getClass().getResource(this.source +"patty/BurntPatty.png")).getImage()); break;
        }
    }
    public String getCookingLevelAsString(){
        return switch (cooking_level) {
            case 0 -> "raw";
            case 1 -> "rare";
            case 2 -> "medium";
            case 3 -> "well-done";
            case 4 -> "burnt";
            default -> "";
        };
    }
    public int getCookingLevelBasedOnHeatAndTime(int heat, int time){
        if(heat == 0) return 0;
        if(heat <= 10){
            if(time <= 10){
                return 0;
            }else{
                return 1;
            }
        }else if(heat <= 30){
            if(time <= 5){
                return 0;
            }
            else if(time <= 15){
                return 1;
            }else if(time <= 30){
                return 2;
            }else if(time <= 40) {
                return 3;
            }else return 4;
        }else if(heat <= 60){
            if(time <= 5){
                return 0;
            }else if(time <= 10){
                return 1;
            }else if(time <=15){
                return 2;
            }else if(time <= 20){
                return 3;
            }else return 4;
        }else{
            if (time <= 1){
                return 0;
            }else if(time <= 5){
                return 1;
            }else if(time <= 6){
                return 2;
            }else if(time <= 7){
                return 3;
            }else return 4;
        }
    }
    public String toString(){
        String cooking_level = getCookingLevelAsString();
        return "Patty cooked to "+ cooking_level;
    }
}
