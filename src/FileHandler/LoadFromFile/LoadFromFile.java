package FileHandler.LoadFromFile;

import Component.Component;
import Customer.Customer;
import Game.Day.Day;
import Game.Game;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class LoadFromFile {
    public static File loadFileFromSlot(int slotNumber){
        return new File("./saves/game-"+slotNumber+".ser");
    }
    public static Game loadGameFromSlot(int slotNumber){
        Game game;
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream("./saves/game-"+slotNumber+".ser"))){
            game = (Game) in.readObject();
            System.out.println("Visszaolvasott objektum: " + game);
        }catch (Exception e){
            e.printStackTrace();
            game = null;
        }
        game.getDays().set(game.getDays().indexOf(game.getToday()),new Day(game.getDay()));
        return game;
    }
}
