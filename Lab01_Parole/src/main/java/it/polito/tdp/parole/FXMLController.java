package it.polito.tdp.parole;

import it.polito.tdp.parole.model.Parole;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	Parole elenco ;
	List<String> risultato = new ArrayList<String>();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtParola;

    @FXML
    private Button btnInserisci;

    @FXML
    private TextArea txtResult;

    @FXML
    private Button btnReset;

    @FXML
    void doInsert(ActionEvent event) {
    	
    	String parolaNuova = txtParola.getText();
    	char[] verificaParola = parolaNuova.toCharArray();
    	
//    	StringBuilder sb = new StringBuilder();
    	
    	for(char c : verificaParola) {
    		if(Character.isDigit(c)) {
//    			txtResult.setText("Inserire solo caratteri alfabetici");
    			txtResult.appendText("ERRORE: inserire solo caratteri alfabetici \n");
    			txtParola.clear();
    			return;
    		} else {
    			// Converto per questioni di uniformità, tutte le parole in modo che abbiano la prima lettera Maiuscola e
    			// il resto del testo in minuscolo!
//    			parolaNuova = parolaNuova.toLowerCase();
    			parolaNuova = parolaNuova.substring(0, 1).toUpperCase() + parolaNuova.substring(1).toLowerCase();
    		}
    	}
    	
    	
    	txtResult.clear();
    	
    	elenco.addParola(parolaNuova);
//    	txtResult.appendText(elenco.toString()); 
    	risultato = elenco.getElenco();
    	for(String s : risultato) {
    		txtResult.appendText(s);
    		txtResult.appendText("\n");
    	}
    	
    	txtParola.clear();
    	
    }

    @FXML
    void doReset(ActionEvent event) {
    	txtResult.clear();
    	elenco.reset();
    }

    @FXML
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnInserisci != null : "fx:id=\"btnInserisci\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";

        elenco = new Parole() ;
    }
}
