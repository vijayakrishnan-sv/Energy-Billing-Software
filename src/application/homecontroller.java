package application;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;


public class homecontroller {
	
	@FXML
	private BorderPane bp;
	
	@FXML
	private AnchorPane ap;
	
	@FXML
	private AnchorPane ap1;
	
	@FXML
	private Button home;

	public void homlist(ActionEvent e) throws IOException {
    	Parent parent = FXMLLoader.load(
	               getClass().getResource("next.fxml")); 
	      
	      // Build the scene graph.
	      
	      bp.setCenter(parent);
    }

	
		
	}

