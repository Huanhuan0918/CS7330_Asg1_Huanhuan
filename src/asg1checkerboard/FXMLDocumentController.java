/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asg1checkerboard;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author Molamola
 */
public class FXMLDocumentController implements Initializable {
    private Stage stage;
    // parameters for initial settings
    private int numRows = 8;
    private int numCols = 8;
    private double boardWidth;
    private double boardHeight;  
    private Color lightColor = Color.RED;
    private Color darkColor = Color.BLACK;
    private CheckerBoard checkerBoard;
    private AnchorPane anchorPane;
    @FXML
    private VBox vBox;
    
    @FXML
    private MenuBar menuBar;
    
    public void ready(Stage stage){
        // set up the initial checker  board
        this.stage = stage;
        boardWidth = vBox.getWidth();
        boardHeight = vBox.getHeight() - menuBar.getHeight();
        checkerBoard = new CheckerBoard(numRows, numCols, boardWidth, boardHeight, lightColor, darkColor);
        anchorPane = checkerBoard.build();
        vBox.getChildren().add(anchorPane);
        // initialize listener that allows resize of checker board
        ChangeListener<Number> listener = (ObservableValue<? extends Number> observable, Number oldValue, final Number newValue)->{
            boardWidth = vBox.getWidth();
            boardHeight = vBox.getHeight() - menuBar.getHeight();
            vBox.getChildren().remove(checkerBoard.getBoard());
            checkerBoard = new CheckerBoard(checkerBoard.getNumRows(),checkerBoard.getNumCols(),boardWidth,boardHeight,checkerBoard.getLightColor(),checkerBoard.getDarkColor());
            anchorPane = checkerBoard.build();
            vBox.getChildren().add(anchorPane);
        };
        stage.widthProperty().addListener(listener);
        stage.heightProperty().addListener(listener);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void handleGridSize16(ActionEvent event) {
        changeGrid(16,16);
    }
    
    @FXML
    private void handleGridSize10(ActionEvent event) {        
        changeGrid(10,10); 
    }
    
    @FXML
    private void handleGridSize8(ActionEvent event) {
        changeGrid(8,8);
    }
    
    @FXML
    private void handleGridSize3(ActionEvent event) {        
        changeGrid(3,3);
    }
    
    @FXML
    private void handleColorDefault(ActionEvent event) {
        changeColor(Color.RED,Color.BLACK);
    }
    
    @FXML
    private void handleColorBlue(ActionEvent event) {
        changeColor(Color.SKYBLUE,Color.DARKBLUE);
    }
    
    private void changeGrid(int newCols, int newRows){
        vBox.getChildren().remove(checkerBoard.getBoard());
        checkerBoard = new CheckerBoard( newRows, newCols, checkerBoard.getBoardWidth(),checkerBoard.getBoardHeight(),lightColor,darkColor);
        anchorPane = checkerBoard.build();
        vBox.getChildren().add(anchorPane);
    }
    private void changeColor(Color newLightColor, Color newDarkColor){
        vBox.getChildren().remove(checkerBoard.getBoard());
        checkerBoard = new CheckerBoard( checkerBoard.getNumRows(), checkerBoard.getNumCols(), checkerBoard.getBoardWidth(),checkerBoard.getBoardHeight(),newLightColor, newDarkColor);
        anchorPane = checkerBoard.build();
        vBox.getChildren().add(anchorPane);
    }
}
