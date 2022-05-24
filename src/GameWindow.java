
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
import javax.swing.JFrame;
import javax.swing.Timer;
import java.awt.event.*;

@SuppressWarnings("serial")
public class GameWindow extends JFrame implements ActionListener, KeyListener
{
	// Control constants.
	public final static int MOVE = 0;
	public final static int RIGHT = 1;
	public final static int LEFT = 2;
	public final static int STOP = 3;

	private Driver driver;
	private Timer timer;

	/**
	 * Creates game-play window.
	 *
	 * @param d Driver object to communicate with when keyboard and animation-timer
	 *          actions occur.
	 */
	public GameWindow(Driver d)
	{
		super("Window");
		setLocation(0, 0);
		setLayout(null);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		addKeyListener(this);
		driver = d;
		timer = new Timer(5, this);
	}

	/**
	 * Starts the animating timer; changes the run/pause button to "Pause".
	 */
	public void startTimer()
	{
		timer.start();
	}

	/**
	 * Stops the animating timer; changes the run/pause button to "Run".
	 */
	public void stopTimer()
	{
		timer.stop();
	}

	/**
	 * Sets the background of the contained display-area.
	 */
	public void setBackground(java.awt.Color c)
	{
		getContentPane().setBackground(c);
	}

	/**
	 * @return The y-coordinate of the bottom of the window display area. NOTE: may
	 *         be less than getHeight(), due to window insets.
	 */
	public int getBottomEdge()
	{
		return getHeight() - getInsets().bottom - getInsets().top;
	}

	/**
	 * Sets size of window display area.
	 *
	 * @param w Width of display area.
	 * @param h Height of display area.
	 */
	public void setSize(int w, int h)
	{
		super.setSize(w + getInsets().left + getInsets().right, h + getInsets().top + getInsets().bottom);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == timer)
		{
			driver.handleAction(MOVE);
		}
	}

	@Override
	public void keyPressed(KeyEvent k)
	{
		int key = k.getKeyCode();

		// 'J' == LEFT; 'K' == RIGHT
		if (key == KeyEvent.VK_J)
		{
			driver.handleAction(LEFT);
		} else if (key == KeyEvent.VK_K)
		{
			driver.handleAction(RIGHT);
		}
	}

	@Override
	public void keyReleased(KeyEvent k)
	{
		driver.handleAction(STOP);
	}

	@Override
	public void keyTyped(KeyEvent k)
	{
		// DOES NOTHING
	}
}
