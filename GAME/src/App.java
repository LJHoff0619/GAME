import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Frame;
import java.awt.Graphics;
import java.io.IOException;
import javax.swing.JButton;

public class Test
{

	public static void main(String []args) throws IOException
	{
		//creates JFrame to put pictures on top of 	
		JFrame frame = new JFrame();
		frame.setExtendedState(Frame.MAXIMIZED_BOTH);
		//when you close the window, it will terminate the code
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//All the photos we have and setting the layout of the border to the center
		final JB jb= new JB();
		frame.add(jb,BorderLayout.CENTER);
		//makes the Frame visible and starts running the code
		frame.setVisible(true); 
		jb.startAnimation();
		
		
		
	
	}
}
