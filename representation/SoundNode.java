package representation;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;


public class SoundNode extends Decorator implements Event{
    //private final Event decoratedNode;
    private final String soundFilePath;

    public SoundNode(Event decoratedNode, String soundFilePath) {
    	super(decoratedNode); 
        //this.decoratedNode = decoratedNode;
        this.soundFilePath = soundFilePath;
    }

    @Override
    public void display() {
        playSound(soundFilePath);
        System.out.println("Displaying SoundNode information");
        // Logique spécifique à l'affichage de SoundNode
    }


    public static void playSound(String soundFilePath) {
        try {
            File soundFile = new File(soundFilePath);
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}