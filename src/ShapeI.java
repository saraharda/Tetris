/**
 * A ShapeI class that makes the square shape
 * @author Sara Harda
 **/

public class ShapeI extends TetrisPiece
{
	/**
	 * Constructor
	 */
	public ShapeI() {
		super();
		filledSquares = new boolean[][][] {				
			{
				{false, true, false, false},
				{false, true, false, false},
				{false, true, false, false},
				{false, true, false, false}, 
			},

			{
				{false, false, false, false},
				{true, true, true, true},
				{false, false, false, false},
				{false, false, false, false},
			},

			{
				{false, true, false, false},
				{false, true, false, false},
				{false, true, false, false},
				{false, true, false, false}, 
			},

			{
				{false, false, false, false},
				{true, true, true, true},
				{false, false, false, false},
				{false, false, false, false},
			},
		};
	}
}
