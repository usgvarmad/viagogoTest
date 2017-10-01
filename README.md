This is the git project for Viagogo Test

***************************************************************************************************************************************************
Assumptions made for the project:
1. Coordinates can also be double (not only integers)
2. "Each event has zero or more tickets." this was interpreted as each event can have different ticket types (or categories) like Gold or Silver etc.
3. Event with zero tickets was assumed as a free event with price 0.
4. The program's inputs wouldn't cause the program to run out of memory and cause Memory out of Bound exceptions.
5. Assuming that all inputs are entered on a single line.
6. All calculations are done with double precision but the values are displayed with 2 decimal precisions for aesthetic sense.
7. Since I am not displaying the full precision of the points while printing, you might see in some cases that the distance calculation you would do 
to verify the results might be offset by 0.1. 
For eg: Target x = 0, 			
		Target y = 0,
 		actual x = 1.009999,
 		Displayed x on console = 1.00,
 		actual y = 1.2922222,
 		Displayed y on console = 1.29,

 		Here the Distance you might calculate based on the displayed x and y values would give you distance as 2.29 but I will be displaying the actual
 		distance rounded to 2 digit precision which would give 2.30.


Key Points:
1. The program arguments can be increased through providing, number of events closeby "k" or axis constraints and many other by minimal code changes.
2. The program prints the inputs so that the user would have a refrence to cross check the results.
3. A jar file would be present inside the Target/jar folder. That jar can be used directly to run.
4. Data corresponding to coordinates or cost or ticket type(or categories) are randomly generated.
5. numberOfPoints corresponds to total number of inputs or events. xMax, yMax are the coordinates max values and are used for random generation of points. xMin and yMin are the minimum values and are used for randome generation of points. k corresponds to the number of closest events to be searched for. In this case, it is 5. maxTicketTypes and minTicketTypes corresponds to maximum random integer variations, ticket categories can have. maxTicketCost and minTicketCost are used for random generation of ticket prices for each category.
	
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

***************************************************************************************************************************************************
This code is written in Java and setup as an ant project. To get started:

Method 1 [Need a command prompt that could run java jar file]

1. clone the repository and unzip it

2. Travel to Target/jar folder through command prompt and use the command "java -jar viagogoTest.jar"

Method 2 [Need a command prompt and ant installed]:

1. clone the repository and unzip it

2. From the root directory of the repo, run `ant` on the command prompt. This will build the code and outputs a jar in the Target/jar path. 
Once the build is complete. [in case of corrupted jar file use "ant clean" to remove the target folder and then use "ant" command to rebuild again]

3. please run it using java -jar target/jar/viagogoTest.jar


Method 2 [Need Eclipse]

1. clone the repository into the local machine. unzip it.

2. File -> Import --> Project from folder or Archive (Next) --> (Browse the folder for the project) Next --> Finish

3. Main file for the program is ExecuteMainMethod class. Right click and run as a Java application

************************************************************************************************************************************************

How might you change your program if you needed to support multiple events at the same location?

Answer: My program is in such a way that it can handle multiple events at the same coordinates. The small change that is required to be done is:
Instead of using Hashmap<Coordinates, Event>, I will be using Hashmap<Coordinates, Event[]>. In this way each coordinate can be mapped to multiple
events. My program would retreive first 5 closest coordinates using getKNearestCoordinates function. While printing the 5 events closest to the given
coordinate by iterating the kNearestCoordinates[], I will have an extra counter which would keep track of number of events I have printed (as 1 coordinate can print multiple events) and I would stop printing once the 5 or K requested events are printed.


 How would you change your program if you were working with a much larger world size?

Answer: 1. Database connections needs to be made when we are considering data in huge amounts. 
		2. Instead of updating the database every time, I would try to maintain a small local copy of the data and push data in small Batches to reduce latency caused by database RW or database connection.
		3. Data verification can be done thoroughly as it may create lot of exceptions in the database or in the program. Cases in which no points corresponding to Event or Event corresponding to no point would be handled.
		4. The complexity of the code should be further brought down from O(nlogk).
		



************************************************************************************************************************************************

Once the program is run, it would prompt for a user input. Please enter the X and Y coordinates seperately.

Eg: Below is a one sample run for input x = 2 and y = 2


vagelos-ve503-0239:viagogoTest uzval$ java -jar target/jar/viagogoTest.jar 

*********************************************Input*********************************************

Event No: 1,	(6.73, -3.32),	Distance from Origin: 10.05
Category: 1,	Cost: 1.80
Category: 2,	Cost: 12.09

Event No: 2,	(-8.12, -0.27),	Distance from Origin: 8.38
Category: 1,	Cost: 4.69

Event No: 3,	(5.93, 9.92),	Distance from Origin: 15.85
Category: 1,	Cost: 41.76
Category: 2,	Cost: 23.93

Event No: 4,	(-2.55, 8.19),	Distance from Origin: 10.75
Category: 0,	Cost: 0.00

Event No: 5,	(-2.56, -8.01),	Distance from Origin: 10.57
Category: 0,	Cost: 0.00

Event No: 6,	(6.60, 1.44),	Distance from Origin: 8.04
Category: 1,	Cost: 44.57

Event No: 7,	(7.01, -2.46),	Distance from Origin: 9.47
Category: 1,	Cost: 38.60
Category: 2,	Cost: 47.45

Event No: 8,	(5.14, 7.47),	Distance from Origin: 12.62
Category: 0,	Cost: 0.00

Event No: 9,	(1.41, 10.32),	Distance from Origin: 11.73
Category: 1,	Cost: 28.08
Category: 2,	Cost: 9.59

Event No: 10,	(2.49, -0.14),	Distance from Origin: 2.63
Category: 1,	Cost: 22.94
Category: 2,	Cost: 34.65

Please enter the X and Y coordinates of your Location one by one  (Format: Integer or Double in range of 10 to -10 & Eg: 10 or 12.55)

X Coordinate:
2
Y Coordinate:
2

*********************************************Output*********************************************

Event: 10	Cost: 22.94	Distance 2.63
Event: 6	Cost: 44.57	Distance 5.16
Event: 8	Cost: 0.00	Distance 8.62
Event: 9	Cost: 9.59	Distance 8.91
Event: 7	Cost: 38.60	Distance 9.47

 Do you want to try checking events near a new Location?(Type Yes or Anything else to quit)