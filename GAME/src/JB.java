import java.awt.Graphics; 
import java.util.Scanner;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.KeyEvent;
import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JPanel;

import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
public class JB extends JComponent implements Runnable, KeyListener
{
	//all images
	private BufferedImage JB_down;
	private BufferedImage JB_up;
	private BufferedImage JB_not_moving;
	private BufferedImage JB_left;
	private BufferedImage JB_right;
	private BufferedImage AR;
	private BufferedImage AL;
	private BufferedImage AU;
	private BufferedImage AD;
	private BufferedImage hoop;
	private BufferedImage swoosh;
	private BufferedImage good;
	private BufferedImage ok;
	private BufferedImage booty;
	private BufferedImage court;
	private BufferedImage onethree;
	//choosing images
	private BufferedImage x;
	private BufferedImage y;
	//difficulty
	private int gameDifficulty;
	//sound
	private Sound s;
	//all axis positions and speeds
	private int x_pos;
	private int x_speed;
	private int y_pos;
	private int y_pos2;
	private int y_pos3;
	private int y_pos4;
	private boolean[] keys = new boolean[256];
	private CardLayout layout; 
	private JPanel layers;
	private int speed;
	
	private int score;
	private Scanner in;
	public JB()
	{
		in = new Scanner(System.in);
		//set speeds and positions
		x_pos = 385;
		y_pos = -100;
		y_pos2= -200;
		y_pos3= -300;
		y_pos4= -400;
		x_speed = 8;
		speed=20;
		//score
		score = 0;
		//sound file
		s = new Sound("C:\\Users\\27hofl01\\Downloads\\ode-to-joy-piano-68697.wav");

		

//		s = new Sound();
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		//ALL IMAGES TO VARIABLES
		try
		{
			court = ImageIO.read(Test.class.getResourceAsStream("court.jpg"));
		}
		catch(IOException | IllegalArgumentException e)
		{
			e.printStackTrace();
		}
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
			booty = ImageIO.read(Test.class.getResourceAsStream("booty.png"));
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
			hoop = ImageIO.read(Test.class.getResourceAsStream("hoop.png"));
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
	//methods to set x to one of JB's poses
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
	
	//sets y to how well you did for one arrow
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
	//ending
	public void onethree()
	{
		y= onethree;
	}
	//difficulty
	public void setDifficulty(int x)
	{
		gameDifficulty = x;
	}
	
	public void startAnimation()
	{
		Thread t = new Thread(this);
		t.start();
		//starts out stationary
		notMoving();
	}

	public void paintComponent(Graphics g)
	{	
		//painting the background and JB
		g.drawImage(court, 0, 0, 1400, 900, null);
  		g.drawImage(x, 20,300,500,300, null);
  		//all the arrows above their assigned baskets
  		g.drawImage(AU, 750, y_pos3, null);
  		g.drawImage(AD, 600, y_pos4, null);
  		g.drawImage(AL, 450, y_pos, null);
  		g.drawImage(AR,900,y_pos2,null);
  		//baskets
  		g.drawImage(hoop, 400, 400, null);
  		g.drawImage(hoop, 550, 400, null);
  		g.drawImage(hoop, 700, 400, null);
  		g.drawImage(hoop, 850, 400, null);
  		//how they did
  		g.drawImage(y, 100, 50,null);

	}
	public void keyTyped(KeyEvent e) 
	{
	
	}

	
	public void keyPressed(KeyEvent e) 
	{
		//if you go left
		if (e.getKeyCode() == 37) 
			{
			//JB pose left
			left();
			//depending on how far the arrow is to the hoop when you press the key, your score will go up 
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
		//if you go right
		if (e.getKeyCode() == 39) 
		{
			//JB pose right
			right();
			//depending on how far the arrow is to the hoop when you press the key, your score will go up 
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
		//if you go up
		if (e.getKeyCode() == 38) 
			{
			//JB pose up
			up();
			//depending on how far the arrow is to the hoop when you press the key, your score will go up 
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
		//if you go down
		if (e.getKeyCode() == 40) 
		{
		//JB pose down
		down();
		//depending on how far the arrow is to the hoop when you press the key, your score will go up 
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
		//brings back to not moving pose
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
		System.out.println("Enter difficulty:");
		int p = in.nextInt();
		setDifficulty(p);
		//gives time to get ready
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//start audio
		s.makeSound();
		
		while (true) {
			try {
				//moves arrows down screen
				y_pos+=speed;
				y_pos2+=speed;
				y_pos3+=speed;
				y_pos4+=speed;
				//miss for arrow 1
				if(y_pos > 600)
				{
					booty();
					y_pos = (int) ((-1 * (Math.random()*(1500-500)/100)))*100+-100;
					score-= 1;
					System.out.println("-1! :" + score +"  " + y_pos);
				}
				//miss for arrow 2
				if(y_pos2 > 600)
				{
					booty();
					y_pos2 = (int) ((-1 * (Math.random()*(1500-500)/100)))*100+-100;
					score-= 1;
					System.out.println("-1! :" + score);
				}
				//miss for arrow 3
				if(y_pos3 > 600)
				{
					booty();
					y_pos3 = (int) ((-1 * (Math.random()*(1500-500)/100)))*100+-100;
					score-= 1;
					System.out.println("-1! :" + score);
				}
				//miss for arrow 4
				if(y_pos4 > 600)
				{
					booty();
					y_pos4 = (int) ((-1 * (Math.random()*(1500-500)/100)))*100+-100;
					score-= 1;
					System.out.println("-1! :" + score);
				}
				//when the song ends, prints final score and exits code
				if (s.isEnded())
				{
					System.out.println("Final Score: " + score);
					System.exit(0);
				}
				repaint();
				Thread.sleep(20);
				
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
		
	}

	public void difficultySelect() 
	{
		//depending on what difficulty you choose,
		//the game will speed up or slow down the arrows
		if(gameDifficulty==1)
		{
			speed=10;
		}
		if(gameDifficulty==2)
		{
			speed=20;
		}
		if(gameDifficulty==3)
		{
			speed=30;
		}
		if(gameDifficulty==4)
		{
			speed=40;
		}
	}

	//menu screen
	public void setMenu(CardLayout layout1, JPanel layers1) 
	{
		layout = layout1;
		layers = layers1;
	}
	

}


