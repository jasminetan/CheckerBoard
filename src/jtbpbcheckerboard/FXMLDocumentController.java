/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jtbpbcheckerboard;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author jasminetan
 */
public class FXMLDocumentController implements Initializable {
    
    private Stage stage;
    private CheckerBoard checkerBoard;
    private int paneWidth;
    private int paneHeight;
    
    @FXML
    private MenuBar menuBar;
    @FXML
    private VBox root;
    @FXML
    private AnchorPane board;
    
    @FXML
    private void handle3(ActionEvent event) {
        clearAnchorPane();
        checkerBoard = new CheckerBoard(3, 3, board.getWidth(), board.getHeight(), checkerBoard.getLightColor(), checkerBoard.getDarkColor());
        board.getChildren().add(checkerBoard.build());
    }
        
    @FXML
    private void handle8(ActionEvent event) {
        clearAnchorPane();
        checkerBoard = new CheckerBoard(8, 8, board.getWidth(), board.getHeight(), checkerBoard.getLightColor(), checkerBoard.getDarkColor());
        board.getChildren().add(checkerBoard.build());
    }
    
    @FXML
    private void handle10(ActionEvent event) {
        clearAnchorPane();
        checkerBoard = new CheckerBoard(10, 10, board.getWidth(), board.getHeight(), checkerBoard.getLightColor(), checkerBoard.getDarkColor());
        board.getChildren().add(checkerBoard.build());
    }
    
    @FXML
    private void handle16(ActionEvent event) {
        clearAnchorPane();
        checkerBoard = new CheckerBoard(16, 16, board.getWidth(), board.getHeight(), checkerBoard.getLightColor(), checkerBoard.getDarkColor());
        board.getChildren().add(checkerBoard.build());
    }
    
    @FXML
    private void handleDefault(ActionEvent event) {
        clearAnchorPane();
        checkerBoard = new CheckerBoard(checkerBoard.getNumRows(), checkerBoard.getNumCols(), board.getWidth(), board.getHeight(), Color.RED, Color.BLACK);
        board.getChildren().add(checkerBoard.build());
    }
    
    @FXML
    private void handleBlue(ActionEvent event) {
        clearAnchorPane();
        checkerBoard = new CheckerBoard(checkerBoard.getNumRows(), checkerBoard.getNumCols(), board.getWidth(), board.getHeight(), Color.SKYBLUE, Color.DARKBLUE);
        board.getChildren().add(checkerBoard.build());
    }
    
    private void clearAnchorPane(){
        board.getChildren().clear();
    }
    
    private void update(int numRows, int numCols, Color lightColor, Color darkColor){
        clearAnchorPane();
        checkerBoard = new CheckerBoard(numRows, numCols, root.getWidth(), root.getHeight()-menuBar.getHeight(), lightColor, darkColor);
        board.getChildren().add(checkerBoard.build());
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    public void start(Stage stage){
        this.stage = stage;
        update(8, 8, Color.RED, Color.BLACK);
        
        ChangeListener<Number> lambdaChangeListener = (ObservableValue<? extends Number> observable, Number oldValue, final Number newValue) -> {
            update(checkerBoard.getNumRows(), checkerBoard.getNumCols(), checkerBoard.getLightColor(), checkerBoard.getDarkColor());
        };
        this.board.widthProperty().addListener(lambdaChangeListener);
        this.board.heightProperty().addListener(lambdaChangeListener);
        
        update(checkerBoard.getNumRows(), checkerBoard.getNumCols(), checkerBoard.getLightColor(), checkerBoard.getDarkColor()); 
    }
    
}
