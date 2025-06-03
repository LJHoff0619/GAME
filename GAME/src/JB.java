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
	private BufferedImage AR;
	private BufferedImage AL;
	private BufferedImage AU;
	private BufferedImage AD;
	private BufferedImage x;
	private BufferedImage y;
	private BufferedImage hoop;
	private BufferedImage swoosh;
	private BufferedImage good;
	private BufferedImage ok;
	private BufferedImage booty;
	
	private BufferedImage onethree;
	
	private sound s;
	private int x_pos;
	private int x_speed;
	private int y_pos;
	private int y_pos2;
	private int y_pos3;
	private int y_pos4;
	private boolean[] keys = new boolean[256];
	
	
	
	private int score;

	public JB()
	{
		
		x_pos = 385;
		y_pos = -100;
		y_pos2= -200;
		y_pos3= -300;
		y_pos4= -400;
		x_speed = 8;
		
		score = 0;
		
		s = new sound("C:\\Users\\27kimd01\\Downloads\\otj.wav");

		

//		s = new Sound();
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
			swoosh = ImageIO.read(Test.class.getResourceAsStream("swoosh.jpg"));
		}
		catch(IOException | IllegalArgumentException e)
		{
			e.printStackTrace();
		}
		
		try
		{
			onethree = ImageIO.read(Test.class.getResourceAsStream("jb3-1.jpg"));
		}
		catch(IOException | IllegalArgumentException e)
		{
			e.printStackTrace();
		}
		
		try
		{
			booty = ImageIO.read(Test.class.getResourceAsStream("booty.jpg"));
		}
		catch(IOException | IllegalArgumentException e)
		{
			e.printStackTrace();
		}
		
		
		try
		{
			good = ImageIO.read(Test.class.getResourceAsStream("good.jpg"));
		}
		catch(IOException | IllegalArgumentException e)
		{
			e.printStackTrace();
		}
		
		
		try
		{
			ok = ImageIO.read(Test.class.getResourceAsStream("ok.jpg"));
		}
		catch(IOException | IllegalArgumentException e)
		{
			e.printStackTrace();
		}
		
		
		try
		{
			hoop = ImageIO.read(Test.class.getResourceAsStream("images__3_-removebg-preview (2).png"));
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
			AR = ImageIO.read(Test.class.getResourceAsStream("right.png"));
		}
		catch(IOException | IllegalArgumentException e)
		{
			e.printStackTrace();
		}
		
		try
		{
			AL = ImageIO.read(Test.class.getResourceAsStream("left.png"));
		}
		catch(IOException | IllegalArgumentException e)
		{
			e.printStackTrace();
		}
		
		try
		{
			AU = ImageIO.read(Test.class.getResourceAsStream("upp.png"));
		}
		catch(IOException | IllegalArgumentException e)
		{
			e.printStackTrace();
		}
		
		
		
		
		try
		{
			AD = ImageIO.read(Test.class.getResourceAsStream("down.png"));
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
	
	
	public void swoosh()
	{
		y = swoosh;
	}
	public void good()
	{
		y = good;
	}
	public void ok()
	{
		y = ok;
	}
	public void booty()
	{
		y = booty;
	}
	public void onethree()
	{
		y= onethree;
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
  		
  		g.drawImage(AU, 750, y_pos3, null);
  		g.drawImage(AD, 600, y_pos4, null);
  		g.drawImage(AL, 450, y_pos, null);
  		g.drawImage(AR,900,y_pos2,null);
  		
  		g.drawImage(hoop, 400, 400, null);
  		g.drawImage(hoop, 550, 400, null);
  		g.drawImage(hoop, 700, 400, null);
  		g.drawImage(hoop, 850, 400, null);
  		
  		g.drawImage(y, 100, 50,null);

	}
	public void keyTyped(KeyEvent e) 
	{
	
	}

	
	public void keyPressed(KeyEvent e) 
	{
		
		if (e.getKeyCode() == 37) 
			{
			left();
				if((y_pos<= 450 && y_pos >425) || (y_pos< 375 && y_pos >= 350))
				{
					good();
					
					score+=2;
					System.out.println("+2! score:" + score);
					y_pos = (int) ((-1 * (Math.random()*(1500-500)/100)))*100+-100;
					
					
				}
				if(y_pos <= 425 && y_pos >= 375)
				{
					swoosh();
					score+=3;
					System.out.println("+3! score: " + score);
					
					y_pos = (int) ((-1 * (Math.random()*(1500-500)/100)))*100+-100;
				}
				
			}
		if (e.getKeyCode() == 39) 
		{
			right();
			if((y_pos2<= 450 && y_pos2 >425) || (y_pos2< 375 && y_pos2 >= 350))
			{
				good();
				score+=2;
				System.out.println("+2! score:" + score);
				y_pos2 = (int) ((-1 * (Math.random()*(1500-500)/100)))*100+-100;
				
			}
			if(y_pos2 <= 425 && y_pos2 >= 375)
			{
				swoosh();
				score+=3;
				System.out.println("+3! score: " + score);
				y_pos2 = (int) ((-1 * (Math.random()*(1500-500)/100)))*100+-100;
			}
		}
		
		if (e.getKeyCode() == 38) 
			{
			up();
			if((y_pos3<= 450 && y_pos3 >425) || (y_pos3< 375 && y_pos3 >= 350))
			{
				good();
				score+=2;
				System.out.println("+2! score:" + score);
				y_pos3 = (int) ((-1 * (Math.random()*(1500-500)/100)))*100+-100;
			
				
			}
			if(y_pos3 <= 425 && y_pos3 >= 375)
			{
				swoosh();
				score+=3;
				System.out.println("+3! score: " + score);
				y_pos3 = (int) ((-1 * (Math.random()*(1500-500)/100)))*100+-100;
			}
			}
		if (e.getKeyCode() == 40) 
		{
		down();
		if((y_pos4<= 450 && y_pos4 >425) || (y_pos4< 375 && y_pos4 >= 350))
		{
			good();
			score+=2;
			System.out.println("+2! score:" + score);
			y_pos4 = (int) ((-1 * (Math.random()*(1500-500)/100)))*100+-100;
			
		}
		if(y_pos4 <= 425 && y_pos4 >= 375)
		{
			swoosh();
			score+=3;
			System.out.println("+3! score: " + score);
			y_pos4 = (int) ((-1 * (Math.random()*(1500-500)/100)))*100+-100;
		}
		}
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
				y_pos+=20;
				y_pos2+=20;
				y_pos3+=20;
				y_pos4+=20;
				if(y_pos > 600)
				{
					booty();
					y_pos = (int) ((-1 * (Math.random()*(1500-500)/100)))*100+-100;
					score-= 1;
					System.out.println("-1! :" + score +"  " + y_pos);
				}
				
				if(y_pos2 > 600)
				{
					booty();
					y_pos2 = (int) ((-1 * (Math.random()*(1500-500)/100)))*100+-100;
					score-= 1;
					System.out.println("-1! :" + score);
				}
				
				if(y_pos3 > 600)
				{
					booty();
					y_pos3 = (int) ((-1 * (Math.random()*(1500-500)/100)))*100+-100;
					score-= 1;
					System.out.println("-1! :" + score);
				}
				
				if(y_pos4 > 600)
				{
					booty();
					y_pos4 = (int) ((-1 * (Math.random()*(1500-500)/100)))*100+-100;
					score-= 1;
					System.out.println("-1! :" + score);
				}
				
				
				
				
				
				repaint();
				Thread.sleep(20);
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}


}


