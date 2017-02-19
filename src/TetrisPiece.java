/**
 * The TetrisPiece  class represents a piece made of 4 TetrisBlocks. 
 * It maintains 4 rotations (0°, 90°, 180° and 270°), with each being a 4x4 grid with certain filled squares.
 * @author Sara Harda
 **/
public  class TetrisPiece
{ 
	//3 dimensional array maintaining which squares are filled
	protected boolean[][][] filledSquares = new boolean [4][4][4];

	//maintains the current rotation (0: 0°, 1: 90°, etc)
	protected int pieceRotation = 0;

	/**
	 * Constructor
	 */
	public TetrisPiece() {
	}

	/**
	 * Rotate the piece clockwise by 90°
	 */
	public void rotateCW() {
		pieceRotation = (pieceRotation-1) %4 ;
	}

	/**
	 * Rotate the piece counter-clockwise by 90°
	 */
	public void rotateCCW() {
		pieceRotation = (pieceRotation+1) %4;
	}

	/**
	 * Get the rotation of this piece
	 * Return: 0, 90, 180, or 270°
	 */
	public int getPieceRotation() {
		return pieceRotation;
	}

	/**
	 * Checks if there is a TetrisBlock at the (row, col) position for the rotation rot
	 * Returns true if there is a block in the position for that rotation
	 * @param rot is the piece rotation value (0, 90, 180 or 270°)
	 * @param row is the the row position for the rotation within the 4*4 grid
	 * @param col is the column position for the rotation within the 4*4 grid
	 */
	public boolean isFilled( int rot, int row, int col){
		if (filledSquares[rot][row][col] == true) {
			return true;
		}
		else{
			return false;
		}
	}
}


