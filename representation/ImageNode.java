package representation;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;  
import java.util.List;
import java.awt.GridLayout;
/**
 * La classe {@code ImageNode} représente un événement décorator avec des images.
 * Elle étend la classe {@code Decorator} et ajoute la fonctionnalité d'affichage d'images.
 *
 * @author RABIA Lysa et NASR Rachelle
 * @version 2.1
 * @since 20/12/23
 */
public class ImageNode extends Decorator{
	/** La liste des chemins de fichiers d'images. */
    private List<String> imagePaths;
    
   
    /**
     * Construit un {@code ImageNode} avec l'événement décoré spécifié et les chemins d'images.
     *
     * @param decoratedEvent L'événement à décorer.
     * @param imagePaths     La liste des chemins de fichiers d'images à afficher.
     */
    public ImageNode(Event decoratedEvent, List<String> imagePaths) {
        super(decoratedEvent);
        this.imagePaths = imagePaths;
    }

    /**
     * Affiche les images ainsi que l'événement décoré.
     */
    @Override
    public void display() {
        displayImages(imagePaths);
        super.display();
    }

    /**
     * Affiche une fenêtre contenant des images dans une disposition en grille.
     *
     * @param imagePaths La liste des chemins de fichiers d'images à afficher.
     */
    public static void displayImages(List<String> imagePaths) {
        JFrame frame = new JFrame("Images");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(0, 5));  

        for (String imagePath : imagePaths) {
            ImageIcon originalIcon = new ImageIcon(imagePath);
            // Scale down the image to a smaller size
            ImageIcon scaledIcon = new ImageIcon(originalIcon.getImage().getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH));
            JLabel label = new JLabel(scaledIcon);
            panel.add(label);
        }

        frame.getContentPane().add(new JScrollPane(panel));
        frame.pack();
        frame.setVisible(true);
    }


}