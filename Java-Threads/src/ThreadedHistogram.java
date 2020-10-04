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

public class ThreadedHistogram
{
 public static void main(String[] args)
 {
 int[] counts = new int[21];
 // Insert code here to:
 // - initialize array
 // - obtain file names from user
 // - create two FileReaderThread’s, each to read from
 // a different file
 // - run the threads
 // - wait for both threads to terminate
 // (hint use join method)
 // - display the histogram
 }
}
//--------------------------------------------------------------------------
abstract class FileReaderThread extends Thread {


    String filename = "";
    File file = null;
    private int[] freq;
    boolean fileStarted = false;
    boolean fileEnded = false;
//-------------------------------------------------------------------------
 //Constructor for FileReaderThread  
    public FileReaderThread(String fname, int[]f) {
        filename = fname;
        freq = f;
    }
//--------------------------------------------------------------------------
    public void readFile() {
        BufferedReader br = null;
        System.out.println("Base call: " + filename);
        try {

            System.out.println("inside");
            br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            if(br.readLine().trim().isEmpty()) {
                endFile();
                return;
                
            } else {
                startFile(filename);
                String record;
                while((record = br.readLine().trim()) != null) {
                    parseRecord(record);
                }
                endFile();
            }
        } catch(Exception ioe) {
            ioe.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
//----------------------------------------------------------------------------
    //method for running the file read
    public void run() {
        while(true) {
            System.out.println("Inside run, fileName: " + filename);
            System.out.println("Filestarted: " + fileStarted + ", file exists: " + file.exists());
            if(!fileStarted) {
                readFile();
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
 //------------------------------------------------------------------
  //Implements the start and end of the file
    public abstract void parseRecord(String record);

    public void startFile(String filename) {
        this.fileStarted = true;
        this.fileEnded = false;
    }

    public void endFile() {
        file.delete();
        this.fileEnded = true;
        this.fileStarted = false;
    }
}