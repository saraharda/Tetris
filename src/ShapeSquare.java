/**
 * A ShapeSquare class that makes the square shape
 * @author Sara Harda
 **/

public class ShapeSquare extends TetrisPiece
{
	/**
	 * Constructor
	 */
	public ShapeSquare() {
		super();
		filledSquares = new boolean[][][] {
			{
				{true, true, false, false},
				{true, true, false, false},
				{false, false, false, false},
				{false, false, false, false}, 
			},

			{
				{true, true, false, false},
				{true, true, false, false},
				{false, false, false, false},
				{false, false, false, false}, 
			},

			{
				{true, true, false, false},
				{true, true, false, false},
				{false, false, false, false},
				{false, false, false, false}, 
			},

			{
				{true, true, false, false},
				{true, true, false, false},
				{false, false, false, false},
				{false, false, false, false}, 
			},
		};
	}
}
