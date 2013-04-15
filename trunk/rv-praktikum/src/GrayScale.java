import java.awt.*;
import java.awt.color.ICC_Profile;
import java.io.File;
import java.awt.color.ColorSpace;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.image.BufferedImage;
import java.awt.image.ColorConvertOp;
import javax.imageio.ImageIO;

public class GrayScale extends JPanel {
    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        try {   //reading from file
            BufferedImage src = ImageIO.read(new File("grayscale_src.jpg"));

            BufferedImage grayscale_8bit = new BufferedImage(src.getWidth(),src.getHeight(),BufferedImage.TYPE_BYTE_GRAY);
            BufferedImage grayscale_8bit_negativ = new BufferedImage(src.getWidth(),src.getHeight(),BufferedImage.TYPE_BYTE_GRAY);
            BufferedImage grayscale_8bit_median = new BufferedImage(src.getWidth(),src.getHeight(),BufferedImage.TYPE_BYTE_GRAY);


            create_8bit_grayscale(src,grayscale_8bit);
            create_negativ(grayscale_8bit,grayscale_8bit_negativ);
            Filters.Median(grayscale_8bit.getData(),grayscale_8bit_median.getRaster(),9,9);

            g2d.drawImage(grayscale_8bit_median, 0, 0, this);  /* drawing the image on panel and then writing to a file */

            ImageIO.write(grayscale_8bit, "jpeg", new File("dest_8bit_grayscale.jpg"));
            ImageIO.write(grayscale_8bit_negativ, "jpeg", new File("dest_8bit_grayscale_negativ.jpg"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        JFrame jf = new JFrame("GRAY_SCALE");
        GrayScale obj = new GrayScale();
        jf.getContentPane().add(obj);
        jf.setVisible(true);
        jf.setSize(320, 235);
        jf.setDefaultCloseOperation(jf.EXIT_ON_CLOSE);
    }


    public void create_negativ(BufferedImage src,BufferedImage dst) {
        int picSizeY = src.getHeight();
        int picSizeX = src.getWidth();
        int grayscale_8bit;
        for (int y = 0; y < picSizeY; y++) {
            for (int x = 0; x < picSizeX; x++) {
                grayscale_8bit = src.getRGB(x,y);
                dst.setRGB(x,y,255-grayscale_8bit);
            }
        }
    }

    public void create_8bit_grayscale(BufferedImage src, BufferedImage dst) {
        int picSizeY = src.getHeight();
        int picSizeX = src.getWidth();
        for (int y = 0; y < picSizeY; y++) {
            for (int x = 0; x < picSizeX; x++) {
                dst.setRGB(x,y,Filters.convertRGBto8BitGrayscale(src.getRGB(x,y)));
            }
        }
    }




}