/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jtbpbcheckerboard;

import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author jasminetan
 */
public class CheckerBoard {
    private AnchorPane anchorPane;
    private int numRows;
    private int numCols;
    private double rectHeight;
    private double rectWidth;
    private Color lightColor = Color.RED;
    private Color darkColor = Color.BLACK;
    private double width;
    private double height;
    private double boardWidth;
    private double boardHeight;

    public CheckerBoard(int numRows, int numCols, double boardWidth, double boardHeight){
        this(numRows,numCols,boardWidth,boardHeight,Color.RED,Color.BLACK);
    }
        
    public CheckerBoard(int numRows, int numCols, double boardWidth, double boardHeight, Color lightColor, Color darkColor){
        this.numRows = numRows;
        this.numCols = numCols;
        this.boardWidth = boardWidth;
        this.boardHeight = boardHeight;
        this.lightColor = lightColor;
        this.darkColor = darkColor; 
        this.rectWidth = this.boardWidth/this.numCols;
        this.rectHeight = this.boardHeight/this.numRows;   
    } 
    
    public AnchorPane build(){
        anchorPane = new AnchorPane();
        
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                Rectangle rect = new Rectangle(col*rectWidth,row*rectHeight, rectWidth, rectHeight);
                if((row+col)%2 == 0){
                    rect.setFill(lightColor);
                }
                else{
                    rect.setFill(darkColor);
                }
                anchorPane.getChildren().add(rect);
            }
        }
        return anchorPane;    
    }
    
    public AnchorPane getBoard(){
        return anchorPane;    
    }
    public int getNumRows(){
        return numRows;    
    }
    public int getNumCols(){
        return numCols;  
    }
    public double getWidth(){
        return width; 
    }
    public double getHeight(){
        return height;    
    }
    public Color getLightColor(){
        return lightColor;
    }
    public Color getDarkColor(){
        return darkColor;
    }
    public double getRectangleWidth(){
        return rectWidth;  
    }
    public double getRectangleHeight(){
        return rectHeight;   
    }
    
}
