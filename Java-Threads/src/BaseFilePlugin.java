import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public abstract class BaseFilePlugin extends Thread{

    String filename = "";
    File file = null;
    boolean fileStarted = false;
    boolean fileEnded = false;

    public BaseFilePlugin() {
        file = new File(filename);
    }

    public void readFile() {
        BufferedReader br = null;
        System.out.println("Base call: " + filename);
        try {

            System.out.println("inside ");
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

    /**
     * @return the filename
     */
    public String getFilename() {
        return filename;
    }

    /**
     * @param filename the filename to set
     */
    public void setFilename(String filename) {
        this.filename = filename;
    }

}