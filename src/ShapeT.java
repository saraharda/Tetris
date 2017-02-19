/**
 * A ShapeT class that makes the T shape
 * @author Sara Harda
 **/

public class ShapeT extends TetrisPiece
{
	/**
	 * Constructor
	 */
	public ShapeT() {
		super();
		filledSquares = new boolean[][][] {
			{
				{true, true, true, false},
				{false, true, false, false},
				{false, false, false, false},
				{false, false, false, false}, 
			},

			{
				{true, false, false, false},
				{true, true, false, false},
				{true, false, false, false},
				{false, false, false, false},
			},

			{
				{false, false, false, false},
				{false, true, false, false},
				{true, true, true, false},
				{false, false, false, false},
			},

			{
				{false, false, true, false},
				{false, true, true, false},
				{false, false, true, false},
				{false, false, false, false},
			}
		};
	}
}
