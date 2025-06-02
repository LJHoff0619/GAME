import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Graphics;
import java.io.IOException;
import javax.swing.JButton;

public class Test
{

	public static void main(String []args) throws IOException
	{
		
		JFrame frame = new JFrame();
		final int FRAME_WIDTH = 1000;
		final int FRAME_HEIGHT = 600;
		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		final JB jb= new JB();
		frame.add(jb,BorderLayout.CENTER);
		frame.setVisible(true); 
		jb.startAnimation();
		
		final Arrows a= new Arrows();
		frame.add(a,BorderLayout.EAST);
		frame.setVisible(true);
		a.startAnimation();
		
		
	
	}
}
