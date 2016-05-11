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
    private Color initialColor;

    private CircleSpiral drawing;
    private Customizer customize;
    private SpiralDrawer mainFrame;
    
    private static final double resizeCircle = 0.8;
    private static final double xFactor = 0.9;
    private static final double yFactor = 0.7;
    
    private int count = 1;
    private int numRecursions;
    
    /**
     * Constructor for class DrawingPanel
     */
    public DrawingPanel(SpiralDrawer frame)
    {
        setBackground(Color.BLACK);
        initialColor = Color.BLUE;
        
        mainFrame = frame;
    }

    /**
     * Returns the current drawing color
     *
     * @return     the current color
     */
    public Color getColor()
    {
        return initialColor;
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
        Color initColor = JColorChooser.showDialog(this, "Color Chooser", initialColor);
        
        //this code makes sure that when 'cancel' is clicked the panel will 
        //retain the previous color
        if (initColor != null)
        {
            initialColor = initColor;
        }
    }
    
    public void addCustomizer()
    {
        customize = new Customizer();
    }
    
    public void addDrawing()
    {
        System.out.print("hi");
        double x = customize.getXCoord();
        double y = customize.getYCoord();
        double radius = customize.getRadius();
        numRecursions = customize.getNumRecursions();
        
        //drawing = new CircleSpiral(x, y, radius, numRecursions, initialColor);
        //add(drawing);
        //revalidate();
        //repaint();
        //mainFrame.add(drawing);
        //SwingUtilities.updateComponentTreeUI(mainFrame);
        // mainFrame.invalidate();
        //mainFrame.revalidate();
        //mainFrame.repaint();
        //mainFrame.setVisible(false);
        //mainFrame.setVisible(true);
        
        drawSpiral(x, y, radius, (Graphics2D)getGraphics());
    }
    
    public void drawSpiral(double x, double y, double radius, Graphics2D g2)
    {
        g2.setPaint(initialColor);
        
        if (count == 1)
        {
            Ellipse2D.Double newCircle = new Ellipse2D.Double(x, y, 2*radius, 2*radius);
            g2.fill(newCircle);
        }
        else if (count <= numRecursions)
        {
            radius *= resizeCircle;
            x *= xFactor;
            y *= yFactor;
            count++;
            
            Ellipse2D.Double newCircle = new Ellipse2D.Double(x, y, 2*radius, 2*radius);
            g2.fill(newCircle);
            
            drawSpiral(x, y, radius, g2);
        }
    }
    
    /**
     * Draws all the shapes in the list
     *
     * @param  g   Graphics object
     */
    public void paintComponent(Graphics g)
    {
        // this code is invoked initially and each time we call repaint
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

    }
    

}
