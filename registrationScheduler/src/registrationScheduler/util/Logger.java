package registrationScheduler.util;

/**
 * @author Abhishek Niranjan Upasani
 * @version 1.0
 * @since 2016-09-30
 * 
 */
public class Logger {

	private static DebugLevel debugLevel;
	
	public static enum DebugLevel {
		CONSTRUCTOR, RUN, RESULT, DATA, AVG_PREF_SCORE
	};

	
	/**
	 * This method does not have a return type. When an object is 
	 * created this constructor is invoked 
	 */
	public Logger() {
		Logger.writeMessage("Constructor of Logger class", Logger.DebugLevel.CONSTRUCTOR);
	}

	/** 
	 * @param levelIn The debug level to set
	 */
	public static void setDebugValue(int levelIn) {
		switch (levelIn) {
		case 0:
			debugLevel = DebugLevel.AVG_PREF_SCORE;
			break;
		case 1:
			debugLevel = DebugLevel.DATA;
			break;
		case 2:
			debugLevel = DebugLevel.RESULT;
			break;
		case 3:
			debugLevel = DebugLevel.RUN;
			break;
		case 4:
			debugLevel = DebugLevel.CONSTRUCTOR;
			break;
		}
	}

	/**
	 * @param levelIn The debug level to set
	 */
	public static void setDebugValue(DebugLevel levelIn) {
		debugLevel = levelIn;
	}

	/**
	 * This method prints the message passed as per the debug level
	 * 
	 * @param message
	 * @param levelIn
	 */
	public static void writeMessage(String message, DebugLevel levelIn) {
		if (levelIn == debugLevel)
			System.out.println(message);
	}
	
	/**
	 * Returns string
	 * 
	 * @return given string in the function
	 */
	public String toString() {
		return "Debug Level is " + debugLevel;
	}
}