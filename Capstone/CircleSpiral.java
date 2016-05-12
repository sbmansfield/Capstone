import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Ellipse2D.Double;
import java.awt.Point;

import java.lang.Math;

public class CircleSpiral extends JPanel
{
    private int xCoord;
    private int yCoord;
    private double radius;
    private int numRecursions;
    private Color circleColor;
    
    // scaling factor for each subsequent circle
    private static final double SCALING_FACTOR = 0.9;
    
    // Number of radians to rotate each rectangle
    private static final double ROTATION_INCREMENT = Math.PI/24;

    /**
     * Constructor for objects of class CircleSpiral
     */
    public CircleSpiral(int x, int y, double rad, int recursions, Color color)
    {
        xCoord = x;
        yCoord = y;
        radius = rad;
        numRecursions = recursions;
        circleColor = color;
        
        setBackground(Color.black);
    }
    
    /**
     * Draws the spiral recursively
     *
     * @param  x   x coordinate
     * @param  y   y coordinate
     * @param  radius   radius of the circle
     * @param  g2   Graphics2D object
     * @param  step   step size to determine recursion
     */
    public void drawSpiral(int x, int y, double radius, Graphics2D g2, int step)
    {
        
        if (step == 0)
        {
            return;
        }
        else
        {
            Ellipse2D.Double newCircle = new Ellipse2D.Double(x, y, 2*radius, 2*radius);
            
            g2.setPaint(circleColor);
            g2.fill(newCircle);
            
            circleColor = circleColor.brighter();
            radius *= SCALING_FACTOR;
            g2.rotate(ROTATION_INCREMENT);

            drawSpiral(x, y, radius, g2, step - 1);
        }

    }

    //-----------------------------------------------------------------
    //  Performs the initial calls to the drawSpiral method.
    //-----------------------------------------------------------------
    public void paintComponent(Graphics2D g2)
    {
        super.paintComponent(g2);
        //g2.setPaint(circleColor);

        drawSpiral(xCoord, yCoord, radius, g2, numRecursions);
    }

}
