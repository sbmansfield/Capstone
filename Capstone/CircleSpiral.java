import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Ellipse2D.Double;

/**
 * Write a description of class CircleSpiral here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CircleSpiral extends JPanel
{
    private double xCoord;
    private double yCoord;
    private double radius;
    private int numRecursions;
    private Color circleColor;
    
    private static final double resizeCircle = 0.8;
    private static final double xFactor = 0.9;
    private static final double yFactor = 0.7;
    
    private int count = 1;

    /**
     * Constructor for objects of class CircleSpiral
     */
    public CircleSpiral(double x, double y, double rad, int recursions, Color color)
    {
        xCoord = x;
        yCoord = y;
        radius = rad;
        numRecursions = recursions;
        circleColor = color;
        
        setBackground(Color.black);
    }
    
    //-----------------------------------------------------------------
    //  Draws the spiral recursively
    //-----------------------------------------------------------------
    public void drawSpiral(double x, double y, double radius, Graphics2D g2)
    {
        
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
        
        repaint();
    }

    //-----------------------------------------------------------------
    //  Performs the initial calls to the drawSpiral method.
    //-----------------------------------------------------------------
    public void paintComponent(Graphics2D g2)
    {
        super.paintComponent(g2);
        g2.setPaint(circleColor);
        drawSpiral(xCoord, yCoord, radius, g2);
    }

}
