package application;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class ListBillsController {
	
	
	    @FXML
	    private TableColumn<BillAndPayment, String> accountNo;

	    @FXML
	    private TableColumn<BillAndPayment, String> amount;

	    @FXML
	    private TableColumn<BillAndPayment, String> enddate;

	    @FXML
	    private TableColumn<BillAndPayment, String> payment;

	    @FXML
	    private TableColumn<BillAndPayment, String> startdate;

	    @FXML
	    private TableView<BillAndPayment> tableView;

	    @FXML
	    private Button viewBill;

	    @FXML
	    void billDetailsListener(ActionEvent event) throws ClassNotFoundException, IOException {
				 
			 FXMLLoader loader= new FXMLLoader(getClass().getResource("BillDashboard.fxml"));
			 Parent root = (Parent)loader.load(); 
			 BillDashboardController billDetails = loader.getController();
			 BillAndPayment bill = tableView.getSelectionModel().getSelectedItem();
			 billDetails.setBillData(bill);
			 Stage stage = new Stage();
		      stage.setTitle("Bill Details"); 
		      stage.setScene(new Scene(root));
		      stage.show(); 
			      
	    }
	
	private UserList uList;
	private BillAndPaymentList bList;


public void initialize() throws ClassNotFoundException {
	  accountNo.setCellValueFactory(new PropertyValueFactory<BillAndPayment, String>("accountNo"));
	  amount.setCellValueFactory(new PropertyValueFactory<BillAndPayment, String>("amount"));
	  enddate.setCellValueFactory(new PropertyValueFactory<>("enddate"));
	  payment.setCellValueFactory(new PropertyValueFactory<BillAndPayment, String>("payment"));
	  startdate.setCellValueFactory(new PropertyValueFactory<>("startdate"));
	  tableView.setItems(getBills());
}

public ObservableList<BillAndPayment> getBills() throws ClassNotFoundException{
	ObservableList<BillAndPayment> finalList = FXCollections.observableArrayList();
	try
	{
	    bList = new BillAndPaymentList();
		bList = DataHandler.readeBillList();
		for (int i=0; i<bList.getBills().size();i++) {
			BillAndPayment  c = bList.getBills().get(i);
    		finalList.add(c);
    	}

	} catch(IOException e) {
		System.out.println("OOps...there was a problem");
		e.printStackTrace();
	}
	return finalList;
}
}