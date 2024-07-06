package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class dashboardController {
	@FXML
	private BorderPane bp;
	
	@FXML
	private AnchorPane ap;
	
	@FXML
	private AnchorPane ap1;
	
	@FXML
	private Button addAdminButton;
	@FXML
	private Button addUserButton;
	@FXML
	private Button listUserButton;
	@FXML
	private Button searchUserButton;
	@FXML
	private Button addBillButton;
	@FXML
	private Button viewBillButton;
	
	public void createAdminListener(ActionEvent e) throws IOException {
    	Parent parent = FXMLLoader.load(
	               getClass().getResource("AddAdmin.fxml")); 
	      
	      // Build the scene graph.
	      
	      bp.setCenter(parent);
    }
	public void addUserListener(ActionEvent e) throws IOException {
    	Parent parent = FXMLLoader.load(
	               getClass().getResource("addUser.fxml")); 
	      
	      // Build the scene graph.
	      
	      bp.setCenter(parent);
    }
	public void listUserListener(ActionEvent e) throws IOException {
    	Parent parent = FXMLLoader.load(
	               getClass().getResource("UserDetailsList.fxml")); 
	      
	      // Build the scene graph.
	      
	      bp.setCenter(parent);
    }
	public void searchUserListener(ActionEvent e) throws IOException {
    	Parent parent = FXMLLoader.load(
	               getClass().getResource("UserSearch.fxml")); 
	      
	      // Build the scene graph.
	      
	      bp.setCenter(parent);
    }
	public void addBillListener(ActionEvent e) throws IOException {
    	Parent parent = FXMLLoader.load(
	               getClass().getResource("UserAddBill.fxml")); 
	      
	      // Build the scene graph.
	      
	      bp.setCenter(parent);
    }
	public void viewBillListener(ActionEvent e) throws IOException {
    	Parent parent = FXMLLoader.load(
	               getClass().getResource("BillListPage.fxml")); 
	      
	      // Build the scene graph.
	      
	      bp.setCenter(parent);
    }
}
