package CMSC405_Project1;
import java.awt.*;        // import statements to make necessary classes available
import java.awt.event.*;
import java.awt.geom.*;

import javax.swing.*;

/**
 *  This class will create 3 simple, binary 25x25 images or your choice and use
 *  Java 2D graphic methods to rotate, scale and translate each of the images.
 *  The drawing code goes in the paintComponent() method.  When the program
 *  is run, the drawing is shown in a window on the screen.
 *  
 *  Name: Nabeel Hussain
 *  Class: CMSC 405
 *  Professor: Catlin Tudose
 *  Project 1
 *  Date: 3/22/2017
 * 
 * @author Nabeel Hussain
 */
@SuppressWarnings("serial")
public class ImageTransformations extends JPanel
{
	private static ImageTransformations panel;
	
	private int counter = 0;  // A counter that keeps track of the transformation stages 	    
	
	private SimpleImage image1 = new SimpleImage(25,25);  //Instance of the SimpleImage class, which will be used to create the buffered image of my first shape. 
	private SimpleImage image2 = new SimpleImage(25,25);; //Instance of the SimpleImage class, which will be used to create the buffered image of my second shape.
	private SimpleImage image3 = new SimpleImage(25,25);; //Instance of the SimpleImage class, which will be used to create the buffered image of my third shape.

	
	//My first simple 25x25 binary image stored in a 2Darray. It is the letter "F"
	private byte[][] arrayImage1 = {
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }
		};
	
	//My second simple 25x25 binary image stored in a 2Darray. It is the letter "E"
	private byte[][] arrayImage2 = {
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			};
    
	//My third simple 25x25 binary image stored in a2Darray. It is the letter "H"
	private byte[][] arrayImage3 = {
			{ 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1 },
			{ 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1 },
			{ 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1 },
			{ 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1 },
			{ 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1 },
			{ 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1 },
			{ 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1 },
			{ 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1 },
			{ 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1 },
			{ 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1 },
			{ 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1 },
			{ 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1 },
			{ 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1 },
			{ 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1 },
			{ 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1 },
			{ 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1 },
			{ 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1 },
			{ 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1 },
			{ 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1 },
			{ 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1 },
			{ 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1 },
			};
	
    /**
     * The constructor for the ImageTransformations class. Here, it sets the size of the drawing area.
     * (The size is set as a "preferred size," which will be used by the pack() command in the main() routine.)
     */
	public ImageTransformations()
	{
        setPreferredSize( new Dimension(600,250) ); // Set size of drawing area, in pixels.
	}
	
	/**
    * The paintComponent method draws the content of the JPanel. The parameter is a graphics context that can be used for drawing on the panel.
    * It is declared to be of type Graphics but is actually of type Graphics2D, which is a subclass of Graphics.
    */
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
	    Graphics2D g2 = (Graphics2D)g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
      	        
        // Make the background of the paint screen white. 
        g2.setPaint(Color.WHITE);
        g2.fillRect(0,0,getWidth(),getHeight()); 
        
        g2.drawLine(100, 100, 200, 200);  // Draw in the default coordinate system
        g2.translate(100.0, 100.0);       // Moves the (0,0) origin down and to the right by 100, so that the transformations will be easily visible. 
        g2.drawLine(0, 0, 100, 100);      // Draw the same line relative to new origin
        
       
        AffineTransform savedTransform = g2.getTransform();  // save the current transform
        
        
		switch(counter)
		{
    		//Will display the 3 images in there original specified locations. 
			case 0:
			{
	            displayOriginalImage(image3, arrayImage3, g2, 200, 0);
	            g2.setTransform(savedTransform);  // restore the saved transform	            
	            
	            displayOriginalImage(image2,arrayImage2, g2, 100, 0);
	            g2.setTransform(savedTransform);  // restore the saved transform
	            	           
	            displayOriginalImage(image1,arrayImage1, g2, 0, 0);
	    		
	    		break;
			}
	        // Will translate the images -5 in x direction, and +7 in the y direction.
			case 1:
			{
				firstImageTransformation( image3, arrayImage3, g2, 200, 0);
	            g2.setTransform(savedTransform);  // restore the saved transform

	            firstImageTransformation( image2, arrayImage2, g2, 100, 0);
	            g2.setTransform(savedTransform);  // restore the saved transform
	           
	            firstImageTransformation( image1, arrayImage1, g2, 0, 0);
	    		
	    		break;
			}
	        // Will rotate the images 45 degrees counter clockwise after the previous translation. 
			case 2:
			{
				secondImageTransformation( image3, arrayImage3, g2, 200, 0);
	            g2.setTransform(savedTransform);  // restore the saved transform

	            secondImageTransformation( image2, arrayImage2, g2, 100, 0);
	            g2.setTransform(savedTransform);  // restore the saved transform
	           
	            secondImageTransformation( image1, arrayImage1, g2, 0, 0);
 	    		
	    		break;
			}
	        // Will rotate the images 90 degrees clockwise after the previous rotation
			case 3:
			{
				thirdImageTransformation( image3, arrayImage3, g2, 200, 0);
	            g2.setTransform(savedTransform);  // restore the saved transform

	            thirdImageTransformation( image2, arrayImage2, g2, 100, 0);
	            g2.setTransform(savedTransform);  // restore the saved transform
	           
	            thirdImageTransformation( image1, arrayImage1, g2, 0, 0);
 	    		
	    		break;
	
			}
	        // Will scale the images 2 times for the x component, and 0.5 times for the y component after the previous rotation
			default:
			{           	    		
				fourthImageTransformation( image3, arrayImage3, g2, 200, 0);
	            g2.setTransform(savedTransform);  // restore the saved transform

	            fourthImageTransformation( image2, arrayImage2, g2, 100, 0);
	            g2.setTransform(savedTransform);  // restore the saved transform
	           
	            fourthImageTransformation( image1, arrayImage1, g2, 0, 0);	    		
	            
				//if counter is not equal to any of the numbers from 0-4, then 
	    		//reset counter to -1, so we that when the animationTimer runs again and increments the counter by 1
	    		//it will make it equal to 0, which will cause the image transformations to be displayed
	    		// from the beginning again. 
	            counter = -1;
	            break;
			}
		}
        panel.repaint();
	}
	
	/**
	    * A method that displays the image in its original state at the desired location in the coordinate grid. 
	    * 
	    * @param image the image created from the SimpleImage class that will be displayed
	    * @param arrayImage the image in binary 2D array form
	    * @param g a graphics object to draw the image onto the canvas
	    * @param x the x coordinate of the top left position of the image
	    * @param y the y coordinate of the top left position of the image
	    */
		public void displayOriginalImage(SimpleImage image, byte[][] arrayImage, Graphics g, int x, int y)
		{
			Graphics2D g2 = (Graphics2D)g.create();
			
			g2.drawImage(image.getImage(),null, x, y);
			image.drawImageArray(arrayImage);
		}
		
		/**
	    * A method that performs the first transformation that is required for this project. 
	    * Translates the image -5 in x direction, Translate +7 in the y direction.
	    * 
	    * @param image the image created from the SimpleImage class that will be used for the transformation
	    * @param arrayImage the image in binary 2D array form
	    * @param g a graphics object to perform the transformation
	    * @param x the x coordinate of the top left position of the untransformed image
	    * @param y the y coordinate of the top left position of the untransformed image
		*/
		public void firstImageTransformation(SimpleImage image, byte[][] arrayImage, Graphics g, int x, int y)
		{
			Graphics2D g2 = (Graphics2D)g.create();
			
			g2.translate(-5, 7);       // Translate -5 in x direction, Translate +7 in the y direction.
			displayOriginalImage(image, arrayImage,g2, x, y);
		}
		
		/**
	    * A method that performs the second transformation that is required for this project. 
	    * Rotates the image 45 degrees counter clockwise from the previous image transformation
	    * 
	    * @param image the image created from the SimpleImage class that will be used for the transformation
	    * @param arrayImage the image in binary 2D array form
	    * @param g a graphics object to perform the transformation
	    * @param x the x coordinate of the top left position of the untransformed image
	    * @param y the y coordinate of the top left position of the untransformed image
		*/
		public void secondImageTransformation(SimpleImage image, byte[][] arrayImage, Graphics g, int x, int y)
		{
			Graphics2D g2 = (Graphics2D)g.create();
			
			g2.rotate(-45, x-5, y+7);   //Rotate 45 degrees counter clockwise from the new origin after the first transformation
			firstImageTransformation(image, arrayImage,g2, x, y);  //previous image transformation
		}
		
		/**
	    * A method that performs the third transformation that is required for this project. 
	    * Rotates the image 90 degrees clockwise from the previous image transformation
	    * 
	    * @param image the image created from the SimpleImage class that will be used for the transformation
	    * @param arrayImage the image in binary 2D array form
	    * @param g a graphics object to perform the transformation
	    * @param x the x coordinate of the top left position of the untransformed image
	    * @param y the y coordinate of the top left position of the untransformed image
		*/
		public void thirdImageTransformation(SimpleImage image, byte[][] arrayImage, Graphics g, int x, int y)
		{
			Graphics2D g2 = (Graphics2D)g.create();
			
			g2.rotate(90, x-5, y+7);   //Rotate 90 degrees clockwise from the previous transformation
			secondImageTransformation(image, arrayImage,g2, x, y); //previous image transformation
		}
		
		/**
	    * A method that performs the fourth transformation that is required for this project. 
	    * Scales the image 2 times for the x component, and 0.5 times for the y component from the previous image transformation
	    * 
	    * @param image the image created from the SimpleImage class that will be used for the transformation
	    * @param arrayImage the image in binary 2D array form
	    * @param g a graphics object to perform the transformation
	    * @param x the x coordinate of the top left position of the untransformed image
	    * @param y the y coordinate of the top left position of the untransformed image
		*/
		public void fourthImageTransformation(SimpleImage image, byte[][] arrayImage, Graphics g, int x, int y)
		{
			Graphics2D g2 = (Graphics2D)g.create();
			
	    	g2.scale(2.0, .50);        //Scale 2 times for the x component, scale 0.5 times for the y component from the previous transformation
			thirdImageTransformation(image, arrayImage,g2, x, y); //previous image transformation
		}
		
	
	public static void main(String[] args)
	{
		JFrame frame = new JFrame("Image Transformations");
		
		panel = new ImageTransformations();
		
		frame.setContentPane( panel ); // Show the panel in the window.
		frame.pack();  // Set window size based on the preferred sizes of its contents.
		frame.setResizable(false);
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation( // Center window on screen.
                (screen.width - frame.getWidth())/2, 
                (screen.height - frame.getHeight())/2 );
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // End program when window closes.
		
		
		Timer animationTimer = new Timer(1500, new ActionListener()  // A Timer that will emit events to drive the animation.
        {
        	@Override
            public void actionPerformed(ActionEvent arg0)
            {
            	panel.counter++;;
            }
        });
		animationTimer.start();  // Start the animation running.
	}
}