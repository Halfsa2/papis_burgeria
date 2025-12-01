import UserInterface.Menu.MenuUI;
import UserInterface.Window.Window;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import java.io.File;

public class Main {
    public static void main(String[] args) {
        Window window = new Window();
        window.showScreen("menu");
        try {
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(new File("./resources/music/Papi.wav")));
            clip.loop(Clip.LOOP_CONTINUOUSLY);
            clip.start();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}