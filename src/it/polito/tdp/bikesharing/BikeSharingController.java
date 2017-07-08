/**
 * Sample Skeleton for 'BikeSharing.fxml' Controller Class
 */

package it.polito.tdp.bikesharing;

import java.net.URL;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.bikesharing.model.Model;
import it.polito.tdp.bikesharing.model.Statistics;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;

public class BikeSharingController {
	
	private Model model;

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="datePicker"
    private DatePicker datePicker; // Value injected by FXMLLoader

    @FXML // fx:id="btnConta"
    private Button btnConta; // Value injected by FXMLLoader

    @FXML // fx:id="kSlider"
    private Slider kSlider; // Value injected by FXMLLoader

    @FXML // fx:id="btnSimula"
    private Button btnSimula; // Value injected by FXMLLoader

    @FXML // fx:id="txtMessage"
    private TextArea txtMessage; // Value injected by FXMLLoader

    @FXML
    void handleConta(ActionEvent event) {
    	    	
    	LocalDate date = datePicker.getValue();
    	
    	if(date==null){
    		txtMessage.setText("Inserire una data.\n");
    		return;
    	}
    	
    	List<Statistics> stats = model.getStats(date);
    	
    	if(stats==null){
    		txtMessage.setText("Non sono presenti viaggi relativi alla data indicata.\n");
    		return;
    	}
    	
    	Collections.sort(stats);
    	
    	txtMessage.clear();
    	
    	for(Statistics stat : stats){
    		txtMessage.appendText(String.format("%s %d %d\n", stat.getStation().getName(), stat.getPick(), stat.getDrop()));
    	}
    	    	
    	return;
    	
    }

    @FXML
    void handleSimula(ActionEvent event) {

    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert datePicker != null : "fx:id=\"datePicker\" was not injected: check your FXML file 'BikeSharing.fxml'.";
        assert btnConta != null : "fx:id=\"btnConta\" was not injected: check your FXML file 'BikeSharing.fxml'.";
        assert kSlider != null : "fx:id=\"kSlider\" was not injected: check your FXML file 'BikeSharing.fxml'.";
        assert btnSimula != null : "fx:id=\"btnSimula\" was not injected: check your FXML file 'BikeSharing.fxml'.";
        assert txtMessage != null : "fx:id=\"txtMessage\" was not injected: check your FXML file 'BikeSharing.fxml'.";

    }
    
    /**
	 * @param model the model to set
	 */
	public void setModel(Model model) {
		
		this.model = model;
		
	}
	
}
