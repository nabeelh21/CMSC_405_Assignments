package CMSC405_Project1;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;
/**
 *  This class is a data manager class, which will hold the info of an binary 2D array converted into a BufferedImage. 
 */
public class SimpleImage extends JPanel
{
    private BufferedImage bufferedImage; // Will hold the image as a BufferedImage

    /**
     * The constructor for the ArrayImage class.  Here, it sets the size of the image specified by the parameter.
     * 
     * @param width the width of the image
     * @param height the height of the image
     */
	public SimpleImage(int width, int height)
	{

        bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
	}
	
	/**
    * The drawImageArray method takes in a 2D byte image array and converts it into a BufferedImage. This will be the format in which the images will be
    * used to perform the translation on in the ImageTransformations class. 
    * 
    * @param arrayImage the binary 2D array that contains the shape
    */
	public void drawImageArray(byte[][] arrayImage)
	{
		for (int i = 0; i < arrayImage.length; i++) {
			for (int j = 0; j < arrayImage[i].length; j++) {
				if (arrayImage[i][j] == 1)
				{
					bufferedImage.setRGB(j, i, Color.BLACK.getRGB());
				}
			}
		}
		repaint();
	}
	
    /**
     * A getter method which returns the image stored as a buffered image.
     * 
     * @return the buffered image
     */
	public BufferedImage getImage()
	{
		
		return bufferedImage;
		
	}
}
