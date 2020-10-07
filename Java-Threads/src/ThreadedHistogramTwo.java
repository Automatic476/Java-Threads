// Multiplethread Histogram
// @author Zahary Delardi
// @version 10/6/2020

import java.io.*;
import java.util.Scanner;

public class ThreadedHistogramTwo {
	public static void main(String[] args) {
		int[] counts = new int[21];
		// Insert code here to:
		// - initialize array
		// - obtain file names from user
		// - create two FileReaderThread’s, each to read from a different file
		// - run the threads
		// - wait for both threads to terminate (hint use join method)
		// - display the histogram
		
		//Run through command line parameters and make a thread for each file
		for(int i = 0; i < args.length; i++) {
			//Create FileReaderThread
			FileReaderThread2 file1 = new FileReaderThread2(args[i], counts);
		
			//Run the two files (method defined below)
			file1.run();
			
			//Make sure the first thread is done before starting the next thread
			//Source: https://www.geeksforgeeks.org/joining-threads-in-java/
			try { 
	            file1.join(); 
	        } 
	        catch(Exception ex) { 
	            System.out.println("Exception has been caught" + ex); 
	        } 
		}
		
		
	}
}

class FileReaderThread2 extends Thread {
	//Make variables
	private String filename;
	private int[] freq;
	private String word;

	public FileReaderThread2(String fname, int[] f) {
		filename = fname;
		freq = f;
	}

	public void run(){
		System.out.println("Thread to read " + filename + " – started");
        // Insert code here to:
		// - open file
		// - read words from file and update array freq
		// - display message at end of execution with name of file and number of words read
		
		//Open File
		try {
			Scanner sc = new Scanner(new File(filename));

			//Count Words
			int wordCount = 0;
			while (sc.hasNext())
			{
				word = sc.next();
				freq[word.length()]++;
				wordCount++;
			}
			
			//Display Histogram
			displayHistogram();
			
			//Ending Statement
			System.out.println("For the file " + filename + " there were a total of " + wordCount + "word(s)\n");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	//Displays Histogram
	public void displayHistogram(){
		int i;
		int j;
		
		for (i = 1; i < freq.length; i++){
			System.out.print("[" + ((i < 10)?" ":"") + i + "]  ");
			
			for (j = 0; j < freq[i]; j++){
				System.out.print("*");
				
			}
			
			System.out.println();
		}
		
	}
}


