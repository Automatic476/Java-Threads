/* ThreadedHistogram.java
*/
import java.io.*;
public class ThreadedHistogram {
      public static void main(String[] args)
      {
int[] counts = new int[21];
         // Insert code here to:
// - initialize array
// - obtain file names from user
// - create two FileReaderThread’s, each to read from
         //       a different file
// - run the threads
// - wait for both threads to terminate
         //       (hint use join method)
// - display the histogram
} }
   class FileReaderThread extends Thread
   {
      private String filename;
      private int[] freq;
 
public FileReaderThread(String fname, int[] f) {
filename = fname;
freq = f; }
      public void run()
      {
System.out.println(“Thread to read “ + filename + “ – started”);
        // Insert code here to:
// - open file
// - read words from file and update array freq
// - display message at end of execution with name of
         //       file and number of words read
} }