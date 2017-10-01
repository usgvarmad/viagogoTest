package viagogoTest.main;

/*
 * This class acts as a generator for random points and stores them into array of Coordinates
 */
public class InputCoordinatesGenerator {
	private int numberOfPoints;
	private int xMax;
	private int yMax;
	private int xMin;
	private int yMin;
	
	InputCoordinatesGenerator(int numberOfPoints, int xMax, int yMax, int xMin, int yMin) {
		this.numberOfPoints = numberOfPoints;
		this.xMax = xMax;
		this.yMax = yMax;
		this.xMin = xMin;
		this.yMin = yMin;
	}

	//This is used for random number generation
	public double randomnumber(int max, int min) {
		return ((Math.random() * (max + 1 - min)) + min);
	}

	//Based on the count of the coordinates required we generate corresponding coordinates using randomnumber() function 
	public Coordinates[] generateInputCoordinatesArray() {
		Coordinates coordinates[] = new Coordinates[numberOfPoints];
		for (int i = 0; i < numberOfPoints; i++) {
			coordinates[i] = new Coordinates(randomnumber(xMax, xMin), randomnumber(yMax, yMin));
		}
		return coordinates;
	}
}
