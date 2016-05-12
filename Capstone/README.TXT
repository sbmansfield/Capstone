OVERVIEW:
My Capstone is a pretty basic GUI program based a bit off of the Drawing Editor Lab and 
the Fractal Tree Lab. It features a JFrame that includes several panels and buttons that can be used
to specify the color, starting coordinates, and number of recursions involved in a "CircleSpiral"
object. After entering in the given user information and pressing the Draw button, a recursive
spiral using circles is generated and displayed on the screen. Each reentering of information
generates a new spiral that replaces the old one on the frame of the program.

EXPLANATION OF SYNTHESIZATION:
As stated before, my project used many concepts utilized in both the Drawing Editor Lab and 
the Fractal Tree Lab, which was GUI application and recursive methods.
However, in order to make a complex GUI, I did have to research new
GUI elements and how to implement them/get them to work, such as allowing the click of a button
to open up a new panel/window, as well asapplying Jlabels and JTextFields to that new window in 
an organized format. I also had to apply parsing in order to read the text inputted from the user
and convert it into ints and doubles.

INSTRUCTIONS TO RUN CAPSTONE:
1. Invoke the main method of the SpiralDrawer class
2. Click the Press Color button to choose a new color
3. Click the Customize button and enter in values for all 4 textfields (all must be ints aside from
the starting size(radius))
4. Press the submit button to enter your input and close the customization window, or the
cancel button just to close the window
5. Press the Draw button to draw the spiral

CITATION OF CODE TAKEN FROM ONLINE:
One method involving GridBagConstraints in the Customizer class was taken from Stack Overflow 
"http://stackoverflow.com/questions/27207887/java-jbutton-opening-another-jframe-that-i-can-input-into"