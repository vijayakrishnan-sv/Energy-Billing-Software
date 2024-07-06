package application;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class homePageController
{
	
    @FXML 
    private Button loginButton;

    @FXML 
    private TextField userName;
    
    @FXML 
    private TextField password;
    
    @FXML 
    private Label outputLabel;
    
    @FXML
    private ImageView imageId;

    private Image book;
    
    private AdminList aList;
    
    // This method is called when the FXML file is loaded
    public void initialize() throws ClassNotFoundException, IOException {
  	  book = new Image("images/energy.jpg");
  	  imageId.setImage(book);
  	  
  	  aList = new AdminList();
  	  aList = DataHandler.readAdminList();
  }
    public boolean adminCheck(String userName,String password) {
    	for (int i=0; i<aList.getAdmins().size();i++) {
    		Admin  c = aList.getAdmins().get(i);
    		if(c.getUserName().equals(userName) && c.getPassword().equals(password)) {
    			return true;
    		}
    	}
    	return false;
    }
  
    
    // Event listener for the convertButton
    
    public void loginButtonListener (ActionEvent e) throws IOException
    { 
    	//String name = userName.getText();
    	//String pass = password.getText();
    	String name = userName.getText();
    	String pass = password.getText();
    	if(adminCheck(name,pass)) {
    		Parent parent = FXMLLoader.load(
 	               getClass().getResource("dashboardPage.fxml")); 
 	      // Build the scene graph.
 	      Scene scene = new Scene(parent); 
 	
 	      Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
 	      // Display our window, using the scene graph.
 	      stage.setTitle("Dashboard"); 
 	      stage.setScene(scene);
 	      stage.show(); 
    	}
    	else {
        outputLabel.setText("Invalid userName or password"); 
    	}
   }
    
   public void registrationButtonListener (ActionEvent e) throws IOException {
	   Parent parent = FXMLLoader.load(
	               getClass().getResource("DashboardPage.fxml")); 
	      // Build the scene graph.
	      Scene scene = new Scene(parent); 
	
	      Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
	      // Display our window, using the scene graph.
	      stage.setTitle("Dashboard"); 
	      stage.setScene(scene);
	      stage.show(); 
   }
}


