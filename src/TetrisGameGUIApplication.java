/**
 * A TetrisGameGUIApplication class that represents the command line version of the GUI Tetris game.
 * @author Sara Harda
 **/
import javax.swing.JFrame;

public class TetrisGameGUIApplication
{
	//dimensions of the frame
	public static final int FRAME_WIDTH = 500;
	public static final int FRAME_HEIGHT = 600;

	/**
	 * Starts the game
	 */
	public static void main (String[] args){
		//makes a new JFrame
		JFrame frame = new JFrame("Let's play Tetris!");
		
		//adds the controller to the JFrame
		frame.add(new TetrisGameGUIController());
		
		//sets the size of the JFrame
		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		
		//sets frame to visible
		frame.setVisible(true);
		
		//exists on close
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}