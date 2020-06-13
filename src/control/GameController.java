package control;

/**
 * @author Johan Camilo Cortés Ocampo
 * Código: A00346571
 * 20/08/2018
 */

import model.Matriz;
import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

public class GameController implements Initializable{
	
	public final int MAX_TRACKS = 3;

    @FXML
    private Button trackButton;
    
	@FXML
	private Label countOfMinesLabel;

    @FXML
    private Label outcomeLabel;

	@FXML
	private GridPane gridPane;
	
    private Matriz board;
    private int countOfMines, amountOfMines, numberOfRows, numberOfColumns, trackCount;
    
    public void createMatrix(int rows, int columns, int mines) {
    	board = new Matriz(rows, columns, mines);
    	numberOfRows = rows;
    	numberOfColumns = columns;
    	amountOfMines = mines;
    	trackCount = MAX_TRACKS;
    	trackButton.setText(Integer.toString(trackCount));
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		countOfMines = 0;
	}
	
    @FXML
	public void clickOnBox(MouseEvent event) {
		int index = gridPane.getChildren().indexOf((Button)event.getSource());
		int column = GridPane.getColumnIndex((Button) event.getSource());
		int row = GridPane.getRowIndex((Button) event.getSource());
		
		if(event.getButton().equals(MouseButton.PRIMARY)) {
			openBox(row, column, index);
		}
		if(event.getButton().equals(MouseButton.SECONDARY)) {
			putMark(row, column, index);
		}
	}
    
	private void openBox(int row, int column, int index) {
		
		if(board.darCasilla(row, column).hayMina()) {
			showSolution();
			outcomeLabel.setText("YOU LOSE!");
			outcomeLabel.setStyle("-fx-text-fill: red;");
			outcomeLabel.setVisible(true);
		}
		else {
			((Button)gridPane.getChildren().get(index)).setText(Integer.toString(board.darCasilla(row, column).darCantidadMinasAlrededor()));
			((Button)gridPane.getChildren().get(index)).setDisable(true);
			board.darCasilla(row, column).cubrir(false);
			if(board.casillasDescubiertas() == (gridPane.getChildren().size()-amountOfMines)) {
				showSolution();
				outcomeLabel.setStyle("-fx-text-fill: green;");
				outcomeLabel.setVisible(true);
			}
		}
	}
	
	private void showSolution() {
		int row = 0, column = 0;
		for(int i = 0; i < (numberOfRows*numberOfColumns); i++) {
			if(board.darCasilla(row, column).hayMina()) {
				((Button)gridPane.getChildren().get(i)).setText("X");
				((Button)gridPane.getChildren().get(i)).setStyle("-fx-text-fill: red;");
			}
			else {
				((Button)gridPane.getChildren().get(i)).setText(Integer.toString(board.darCasilla(row, column).darCantidadMinasAlrededor()));
			}
			((Button)gridPane.getChildren().get(i)).setDisable(true);
			column++;
			if(column == numberOfColumns) {
				column = 0;
				row++;
			}
		}
		trackButton.setDisable(true);
	}
	
	private void putMark(int row, int column, int index) {
		if(board.darCasilla(row, column).estaMarcada()) { 					
			((Button)gridPane.getChildren().get(index)).setText("");
			board.darCasilla(row, column).establecerMarca(false);
		}
		else {
			if(board.darCasilla(row, column).hayMina()) {
				countOfMines++;
				countOfMinesLabel.setText(Integer.toString(countOfMines));
				if(countOfMines == amountOfMines) {
					outcomeLabel.setStyle("-fx-text-fill: green;");
					outcomeLabel.setVisible(true);
				}
			}
			((Button)gridPane.getChildren().get(index)).setText("!");
			board.darCasilla(row, column).establecerMarca(true);
		}
		
	}

    @FXML
    public void trackButtonClicked(ActionEvent event) {
    	if(trackCount == 0) {
    		JOptionPane.showMessageDialog(null, "No puedes pedir más pistas.");
    	}
    	else {
    		int row = 0, column = 0, index = 0;
    		boolean stop = false;
    		for(int i = 0; i < numberOfRows && !stop; i++) {
	    		for(int j = 0; j < numberOfColumns && !stop; j++) {
	    			if(board.darCasilla(i, j).estaCubierta() && !board.darCasilla(i, j).hayMina() && board.darCasilla(i, j).darCantidadMinasAlrededor() > 0) {
	    				stop = true;
	    				row = i;
	    				column = j;
	    				index--;
	    			}
	    			index++;
	    		}
    		}
    		trackCount--;
    		trackButton.setText(Integer.toString(trackCount));
    		openBox(row, column, index);
    	}
    }
}