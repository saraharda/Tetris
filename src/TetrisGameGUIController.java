/**
 * A TetrisGameGUIController class that create the GUI version of Tetris
 * @author Sara Harda
 **/

import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.Timer;
import javax.swing.JPanel;

public class TetrisGameGUIController extends JPanel implements KeyListener
{
	private static final long serialVersionUID = 1L;
	//constant for drop rate
	public static final int DEFAULT_DROP_RATE = 1000;
	
	//instance of Tetris game
	private TetrisGame game;
	
	//instance of view
	private TetrisBoardGUIView view;
	
	//Label for the lines
	private JLabel linesLabel;
	
	//label for the tetrises
	private JLabel tetrisesLabel;
	
	/**
	 * Constructor
	 */
	public TetrisGameGUIController() {
		//calls super
		super(new BorderLayout());

		//add the key listener
		setFocusable(true);
		addKeyListener(this);
		
		//initialized the game class
		game = new TetrisGame();
		
		//initializes the board
		new TetrisBoard();
		
		//calls the controller methods
		createView();
		createScore();
		setupTimer();
		refreshDisplay();
	}

	/**
	 * Method to set up the timer for the falling pieces
	 */
	private void setupTimer() {
		//make action listener
		ActionListener timer = new ActionListener(){
			public void actionPerformed (ActionEvent e){
				game. attemptMove(TetrisGame.DOWN);
				refreshDisplay();
			}
		};
		//make the piece fall according to the drop rate
		new Timer(DEFAULT_DROP_RATE, timer).start();
	}

	/**
	 * Creates the view of the game
	 */
	private void createView() {
		view = new TetrisBoardGUIView(game.getTetrisBoard());
		setLayout(new BorderLayout());
		add(view, BorderLayout.CENTER);

	}

	/**
	 * Creates the score labels and adds them to a panel in the north of the canvas
	 */
	private void createScore() {
		JPanel panel = new JPanel();
		linesLabel = new JLabel();
		tetrisesLabel = new JLabel();
		panel.add(linesLabel);
		panel.add(tetrisesLabel);
		add(panel, BorderLayout.NORTH);
	}

	/**
	 * Refreshes the display of the game
	 */
	public void refreshDisplay() {
		//prints score
		linesLabel.setText("Lines cleared: "+" "+game.getNumLines());
		tetrisesLabel.setText("Tetrises cleared: "+" "+game.getNumTetrises());
		
		//repaints the screen
		view.repaint();
	}

	/**
	 * Do something when a key is pressed and released
	 * @param e the key that is pressed and released
	 */
	@Override
	public void keyTyped(KeyEvent e) {
	}

	/**
	 * Move the circle when a key is released
	 * @param e the key that is released
	 */
	@Override
	public void keyReleased(KeyEvent e) {
	}

	/**
	 * Do something when a key is pressed
	 * @param e the key that is pressed
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		//"KeyCode" is the enum of the key that was pressed
		//Check the KeyEvent documentation for more
		int key = e.getKeyCode();
		
		if (key == KeyEvent.VK_DOWN) {
			game.attemptMove(TetrisGame.DOWN);
			refreshDisplay();
		}
		else if (key == KeyEvent.VK_RIGHT) {
			game.attemptMove(TetrisGame.RIGHT);
			refreshDisplay();
		}
		else if (key == KeyEvent.VK_LEFT) {
			game.attemptMove(TetrisGame.LEFT);
			refreshDisplay();
		}
		else if (key == KeyEvent.VK_X) {
			game.attemptMove(TetrisGame.CW);
			refreshDisplay();
		}
		else if (key == KeyEvent.VK_Z) {
			game.attemptMove(TetrisGame.CCW);
			refreshDisplay();
		}
		repaint();
	}	 
}