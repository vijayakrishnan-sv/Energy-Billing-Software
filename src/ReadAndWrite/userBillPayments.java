package ReadAndWrite;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


public class userBillPayments {
	
	public static void writeToFile(ArrayList dataList, String fileName)  {
		
		 try
		 {
		 // Create the stream objects.
	      FileOutputStream outStream = 
	                new FileOutputStream(fileName);
	      ObjectOutputStream objectOutputFile = 
	                new ObjectOutputStream(outStream);
	      
	      // Write the serialized objects to the file.
	      for (int i = 0; i < dataList.size(); i++)
	      {
	         objectOutputFile.writeObject(dataList);
	      }
	      
	      // Close the file.
	      objectOutputFile.close();
	      
		 } catch(IOException e)
		 {
			 System.out.println("OOps...there was a problem");
			 e.printStackTrace();
		 }
	}
	

}
