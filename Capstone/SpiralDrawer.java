import java.awt.BorderLayout;
import javax.swing.JFrame;

public class SpiralDrawer extends JFrame
{
    /**
     * Constructor for class SpiralDrawer
     */
    public SpiralDrawer()
    {
        setTitle("Spiral Drawer");
        setSize(800, 800);   
        
        DrawingPanel canvas = new DrawingPanel(this);
        add(canvas, BorderLayout.CENTER);
        
        ControlPanel controls = new ControlPanel(canvas);
        add(controls, BorderLayout.PAGE_END);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    /**
     * Creates a new SpiralDrawer object which opens a window on the screen 
     */
    public static void main(String[] args)
    {
        SpiralDrawer frame = new SpiralDrawer();
    }
}
