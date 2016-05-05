import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.Color;


public class ControlPanel extends JPanel
{
    //color panel for JColorChooser
    private JPanel colorPanel;
    //pick color button
    private JButton button;
    //add fractal button
    private JButton fractalButton;
   
    //canvas for the drawing panel
    private DrawingPanel canvas;
    
    /**
     * Constructor for class ControlPanel
     *
     * @param  canv   a DrawingPanel object
     */
    public ControlPanel(DrawingPanel canv)
    {
        canvas = canv;
        button = new JButton("Pick Color");
        add(button);
        
        colorPanel = new JPanel();
        colorPanel.setBackground(Color.BLACK);
        add(colorPanel);
        
        fractalButton = new JButton("Customize Fractal");
        add(fractalButton);
        
        //tf1 = new TextField();
        //add(tf1);
        
        //button3 = new JButton("Add Square");
        //add(button3);
        
        ClickListener listener = new ClickListener();
        button.addActionListener(listener);
        fractalButton.addActionListener(listener);
        //tf1.addActionListener(listener);
        
        setVisible(true);
    }

    public class ClickListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            if (event.getSource() == button)
            {
                //pick color button
                canvas.pickColor();
                colorPanel.setBackground( canvas.getColor() );
            }
            else if (event.getSource() == fractalButton)
            {
                canvas.customizeFractal();
                
            }
            else
            {
                //add square button
                //canvas.addSquare();
            }
        }
    }
}
