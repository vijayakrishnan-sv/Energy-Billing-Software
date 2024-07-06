package application;

import java.io.IOException;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import application.UserDetailsController.*;
public class SearchUserController {
	 @FXML private Button searchButton;
	 
	 @FXML private TextField accountNo;
	 
	 @FXML private Label outputLabel;
	 
	 private UserList uList;
	 private User user;
	 
	 public void initialize() throws ClassNotFoundException, IOException 
	    {   uList = new UserList();
	    	uList = DataHandler.readUserList(); // read existing student list from file
	    	user.setUserCount(uList.getUsers().size());
	    }

	 
	 
	 public void searchButtonListener(ActionEvent e) throws IOException{
	 	boolean flag = false;
	 	User userObj = new User();
		 for (int i=0; i<uList.getUsers().size();i++) {
	    		User  c = uList.getUsers().get(i);
	    		String key = c.getAccountNo();
	    		if(key.equals(accountNo.getText())) {
	    			userObj = c;
	    			flag = true;
	    		}
	    	}
		 
		 if (flag) {
			 
			 FXMLLoader loader= new FXMLLoader(getClass().getResource("userDetails.fxml"));
			 Parent root = (Parent)loader.load(); 
			 UserDetailsController userDetails = loader.getController();
			 userDetails.setUserData(userObj);
			 Stage stage = new Stage();
		      stage.setTitle("User Details"); 
		      stage.setScene(new Scene(root));
		      stage.show(); 
		      
		 }
		 else {
			 outputLabel.setText("No User Found");
		 }
	    }
}
