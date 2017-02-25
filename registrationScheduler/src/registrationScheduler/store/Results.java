package registrationScheduler.store;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import registrationScheduler.util.CoursePoolInterface;
import registrationScheduler.util.Logger;
import registrationScheduler.util.ObjectPool;

/**
 * @author Abhishek Niranjan Upasani
 * @version 1.0
 * @since 2016-09-30
 * 
 */
public class Results implements StdoutDisplayInterface, FileDisplayInterface, CourseAllocationInterface {
	
	private int totalAllocated;
	private int preferenceScore;
	private static final int noOfStudents = 80;
	private String studentName;
	private String assignedCourseName;

	/**
	 * This method does not have a return type. When an object is 
	 * created this constructor is invoked
	 */
	public Results() {
		
		totalAllocated = 0;
		preferenceScore = 0;
		studentName = "";
		assignedCourseName = "";

		Logger.writeMessage("Constructor of Results class", Logger.DebugLevel.CONSTRUCTOR);	
	}

	/* (non-Javadoc)
	 * @see registrationScheduler.store.StdoutDisplayInterface#
	 * writeScheduleToScreen(registrationScheduler.store.CourseAllocationInterface[])
	 */
	@Override
	public void writeScheduleToScreen(List<CourseAllocationInterface> resIn) {
		
		List<CourseAllocationInterface> res = resIn;
		CoursePoolInterface obj = ObjectPool.getInstance();
		
		for(int i = 0; i < res.size(); i++){
			System.out.println(res.get(i).getStudentName() + " " + res.get(i).getAssignedCourseName() + res.get(i).getPreferenceScore());
		}
		System.out.println("Average preference_score is: " + obj.borrowAveragePreferenceScore() / noOfStudents);
	}

	
	/* (non-Javadoc)
	 * @see registrationScheduler.store.FileDisplayInterface
	 * #writeSchedulesToFile(registrationScheduler.store.CourseAllocationInterface[], java.lang.String)
	 */
	@Override
	public void writeSchedulesToFile(List<CourseAllocationInterface> resIn, String outputFileIn) {
		
		String outputFile = outputFileIn;
		List<CourseAllocationInterface> res = resIn;
		CoursePoolInterface obj = ObjectPool.getInstance();
		FileWriter fw = null;
		BufferedWriter bw = null;
		
		try {
			fw = new FileWriter(outputFile);
			bw = new BufferedWriter(fw);
			
			for (int i = 0; i < res.size(); i++) {
				bw.write(res.get(i).getStudentName() + " " + res.get(i).getAssignedCourseName() + res.get(i).getPreferenceScore());
				bw.newLine();
			}
			
			bw.write("Average preference_score is: " + obj.borrowAveragePreferenceScore() / noOfStudents);
			
		} catch (IOException e) {
			System.out.println("Error writing to file '" + outputFile + "'");
			System.exit(1);
		} finally {
			try {
				if(bw != null) {
					bw.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
				System.exit(1);
			} finally {
				
			}
		}
	}

	/* (non-Javadoc)
	 * @see registrationScheduler.store.CourseAllocationInterface
	 * #displayAllocation(registrationScheduler.store.CourseAllocationInterface[])
	 */
	@Override
	public void displayAllocation(List<CourseAllocationInterface> resIn) {
		
		List<CourseAllocationInterface> res = resIn;
		CoursePoolInterface obj = ObjectPool.getInstance();
		
		Logger.writeMessage("Printing contents of data structure in the store", Logger.DebugLevel.DATA);
		
		System.out.println("------------------------------------------------------");
		System.out.println("Student Name" + " " + "Allocated Courses" + " " + "Total Preference Score");
		System.out.println("------------------------------------------------------");
		
		for(int i = 0; i < res.size(); i++){
			System.out.println(res.get(i).getStudentName() + "        "
					+ res.get(i).getAssignedCourseName() + "              "
					+ res.get(i).getPreferenceScore());
		}
		System.out.println("Average preference_score is: " + obj.borrowAveragePreferenceScore() / noOfStudents);
	}

	/* (non-Javadoc)
	 * @see registrationScheduler.store.CourseAllocationInterface
	 * #displayAveragePreferenceScore()
	 */
	@Override
	public void displayAveragePreferenceScore() {
		
		CoursePoolInterface obj = ObjectPool.getInstance();
		Logger.writeMessage("The average preference value is " + obj.borrowAveragePreferenceScore() / noOfStudents, Logger.DebugLevel.AVG_PREF_SCORE);
	}
	
	/* (non-Javadoc)
	 * @see registrationScheduler.store.CourseAllocationInterface
	 * #getTotalAllocated()
	 */
	@Override
	public  int getTotalAllocated() {
		return totalAllocated;
	}

	/* (non-Javadoc)
	 * @see registrationScheduler.store.CourseAllocationInterface
	 * #setTotalAllocated(int)
	 */
	@Override
	public  void setTotalAllocated(int totalAllocatedIn) {
		totalAllocated = totalAllocatedIn;
	}

	/* (non-Javadoc)
	 * @see registrationScheduler.store.CourseAllocationInterface
	 * #getPreferenceScore()
	 */
	@Override
	public  int getPreferenceScore() {
		return preferenceScore;
	}

	/* (non-Javadoc)
	 * @see registrationScheduler.store.CourseAllocationInterface
	 * #setPreferenceScore(int)
	 */
	@Override
	public  void setPreferenceScore(int preferenceScoreIn) {
		preferenceScore = preferenceScoreIn;
	}

	/* (non-Javadoc)
	 * @see registrationScheduler.store.CourseAllocationInterface
	 * #getStudentName()
	 */
	@Override
	public  String getStudentName() {
		return studentName;
	}

	/* (non-Javadoc)
	 * @see registrationScheduler.store.CourseAllocationInterface
	 * #setStudentName(java.lang.String)
	 */
	@Override
	public  void setStudentName(String studentNameIn) {
		studentName = studentNameIn;
	}

	/* (non-Javadoc)
	 * @see registrationScheduler.store.CourseAllocationInterface
	 * #getAssignedCourseName()
	 */
	@Override
	public  String getAssignedCourseName() {
		return assignedCourseName;
	}

	/* (non-Javadoc)
	 * @see registrationScheduler.store.CourseAllocationInterface
	 * #setAssignedCourseName(java.lang.String)
	 */
	@Override
	public  void setAssignedCourseName(String assignedCourseNameIn) {
		assignedCourseName = assignedCourseNameIn;
	}

	/**
	 * Returns string
	 * 
	 * @return given string in the function
	 */
	@Override
	public String toString() {
		return "Results [totalAllocated=" + totalAllocated
				+ ", preferenceScore=" + preferenceScore + ", studentName="
				+ studentName + ", assignedCourseName=" + assignedCourseName
				+ "]";
	}
}