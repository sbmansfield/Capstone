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
public class CircleSpiral
{
    private Ellipse2D.Double newCircle;
    private double xCoord;
    private double yCoord;
    private double radius;
    private int numRecursions;
    private Color circleColor;

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
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  g2   Graphics2D object
     */
    public void draw(Graphics2D g2)
    {
        newCircle = new Ellipse2D.Double(xCoord, yCoord, 2*radius, 2*radius);
        g2.setPaint(circleColor);
        g2.fill(newCircle);
    }
}
