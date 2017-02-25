package registrationScheduler.util;

/**
 * @author Abhishek Niranjan Upasani
 * @version 1.0
 * @since 2016-09-30
 * 
 */
public interface CoursePoolInterface {
	
	/**
	 * @param courseIn the course to check availability 
	 * @return course capacity
	 */
	public int borrowObject(String courseIn);

	/**
	 * @param courseIn the course to be added
	 */
	public void addObject(String courseIn);

	/**
	 * @return the average preference score
	 */
	public double borrowAveragePreferenceScore();

	/**
	 * @param valueIn the average preference score to set
	 */
	public void addAveragePreferenceScore(int valueIn);

}
