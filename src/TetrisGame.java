/**
 * A TetrisGame class that maintains a Tetris game
 * @author Sara Harda
 **/

public class TetrisGame
{
	//number of deleted lines  
	private int numLines;

	//number of Tetrises
	private int numTetrises;

	//instance of the board class
	private TetrisBoard tetrisBoard;

	//static numbers corresponding to each user move
	public static final int DOWN = 1;
	public static final int LEFT = 2;
	public static final int RIGHT = 3;
	public static final int CW = 4;
	public static final int CCW = 5;

	/**
	 * Constructor
	 */
	public TetrisGame() {
		tetrisBoard = new TetrisBoard();
	}

	/**
	 * Move the current piece with RIGHT, LEFT, DOWN, CW, CCW
	 * @param  moveType is the move performed by the user
	 */
	public void attemptMove(int moveType) {
		if (moveType == DOWN){
			if (tetrisBoard.moveDown() == false){
				endRound();
			}
		}
		else if (moveType == LEFT){
			tetrisBoard.moveLeft();
		}
		else if (moveType == RIGHT){
			tetrisBoard.moveRight();
		}
		else if (moveType == CW){
			tetrisBoard.rotateCW();
		}
		else if (moveType == CCW){
			tetrisBoard.rotateCCW();
		}
	}

	/**
	 * Performed when a piece cannot move down anymore
	 * Ends the round by checking for newly formed lines and adding a new piece
	 */
	private void endRound() {
		tetrisBoard.landPiece();
		tetrisBoard.addNewPiece();
	}

	/**
	 * @return the number of deleted lines
	 */
	public int getNumLines() {
		int rows = tetrisBoard.numberOfFormedLines();
		numLines = numLines + rows;
		return numLines;		
	}

	/**
	 * @return the number of Tetrises
	 */
	public int getNumTetrises() {
		if (getNumLines() >3){
			numTetrises = getNumLines()/4 ;
		}
		return numTetrises;
	}

	/**
	 * @return the tetrisBoard
	 */
	public TetrisBoard getTetrisBoard() {
		return tetrisBoard;
	}
}