import java.awt.Color;
import java.util.Random;

public class Ball
{
	// Initializing variables
	private int upright = 0;
	private int upleft = 1;
	private int downright = 3;
	private int downleft = 4;
	private int x;
	private int y;
	private Oval ball;
	private int windowSize = 500;
	private int ballSize = 20;
	private int bounces;
	private int speed = 1;

	// Random direction for starting of the ball
	Random rand = new Random();
	int direction = rand.nextInt(2);

	//Setting parameters for the ball
	public Ball(int x, int y, GameWindow w)
	{
		ball = new Oval(x, y, 20, 20);
		w.add(ball);
	}

	public void move()
	{

		// Movement of the ball
		if (direction == upright)
		{
			x = ball.getX() + speed;
			y = ball.getY() - speed;
			ball.setLocation(x, y);
		}

		else if (direction == upleft)
		{
			x = ball.getX() - speed;
			y = ball.getY() - speed;
			ball.setLocation(x, y);
		}

		else if (direction == downright)
		{
			x = ball.getX() + speed;
			y = ball.getY() + speed;
			ball.setLocation(x, y);
		}

		else if (direction == downleft)
		{
			x = ball.getX() - speed;
			y = ball.getY() + speed;
			ball.setLocation(x, y);
		}

		// When the ball hits the edge

		// When the ball hits the edge
		if ((direction == upright) && (x >= (windowSize - ballSize)) && (y <= 0))
		{
			direction = downleft;
		}

		// When the ball hits Y axis
		else if ((direction == upright) && (x >= (windowSize - ballSize)) && (y >= 0))
		{
			direction = upleft;
		}

		// When the ball hits X axis
		else if ((direction == upright) && (x >= 0) && (y <= 0))
		{
			direction = downright;
		}

		// When the ball hits the edge
		else if ((direction == upleft) && (x <= 0) && (y <= 0))
		{
			direction = downright;
		}

		// When the ball hits X axis
		else if ((direction == upleft) && (x >= 0) && (y <= 0))
		{
			direction = downleft;
		}

		// When the ball hits Y axis
		else if ((direction == upleft) && (x <= 0) && (y >= 0))
		{
			direction = upright;
		}

		// When the ball hits left Y axis
		else if ((direction == downright) && (x >= (windowSize - ballSize) && (y >= 0)))
		{
			direction = downleft;
		}

		// When the ball hits right Y axis
		else if ((direction == downleft) && (x <= 0) && (y >= 0))
		{
			direction = downright;
		}

	}

	// Checks the ball if it hits with the ball and bounces it ofo
	public void checkBatHit(Bat b)
	{
		x = ball.getX();
		y = ball.getY();

		if (x + ball.getWidth() / 2 >= b.getX() && x + ball.getWidth() / 2 <= b.getX() + b.getWidth()
				&& y + ball.getWidth() == b.getY())
		{
			if (direction == downright)
			{
				direction = upright;
				bounces++;

				// Increase speed and count ball hits
				if (bounces % 5 == 0)
				{
					speed++;
				}
			}

			else if (direction == downleft)
			{
				direction = upleft;
				bounces++;

				// Increase speed and count ball hits
				if (bounces % 5 == 0)
				{
					speed++;
				}
			}
		}
	}

	//Bounces the ball
	public int getBounces()
	{
		return bounces;
	}

	//Help bounces the ball
	public int getSpeed()
	{
		return speed;
	}

}
