import javax.swing.JPanel;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JColorChooser;

import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Ellipse2D.Double;
import java.awt.geom.Point2D;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import java.awt.Component;
import java.awt.TextField;
import javax.swing.JFrame;

public class DrawingPanel extends JPanel
{
    //color of the drawing panel using JColorChooser
    private Color color;

    private Customizer customize;

    public boolean doDraw = false;
    
    /**
     * Constructor for class DrawingPanel
     */
    public DrawingPanel()
    {
        setBackground(Color.BLACK);
        color = Color.BLUE;
        
        //mainFrame = frame;
    }

    /**
     * Returns the current drawing color
     *
     * @return     the current color
     */
    public Color getColor()
    {
        return color;
    }
    
    /**
     * Overrides JComponent’s getPreferredSize method to return a size large enough 
     * to encapsulate a reasonable drawing canvas.
     *
     * @return     a size to encapsulate the drawing canvas
     */
    public Dimension getPreferredSize()
    {
        return getSize( new Dimension(1000, 1000) );
    }
    
    /**
     * Called from ControlPanel when the “Pick Color” button is clicked. 
     * Brings up a JColorChooser and sets the chosen color as the new drawing color. 
     * Leaves the drawing color unchanged if the user clicks “Cancel.”
     *
     */
    public void pickColor()
    {
        Color newColor = JColorChooser.showDialog(this, "Color Chooser", color);
        
        //this code makes sure that when 'cancel' is clicked the panel will 
        //retain the previous color
        if (newColor != null)
        {
            color = newColor;
        }
    }
    
    /**
     * Adds a new Customizer window after the Customize button is pressed
     */
    public void addCustomizer()
    {
        Customizer customize = new Customizer();
    }
    
    /**
     * Draws the circle spiral
     *
     * @param  g   Graphics object
     */
    public void paintComponent(Graphics g)
    {
        // this code is invoked initially and each time we call repaint
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        
        if (doDraw)
        {
            //begins drawing the CircleSpiral object
            g2.setPaint(color);
            int x = customize.getXCoord();
            int y = customize.getYCoord();
            double radius = customize.getRadius();
            int numRecursions = customize.getNumRecursions();
            CircleSpiral drawing = new CircleSpiral(x, y, radius, numRecursions, color);
            drawing.drawSpiral(x, y, radius, g2, numRecursions);
            doDraw = false;
        }
    }
    

}
