package viagogoTest.main;

/**
  * This class carries the structure of the coordinates and is also used to override the compareTo method 
  * 
  * @author uzval
  */
public class Coordinates implements Comparable<Coordinates> {
	private double x;
	private double y;
	private double xTarget;
	private double yTarget;

	/**
	 * This is the constructor for Coordinates Class.
	 * @param x, a variable of type double 
	 * @param y, a variable of type double 
	 * @return Nothing.
	 */
	public Coordinates(double x, double y) {
		this.xTarget = ExecuteMainMethod.xTarget;
		this.yTarget = ExecuteMainMethod.yTarget;
		this.x = x;
		this.y = y;

	}

	/**
	 * Calculates the Manhattan Distance between the current Point and the Target Point
	 * @param  No Parameter 
	 * @return distance calculated in double.
	 */
	public double getDistance() {
		return Math.abs(x - xTarget) + Math.abs(y - yTarget);
	}

	/**
	 * Overrides CompareTo Method to use getDistance for comparison
	 * @param  a variable of type Coordinates 
	 * @return int which would be generated after comparison of distances.
	 */
	@Override
	public int compareTo(Coordinates newCoordinate) {

		int compareValue = Double.compare(getDistance(), newCoordinate.getDistance());
		if (compareValue == 0) {
			compareValue = Double.compare(x, newCoordinate.x);
			if (compareValue == 0) {
				compareValue = Double.compare(y, newCoordinate.y);
			}
		}
		return compareValue;
	}

	/**
	 * Getter Method for x coordinate
	 * @param  None 
	 * @return double which would be the x coordinate value.
	 */
	public double getX() {
		return x;
	}

	/**
	 * Getter Method for y coordinate
	 * @param  None 
	 * @return double which would be the y coordinate value.
	 */
	public double getY() {
		return y;
	}

	/**
      * Updates the Target Coordinate of the Coordinates
      * @param  None 
      * @return None
      */	 
	public void updateTarget() {
		this.xTarget = ExecuteMainMethod.xTarget;
		this.yTarget = ExecuteMainMethod.yTarget;
	}
}