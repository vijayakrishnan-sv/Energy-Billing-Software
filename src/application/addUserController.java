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
import javafx.scene.control.TextField;

public class addUserController{
	
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
    private TextField email;
    
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
	
    // This method is called when the FXML file is loaded
    public void initialize() 
    {
    	tariffComboBox.getItems().addAll("normal","day night");
    	meterComboBox.getItems().addAll("standard", "economy");
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
		 System.out.println("-----------------------------"+selectedTariff);
		 System.out.println("-----------------------------"+selectedMeterType);
	}
    
    // Event listener for the convertButton
    public void saveButtonListener() 
    { 
    	ArrayList<User> list = new ArrayList<User>();
    	User obj = new User();
    	obj.setName( name.getText() );
    	obj.setAddress( address.getText() );
    	obj.setPhoneNo( phoneNo.getText() );
    	obj.setPincode( pinCode.getText() );
    	obj.setEmail( email.getText() );
    	obj.setMeterType( selectedMeterType );
    	obj.setTariff( selectedTariff );
		list.add(obj);
		BinaryUtils.writeToFile(list,"user.dat"); 
        //outputLabel.setText("User added successfully"); 
   }
}