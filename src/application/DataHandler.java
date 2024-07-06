package application;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Properties;


public class DataHandler {
	
	private static String adminListFileName;
	private static String userListFileName;
	private static String billListFileName;
	
	public static void readProperties(Properties config) {
		adminListFileName = config.getProperty("adminlist.file");
		userListFileName = config.getProperty("userlist.file");
		billListFileName = config.getProperty("billslist.file");
	}

	
	
	// Serialize the object to a file
	public static void doSerialize(Object obj, String outputFile) throws IOException {
        FileOutputStream fileTowrite = new FileOutputStream(outputFile);
        ObjectOutputStream objTowrite = new ObjectOutputStream(fileTowrite);
        objTowrite.writeObject(obj);
        fileTowrite.close();
    }

    // Deserialize the Java object from a given file
    public static Object doDeserialize(String inputFile) throws IOException, ClassNotFoundException {
    	System.out.println(inputFile);
    	Object obj = new Object();
    	File f = new File (inputFile);
    	try {
	    	if (f.exists()) {
	    	FileInputStream fileToread = new FileInputStream(inputFile);
	        ObjectInputStream objToread = new ObjectInputStream(fileToread);
	    	 if (f.length() > 0) {
	    	    	System.out.println(inputFile);
	            obj = objToread.readObject();
	            objToread.close();
	    	   } else {
	    	    	System.out.println("=====");
	
	    		   System.out.println("File " + inputFile + " is empty");
	    	   }
	    	}
	    	  else {
	    		  System.out.println("File " + inputFile + " does not exist");
	    	  }
    	}
    	catch (Exception e) {
			// TODO: handle exception
    		System.out.println("Exception occured on File "+ e);
		}
        return obj;
    }
    
	public static void writeToFile(AdminList list) throws IOException {
	      doSerialize(list, adminListFileName);
	      System.out.println("The serialized objects " +"were written to "+ adminListFileName);	
	}
    
	public static AdminList readAdminList() throws IOException, ClassNotFoundException {
		System.out.println("__________"+adminListFileName);
		AdminList list = new AdminList();
		Object obj;
		obj = doDeserialize(adminListFileName);
		if (obj instanceof AdminList)
			list = (AdminList) obj;
		System.out.println("list size: "+list.getAdmins().size());
		
		// display list
		if (list.getAdmins().size() > 0) {
			System.out.println("Admin in the list are: ");
			for (int i = 0; i < list.getAdmins().size(); i++) {
				System.out.println("Admin Name: " + list.getAdmins().get(i));
			}
		}
		return list;
	}
	
	
	public static void writeToFile(UserList list) throws IOException {
	      doSerialize(list, userListFileName);
	      System.out.println("The serialized objects " +"were written to "+ userListFileName);	
	}
	
	public static UserList readUserList() throws IOException, ClassNotFoundException {
		UserList list = new UserList();
		Object obj = doDeserialize(userListFileName);
		if (obj instanceof UserList)
			list = (UserList) obj;
		System.out.println("list size: "+list.getUsers().size());
		
		// display list
		if (list.getUsers().size() > 0) {
			System.out.println("Users in the list are: ");
			for (int i = 0; i < list.getUsers().size(); i++) {
				System.out.println("User Name: " + list.getUsers().get(i));
			}
		}
		return list;
	}
	
	public static void writeToFile(BillAndPaymentList list) throws IOException {
	      doSerialize(list, billListFileName);
	      System.out.println("The serialized objects " +"were written to "+ billListFileName);	
	}
	
	public static BillAndPaymentList readeBillList() throws IOException, ClassNotFoundException {
		BillAndPaymentList list = new BillAndPaymentList();
		Object obj;
		obj =  doDeserialize(billListFileName);
		if (obj instanceof BillAndPaymentList)
			list = (BillAndPaymentList) obj;
		System.out.println("list size: "+list.getBills().size());
		
		// display list
		if (list.getBills().size() > 0) {
			System.out.println("Bills in the list are: ");
			for (int i = 0; i < list.getBills().size(); i++) {
				System.out.println("Bills are : " + list.getBills().get(i));
			}
		}
		return list;
	}
	

}
