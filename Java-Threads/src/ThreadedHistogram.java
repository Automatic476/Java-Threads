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
	 // - initialize array
 int[] counts = new int[21];

//- create two FileReaderThread’s, each to read from
// a different file
 
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
    // - obtain file names from user
    public void readFile() {
        BufferedReader br = null;
        System.out.println("Give File Name: " + filename);
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
         //Error catching if file name is not correct
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
    //method for running the file read, (run the threads)
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
                //Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
 //------------------------------------------------------------------
 //Implements the start and end of the file
 //  TODO wait for both threads to terminate
    public abstract void parseRecord(String record);

    public void beginFile(String filename) {
        this.fileStarted = true;
        this.fileEnded = false;
    }

    public void endFile() {
        file.delete();
        this.fileEnded = true;
        this.fileStarted = false;
    }
 // TODO (hint use join method)
 //TODO - display the histogram
}