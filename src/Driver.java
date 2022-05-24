
/**
 * There is a red ball that starts to move at angle of 45 degree
 * right or left and then when the ball hits the boundary of the window 
 * the ball bounces accordingly. There is a bat at the bottom so whenever the 
 * ball hits the bat then the ball bounces and when the bat does not hit the ball
 * the ball goes of the edge. There is a counter for bounce as well and the 
 * speed of the ball increases by 1 pixel every 5 bounces.
 * 
 * Zoyace Shrestha
 * CS-120 
 * Fall 2019
 * 
 * Programming Assignment 7
 * November 21, 2019
 * 
 * @author M. Allen
 */

import java.awt.Color;
import javax.swing.JLabel;

public class Driver
{
	private GameWindow window;
	private JLabel bounces, speed;
	private Bat blok;
	private Ball ball;

	/**
	 * post : Driver constructor run and game set-up performed
	 */
	public static void main(String[] args)
	{
		Driver d = new Driver();
		d.makeGame();
	}

	/**
	 * post: constructor sets up window and creates all needed objects
	 */
	private void makeGame()
	{
		// Create window with animating timer and keyboard input response.
		window = new GameWindow(this);
		window.setTitle("Bounce, bounce, bounce...");
		window.setLocation(50, 50);
		window.setSize(500, 500);
		window.setBackground(Color.white);

		// Add ball and bat to window.
		ball = new Ball(window.getWidth() / 2 - 10, window.getHeight() / 2 - 10, window);
		blok = new Bat(window.getWidth() / 2 - 50, window.getHeight() - 50, window);

		// add labels for speed and number of bounces
		bounces = new JLabel("Bounces: " + ball.getBounces());
		bounces.setBounds(10, 10, 150, 20);
		window.add(bounces);
		speed = new JLabel("Speed: " + ball.getSpeed());
		speed.setBounds(10, 30, 150, 20);
		window.add(speed);

		window.startTimer();
		window.repaint();
	}

	/**
	 * @param action : an integer describing the action taken post: the method
	 *               corresponding to the appropriate action will be taken
	 */
	public void handleAction(int action)
	{
		if (action == GameWindow.MOVE)
		{
			ball.move();
			blok.move();
			ball.checkBatHit(blok);
			bounces.setText("Bounces: " + ball.getBounces());
			speed.setText("Speed: " + ball.getSpeed());
		} else
		{
			blok.setDirection(action);
		}
	}
}
