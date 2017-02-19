/**
 * A ShapeL class that makes the L shape
 * @author Sara Harda
 **/

public class ShapeL extends TetrisPiece
{
	/**
	 * Constructor
	 */
	public ShapeL() {
		super();
		filledSquares = new boolean[][][] {
			{
				{true, true, true, false},
				{true, false, false, false},
				{false, false, false, false},
				{false, false, false, false}, 
			},

			{
				{false, true, false, false},
				{false, true, false, false},
				{false, true, true, false},
				{false, false, false, false},
			},

			{
				{false, false, true, false},
				{true, true, true, false},
				{false, false, false, false},
				{false, false, false, false},
			},

			{
				{true, true, false, false},
				{false, true, false, false},
				{false, true, false, false},
				{false, false, false, false},
			}
		};
	}
}
