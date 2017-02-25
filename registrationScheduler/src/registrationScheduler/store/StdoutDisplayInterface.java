package registrationScheduler.store;

import java.util.List;

/**
 * @author Abhishek Niranjan Upasani
 * @version 1.0
 * @since 2016-09-30
 * 
 */
public interface StdoutDisplayInterface {
	
	/**
	 * This method prints the schedules, courses allocated, total 
	 * preference score and average preference score for all the 
	 * students to the console.
	 * 
	 * @param resIn
	 */
	public void writeScheduleToScreen(List<CourseAllocationInterface> resIn);
	
}
