
/**
 * This program uses threads to read words from a file 
 * and update frequencies stored in shared 
 * array of integers. 
 * Used in CS346 (Operating Systems) Lab 4
 * 
 * 
 * @author Jason Green & Maggie Sweeney
 * @version 2 Oct 2020
 */
/* ThreadedHistogram.java
*/
import java.io.*;

public abstract class ThreadedHistogram {
	public static void main(String[] args) {

		// - initialize array
		int[] counts = new int[21];

		// -------------------------------------------------------------------------
		System.out.print("Test");
		abstract class FileReaderThread extends Thread {

			String filename = "";
			File file = null;
			private int[] counts;
			boolean fileStarted = false;
			boolean fileEnded = false;

			// -------------------------------------------------------------------------
			// Constructor for FileReaderThread
			public FileReaderThread(String fname, int[] f) {
				filename = fname;
				counts = f;
			}

			// -------------------------------------------------------------------------
			// obtain file names from user
			public void readFile() {
				// Creates the bufferedReaders
				BufferedReader br = null;
				BufferedReader br2 = null;

				System.out.println("Give File Name: " + filename);
				try {

					br = new BufferedReader(new FileReader("B:\\myfile.txt"));

					// First file read
					System.out.println("Reading the file using readLine() method:");
					String contentLine = br.readLine();
					while (contentLine != null) {
						System.out.println(contentLine);
						contentLine = br.readLine();
					}
					// ------------------------------------------------------------------
					// Error catching if file name is not correct, put this in or else the return
					// leaks data
				} catch (

				Exception ioe) {
					ioe.printStackTrace();
				} finally {
					try {
						if (br != null)
							br.close();
					} catch (IOException e) { // Auto-generated catch block
						e.printStackTrace();
						System.out.println("Error in closing the BufferedReader");
					}
				}
			}

			//----------------------------------------------------------------------------
			// method for running the file read, (run the threads)
			// also checks if file actually has anything in it
			public void run() {
				while (true) {
					System.out.println("Thread to read: " + filename);

					// Message of execution with name of file
					System.out.println("File Started: " + fileStarted + ", file exists: " + file.exists());
					if (!fileStarted) {
						readFile(); // open file
						// TODO read words from file and update array frequency and print number of
						// words read
					}
				}
			}
			// TODO (hint use join method)
			// TODO - display the histogram
		}
	} // main bracket
}