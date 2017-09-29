This is the git project for Viagogo Test

***************************************************************************************************************************************************
Assumptions made for the project:
1. Coordinates can also be double (not only integers)
2. "Each event has zero or more tickets." this was interpreted as each event can have different ticket types or categories like Gold or Silver etc.
3. Event with zero tickets was assumed as a free event with price 0.
3. The program's inputs wouldn't cause the program to run out of memory and cause Memory out of Bound exceptions.
4. The coordinates and distances were considered as double but while printing they were printed only upto 2 decimal points for aesthetic sense.
5. Since I am not displaying the full precision of the point while printing, you might see in some cases that the distance calculation you would do 
to verify the results might be offset by 0.1. 
For eg: Target x = 0, 			
		Target y=0,
 		actual x = 1.009999,
 		Displayed x = 1.00
 		actual y = 1.2922222
 		Displayed y = 1.29

 		Here the Distance you might calculate based in the displayed x and y would give you distance as 2.29 but I will be displaying the actual
 		distance rounded to 2 digit precision which would give 1.30.


Key Points:
1. The program is written in such a way that the number of arguments can be increased and the program is ready to handle it by adding less code
2. The program prints the inputs so that the user would have a refrence to cross check the results.
3. K can be changed from 5 to anything below total number of points to play around with number of results we want.
4. A jar file would be present inside the Target/jar folder. That jar can be used directly to run.
5. Data corresponding to coordinates or cost or ticket type(or categories) are randomly generated


***************************************************************************************************************************************************
This code is written in Java and setup as an ant project. To get started:

Method 1 [Need a command prompt and ant installed]:

1. clone the repository

2. From the root directory of the repo, run `ant` on the command prompt. This will build the code and outputs a jar in the Target/jar path. 
Once the build is complete. [ in case of corrupted jar file use "ant clean" to remove the target folder and then use "ant" command to rebuild again

3. please run it using java -jar target/jar/viagogoTest.jar

Method 2 [Need Eclipse]

1. clone the repository into the local machine. unzip it.

2. File -> Import --> Project from folder or Archive (Next) --> (Browse the folder for the project) Next --> Finish

3. Main file for the program is ExecuteMainMethod class. Right click and run as a Java application

************************************************************************************************************************************************

How might you change your program if you needed to support multiple events at the same location?

Answer: My program is in such a way that it can handle multiple events at the same coordinates. The small change that is required to be done is:
Instead of using Hashmap<Coordinates, Event>, I will be using Hashmap<Coordinates, Event[]>.


 How would you change your program if you were working with a much larger world size?

Answer: 1. Database connections needs to be made when we are considering data in huge amounts. 
		2. Instead of uodating the database every time, I would try to maintain a small local copy of the data and push data in small Batches to reduce latency caused by database RW or database connection.
		3. Data verification should be done thoroughly as it may create lot of exceptions. Cases in which no points corresponding to Event or Event corresponding to no point should be handled.
		3. Scenario would change from one to one or one to many to many to many. Each location can hold multiple events and each event can be held at 
		multiple locations. 
		4. The complexity of the code should be further brought down.
		



************************************************************************************************************************************************

Once the program is run, it would prompt for a user input. Please enter the X and Y coordinates seperately.

Eg: Below is a one sample run for input x = 2 and y = 3


vagelos-ve503-0239:viagogoTest uzval$ java -jar target/jar/viagogoTest.jar 

Please enter the X and Y coordinates of your Location one by one  (Format: Integer or Double in range of 10 to -10 & Eg: 10 or 12.55)

X Coordinate:
2
Y Coordinate:
3

*********************************************Input*********************************************

Event No: 1,	(-9.74, -8.49),	Distance: 23.23
Category: 1,	Cost: 23.14
Category: 2,	Cost: 47.42

Event No: 2,	(3.76, -9.54),	Distance: 14.31
Category: 1,	Cost: 33.41

Event No: 3,	(1.63, -6.84),	Distance: 10.21
Category: 1,	Cost: 15.26

Event No: 4,	(-0.34, 0.83),	Distance: 4.51
Category: 1,	Cost: 34.03

Event No: 5,	(4.04, -4.28),	Distance: 9.33
Category: 1,	Cost: 47.49

Event No: 6,	(3.46, -1.40),	Distance: 5.86
Category: 1,	Cost: 35.39

Event No: 7,	(2.26, 10.24),	Distance: 7.50
Category: 0,	Cost: 0.00

Event No: 8,	(3.47, 10.77),	Distance: 9.24
Category: 1,	Cost: 39.18

Event No: 9,	(-7.59, -1.93),	Distance: 14.53
Category: 0,	Cost: 0.00

Event No: 10,	(-5.88, 2.32),	Distance: 8.56
Category: 1,	Cost: 1.88
Category: 2,	Cost: 45.99

*********************************************Output*********************************************

Event: 4	Cost: 34.03	Distance 4.51
Event: 6	Cost: 35.39	Distance 5.86
Event: 7	Cost: 0.00	Distance 7.50
Event: 10	Cost: 1.88	Distance 8.56
Event: 8	Cost: 39.18	Distance 9.24
