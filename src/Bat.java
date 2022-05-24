import java.awt.Color;
import java.awt.Window;

public class Bat
{
	// Initialization of Variables
	public Rectangle bat;
	private int direction;
	private int batLenght = 100;
	private int batHeight = 20;
	private int Right = 1;
	private int Left = 2;
	private int windowSize = 500;

	// Declaration of bat
	public Bat(int x, int y, GameWindow w)
	{
		bat = new Rectangle(x, y, batLenght, batHeight);
		bat.setBackground(Color.blue);
		w.add(bat);
		w.repaint();
	}

	public void move()
	{
		// Variable for the bat movement
		int x = bat.getX();
		int y = bat.getY();
		int Side = windowSize - batLenght;
		int batSpeed = 3;

		// Moves bat Left or right
		if ((direction == Right) && (x < Side))
		{
			bat.setLocation(x + batSpeed, y);
		} 
		else if ((direction == Left) && (x > 0))
		{
			bat.setLocation(x - batSpeed, y);
		}
	}

	// Set Direction for the bat
	public void setDirection(int dir)
	{
		direction = dir;
	}

	// Get Width of the bat
	public int getWidth()
	{
		return bat.getWidth();
	}

	// Get X of the bat
	public int getX()
	{
		return bat.getX();
	}

	// Get Y of the bat
	public int getY()
	{
		return bat.getY();
	}
}
