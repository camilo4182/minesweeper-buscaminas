package control;

/**
 * @author Johan Camilo Cort�s Ocampo
 * C�digo: A00346571
 * 20/08/2018
 */

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import view.Main;

public class MenuWindowController implements Initializable{

	@FXML
	private RadioButton beginnerRadioButton;

	@FXML
	private ToggleGroup difficultyGroup;

	@FXML
	private RadioButton avanzadoRadioButton;

	@FXML
	private Button playButton;
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}
	
	public void play(ActionEvent event) throws IOException {
		if(beginnerRadioButton.isSelected()) {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("/view/BeginnerDifficultyWindow.fxml"));
			Parent beginnerDifficultyScene = loader.load();
			
			GameController beginnerDifficultyController = loader.getController();
			beginnerDifficultyController.createMatrix(8, 8, 10);
			
			Stage stage2 = new Stage();
			stage2.setScene(new Scene(beginnerDifficultyScene));
			stage2.setTitle("Buscaminas");
			stage2.setResizable(false);
			stage2.show();
			Main.stage.close();
		}
		else if(avanzadoRadioButton.isSelected()) {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("/view/IntermediateDifficultyWindow.fxml"));
			Parent intermediateDifficultyScene = loader.load();
			
			GameController intermediateDifficultyController = loader.getController();
			intermediateDifficultyController.createMatrix(16, 16, 40);
			
			Stage stage2 = new Stage();
			stage2.setScene(new Scene(intermediateDifficultyScene));
			stage2.setTitle("Buscaminas");
			stage2.setResizable(false);
			stage2.show();
			Main.stage.close();
		}
		else {
			JOptionPane.showMessageDialog(null, "Debes elegir una opci�n.");
		}
	}	    
}
