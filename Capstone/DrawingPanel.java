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

import java.lang.Boolean;

public class DrawingPanel extends JPanel
{
    //color of the drawing panel using JColorChooser
    private Color initialColor;
    //keeps track of whether the active shape is selected or not in order to fill/outline
    private boolean isSelected;
    
    /**
     * Constructor for class DrawingPanel
     */
    public DrawingPanel()
    {
        addMouseListener( new MousePressListener() );
        addMouseMotionListener( new MouseDragListener() );
        
        setBackground(Color.WHITE);
        initialColor = Color.BLACK;
        
        isSelected = false;
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
    
    public class MousePressListener implements MouseListener
    {
        public void mousePressed(MouseEvent event) 
        {
        }
        public void mouseReleased(MouseEvent event){}
        public void mouseClicked(MouseEvent event){}
        public void mouseEntered(MouseEvent event){}
        public void mouseExited(MouseEvent event){}
    }
    
    public class MouseDragListener implements MouseMotionListener
    {
        public void mouseDragged(MouseEvent event) 
        {
        }
        public void mouseMoved(MouseEvent event){}
    }

}
