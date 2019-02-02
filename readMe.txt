Anthony Pitts
aep2195
                                            Maximizing Talks Program
                                            
               Talk.java

The job of the Talk class was to provide a constructor for the objects of class Talk, among other things. The 
instance variables of this class are name, for name of presenter, startTime, for the time the presentation starts,
and stopTime, for the time the presenations ends. These are also parameters of each object of the Talk class. 
I also added 3 getter methods for each of the parameters, to access in the Scheduler class. Also, I added 3 setter
methods for each of the parameters, to set them in the Scheduler class. Lastly, this class has a 
compareTo method, which compares two instances of class Talk and there is a toString method which returns the 
3 parameter of instances of Talk in a sentence of String. 


              Scheduler.java

The job of the Scheduler class was to put the given text file into an array, talk, and create another array that has those
talks in order, talksOrder. I instantiate both of these arrays in their declaration, because they are static 
variables. Then, the makeTalks method organizes the given text file into the talks array. 

I wrote "throws IOException" so the program would not use the error message in the SchedulerTest class, as it is
very vague and does not help specify to the user exactly what was wrong with the supplied text file. Instead, my code
still terminates the program if an error is found, using System.exit(0), but also specifies in more detail where
the error was, like exceeding 2400 as a start or end time.

In order to organize the code I used the replaceAll method to get rid of all the spacing and indentation in the code.
This allowed for me to write my code assuming no spacing inbetween characters and digits. I then created an outer while
loop and inner loops to check if the current character in String was a letter, and if it was I stored it in the name
parameter. If the current character was a digit, I stored it in the startTime first, and then after 4 digits, the following
4 were stored in the stopTime variable.

The scheduleTalks method used a primary while loop to find the first object (or presentation) of Talk in the
talkOrder array, and then followed the format of checking that the current startTime in talks was greater
than or equal to the stopTime of the last element in talkOrder and that the start time of the last element added
to talkOrder was less than the start time of the current element of the talks array. After this iterates through,
talkOrder will be an array that is effectively the schedule that will maximize the number of presentations possible.
The end of this method prints out talkOrder, using the toString method, and prints out the size of this array,
or number of presentations.

Lastly, the sortStopTimes array is designed using an outer and inner for loop to iterate through the talks array
and use the compareTo method to look at two adjacent objects and if the current one's stopTime is later than the 
following object's stopTime, those two swap places. The final result is that the talks array is ordered from
earliest to latest stopTime.



