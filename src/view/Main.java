package view;
	
/**
 * @author Johan Camilo Cort�s Ocampo
 * C�digo: A00346571
 * 20/08/2018
 */

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;

public class Main extends Application {
	public static Stage stage;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/view/MenuWindow.fxml"));
			Scene scene = new Scene(root);
			Main.stage = primaryStage;
			stage.setTitle("Buscaminas");
			stage.setResizable(false);
			stage.setScene(scene);
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
