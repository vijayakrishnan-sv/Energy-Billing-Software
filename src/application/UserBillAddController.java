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
public class UserBillAddController {

	@FXML private TextField accountNo;
	@FXML private TextField electricityReading;
	@FXML private TextField gasReading;
	@FXML private DatePicker startDatePicker;
	@FXML private DatePicker endDatePicker;
	@FXML private Button addBillButton;
	@FXML private Label outputLabel;

	private BillAndPaymentList bList;
	private BillAndPayment bill;
	private UserList uList;
	private User user;
	
	public void initialize() throws ClassNotFoundException, IOException 
    {
		bList = new BillAndPaymentList();
		bList = DataHandler.readeBillList(); // read existing student list from file
    	bill.setBillCount(bList.getBills().size());
    
    	uList = new UserList();
    	uList = DataHandler.readUserList(); // read existing student list from file
    	user.setUserCount(uList.getUsers().size());
    }
	
	private void updateUserList(User obj) throws IOException {
		UserList newList = new UserList();
		for (int i=0; i<uList.getUsers().size();i++) {
    		User  c = uList.getUsers().get(i);
    		String key = c.getAccountNo();
    		if(key.equals(obj.getAccountNo())) {
    			c = obj;
    		}
    		newList.addUser(c);
    	}
		DataHandler.writeToFile(newList); 
	}
	
	private User formValidation() {
    	User userObj = null;
    	double endElectricReading = 0.0;
    	double endGasReading = 0.0;
    	try {
	    	for (int i=0; i<uList.getUsers().size();i++) {
	    		User  c = uList.getUsers().get(i);
	    		String key = c.getAccountNo();
	    		if(key.equals(accountNo.getText())) {
	    			userObj = c;
	    		}
	    	}
		}catch (Exception e) {
			outputLabel.setText("Please check the Account Number"); 
			return null;
		}
    	if (userObj == null ) { 
    		outputLabel.setText("Please check the Account Number"); 
    		return null; }
    	
		try {
			endElectricReading = Double.parseDouble(electricityReading.getText());
			endGasReading = Double.parseDouble(gasReading.getText());
		}catch (Exception e) {
			outputLabel.setText("Please check the readings and try again");
			return null;
		}
		
		try {
			if(userObj.getInitMeterReading() >= endElectricReading) {
				outputLabel.setText("Electricity meter Reading is too low with respect to the last bill");
				return null;
			}
			if(userObj.getGasReading() >= endGasReading) {
				outputLabel.setText("Gas meter Reading is too low with respect to the last bill"); 
				return null; 
			}
		}catch (Exception e) {
			outputLabel.setText("Please check the readings and try again"); 
			return null;
		}
    	
    	return userObj;
    }
	
	public void addBillButtonListener() throws IOException, ClassNotFoundException 
    { 

    	User userObj = formValidation(); 
    	if (userObj != null) {
    		BillAndPayment obj = new BillAndPayment();
	    	obj.setAccountNo(accountNo.getText());
	    	obj.setStartDate(startDatePicker.getValue());
	    	obj.setEndDate(endDatePicker.getValue());
	    	obj.setEleStartReading(userObj.getInitMeterReading());
	    	obj.setGasStartReading(userObj.getGasReading());
	    	double endElectricReading = Double.parseDouble(electricityReading.getText());
	    	obj.setEleEndReading(endElectricReading);
	    	double endGasReading = Double.parseDouble(gasReading.getText());
	    	obj.setGasEndReading(endGasReading);
	    	obj.setPayment(false);
	    	obj.setPaymentText("Pending");
	    	obj.setBillNo();
	    	obj.setBillDate();
			obj.setAmount(BillCalculation.finalBillCalculation(obj));
			bList.addBill(obj);
			System.out.println(obj.toString());
    		DataHandler.writeToFile(bList);
    		
    		userObj.setInitMeterReading(endElectricReading);
    		userObj.setGasReading(endGasReading);
    		updateUserList(userObj);
			outputLabel.setText("Bill added successfully"); 
       }
    
    }
		

}
