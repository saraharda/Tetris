/**
 * A ShapeS class that makes the S shape
 * @author Sara Harda
 **/

public class ShapeS extends TetrisPiece
{
	/**
	 * Constructor
	 */
	public ShapeS() {
		super();
		filledSquares = new boolean[][][] {
			{
				{true, false, false, false},
				{true, true, false, false},
				{false, true, false, false},
				{false, false, false, false}, 
			},

			{
				{false, true, true, false},
				{true, true, false, false},
				{false, false, false, false},
				{false, false, false, false},
			},

			{
				{false, true, false, false},
				{false, true, true, false},
				{false, false, true, false},
				{false, false, false, false}, 
			},

			{
				{false, false, false, false},
				{false, true, true, false},
				{true, true, false, false},
				{false, false, false, false},
			}
		};
	}
}
