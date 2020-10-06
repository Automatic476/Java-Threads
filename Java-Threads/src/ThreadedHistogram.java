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

public class ThreadedHistogram
{
 public static void main(String[] args) throws FileNotFoundException
 {
	 	// - initialize array
	 	int[] counts = new int[21];
		String word;
		String filename;
		
		Scanner console = new Scanner(System.in);
		
		// Obtain name of files from users
		System.out.print("Enter name of text file: ");
		filename = console.next();
		
		Scanner sc = new Scanner(new File(filename));
		
		FileReaderThread file1 = new FileReaderThread(filename, counts);
		file1.start();
		FileReaderThread file2 = new FileReaderThread(filename, counts);
		file2.start();
		
		try { 
		file1.join();
		file2.join();
		System.out.println("Main thread will not terminate before child.");
		}
		catch (InterruptedException e) {
			System.out.println("Main thread interrupted.");
		}
		
 
 }
}
//--------------------------------------------------------------------------
class FileReaderThread extends Thread { 
	private String filename = "";
 	private int[] freq;
//    File file = null;
//    private int[] counts;
//    boolean fileStarted = false;
//    boolean fileEnded = false;


    
//-------------------------------------------------------------------------
 //Constructor for FileReaderThread  
public FileReaderThread(String fname, int[] f) {
        filename = fname;
        freq = f;
    }

//----------------------------------------------------------------------------
    //method for running the file read, (run the threads)
    public void run() {
        
            System.out.println("Thread to read: " + filename + " - started.");
            for(int i = 0; i < freq.length; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                //Auto-generated catch block
                e.printStackTrace();
            }
        }
   
 //------------------------------------------------------------------

}
}