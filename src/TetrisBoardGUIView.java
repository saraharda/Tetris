/**
 * A TetrisBoardGUIView class that serves as the view class for the board
 * @author Sara Harda
 **/

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JComponent;

public class TetrisBoardGUIView extends JComponent
{
	private static final long serialVersionUID = 1L;

	//instance of the board
	private TetrisBoard board;

	//block size
	private int size;

	//constant for the size of the piece
	public static final int SIZE = 50;

	//random colors for pieces
	private Color[] randomColor;

	/**
	 * Constructor
	 * @param board is the game board
	 */
	public TetrisBoardGUIView(TetrisBoard board) {
		this.board = board;
	}

	/**
	 * Paint the game.
	 * @param g is the graphics object
	 */
	public void paint(Graphics g) {
		//sets the block size
		size = computeBlockSize();

		//makes a piece on the board
		for (int m=0; m<TetrisBoard.NUM_ROWS; m++){
			for (int n=0; n<TetrisBoard.NUM_COLS; n++){
				if(board.hasBlock(m,n))
					paintBlock(g, m, n, size);
			}
		}
		paintBoardOutline(g, size);
	}

	/**
	 * Paints the outline of the board
	 * @param g is the graphics object
	 * @param blockSize is the size of the block
	 */
	private void paintBoardOutline(Graphics g, int blockSize) {
		g.drawRect(0, 0, TetrisBoard.NUM_COLS*blockSize, TetrisBoard.NUM_ROWS*blockSize);
	}

	/**
	 * Paint the block at grid row, grid col.
	 * @param g is the graphics object
	 * @param row is the board row
	 * @param col is the board column
	 * @param blockSize is the size of the block
	 */
	private void paintBlock(Graphics g, int row, int col, int blockSize) {
		//sets color of the block
		randomColor = new Color[] {
				new Color(66, 134, 244), new Color(178, 219, 114), new Color(153, 125, 215), 
				new Color(10, 20, 34), new Color(38, 78, 255), new Color (87, 77, 48), new Color(4, 34, 220)};
		g.setColor(randomColor[board.random]);
		g.fillRect(blockSize*col, blockSize*row, blockSize, blockSize);

		//sets the color of the outline
		g.setColor(Color.BLUE);
		g.drawRect(blockSize*col, blockSize*row, blockSize, blockSize);
	}

	/**
	 * Compute the best block size for the current width and height
	 * @return best block size
	 */
	private int computeBlockSize() {
		return (getWidth()/TetrisBoard.NUM_COLS);
	}
}