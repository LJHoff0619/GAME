import javax.swing.JFrame;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

import javax.swing.JButton;

public class Test 
{
	

	public static void main(String []args) 
	{
		JFrame frame = new JFrame();
		final int FRAME_WIDTH = 1000;
		final int FRAME_HEIGHT = 600;
		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		JB jb= new JB();
		frame.add(jb,BorderLayout.CENTER);
		frame.setVisible(true);
		jb.startAnimation();
//		jb.up();
//		jb.run();
	
	}	
}
