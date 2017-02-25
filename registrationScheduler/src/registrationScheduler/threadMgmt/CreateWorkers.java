package registrationScheduler.threadMgmt;

import java.util.List;

import registrationScheduler.allocation.Course;
import registrationScheduler.allocation.Student;
import registrationScheduler.store.CourseAllocationInterface;
import registrationScheduler.util.FileProcessor;
import registrationScheduler.util.Logger;

/**
 * @author Abhishek Niranjan Upasani
 * @version 1.0
 * @since 2016-09-30
 * 
 */
public class CreateWorkers {
	
	private FileProcessor fp;
	private List<CourseAllocationInterface> res;
	private Course course;
	private List<Student> student;
	
	/**
	 * This method does not have a return type. When an object is 
	 * created this constructor is invoked
	 *
	 * @param fpIn
	 * @param resIn
	 * @param courseIn
	 * @param studentIn
	 */
	public CreateWorkers(FileProcessor fpIn, List<CourseAllocationInterface> resIn, Course courseIn, List<Student> studentIn) {
	
		fp = fpIn;
		res = resIn;
		course = courseIn;
		student = studentIn;
		
		Logger.writeMessage("Constructor of CreateWorkers class", Logger.DebugLevel.CONSTRUCTOR);
	}

	/** This method starts  NUM_THREADS and then joins on them
	 * 
	 * @param NUM_THREADSIn
	 */
	public void startWorkers(int NUM_THREADSIn) {

		int NUM_THREADS = NUM_THREADSIn;
		Thread[] thread = new Thread[NUM_THREADS];
		
		// Create NUM_THREADS threads
		for (int i = 0; i < NUM_THREADS; i++) {
			thread[i] = new Thread(new WorkerThread(fp, res, course, student));
			thread[i].start();
		}
	
		// Join on NUM_THREADS threads
		for (int i = 0; i < NUM_THREADS; i++) {
			try {
				thread[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
				System.exit(1);
			} finally {
				
			}
		}
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CreateWorkers [fp=" + fp + ", res=" + res + ", course="
				+ course + ", student=" + student + "]";
	}
}