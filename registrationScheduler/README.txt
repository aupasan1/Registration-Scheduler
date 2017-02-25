CS542 Design Patterns
Fall 2016
PROJECT <2> README FILE

Due Date: <PROJECT DUE DATE, IN FORMAT: Friday, September 30, 2016>
Submission Date: <DATE YOU SUBMIT, IN FORMAT: Friday, September 30, 2016>
Grace Period Used This Project: <0> Days
Grace Period Remaining: <0> Days
Author(s): <ABHISHEK NIRANJAN UPASANI>
e-mail(s): <aupasan1@binghamton.edu>


PURPOSE:

[
  The purpose of this project is to write a Java program and 
  apply design principles for a simple multi-threaded application
]

PERCENT COMPLETE:

[
  "I believe I have completed 100% of this project."
]

PARTS THAT ARE NOT COMPLETE:

[
  None
]

BUGS:

[
  None
]

FILES:

[
  Included with this project are 15 files:

  Driver.java, the main file associated with the program also contains main
  Student.java, the file associated with the student details
  Course.java, the file assocoated with the course allocation
  CourseAllocationInterface.java, the file associated with the allocated courses details
  FileDisplayInterface.java, the file associated with displaying schedules to the output file
  StdoutDisplayInterface.java, the file associated with displaying schedules to the console
  Results.java, the file associated with storing the results of course allocation
  CreateWorkers.java, the file associated with starting and joining on the threads
  WorkerThread.java, the file associated with running the threads for course allocation
  CoursePoolInterface.java, the file associated with object pool details
  FileProcessor.java, the file associated with reading from input file
  Logger.java, the file associated with debugging
  ObjectPool.java, the file associated with controlling the course objects
  build.xml, the file associated with cleaning, compiling and running the code
  README.txt the text file you are presently reading
]

SAMPLE OUTPUT:

[
     [java] 
     [java]  The args[0] is: input.txt
     [java] Student_1 A B C D E 15
     [java] Student_4 D E F G A 15
     [java] Student_5 E F G A B 15
     [java] Student_3 C D E F G 15
     [java] Student_7 G A B C D 15
     [java] Student_8 A B C D E 15
     [java] Student_9 B C D E F 15
     [java] Student_10 C D E F G 15
     [java] Student_11 D E F G A 15
     [java] Student_12 E F G A B 15
     [java] Student_13 F G A B C 15
     [java] Student_14 G A B C D 15
     [java] Student_15 A B C D E 15
     [java] Student_16 B C D E F 15
     [java] Student_17 C D E F G 15
     [java] Student_18 D E F G A 15
     [java] Student_19 E F G A B 15
     [java] Student_20 F G A B C 15
     [java] Student_21 G A B C D 15
     [java] Student_22 A B C D E 15
     [java] Student_23 B C D E F 15
     [java] Student_24 C D E F G 15
     [java] Student_25 D E F G A 15
     [java] Student_26 E F G A B 15
     [java] Student_27 F G A B C 15
     [java] Student_28 G A B C D 15
     [java] Student_29 A B C D E 15
     [java] Student_30 B C D E F 15
     [java] Student_31 C D E F G 15
     [java] Student_32 D E F G A 15
     [java] Student_33 E F G A B 15
     [java] Student_34 F G A B C 15
     [java] Student_35 G A B C D 15
     [java] Student_36 A B C D E 15
     [java] Student_37 B C D E F 15
     [java] Student_38 C D E F G 15
     [java] Student_2 B C D E F 15
     [java] Student_39 D E F G A 15
     [java] Student_41 F G A B C 15
     [java] Student_42 G A B C D 15
     [java] Student_43 A B C D E 15
     [java] Student_44 B C D E F 15
     [java] Student_45 C D E F G 15
     [java] Student_46 D E F G A 15
     [java] Student_47 E F G A B 15
     [java] Student_48 F G A B C 15
     [java] Student_49 G A B C D 15
     [java] Student_50 A B C D E 15
     [java] Student_51 B C D E F 15
     [java] Student_52 C D E F G 15
     [java] Student_53 D E F G A 15
     [java] Student_54 E F G A B 15
     [java] Student_55 F G A B C 15
     [java] Student_56 G A B C D 15
     [java] Student_57 A B C D E 15
     [java] Student_58 B C D E F 15
     [java] Student_59 C D E F G 15
     [java] Student_60 D E F G A 15
     [java] Student_61 E F G A B 15
     [java] Student_62 F G A B C 15
     [java] Student_63 G A B C D 15
     [java] Student_64 A B C D E 15
     [java] Student_65 B C D E F 15
     [java] Student_66 C D E F G 15
     [java] Student_67 D E F G A 15
     [java] Student_68 E F G A B 15
     [java] Student_69 F G A B C 15
     [java] Student_70 G A B C D 15
     [java] Student_71 A B C D E 15
     [java] Student_72 B C D E F 15
     [java] Student_73 C D E F G 15
     [java] Student_74 D E F G A 15
     [java] Student_75 E F G A B 15
     [java] Student_76 F G A B C 15
     [java] Student_77 G A B C D 15
     [java] Student_78 A B C D E 15
     [java] Student_79 B C D E F 15
     [java] Student_80 C D E F G 15
     [java] Student_6 F G A B C 15
     [java] Student_40 E F G A B 15
     [java] Average preference_score is: 15.0
     [java] The average preference value is 15.0
]

TO UNTAR:
[
  tar -xvf abhishek_upasani_assign2.tar.gz
]

TO COMPILE:

[
  ant -buildfile src/build.xml clean
]

TO RUN:

[
  ant -buildfile src/build.xml run -Darg0=<input_file> -Darg1=<output_file> -Darg2=<NUM_THREADS> -Darg3=<DEBUG_VALUE>
  
  For example,
  ant -buildfile src/build.xml run -Darg0=input.txt -Darg1=output.txt -Darg2=3 -Darg3=0
]

CHOICE OF DATA STRUCTURES:

[
  ArrayList of Objects to store the student details. ArrayList of objects to store the results.
  ArrayList gives flexibility for multiple insertion and removal operations on result objects and also 
  allows holding of mltiple null elements.
  
  Given that there are m courses to be allocated for n students, the time complexity of the 
  algorithm would be O(mn).
]

EXTRA CREDIT:

[
 "N/A" 
]


BIBLIOGRAPHY:

[
  For exception handling in reading and writing files
  * https://www.caveofprogramming.com/java/java-file-reading-and-writing-files-in-java.html
  
  For starting and joining threads, also using sleep()
  * https://docs.oracle.com/javase/tutorial/essential/concurrency/runthread.html
]

ACKNOWLEDGEMENT:

[
  None
]
