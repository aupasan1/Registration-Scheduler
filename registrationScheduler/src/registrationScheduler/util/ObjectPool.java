package registrationScheduler.util;

/**
 * @author Abhishek Niranjan Upasani
 * @version 1.0
 * @since 2016-09-30
 * 
 */
public class ObjectPool implements CoursePoolInterface{
	
	private int allocatedForA = 0;
	private int allocatedForB = 0;
	private int allocatedForC = 0;
	private int allocatedForD = 0;
	private int allocatedForE = 0;
	private int allocatedForF = 0;
	private int allocatedForG = 0;
	private static double averagePreferenceScore = 0.0;
	private volatile static ObjectPool objectInstance;
	
	/**
	 * This method does not have a return type. When an object is 
	 * created this constructor is invoked
	 */
	private ObjectPool() {

		Logger.writeMessage("Constructor of Object Pool class", Logger.DebugLevel.CONSTRUCTOR);
	
	}

	/**
	 * This method ensures that only one instance of Object Pool
	 * is created and returns that instance.
	 * 
	 * @return objectInstance
	 */
	public static ObjectPool getInstance() {
		
		if (objectInstance == null) {
			synchronized (ObjectPool.class) {
				if (objectInstance == null) {
					objectInstance = new ObjectPool();
				}
			}
		}
		return objectInstance;
	}

	/* (non-Javadoc)
	 * @see registrationScheduler.util.CoursePoolInterface#borrowObject(java.lang.String)
	 */
	@Override
	public synchronized int borrowObject(String courseIn) {
		
		String course = courseIn;
		
		if (course.equals("A")) {
			return allocatedForA;
		} else if (course.equals("B")) {
			return allocatedForB;
		} else if (course.equals("C")) {
			return allocatedForC;
		} else if (course.equals("D")) {
			return allocatedForD;
		} else if (course.equals("E")) {
			return allocatedForE;
		} else if (course.equals("F")) {
			return allocatedForF;
		} else {
			return allocatedForG;
		}
	}
	
	/* (non-Javadoc)
	 * @see registrationScheduler.util.CoursePoolInterface#addObject(java.lang.String)
	 */
	@Override
	public synchronized void addObject(String courseIn) {
		
		String course = courseIn;
		
		if (course.equals("A")) {
			allocatedForA++;
		} else if (course.equals("B")) {
			allocatedForB++;
		} else if (course.equals("C")) {
			allocatedForC++;
		} else if (course.equals("D")) {
			allocatedForD++;
		} else if (course.equals("E")) {
			allocatedForE++;
		} else if (course.equals("F")) {
			allocatedForF++;
		} else {
			allocatedForG++;
		}		
	}
	
	/* (non-Javadoc)
	 * @see registrationScheduler.util.CoursePoolInterface#borrowAveragePreferenceScore()
	 */
	@Override
	public synchronized double borrowAveragePreferenceScore() {
		return averagePreferenceScore;
	}
	
	/* (non-Javadoc)
	 * @see registrationScheduler.util.CoursePoolInterface#addAveragePreferenceScore(int)
	 */
	@Override
	public synchronized void addAveragePreferenceScore(int valueIn) {
		averagePreferenceScore += valueIn;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ObjectPool [allocatedForA=" + allocatedForA
				+ ", allocatedForB=" + allocatedForB + ", allocatedForC="
				+ allocatedForC + ", allocatedForD=" + allocatedForD
				+ ", allocatedForE=" + allocatedForE + ", allocatedForF="
				+ allocatedForF + ", allocatedForG=" + allocatedForG + "]";
	}

}