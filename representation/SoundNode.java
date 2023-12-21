package representation;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

/**
 * La classe `SoundNode` étend la classe abstraite `Decorator` et représente un nœud d'événement avec la capacité de jouer un son.
 * Elle permet de décorer un événement existant en ajoutant la fonctionnalité de lecture de son.
 *
 * @author RABIA Lysa et NASR Rachelle
 * @version 1.0
 * @since 20/12/23
 * @see Decorator
 * @see Event
 */
public class SoundNode extends Decorator implements Event{
    
    private final String soundFilePath;
    
    /**
    * Constructeur de la classe `SoundNode`.
    *
    * @param decoratedNode L'événement à décorer.
    * @param soundFilePath Le chemin du fichier son à jouer.
    */

    public SoundNode(Event decoratedNode, String soundFilePath) {
    	super(decoratedNode); 
        
        this.soundFilePath = soundFilePath;
    }
    
    /**
     * Affiche l'événement en jouant également le son spécifié.
     */

    @Override
    public void display() {
        playSound(soundFilePath);
        System.out.println("Displaying SoundNode information");
      
    }
    
    /**
     * Joue le son à partir du fichier spécifié.
     *
     * @param soundFilePath Le chemin du fichier son à jouer.
     */


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