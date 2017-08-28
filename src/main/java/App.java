import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

import com.github.sarxos.webcam.Webcam;
import org.openimaj.image.ImageUtilities;
import org.openimaj.image.processing.face.detection.DetectedFace;
import org.openimaj.image.processing.face.detection.HaarCascadeDetector;

public class App {

    private static final HaarCascadeDetector detector = new HaarCascadeDetector();

    public static void main(String[] args) throws IOException {

        List<DetectedFace> faces;

        Webcam webcam = Webcam.getDefault();
        webcam.open();
        BufferedImage image = webcam.getImage();
//        ImageIO.write(image, "PNG", new File("hello-world.png"));

        faces = detector.detectFaces(ImageUtilities.createFImage(image));

        if(faces.size() > 0) {
            System.out.println("THERE'S A FACE IN THE FRAME!");
        } else {
            System.out.println("No Face in the frame");
        }
    }
}
