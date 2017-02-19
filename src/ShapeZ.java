/**
 * A ShapeZ class that makes the Z shape
 * @author Sara Harda
 **/

public class ShapeZ extends TetrisPiece
{
	/**
	 * Constructor
	 */
	public ShapeZ() {
		super();
		filledSquares = new boolean[][][] {
			{
				{false, true,false,false},
				{true, true, false, false},
				{true, false, false, false},
				{false, false, false, false},
			},

			{
				{true, true, false, false},
				{false, true, true, false},
				{false, false, false, false},
				{false, false, false, false},
			},

			{
				{false, false, true, false},
				{false, true, true, false},
				{false, true, false, false},
				{false, false, false, false},
			},

			{
				{false, false, false, false},
				{true, true, false, false},
				{false, true, true, false},
				{false, false, false, false},
			}
		};
	}
}


