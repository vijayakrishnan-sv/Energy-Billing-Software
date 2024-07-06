package application;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;

public class UserAddController{
	
    @FXML 
    private Button save;

    @FXML 
    private TextField name;
    
    @FXML 
    private TextField address;
    
    @FXML 
    private TextField phoneNo;
    
    @FXML 
    private TextField pinCode;

    @FXML 
    private TextField houseNo;
    
    @FXML 
    private TextField email;
    
    @FXML 
    private TextField accountNo;
    
    @FXML 
    private TextField initMeterReading;
    
    @FXML
    private ComboBox<String> tariffComboBox;

    @FXML
    private ComboBox<String> meterComboBox;

    @FXML 
    private Label outputLabel;

    @FXML 
    private Label promptLabel;

    private String selectedTariff = "normal"; // initial default selection
	private String selectedMeterType = "standard";// initial default selection
	private UserList uList;
	private User user;
	double initReading = 0.0;
    // This method is called when the FXML file is loaded
    public void initialize() throws ClassNotFoundException, IOException 
    {   uList = new UserList();
    	tariffComboBox.getItems().addAll("normal","standard");
    	meterComboBox.getItems().addAll("standard", "economy");
    	uList = DataHandler.readUserList(); // read existing student list from file
    	user.setUserCount(uList.getUsers().size());
    	
    	phoneNo.textProperty().addListener(new ChangeListener<String>() {
    	    @Override
    	    public void changed(ObservableValue<? extends String> observable, String oldValue, 
    	        String newValue) {
    	        if (!newValue.matches("\\d*")) {
    	            phoneNo.setText(newValue.replaceAll("[^\\d]", ""));
    	        }
    	    }
    	});
    }
    
    public void ComboBoxListeners() {	
		tariffComboBox.valueProperty().addListener(new ChangeListener<String>() {
		        @Override public void changed(ObservableValue<? extends String> selected, String oldValue, String newValue) {
		        	selectedTariff = newValue;
		        }    
		    });
		meterComboBox.valueProperty().addListener(new ChangeListener<String>() {
		        @Override public void changed(ObservableValue<? extends String> selected, String oldValue, String newValue) {
		        	selectedMeterType = newValue;
		        }
  
		    });
	}
    
    public boolean formValidator() {
    	if (name.getText() == null || name.getText().trim().isEmpty() || address.getText() == null || address.getText().trim().isEmpty()
    		|| phoneNo.getText() == null || phoneNo.getText().trim().isEmpty() || pinCode.getText() == null || pinCode.getText().trim().isEmpty()
    		|| email.getText() == null || email.getText().trim().isEmpty() || houseNo.getText() == null || houseNo.getText().trim().isEmpty()
    		|| accountNo.getText() == null || accountNo.getText().trim().isEmpty())
		{
    		outputLabel.setText("Please fill all the fields"); 
    	    return false;
    	}
    	if (userExist()) {
			outputLabel.setText("User allready exist");
			return false;
    	}
    	try {
    		initReading = Double.parseDouble(initMeterReading.getText());
    	}
    	catch (Exception e) {
			// TODO: handle exception
    		outputLabel.setText("please enter the correct meter reading");
		}
    	return true;
    }
    
    
    
    public boolean userExist() {
    	for (int i=0; i<uList.getUsers().size();i++) {
    		User  c = uList.getUsers().get(i);
    		String key = c.getAccountNo();
    		if(key.equals(accountNo.getText())) {
    			return true;
    		}
    	}
    	return false;
    }
    
    // Event listener for the convertButton
    public void saveButtonListener() throws IOException 
    { 
    	if(formValidator()) {
	    	User obj = new User();
	    	obj.setName( name.getText() );
	    	obj.setAccountNo(accountNo.getText());
	    	obj.setAddress( address.getText() );
	    	obj.setPhoneNo( phoneNo.getText() );
	    	obj.setPincode( pinCode.getText() );
	    	obj.setEmail( email.getText() );
	    	obj.setMeterType( selectedMeterType );
	    	obj.setTariff( selectedTariff );
	    	obj.setHouseNo( houseNo.getText() );
	    	obj.setInitMeterReading(initReading);
			uList.addUser(obj);
			System.out.println(obj.toString());
			
			DataHandler.writeToFile(uList); 
	        outputLabel.setText("User added successfully"); 
    	}
   }
}