package viagogoTest.main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/*
 * This is the main class for the program. It creates objects for Coordinates, Event, InputCoordinatesGenerator and KNearestNeighbour classes.
 * The variables given below can be either used as below or can also be passed sent as an argument.
 * This class also has a print data function. The print data function first Outputs
 * the data which will be used for the program and also prints out the "K" Nearest Neighboring points to the given Target Point.
 */
public class ExecuteMainMethod {
	public static double xTarget = 0;
	public static double yTarget = 0;
	private static int numberOfPoints = 10;
	private static int xMax = 10;
	private static int yMax = 10;
	private static int xMin = -10;
	private static int yMin = -10;
	private static int k = 5; 						
	private static int maxTicketTypes = 2;
	private static int minTicketTypes = 0;
	private static int maxTicketCost = 50;
	private static int minTicketCost = 1;
	private static Coordinates inputCoordinates[];
	private static Coordinates kNearestCoordinates[];
	private static Map<Coordinates, Event> coordinateEventsMap = new HashMap<Coordinates, Event>();
	// This map has the data structure required to keep Coordinates vs Events data
	
	public static void main(String args[]) {
		
		//Input the coordinates here. If there is error in input or number of points is less than points asked for. program would return nothing
		if(!targetCoordinatesUserInput())
		{
			return;
		} else if(numberOfPoints < k){
			System.out.println("Not valid number of points. Always (N >= k)");
			return;
		}
		
			
		// Class that would generate random coordinates.
		InputCoordinatesGenerator inputCoordinatesClassObject = new InputCoordinatesGenerator(numberOfPoints, xTarget, yTarget, xMax, yMax, xMin, yMin);
		inputCoordinates = inputCoordinatesClassObject.generateInputCoordinatesArray();
		
		System.out.println("\n*********************************************Input*********************************************");
		// Automatic Random Generation Events, Categories and their costs. Also printing the inputs during this loop
		for (int i = 1; i <= inputCoordinates.length; i++) {
			Event event = new Event(i,maxTicketTypes, minTicketTypes, maxTicketCost,minTicketCost);
			coordinateEventsMap.put(inputCoordinates[i-1], event);
			System.out.println("\nEvent No: " + event.getEventNumber() + ",\t("+ String.format("%.2f", inputCoordinates[i-1].getX())+", "+String.format("%.2f", inputCoordinates[i-1].getY())+"),\tDistance: " + String.format("%.2f", inputCoordinates[i-1].getDistance()));
			TreeMap<Integer, Double> ticketCategoryCostsMap = new TreeMap<Integer, Double>();
			ticketCategoryCostsMap = event.getTicketCategoriesCostsMap();
			for (Integer j : ticketCategoryCostsMap.keySet()) {
				System.out.println("Category: " + j + ",\tCost: " + String.format("%.2f", ticketCategoryCostsMap.get(j)));
			}
		}
		
		// Class that computes the KNearestNeighbour algorithm and gives back a coordinate array
		KNearestNeighbour knearestNeighbourClassObject = new KNearestNeighbour(inputCoordinates, k);
		kNearestCoordinates = knearestNeighbourClassObject.getKNearestCoordinates();
		printOutputData();	
	}
	
	// Function for taking the Target Coordinates
	public static boolean targetCoordinatesUserInput(){
		System.out.println("\nPlease enter the X and Y coordinates of your Location one by one  (Format: Integer or Double in range of 10 to -10 & Eg: 10 or 12.55)\n");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			System.out.println("X Coordinate:");
			String xTargetString = br.readLine();
			xTargetString = xTargetString.trim();
			xTarget = Double.parseDouble(xTargetString);
			System.out.println("Y Coordinate:");
			String yTargetString = br.readLine();
			yTargetString = yTargetString.trim();
			yTarget = Double.parseDouble(yTargetString);
			if(xTarget > 10 || xTarget <-10 || yTarget >10 || yTarget <-10)
			{
				System.out.println("Please enter inputs in range of 10 to -10");
				return false;
			} 			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Invalid Number Entered. Please enter a number in Integer or Double format\n\n");
			e.printStackTrace();
			return false;
		}
		return true; 			
	}
	
	//Prints the final Event which is closest to a given point and displays the least expensive ticket for that event
	public static void printOutputData() {
		System.out.println("\n*********************************************Output*********************************************\n");
		for (int i = 0; i < kNearestCoordinates.length; i++) { 
			Event event = coordinateEventsMap.get(kNearestCoordinates[i]);
			System.out.println("Event: "+event.getEventNumber()+"\tCost: "+String.format("%.2f", event.getCurrentEventMinTicketCost())+"\tDistance "+String.format("%.2f",kNearestCoordinates[i].getDistance())) ;
		}
	}
}
