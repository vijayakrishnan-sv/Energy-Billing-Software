package application;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Observable;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;

public class listUserController {
	
	@FXML private TableView<User> tableView;
	@FXML private TableColumn<User, String> nameColumn;
	@FXML private TableColumn<User, String> pincodeColumn;
	@FXML private TableColumn<User, String> tariffColumn;
	@FXML private TableColumn<User, String> meterTypeColumn;
	@FXML private TableColumn<User, String> houseNoColumn;
	

public void initialize() throws ClassNotFoundException {
	  nameColumn.setCellValueFactory(new PropertyValueFactory<User, String>("name"));
	  pincodeColumn.setCellValueFactory(new PropertyValueFactory<User, String>("pincode"));
	  tariffColumn.setCellValueFactory(new PropertyValueFactory<User, String>("tariff"));
	  meterTypeColumn.setCellValueFactory(new PropertyValueFactory<User, String>("meterType"));
	  houseNoColumn.setCellValueFactory(new PropertyValueFactory<User, String>("houseNo"));
	  tableView.setItems(getUser());
}

public ObservableList<User> getUser() throws ClassNotFoundException{
	ArrayList<User> userDetails = new ArrayList();
	ObservableList<User> finalList = FXCollections.observableArrayList();
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
        	for (int i = 0; i < userDetails.size(); i++)
  	      {
  	    	     User  c =  (User) userDetails.get(i);
  	    	     finalList.add(c);
  	         
  	      }
        
        }
        objectInputFile.close();

	} catch(IOException e) {
		System.out.println("OOps...there was a problem");
		e.printStackTrace();
	}
	return finalList;
}
}