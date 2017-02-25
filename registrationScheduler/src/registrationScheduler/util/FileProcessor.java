package registrationScheduler.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Abhishek Niranjan Upasani
 * @version 1.0
 * @since 2016-09-30
 * 
 */
public class FileProcessor {

	private FileReader fr;
	private BufferedReader br;

	
	/**
	 * This method does not have a return type. When an object is 
	 * created this constructor is invoked
	 *
	 * @param frIn
	 */
	public FileProcessor(FileReader frIn) {

		fr = frIn;
		br = new BufferedReader(fr);

		Logger.writeMessage("Constructor of FileProcessor class", Logger.DebugLevel.CONSTRUCTOR);
	}

	/**
	 * This method reads a single line from a file
	 * 
	 * @return line 
	 * @throws IOException On input error
	 * @see IOException
	 */
	public synchronized String readInputFile() throws IOException {

		String line = null;
		line = br.readLine();
		return line;
	}

	/**
	 * This method closes any open files
	 */
	public void closeFile() {
		try {
			if (br != null) {
				br.close();
			}
		} catch (IOException e) {
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
		return "FileProcessor [fr=" + fr + ", br=" + br + "]";
	}
}