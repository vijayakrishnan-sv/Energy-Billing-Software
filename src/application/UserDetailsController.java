package application;

import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ResourceBundle;

import javax.security.auth.login.AccountNotFoundException;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class UserDetailsController implements Initializable {
	 
	
	@FXML
    private TextField acountNo;

    @FXML
    private TextField address;

    @FXML
    private TextField email;

    @FXML
    private TextField houseNo;

    @FXML
    private TextField meterType;

    @FXML
    private TextField name;

    @FXML
    private TextField phoneNo;

    @FXML
    private TextField pinCode;

    @FXML
    private TextField tariff;
	 
    public void initialize() {}  
	
    @Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

	
    public void setUserData(User obj) {
    	acountNo.setText(obj.getAccountNo());
    	address.setText(obj.getAddress());
    	email.setText(obj.getEmail());
    	houseNo.setText(obj.getHouseNo());
    	meterType.setText(obj.getMeterType());
    	name.setText(obj.getName());
    	phoneNo.setText(obj.getPhoneNo());
    	pinCode.setText(obj.getPincode());
    	tariff.setText(obj.getTariff());
    }
		


	
}
