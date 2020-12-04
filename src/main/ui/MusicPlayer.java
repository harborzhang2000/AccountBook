package ui;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;


//This class represents the music player, where all methods related to playing music
//are performed here.
public class MusicPlayer {

    public static final String LAMBSOUND_FILE = "./data/lambsound.wav";
    public static final String ROOSTER_FILE = "./data/Rooster.wav";
    public static final String HORSE_FILE = "./data/Horse.wav";
    public static final String DOGBARK_FILE = "./data/Dog.wav";
    public static final String ELEPHANT_FILE = "./data/Elephant.wav";
    public static final String LION_FILE = "./data/Lion.wav";
    public static final String MOSQUITO_FILE = "./data/Mosquito.wav";
    public static final String NIGHTINGALE_FILE = "./data/Nightingale.wav";

    //Constructor of Music Player
    public MusicPlayer(String soundName) {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(soundName).getAbsoluteFile());
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch (Exception e) {
            System.out.println("Error with playing sound.");
            e.printStackTrace();
        }

    }
}
