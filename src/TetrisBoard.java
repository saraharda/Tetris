/**
 * A TetrisBoard class that represents the model: a board on which Tetris is played
 * It maintains the grid (the block matrix) and the current piece. 
 * @author Sara Harda
 **/

public class TetrisBoard
{
	//Dimensions of the board
	public static final int NUM_COLS = 16;
	public static final int NUM_ROWS = 16;
	
	//random number of tetris piece order
	protected int random;

	//Array of booleans for the board 
	private boolean[][] blockMatrix;

	//Current piece falling down in the board
	private TetrisPiece currentPiece = new TetrisPiece();

	//position of current (falling) piece 
	private int[] currentPieceGridPosition;
	
	/**
	 * Constructor that sets up the board
	 */
	public TetrisBoard() {
		//Calling the method that adds the initial board with false values
		initBoard();

		//Calling the method that adds a new piece to the board
		addNewPiece();		
	}

	/**
	 * Initialize the 2D board array to have all false values
	 */
	private void initBoard() {
		//Creating a new block matrix 
		blockMatrix = new boolean [NUM_ROWS][NUM_COLS];

		for (int row=0; row<NUM_ROWS; row++) {
			for (int col=0; col<NUM_COLS; col++) {
				blockMatrix[row][col] = false;
			}
		}
	}

	/**
	 * Initialize an int array of length two to keep track of the grid position of the current piece (row, col)
	 */
	private void initCurrentGP() {
		currentPieceGridPosition = new int[2];

		//currentPieceGridPosition[0] stores the current row 
		currentPieceGridPosition[0] = 0;

		//currentPieceGridPosition[1] stores the current column
		currentPieceGridPosition[1] = 6;
	}

	/**
	 * Add a new random Tetris piece to the board at grid position (1, 5)
	 */
	public void addNewPiece() {
		//generate a random number from 0 - 6
		random =  (int)Math.floor(Math.random()*7);

		//randomly prints a Tetris piece to the board
		if (random == 0){
			currentPiece = new ShapeI();
		}
		else if (random == 1){
			currentPiece = new ShapeJ();
		}
		else if (random== 2){
			currentPiece = new ShapeL();
		}
		else if (random == 3){
			currentPiece = new ShapeS();
		}
		else if (random == 4){
			currentPiece = new ShapeZ();
		}
		else if (random == 5){
			currentPiece = new ShapeT();
		}
		else if (random == 6){
			currentPiece = new ShapeSquare();
		}
		initCurrentGP();
	}

	/**
	 * Update the board array to reflect the newly landed piece's filled squares using the currentGridPosition values and the currentPiece's rotation value.
	 */
	public void landPiece(){
		//loop through the Tetris piece
		for (int m = 0; m<4; m++){
			for (int n = 0; n<4; n++){
				if (currentPiece.isFilled(currentPiece.pieceRotation, m, n)){
					if (m+ currentPieceGridPosition[0] < NUM_ROWS){	
						//updateS board
						blockMatrix[currentPieceGridPosition[0]+m][currentPieceGridPosition[1]+n] = true;
					}
				}
			}
		}
		addNewPiece();
	}

	/**
	 * Check if moving down is valid. If so, move the current piece down.
	 * @return true if valid move was performed
	 */
	public boolean moveDown() {
		if (validMove(currentPiece, currentPiece.pieceRotation, currentPieceGridPosition[0] +1, currentPieceGridPosition[1])){
			currentPieceGridPosition[0]++;
			return true;
		}
		return false;
	}

	/**
	 * Check if moving left is valid. If so, move the current piece left.
	 * @return true if valid move was performed
	 */
	public boolean moveLeft() {
		if (validMove(currentPiece, currentPiece.pieceRotation, currentPieceGridPosition[0], currentPieceGridPosition[1]-1)){
			currentPieceGridPosition[1] --;
			return true;
		}
		return false;
	}

	/**
	 * Check if moving right is valid. If so, move the current piece right.
	 * @return true if valid move was performed
	 */
	public boolean moveRight() {
		if (validMove(currentPiece, currentPiece.pieceRotation, currentPieceGridPosition[0], currentPieceGridPosition[1]+1)){
			currentPieceGridPosition[1] ++;
			return true;
		}
		return false;
	}

	/**
	 * Check if rotating clockwise is valid. If so, rotate the current piece clockwise by 90 degrees.
	 * @return true if valid
	 */
	public boolean rotateCW() {
		if (validMove(currentPiece, (currentPiece.pieceRotation-1) < 0 ? 3 : currentPiece.pieceRotation-1, currentPieceGridPosition[0], currentPieceGridPosition[1])){
			currentPiece.pieceRotation = (currentPiece.pieceRotation-1) < 0 ? 3 : currentPiece.pieceRotation-1;
			return true;
		}
		return false;
	}

	/**
	 * Check if rotating counter-clockwise is valid. If so, rotate the current piece clockwise by 90 degrees.
	 * @return true if valid
	 */
	public boolean rotateCCW() {
		if (validMove(currentPiece, (currentPiece.pieceRotation +1)%4, currentPieceGridPosition[0], currentPieceGridPosition[1])){
			currentPiece.pieceRotation=(currentPiece.pieceRotation+1)%4;
			return true;
		}
		return false;
	}

	/**
	 * Check if placing the piece at grid position (row, col) with the rotation rot (0, 90, 180, 270) would cause a collision
	 * i.e., if there would be a block on an already-filled grid square
	 * @return true if there would be a collision
	 * @param piece is a tetris piece
	 * @param rot is rotation
	 * @param gridRow is the board row
	 * @param gridCol is the board column
	 */
	private boolean detectCollision(TetrisPiece piece, int rot, int gridRow, int gridCol) {
		for (int m = 0; m<4; m++){
			for (int n = 0; n < 4; n++){
				if (piece.isFilled(rot, m, n)){
					if (blockMatrix[m +gridRow][n +gridCol]){
						return true;	
					}
				}
			}
		}
		return false;
	}

	/**
	 * Check if placing the piece at grid position (row, col) with the rotation rot (0, 90, 180, 270) would cause an out of bounds condition
	 * i.e., if there would be a block falling off the board
	 * @return true if there would be a bounding error
	 * @param piece is a tetris piece
	 * @param rot is rotation
	 * @param gridRow is the board row
	 * @param gridCol is the board column
	 */
	private boolean detectOutOfBounds(TetrisPiece piece, int rot, int gridRow, int gridCol) {
		for (int m = 0; m<4; m++){
			for (int n = 0; n < 4; n++){
				if (piece.isFilled(rot, m, n)){
					if((gridRow+m) < 0 || (gridRow+m) >= NUM_ROWS || (gridCol+n) <0 || (gridCol+n) >= NUM_COLS){
						return true;
					}
				}
			}
		}
		return false;
	}

	/**
	 * Check if placing the piece at grid position (row, col) with the rotation rot (0, 90, 180, 270) is a valid move.
	 * @return true if no collision or bounding error
	 * @param piece is a tetris piece
	 * @param rot is rotation
	 * @param gridRow is the board row
	 * @param gridCol is the board column
	 */
	private boolean validMove(TetrisPiece piece, int rot, int gridRow, int gridCol) {
		if (detectOutOfBounds(piece, rot, gridRow, gridCol) == false && detectCollision(piece, rot, gridRow, gridCol)== false){
			return true;
		}
		return false;
	}

	/**
	 * Check if there is a block in the row and column.
	 * @return true if there is a block
	 * @param row of the board
	 * @param column of the board
	 */
	public boolean hasBlock(int row, int col) {
		//holds the current rotation value
		int rot = currentPiece.pieceRotation;

		//loops through rows and columns less than size of piece
		for (int i = 0; i < 4; i++){
			for (int j = 0; j < 4; j++){
				if(currentPiece.isFilled(rot, i, j) && (currentPieceGridPosition[0] + i == row) && (currentPieceGridPosition[1] + j == col)){
					return true;
				}
			}
		} 
		//return value of board                                                                                                                                                                                                                         
		return (blockMatrix[row][col]);
	}

	/**
	 * Detect and remove any lines formed.
	 * @return the total number found
	 */
	public int numberOfFormedLines() {
		int numLines = 0;
		for (int i = 0; i < NUM_ROWS; i++) {
			if (fullLine(i)) {
				removeLine(i);
				numLines++;
			}
		}
		return numLines;
	}

	/**
	 * Check if there is a full line at the row.
	 * @return true if full
	 * @param row of the board
	 */
	private boolean fullLine(int row) {
		for (int i = 0; i < NUM_COLS; i++) {
			if (blockMatrix[row][i] == false) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Remove the line at row in the model
	 * @param row to be removed
	 */
	private void removeLine(int row) {		
		//descend rows above the line by one
		for (int m = row; m > 0; m--){
			for (int n = 0; n < NUM_COLS; n++){
				blockMatrix[m][n]=blockMatrix[m-1][n];
			}
		}

		//sets first row to false
		for (int i = 0; i < NUM_COLS; i++){
			blockMatrix[0][i] = false;
		}
	}

	/**
	 * @return the block matrix (the grid of blocks)
	 */
	public boolean[][] getBlockMatrix() {
		return blockMatrix;
	}

	/**
	 * @return current piece on board
	 */
	public TetrisPiece getCurrentPiece() {
		return currentPiece;
	}

	/**
	 * @return the currentPieceGridPosition
	 */
	public int[] getCurrentPieceGridPosition() {
		return currentPieceGridPosition;
	}
}

