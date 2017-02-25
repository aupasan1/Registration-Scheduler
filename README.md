# Registration-Scheduler

o	From the command line, accept the following as input:
  
    o	The name of the input file (referred to as input.txt below)
    o	The name of the output file (referred to as output.txt below)
    o	The number of threads to be used: referred to as NUM_THREADS below
    o	Debug Value: an integer that controls what is printed on stdout

o	Validate that the correct number of command line argumets have been passed.

o	Validate that the value of NUM_THREADS is between 1 and 3.

o	Validate that the DEBUG_VALUE is between 0 and 4.

o	Update from Assignment-1: There are 7 courses (A, B, C, D, E, F, G) being offered in the summer session. The capacity for each course is 60. The total number of students is 80. Each student is required to register for 5 courses. The student is asked to provide a preference for each of the courses. Top preference is specified as "1", while the lowest preference is specified as "7".

o	The Driver code should create an instance of CreateWorkers and pass an instance of the FileProcessor, Results, other instances needed by the Worker to the constructor of CreateWorkers. The Driver should invoke the method startWorkers(...) in CreateWorkers and pass the NUM_THREADS as an argument.

o	CreateWorkers' startWorkers(...) method should create NUM_THREADS threads (via the threaded class WorkerThread), start them and join on them. The instances fo FileProcessor, Results, and classes needed for the scheduling should be passed to he constructor of the worker thread class.

o	The run method of the worker thread should do the following till the end of file is reached:
    
    o	While the end of file has not been reached:
    o	Invoke a method in the FileProcessor to read one line as a string
    o	Run your algorithm to assign courses to this student.
    o	Store the results in the data structure in the Results instance
    
o	The choice of data structure used in the Results class should be justified in the README.txt in terms of space and/or time complexity.

o	The Results class should implement an interface, StdoutDisplayInterface. This interface should have a method writeSchedulesToScreen(...). The driver should invoke this method on the Results instance to print the schedules, average preference score, etc. (similar format as Assignment-1) for all the students.

o	The Results class should implement an interface, FileDisplayInterface. This interface should have a method writeSchedulesToFile(...). The driver should invoke this method on the Results instance to print the schedules, average preference score, etc. (similar format as Assignment-1) for all the students to the output file.

o	Use an Object Pool instance to manage the 7 courses. If your algorithm requires you to return a spot in a course, then you should use the ObjectPool API for this purpose. You should ObjectPool API to request a spot in a course, check availability, etc.

o	Assume that the input file will have one unique string per line, no white spaces, and no empty lines. Also assume that the intput strings in the file do not have errors. The entries in every line are space delimited.

o	Except in the Logger, Object Pool class, do not make any other method static.

o	The DEBUG_VALUE, read from the command line, should be set in the Logger class. Use the DEBUG_VALUE in the following way:

    o	DEBUG_VALUE=4 [Print to stdout everytime a constructor is called]
    o	DEBUG_VALUE=3 [Print to stdout everytime a thread's run() method is called]
    o	DEBUG_VALUE=2 [Print to stdout everytime an entry is added to the Results data structure]
    o	DEBUG_VALUE=1 [Print to stdout the contents of the data structure in the store]
    o	DEBUG_VALUE=0 [No output should be printed from the application, except the line "The average preference value is X.Y" ]

o	The Logger class should have a static method to writeOuput(...). writeMessage(...).

o	Place the FileProcessor.java in the util/ folder
