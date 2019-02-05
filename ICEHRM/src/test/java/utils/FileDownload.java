package utils;

import java.io.File;
import java.io.IOException;

public class FileDownload {

    public static void main(String[] args)
    {
        DeleteAFile("employee_42_Jake_Bruce.txt");
    }

//Delete a file
    public static void DeleteAFile(String filename) {
        //get current project path
        String filePath = System.getProperty("user.dir") + "\\Download\\";
        //create a new file
        File file = new File(filePath + "\\" + filename);
        try {
            if (!file.exists()) {
                file.createNewFile();
                System.out.println("File is created");
            } else {
                //delete a file
                System.out.println("File already exist");
                file.delete();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void WaitforFileDownLoad(String filename) throws InterruptedException {
        //get current project path
    	double filesize1 ;
    	double filesize2 ;
        String filePath = System.getProperty("user.dir") + "\\Download\\";
        //create a new file
        File file = new File(filePath + "\\" + filename);
        do {

        	   filesize1 = file.length();  // check file size
        	   Thread.sleep(1000);      // wait for 5 seconds
        	   filesize2 = file.length();  // check file size again

        	} while (filesize1 != filesize2); 
    }
    
    public static String DeleteExistingFile(String filename) throws IOException {
        //get current project path
        String filePath = System.getProperty("user.dir") + "\\Download\\";
        //create a new file
        File file = new File(filePath + "\\" + filename);
        if (!file.exists()) {
		    //file.createNewFile();
		  return "File does not exist";
		} else {
		    //delete a file
			
		    file.delete();
		    return "File already exist" ;
		}
    }

    }