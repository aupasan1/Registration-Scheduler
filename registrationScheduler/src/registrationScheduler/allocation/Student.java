package registrationScheduler.allocation;

import registrationScheduler.util.Logger;

/**
 * @author Abhishek Niranjan Upasani
 * @version 1.0
 * @since 2016-09-30
 * 
 */public class Student {

	private int preferenceForA;
	private int preferenceForB;
	private int preferenceForC;
	private int preferenceForD;
	private int preferenceForE;
	private int preferenceForF;
	private int preferenceForG;

	/**
	 * This method does not have a return type. When an object is created this
	 * constructor is invoked
	 */
	public Student() {
		preferenceForA = 0;
		preferenceForB = 0;
		preferenceForC = 0;
		preferenceForD = 0;
		preferenceForE = 0;
		preferenceForF = 0;
		preferenceForG = 0;

		Logger.writeMessage("Constructor of Student class", Logger.DebugLevel.CONSTRUCTOR);
	}

	/**
	 * @return the preference for course A
	 */
	public int getPreferenceForA() {
		return preferenceForA;
	}

	/**
	 * @param preferenceForA the preference for course A to set
	 */
	public void setPreferenceForA(int preferenceForAIn) {
		preferenceForA = preferenceForAIn;
	}

	/**
	 * @return the preference for course B
	 */
	public int getPreferenceForB() {
		return preferenceForB;
	}

	/**
	 * @param preferenceForBIn the preference for course B to set
	 */
	public void setPreferenceForB(int preferenceForBIn) {
		preferenceForB = preferenceForBIn;
	}

	/**
	 * @return the preference for course C
	 */
	public int getPreferenceForC() {
		return preferenceForC;
	}

	/**
	 * @param preferenceForCIn the preference for course C to set
	 */
	public void setPreferenceForC(int preferenceForCIn) {
		preferenceForC = preferenceForCIn;
	}

	/**
	 * @return the preference for course D
	 */
	public int getPreferenceForD() {
		return preferenceForD;
	}

	/**
	 * @param preferenceForDIn the preference for course D to set
	 */
	public void setPreferenceForD(int preferenceForDIn) {
		preferenceForD = preferenceForDIn;
	}

	/**
	 * @return the preference for course E
	 */
	public int getPreferenceForE() {
		return preferenceForE;
	}

	/**
	 * @param preferenceForEIn the preference for course E to set
	 */
	public void setPreferenceForE(int preferenceForEIn) {
		preferenceForE = preferenceForEIn;
	}

	/**
	 * @return the preference for course F
	 */
	public int getPreferenceForF() {
		return preferenceForF;
	}

	/**
	 * @param preferenceForFIn the preference for course F to set
	 */
	public void setPreferenceForF(int preferenceForFIn) {
		preferenceForF = preferenceForFIn;
	}

	/**
	 * @return the preference for course G
	 */
	public int getPreferenceForG() {
		return preferenceForG;
	}

	/**
	 * @param preferenceForGIn the preference for course G to set
	 */
	public void setPreferenceForG(int preferenceForGIn) {
		preferenceForG = preferenceForGIn;
	}
	
	/**
	 * Returns string
	 * 
	 * @return given string in the function.
	 */
	@Override
	public String toString() {
		return "Student [preferenceForA=" + preferenceForA
				+ ", preferenceForB=" + preferenceForB + ", preferenceForC="
				+ preferenceForC + ", preferenceForD=" + preferenceForD
				+ ", preferenceForE=" + preferenceForE + ", preferenceForF="
				+ preferenceForF + ", preferenceForG=" + preferenceForG + "]";
	}
}