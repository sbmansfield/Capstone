import java.awt.BorderLayout;
import javax.swing.JFrame;

public class DrawingEditor extends JFrame
{
    /**
     * Constructor for class DrawingEditor
     */
    public DrawingEditor()
    {
        setTitle("Drawing Editor");
        setSize(800, 800);   
        
        DrawingPanel canvas = new DrawingPanel();
        add(canvas, BorderLayout.CENTER);
        
        ControlPanel controls = new ControlPanel(canvas);
        add(controls, BorderLayout.PAGE_END);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    /**
     * Creates a new DrawingEditor object which opens a window on the screen 
     */
    public static void main(String[] args)
    {
        DrawingEditor frame = new DrawingEditor();
    }
}
