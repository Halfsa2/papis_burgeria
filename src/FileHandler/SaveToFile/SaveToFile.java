package FileHandler.SaveToFile;

import FileHandler.LoadFromFile.LoadFromFile;
import Game.Day.Day;
import Game.Game;
import Customer.Customer;
import Component.Component;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;

public class SaveToFile {
    private static void serializeGame(Game game,int slot){
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("./saves/game-"+slot+".ser"))) {
            out.writeObject(game);
            System.out.println("Objektum sikeresen szerializálva ide: "+slot+". slot");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static int saveGameToFile(Game game){
        int slot = 1;
        File savesFolder = new File("saves");
        if(savesFolder.exists()&&savesFolder.isDirectory()&&savesFolder.listFiles().length <3){
            slot = savesFolder.listFiles().length+1;
            SaveToFile.serializeGame(game,slot);
        }else{
            File saveEditedLeastRecently = getSaveFileLeastRecentlyEdited();
            slot = getSlotOfFileLeastRecentlyEdited();
            boolean result = saveEditedLeastRecently.delete();
            System.out.println(result);
            SaveToFile.serializeGame(game,slot);
            Game loadedGame = LoadFromFile.loadGameFromSlot(slot);
            System.out.println(loadedGame);
            System.out.println(game);
        }
        return slot;
    }
    public static void saveGameToAlreadyExistingFile(Game game, int slot){
        serializeGame(game,slot);
    }
    private static int getSlotOfFileLeastRecentlyEdited(){
        File file = getSaveFileLeastRecentlyEdited();
        char getSlotAsChar = file.getName().charAt(5);
        return Character.getNumericValue(getSlotAsChar);
    }
    private static  File getSaveFileLeastRecentlyEdited(){
        File savesFolder = new File("saves");
        File leastRecentlyEdited = new File("");
        if(savesFolder.exists()&&savesFolder.isDirectory()){
            Optional<File> optional = Arrays.stream(savesFolder.listFiles()).min(Comparator.comparingLong(File::lastModified));
            leastRecentlyEdited = optional.orElse(null);
        }

        return leastRecentlyEdited;
    }
}
