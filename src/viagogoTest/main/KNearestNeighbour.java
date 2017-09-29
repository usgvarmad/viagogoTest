package viagogoTest.main;

import java.util.Collections;
import java.util.PriorityQueue;

/*
 * This class contains the method which implements max heap to find out the k- nearest neighbors and then it uses Heap sort to sort
 * the coordinates based on their distances
 */
public class KNearestNeighbour {
	private Coordinates coordinates[];
	private Coordinates kNearestcoordinates[]; 
	private int k;

	//Constructor for kNearestcoordinates 
	public KNearestNeighbour(Coordinates coordinates[], int k) {
		this.coordinates = coordinates;
		this.k = k;
	}
	
	// This method performs the computations for maintaining the K- nearest neighbors in the PriorityQueue 
	public Coordinates[] getKNearestCoordinates() {
		PriorityQueue<Coordinates> kClosest = new PriorityQueue<Coordinates>(k, Collections.reverseOrder());
		for (int i = 0; i < coordinates.length; i++) {
			if (kClosest.size() < k) {
				kClosest.add(coordinates[i]);
			} else if (coordinates[i].getDistance() < kClosest.peek().getDistance()) {
				kClosest.remove();
				kClosest.add(coordinates[i]);
			}
		}
		kNearestcoordinates = kClosest.toArray(new Coordinates[k]);
		sort();
		return kNearestcoordinates;
	}
	

	// This is used to sort the K-Nearest output Array based on Distance
	public void sort()
    {
        int n = kNearestcoordinates.length;
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(n, i);
        for (int i=n-1; i>=0; i--)
        {
        	Coordinates temp = kNearestcoordinates[0];
        	kNearestcoordinates[0] = kNearestcoordinates[i];
        	kNearestcoordinates[i] = temp;
            heapify(i, 0);
        }
    }
	
	// This is used to sort the K-Nearest output Array based on Distance
	public void heapify( int n, int i)
    {
        int largest = i;  
        int left = 2*i + 1;  
        int right = 2*i + 2;  
        if (left < n && kNearestcoordinates[left].getDistance() > kNearestcoordinates[largest].getDistance())
            largest = left;
        if (right < n && kNearestcoordinates[right].getDistance() > kNearestcoordinates[largest].getDistance())
            largest = right;
        if (largest != i)
        {
            Coordinates swap = kNearestcoordinates[i];
            kNearestcoordinates[i] = kNearestcoordinates[largest];
            kNearestcoordinates[largest] = swap;
            heapify(n, largest);
        }
    }

}
