package registrationScheduler.threadMgmt;

import registrationScheduler.allocation.Course;
import registrationScheduler.allocation.Student;
import registrationScheduler.store.CourseAllocationInterface;
import registrationScheduler.util.FileProcessor;
import registrationScheduler.util.Logger;

import java.io.IOException;
import java.util.List;

/**
 * @author Abhishek Niranjan Upasani
 * @version 1.0
 * @since 2016-09-30
 * 
 */
public class WorkerThread implements Runnable {

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
	public WorkerThread(FileProcessor fpIn, List<CourseAllocationInterface> resIn, Course courseIn, List<Student> studentIn) {
		
		fp = fpIn;
		res = resIn;
		course = courseIn;
		student = studentIn;
		
		Logger.writeMessage("Constructor of WorkerThread class", Logger.DebugLevel.CONSTRUCTOR);
	}

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	public void run() {
		
		String line = null;
		
		Logger.writeMessage("Run method of Thread class", Logger.DebugLevel.RUN);
		
		try {
			while ((line = fp.readInputFile()) != null) {				
				course.allocateCourses(student, res, line);
			}		
			Thread.sleep(5);
			course.allocateCourses1(student, res);
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
			System.exit(1);
		} finally {
			
		}
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "WorkerThread [fp=" + fp + ", res=" + res + ", course=" + course
				+ ", student=" + student + "]";
	}
}
