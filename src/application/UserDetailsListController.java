package application;

import java.io.IOException;
import java.time.LocalDate;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class UserDetailsListController {
	 @FXML
	    private TableColumn<User, String> accountNo;

	    @FXML
	    private TableColumn<User, Double> electReading;

	    @FXML
	    private TableColumn<User, Double> gasReading;

	    @FXML
	    private TableColumn<User, String> name;

	    @FXML
	    private TableColumn<User, String> pinCode;

	    @FXML
	    private TableView<User> tableView;
	    
		private UserList uList;

	    public void initialize() throws ClassNotFoundException {
	  	  accountNo.setCellValueFactory(new PropertyValueFactory<User, String>("accountNo"));
	  	  name.setCellValueFactory(new PropertyValueFactory<User, String>("name"));
	  	  electReading.setCellValueFactory(new PropertyValueFactory<User, Double>("initMeterReading"));
	  	  gasReading.setCellValueFactory(new PropertyValueFactory<User, Double>("gasReading"));
	  	  pinCode.setCellValueFactory(new PropertyValueFactory<User, String>("pincode"));
	  	  tableView.setItems(getBills());
	    }
	    
	    public ObservableList<User> getBills() throws ClassNotFoundException{
	    	ObservableList<User> finalList = FXCollections.observableArrayList();
	    	try
	    	{
	    	    uList = new UserList();
	    		uList = DataHandler.readUserList();
	    		for (int i=0; i<uList.getUsers().size();i++) {
	    			User  c = uList.getUsers().get(i);
	        		finalList.add(c);
	        	}

	    	} catch(IOException e) {
	    		System.out.println("OOps...there was a problem");
	    		e.printStackTrace();
	    	}
	    	return finalList;
	    }
	    
	    
}
