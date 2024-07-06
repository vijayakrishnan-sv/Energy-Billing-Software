package application;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.time.LocalDate;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
public class UserBillController {

	@FXML private TextField name;
	@FXML private TextField pinCode;
	@FXML private TextField houseNo;
	@FXML private TextField startReading;
	@FXML private TextField endReading;
	@FXML private DatePicker startDatePicker;
	@FXML private DatePicker endDatePicker;
	@FXML private Button addBillButton;
	@FXML private Label outputLabel;

	ArrayList<User> userList = new ArrayList<User>();;

	public void initialize() throws ClassNotFoundException 
    {
		userList = getUser();
    }
	
	public boolean userValidationCheck(String key1) {
		 boolean flag = false;
		 for (int i = 0; i < userList.size(); i++)
	      {
	    	     User  c =  (User) userList.get(i);
	    	     String name = c.getName();
	    	     String pincode = c.getPincode();
	    	     String houseNo = c.getHouseNo();
	    	     String key = name + pincode + houseNo;
	    	     if (key.equals(key1)) {
	    	    	 flag = true;
	    	     }
	      }
		return flag;
	}
	public ArrayList<User> getUser() throws ClassNotFoundException{
		ArrayList<User> userDetails = new ArrayList();
		try
		{
			   File f = new File("user.dat");
			   FileInputStream inStream;
			   ObjectInputStream objectInputFile = null;
		        if (f.exists())  {
					// Create the stream objects.
				       inStream =  new FileInputStream("user.dat");
				      objectInputFile = new ObjectInputStream(inStream);
		        }
		        else 
	        	 System.out.println("File does not exist");

	      
	      // Read the serialized objects from the file.
	 
	        if (f.length()>0) {
	        	userDetails = (ArrayList<User>) objectInputFile.readObject();
	        
	        }
	        objectInputFile.close();

		} catch(IOException e) {
			System.out.println("OOps...there was a problem");
			e.printStackTrace();
		}
		return userDetails;
	}
	public void addBillButtonListener() 
    { 
    	ArrayList<BillAndPayment> list = new ArrayList<BillAndPayment>();

    	BillAndPayment obj = new BillAndPayment();
    	LocalDate startDate = startDatePicker.getValue();
    	LocalDate endDate = endDatePicker.getValue();
    	double staReading = Double.parseDouble(startReading.getText());
    	double enReading = Double.parseDouble(endReading.getText());
    	obj.setName( name.getText() );
    	obj.setPincode( pinCode.getText() );
    	obj.setHouseNO( houseNo.getText() );
    	obj.setStartReading(staReading);
    	obj.setEndReading(enReading);
    	obj.setStartDate(startDate);
    	obj.setEndDate(endDate);
    	String key = obj.getName() + obj.getPincode() + obj.getHouseNO();
    	boolean flag = userValidationCheck(key);
    	if (flag == true) {
    		list.add(obj);
    		System.out.println("____________" + list.size());
    		DataHandler.writeToFile(list,"bills.dat"); 
			outputLabel.setText("Bill added successfully"); 
       }
    	else {
    		outputLabel.setText("No user found, please add the user and try again"); 
    	}
    }
		

}
