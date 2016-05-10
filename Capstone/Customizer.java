import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.HashMap;
import java.util.Map;
import javax.swing.*;

import javax.swing.JButton;
import java.awt.BorderLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Customizer extends JPanel
{
    public static final int COLS = 8;
    
    private DrawingPanel canvas;
    private JFrame frame;
    private JButton submit;
    private JButton cancel;
    private JPanel input;
    private JPanel buttons;
    
    private JTextField tf1;
    private JTextField tf2;
    private JTextField tf3;
    private JTextField tf4;
    
    public Customizer(DrawingPanel canv)
    {
        canvas = canv;
        
        frame = new JFrame("Customization Settings");
        frame.setSize(400, 300);
        frame.setResizable(false);
        
        setLayout(new BorderLayout());
        
        input = new JPanel();
        input.setLayout(new GridBagLayout());
        
        //textfield 1
        input.add(new JLabel("Starting X Coordinate"), createGbc(0, 0));
        tf1 = new JTextField(COLS);
        input.add(tf1, createGbc(1, 0));
        //textfield 2
        input.add(new JLabel("Starting Y Coordinate"), createGbc(0, 1));
        tf2 = new JTextField(COLS);
        input.add(tf2, createGbc(1, 1));
        //textfield 3
        input.add(new JLabel("Starting Size (Radius)"), createGbc(0, 2));
        tf3 = new JTextField(COLS);
        input.add(tf3, createGbc(1, 2));
        //textfield 4
        input.add(new JLabel("Number of Recursions"), createGbc(0, 3));
        tf4 = new JTextField(COLS);
        input.add(tf4, createGbc(1, 3));
        
        //////

        submit = new JButton("Submit");
        cancel = new JButton("Cancel");
        ClickListener listener = new ClickListener();
        submit.addActionListener(listener);
        cancel.addActionListener(listener);
        
        buttons = new JPanel();
        buttons.add(submit);
        buttons.add(cancel);

        input.setBorder(BorderFactory.createTitledBorder("Spiral Properties"));
        
        add(input, BorderLayout.CENTER);
        add(buttons, BorderLayout.PAGE_END);
        
        frame.add(this);
        frame.setVisible(true);
    }

    public static GridBagConstraints createGbc(int x, int y) 
    {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.weightx = 1.0;
        gbc.weighty = gbc.weightx;
        if (x == 0) {
            gbc.anchor = GridBagConstraints.LINE_START;
            gbc.fill = GridBagConstraints.BOTH;
            gbc.insets = new Insets(3, 3, 3, 8);
        }
        else 
        {
            gbc.anchor = GridBagConstraints.LINE_END;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.insets = new Insets(3, 3, 3, 3);
        }
        return gbc;
    }

    public class ClickListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            if (event.getSource() == submit)
            {
                String tf1Text = tf1.getText();
                double xCoordinate = Double.parseDouble(tf1Text);
                
                String tf2Text = tf2.getText();
                double yCoordinate = Double.parseDouble(tf2Text);
                
                String tf3Text = tf3.getText();
                double radius = Double.parseDouble(tf3Text);
                
                String tf4Text = tf4.getText();
                int numRecursions = Integer.parseInt(tf4Text);
                
                CircleSpiral newCircle = new CircleSpiral(xCoordinate, yCoordinate, 
                radius, numRecursions, canvas.getColor());
                
                frame.dispose();
            }
            else 
            {
                frame.dispose();
            }
        }
    }
}