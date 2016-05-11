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
    //customize button
    private JButton customize;
    //button to initiate drawing
    private JButton draw;
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
        colorPanel.setBackground(Color.BLUE);
        add(colorPanel);
        
        customize = new JButton("Customize Spiral");
        add(customize);

        draw = new JButton("Draw");
        add(draw);
        
        ClickListener listener = new ClickListener();
        button.addActionListener(listener);
        customize.addActionListener(listener);
        draw.addActionListener(listener);
        
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
            else if (event.getSource() == customize)
            {
                canvas.addCustomizer();
                //Customizer customize = new Customizer(canvas);
            }
            else
            {
                canvas.addDrawing();
                repaint();
            }
        }
    }
    
}
