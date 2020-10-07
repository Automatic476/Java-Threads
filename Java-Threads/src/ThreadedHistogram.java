
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
import java.util.Scanner;

public class ThreadedHistogram {
	public static void main(String[] args) throws FileNotFoundException {
		// - initialize array
		int[] counts = new int[21];
		for (int i = 0; i < args.length; i++) {
			FileReaderThread file1 = new FileReaderThread(args[i], counts);
			file1.start();
			try {
				file1.join();
			} catch (Exception e) {
				System.out.println("Main thread interrupted." + e);
			}
		}

//		String filename;
//		Scanner console = new Scanner(System.in);
//		for(int i = 0; i < 3; i++) {
//			System.out.print("Enter name of text file: ");
//			filename = console.next();
//	
//			Scanner sc = new Scanner(new File(filename));
//	
//			FileReaderThread file1 = new FileReaderThread(filename, counts);
//			file1.start();
//			
//			try {
//				file1.join();
//			}
//			catch(Exception e) {
//				System.out.println("Main thread interrupted.");
//			}
//		}

	}
}

//--------------------------------------------------------------------------
class FileReaderThread extends Thread {
	private String filename = "";
	private int[] freq;
	private String word;

//-------------------------------------------------------------------------
	// Constructor for FileReaderThread
	public FileReaderThread(String fname, int[] f) {
		filename = fname;
		freq = f;
	}

//--------------------------------------------------------------------------
	// method for running the file read, (run the threads)
	public void run() {

		System.out.println("Thread to read: " + filename + " - started.");
		try {
			Scanner sc = new Scanner(new File(filename));
			int wordcount = 0;
			while (sc.hasNext()) {
				word = sc.next();
				freq[word.length()]++;
				wordcount++;
			}
			displayHistogram();
			System.out.println("There were " + wordcount + " words in " + filename);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	// -----------------------------------------------------------------------
	private void displayHistogram() {
		int i;
		int j;

		for (i = 1; i < freq.length; i++) {
			System.out.print("[" + ((i < 10) ? " " : "") + i + "]  ");
			for (j = 0; j < freq[i]; j++) {
				System.out.print("*");
			}
			System.out.println();
		}

	}
}
