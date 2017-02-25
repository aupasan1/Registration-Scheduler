package registrationScheduler.driver;

import registrationScheduler.allocation.Course;
import registrationScheduler.allocation.Student;
import registrationScheduler.store.CourseAllocationInterface;
import registrationScheduler.store.FileDisplayInterface;
import registrationScheduler.store.Results;
import registrationScheduler.store.StdoutDisplayInterface;
import registrationScheduler.threadMgmt.CreateWorkers;
import registrationScheduler.util.FileProcessor;
import registrationScheduler.util.Logger;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Abhishek Niranjan Upasani
 * @version 1.0
 * @since 2016-09-30
 * 
 */
public class Driver {

	/**
	 * Returns string
	 * 
	 * @return given string in the function
	 */
	@Override
	public String toString() {
		return "Driver []";
	}

	public static void main(String args[]) {

		System.out.println("\n The args[0] is: " + args[0]);

		//Validate the command line arguments
		if (args.length != 4) {
			System.err.println("Usage: java Driver input.txt output.txt NUM_THREADS DEBUG_VALUE");
			System.exit(1);
		}

		//Read the command line arguments
		final String inputFile = args[0];
		final String outputFile = args[1];
		final int NUM_THREADS = Integer.parseInt(args[2]);
		final int DEBUG_VALUE = Integer.parseInt(args[3]);

		//Validate number of threads
		if (NUM_THREADS < 1 || NUM_THREADS > 3) {
			System.err.println("Invalid number of threads !!");
			System.exit(1);
		}
		
		//Validate debug value
		if (DEBUG_VALUE < 0 || DEBUG_VALUE > 4) {
			System.err.println("Invalid DEBUG_VALUE !!");
			System.exit(1);
		}
		
		FileProcessor fp = null;
		List<CourseAllocationInterface> res = null;
		CourseAllocationInterface res1 = null;
		CreateWorkers cw = null;
		Course course = null;
		List<Student> student = null;
		
		try {
		
			Logger.setDebugValue(DEBUG_VALUE);
			
			FileReader fr = new FileReader(inputFile);
			fp = new FileProcessor(fr);
			
			res1 = new Results();
			res = new ArrayList<CourseAllocationInterface>();
			course = new Course();
			student = new ArrayList<Student>();

			//Start the CreateWorkers
			cw = new CreateWorkers(fp, res, course, student);
			cw.startWorkers(NUM_THREADS);
			
			//Display schedules
			((StdoutDisplayInterface)res1).writeScheduleToScreen(res);
            ((FileDisplayInterface)res1).writeSchedulesToFile(res, outputFile);
            
            if(DEBUG_VALUE == 0) {
            	res1.displayAveragePreferenceScore();
            } else if(DEBUG_VALUE == 1) {
            	res1.displayAllocation(res);
            }
            
		} catch (FileNotFoundException e) {
			System.err.println("Unable to open file '" + inputFile + "'");
			System.exit(1);
		} finally {
			fp.closeFile();
		}
		
	} // end main(...)
} // end public class Driver