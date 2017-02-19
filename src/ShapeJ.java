/**
 * A ShapeJ class that makes the J shape
 * @author Sara Harda
 **/

public class ShapeJ extends TetrisPiece
{
	/**
	 * Constructor
	 */
	public ShapeJ() {
		super();
		filledSquares = new boolean[][][] {
			{
				{true, true, true, false},
				{false, false, true, false},
				{false, false, false, false},
				{false, false, false, false},
			},

			{
				{false, true, true, false},
				{false, true, false, false},
				{false, true, false, false},
				{false, false, false, false}, 
			},

			{
				{true, false, false, false},
				{true, true, true, false},
				{false, false, false, false},
				{false, false, false, false},
			},

			{
				{false, true, false, false},
				{false, true, false, false},
				{true, true, false, false},
				{false, false, false, false},
			},
		};
	}
}
