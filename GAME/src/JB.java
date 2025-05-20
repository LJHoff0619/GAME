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
	private int x_pos;
	private int x_speed;
	private int y_pos;
	private int y_speed;
	public JB() 
	{
		
		//All initializations go here
		x_pos = 10;
		y_pos = 200;
		x_speed = 5;
		y_speed = 5;
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		try 
		{
		    JB_down = ImageIO.read(new File("JB_down.jpg"));
		} 
		catch (IOException e) 
		{
		    e.printStackTrace();
		}
		
		try 
		{
		    JB_down = ImageIO.read(new File("JB_down.jpg"));
		} 
		catch (IOException e) 
		{
		    e.printStackTrace();
		}
	}
	public void startAnimation()
	{
 		Thread t = new Thread(this);
		t.start();
	}
	
	public void paintComponent(Graphics g)
	{
		g.drawImage(JB_down, 100, 200, null);
	}
	public void keyPressed(KeyEvent e)
	{
		System.out.println(e.getKeyCode());
		if(e.getKeyCode()==37)
		{
			System.out.println(e.getKeyCode());
		}
		else if(e.getKeyCode()==46)
		{
			y_speed*=-1;
		}
	}
	public void keyReleased(KeyEvent e)
	{
	}
	public void keyTyped(KeyEvent e)
	{
	}
	public void run()
	{
		while (true)
		{
			try
			{
				if (x_pos>=930)
					x_speed=0;
					y_speed=0;
				if (x_pos <=0)
					x_speed=0;
					y_speed=0;
				if (y_pos>=500)
					y_speed=0;
					x_speed=0;
				if (y_pos <=0)
					y_speed=0;
					x_speed=0;
				
				x_pos+=x_speed;
				y_pos+=y_speed;
				repaint();
				Thread.sleep(10);
			}
			catch (InterruptedException e)
			{
			
			}
		}
	}
	
	
}