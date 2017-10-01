package viagogoTest.main;

import java.util.TreeMap;


/**
 * This class serves as the skeleton for the Events and also used to generate random data for the Events
 * This class randomly generates the number of Ticket types (or categories) and the Ticket cost for each category
 *
 * @author uzval
 */
public class Event {
	private int ticketTypeNumber;
	private TreeMap<Integer, Double> ticketCategoriesCostsMap = new TreeMap<Integer, Double>();
	private double currentEventMinTicketCost;
	private int eventNumber;
	
	/**
	 * This is the constructor for Event Class.
	 * @param eventNumber, a variable of type integer 
	 * @param maxTicketTypes, a variable of type integer 
	 * @param maxTicketCost, a variable of type integer 
	 * @param minTicketCost, a variable of type integer 
	 * @return None
	 */
	Event(int eventNumber, int maxTicketTypes, int minTicketTypes, int maxTicketCost, int minTicketCost) {
		this.eventNumber = eventNumber;
		double currentEventTicketTypeCostVariation;
		ticketTypeNumber = (int) ((Math.random() * (maxTicketTypes + 1 - minTicketTypes)) + minTicketTypes);

		if (ticketTypeNumber == 0) {
			currentEventMinTicketCost = 0;
			ticketCategoriesCostsMap.put(0, currentEventMinTicketCost);
			return;
		} else if (ticketTypeNumber == 1) {
			currentEventMinTicketCost = ((Math.random() * (maxTicketCost + 1 - minTicketCost)) + minTicketCost);
			ticketCategoriesCostsMap.put(1, currentEventMinTicketCost);
			return;
		} else {
			currentEventMinTicketCost = maxTicketCost;
			for (int i = 1; i <= ticketTypeNumber; i++) {

				currentEventTicketTypeCostVariation = ((Math.random() * (maxTicketCost + 1 - minTicketCost))
						+ minTicketCost);
				currentEventMinTicketCost = currentEventMinTicketCost < currentEventTicketTypeCostVariation
						? currentEventMinTicketCost : currentEventTicketTypeCostVariation;
				ticketCategoriesCostsMap.put(i, currentEventTicketTypeCostVariation);
			}
		}
	}

	/**
	 * Getter method for getting the value of the least cost ticket for that particular event
	 * @param None
	 * @return a variable of type double
	 */
	public double getCurrentEventMinTicketCost() {
		return currentEventMinTicketCost;
	}

	/**
	 * Retrieves the Event number corresponding to the event
	 * @param  None 
	 * @return a variable of type int
	 */
	public int getEventNumber() {
		return eventNumber;
	}

	/**
	 * Retrieves a TreeMap which has Ticket Category vs Cost for a Particular Event
	 * @param  None 
	 * @return a variable of type TreeMap
	 */
	public TreeMap<Integer, Double> getTicketCategoriesCostsMap() {
		return ticketCategoriesCostsMap;
	}

}
