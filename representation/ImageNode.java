package representation; 
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.util.List;

public abstract class ImageNode extends Decorator {

    private List<String> imagePaths;

    public ImageNode(Event decoratedEvent, List<String> imagePaths) {
        super(decoratedEvent);
        this.imagePaths = imagePaths;
    }

    @Override
    public void display() {
        //displayImages(List<String> imagePaths);
        super.display();
    }

    private void displayImages (List<String> imagePaths) {
        JFrame frame = new JFrame("Images");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        for (String imagePath : imagePaths) {
            ImageIcon icon = new ImageIcon(imagePath);
            JLabel label = new JLabel(icon);
            frame.getContentPane().add(label);
        }

        frame.pack();
        frame.setVisible(true);
    }
}
