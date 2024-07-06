package application;

import java.io.IOException;
import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class AdminAddController {

	@FXML 
    private TextField userName;
    
    @FXML 
    private TextField password;
    
    @FXML 
    private TextField rePassword;
    
    @FXML 
    private Button create;

    @FXML 
    private Label outputLabel;
    
	private AdminList aList;
	private Admin admin;
    
    public void initialize() throws ClassNotFoundException, IOException {
    	aList = new AdminList();
    	aList = DataHandler.readAdminList(); // read existing student list from file
    	admin.setadminCount(aList.getAdmins().size());
    }
    
    public boolean userNameExist() {
    	for (int i=0; i<aList.getAdmins().size();i++) {
    		Admin  c = aList.getAdmins().get(i);
    		if(c.getUserName().equals(userName.getText())) {
    			return true;
    		}
    	}
    	return false;
    }
    
    public boolean formValidation() {
    	if (userName.getText() == null || userName.getText().trim().isEmpty() || password.getText() == null || password.getText().trim().isEmpty()
    			|| rePassword.getText() == null || rePassword.getText().trim().isEmpty() )
		{
    		outputLabel.setText("Please fill all the fields"); 
    	    return false;
    	}
    	if (! password.getText().equals(rePassword.getText())) {
    		outputLabel.setText("Password doesn't match"); 
    		return false;
    		}
    	if (userNameExist()) {
			outputLabel.setText("User name allready exist");
			return false;
		}
    	
    	return true;
    }
    
    public void createButtonListener() throws IOException 
    { 
    	if (formValidation()) {
			admin = new Admin();
			admin.setUserName(userName.getText());
			admin.setPassword(password.getText());
			aList.addAdmin(admin);
			DataHandler.writeToFile(aList);
	        outputLabel.setText("Admin added successfully"); 
    	}
    	
    	
   }
}
    

