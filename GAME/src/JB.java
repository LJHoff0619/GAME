import java.awt.Graphics; 
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.event.KeyEvent;
import javax.imageio.ImageIO;
import javax.swing.JComponent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
public class JB extends JComponent implements Runnable, KeyListener
{
	private BufferedImage JB_down;
	private BufferedImage JB_up;
	private BufferedImage JB_not_moving;
	private BufferedImage JB_left;
	private BufferedImage JB_right;
	private BufferedImage x;
	private Sound s;
	private boolean[] keys = new boolean[256];

	public JB()
	{

		s = new Sound("G:\\My Drive\\10th Grade\\APCSA\\0_GAME_0\\src\\otj.wav");
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		try
		{
			JB_not_moving = ImageIO.read(Test.class.getResourceAsStream("JB_new_not_moving.jpg"));
		}
		catch(IOException | IllegalArgumentException e)
		{
			e.printStackTrace();
		}

		try
		{
			JB_down = ImageIO.read(Test.class.getResourceAsStream("JB_new_down.jpg"));
		}
		catch(IOException | IllegalArgumentException e)
		{
			e.printStackTrace();
		}

		try
		{
			JB_left = ImageIO.read(Test.class.getResourceAsStream("JB_new_left.jpg"));
		}
		catch(IOException | IllegalArgumentException e)
		{
			e.printStackTrace();
		}


		try
		{
			JB_up = ImageIO.read(Test.class.getResourceAsStream("JB_new_up.jpg"));
		}
		catch(IOException | IllegalArgumentException e)
		{
			e.printStackTrace();
		}

		try
		{
			JB_right = ImageIO.read(Test.class.getResourceAsStream("JB_new_right.jpg"));
		}
		catch(IOException | IllegalArgumentException e)
		{
			e.printStackTrace();
		}

	}

	public void up()
	{
		x = JB_up;
	}
	public void down()
	{
		x = JB_down;
	}
	public void left()
	{
		x = JB_left;
	}
	public void right()
	{
		x = JB_right;
	}
	public void notMoving()
	{
		x= JB_not_moving;
	}


	public void startAnimation()
	{
		Thread t = new Thread(this);
		t.start();
		notMoving();
	}

	public void paintComponent(Graphics g)
	{
  		g.drawImage(x, 100, 200, null);

	}
	public void keyTyped(KeyEvent e) 
	{
	
	}

	
	public void keyPressed(KeyEvent e) 
	{
		System.out.println(e.getKeyCode());
		if (e.getKeyCode() == 37) left();
		if (e.getKeyCode() == 39) right();
		if (e.getKeyCode() == 38) up();
		if (e.getKeyCode() == 40) down();
		
	}


	public void keyReleased(KeyEvent e) 
	{
		try 
		{
			Thread.sleep(20);
		} 
		catch (InterruptedException e1) 
		{
			
			e1.printStackTrace();
		}
		notMoving();
	}



	public void run()
	{
		s.makeSound();
		while (true) {
			try {
				
				repaint();
				Thread.sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}


}
