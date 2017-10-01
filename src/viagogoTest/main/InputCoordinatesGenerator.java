package viagogoTest.main;

/**
 * This class acts as a generator for random points and stores them into array of Coordinates
 * 
 * @author uzval
 */
public class InputCoordinatesGenerator {
	private int numberOfPoints;
	private int xMax;
	private int yMax;
	private int xMin;
	private int yMin;
	

	/**
	 * This is the constructor for InputCoordinatesGenerator Class.
	 * @param numberOfPoints, a variable of type integer 
	 * @param xMax, a variable of type integer 
	 * @param yMax, a variable of type integer 
	 * @param xMin, a variable of type integer 
	 * @param yMin, a variable of type integer 
	 * 
	 * @return None
	 */
	InputCoordinatesGenerator(int numberOfPoints, int xMax, int yMax, int xMin, int yMin) {
		this.numberOfPoints = numberOfPoints;
		this.xMax = xMax;
		this.yMax = yMax;
		this.xMin = xMin;
		this.yMin = yMin;
	}

	/**
	 * This is used for random number generation for coordinates
	 * @param numberOfPoints, a variable of type integer 
	 * @param max, a variable of type integer 
	 * @param min, a variable of type integer 
	 * 
	 * @return a double value that would be used with one of the coordinate
	 */
	public double randomnumber(int max, int min) {
		return ((Math.random() * (max + 1 - min)) + min);
	}

   /**
	 * Based on the count of the coordinates required we generate corresponding coordinates using randomnumber() function 
	 * @param None
	 * 
	 * @return Coordinate array which would serve as input or the event locations
	 */
	public Coordinates[] generateInputCoordinatesArray() {
		Coordinates coordinates[] = new Coordinates[numberOfPoints];
		for (int i = 0; i < numberOfPoints; i++) {
			coordinates[i] = new Coordinates(randomnumber(xMax, xMin), randomnumber(yMax, yMin));
		}
		return coordinates;
	}
}
