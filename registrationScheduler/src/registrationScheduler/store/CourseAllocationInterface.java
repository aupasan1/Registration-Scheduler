package registrationScheduler.store;

import java.util.List;

/**
 * @author Abhishek Niranjan Upasani
 * @version 1.0
 * @since 2016-09-30
 * 
 */
public interface CourseAllocationInterface {
	
	/**
	 * @return totalAllocated
	 */
	public int getTotalAllocated();
	
	/**
	 * @param totalAllocated the total allocated courses to set
	 */
	public void setTotalAllocated(int totalAllocated);
	
	/**
	 * @return preferenceScore
	 */
	public int getPreferenceScore();
	
	/**
	 * @param preferenceScore the preference score to set
	 */
	public void setPreferenceScore(int preferenceScore);
	
	/**
	 * @return studentName
	 */
	public String getStudentName();
	
	/**
	 * @param studentName the student name to set
	 */
	public void setStudentName(String studentName);
	
	/**
	 * @return assignedCourseName 
	 */
	public String getAssignedCourseName();
	
	/**
	 * @param assignedCourseName the course name to set
	 */
	public void setAssignedCourseName(String assignedCourseName);
	
	/**
	 * This method prints the schedules, allocated courses and total 
	 * preference score for all the students on the console.
	 * 
	 * @param resIn
	 */
	public void displayAllocation(List<CourseAllocationInterface> resIn);
	
	/**
	 * This method prints the average preference for the course 
	 * allocation. 
	 * 
	 * @param resIn
	 */
	public void displayAveragePreferenceScore();

}
