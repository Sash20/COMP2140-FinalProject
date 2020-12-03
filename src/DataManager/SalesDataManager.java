package DataManager;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class SalesDataManager {
	
	private Transaction sale;
	private File file;
	private Sales s1;
	private String fileName;
	private BufferedReader reader;
	private BufferedWriter writer;
	
	public SalesDataManager(){
		s1 = new Sales();
		newFile();
		readFile();
	}
	
	public void saveToFile() {
		//write to file
        try{
        	// Creates a file output stream to write to the file
            FileOutputStream writeData = new FileOutputStream("salesData.ser");
            
            // Handle the object to be written into the file that FileOutputStream created
            ObjectOutputStream writeStream = new ObjectOutputStream(writeData);

            // Tell the program to write this people object which is an ArrayList just created above into the file peopledata.ser
            writeStream.writeObject(s1.tempList());
            
            // Not really necessary but a good practice since it will flush all the data in the stream, make sure data is written into the file.
            writeStream.flush();
            
            // Stream closed after the writing is done. This also releases the system resources.
            writeStream.close();

        }catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public void readFile() {
		try{
			// Creates a file Input stream to read from the file
            FileInputStream readData = new FileInputStream("salesData.ser");
            
           // Handle the object to be read from the file that FileInputStream created
            ObjectInputStream readStream = new ObjectInputStream(readData);

            @SuppressWarnings("unchecked")
            // Create an ArrayList which then hosts the list in the Input stream
            ArrayList<Transaction> tempList = (ArrayList<Transaction>) readStream.readObject();
            s1.getSavedList(tempList);
            readStream.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
        
	}
	
	public void newFile() {
		file = new File("salesData.ser");

        try {
			if (file.createNewFile()) {
			    
			    System.out.println("File has been created.");
			} else {
			
			    System.out.println("File already exists.");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		SalesDataManager s1 = new SalesDataManager();
	}

}

