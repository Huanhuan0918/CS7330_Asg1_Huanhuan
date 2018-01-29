/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asg1checkerboard;

import static java.lang.Math.ceil;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
/**
 *
 * @author Molamola
 */
public class CheckerBoard {
    
    private int numCols;
    private int numRows;
    private double boardWidth;
    private double boardHeight;
    
    private Color lightColor = Color.RED;
    private Color darkColor = Color.BLACK;
    
    private AnchorPane anchorPane;
    
    public CheckerBoard(int numRows, int numCols, double boardWidth, double boardHeight){
        this.numRows = numRows;
        this.numCols = numCols;
        this.boardWidth = boardWidth;
        this.boardHeight = boardHeight;
    }
    
    public CheckerBoard(int numRows, int numCols, double boardWidth, double boardHeight, Color lightColor, Color darkColor){
        this(numRows,numCols,boardWidth,boardHeight);
        this.lightColor = lightColor;
        this.darkColor = darkColor;
    }
    /**
     *  builds the board UI and returns an AnchorPane as the root object
     */
    public AnchorPane build(){
        anchorPane = new AnchorPane();
        // compute the size of each grid
        double rectangleWidth = boardWidth/numCols;
        double rectangleHeight = boardHeight/numRows;
        // draw checker board
        Color tmpColor;
        for(int i = 0; i < numCols; i++){
            for(int j = 0; j < numRows ; j++){
                tmpColor = ((i + j) % 2 == 1) ? darkColor : lightColor;
                Rectangle tmpGrid = new Rectangle(rectangleWidth, rectangleHeight,tmpColor);
                tmpGrid.setLayoutX(i * rectangleWidth);
                tmpGrid.setLayoutY(j * rectangleHeight);
                anchorPane.getChildren().add(tmpGrid);
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
    
    public double getBoardWidth(){
        return boardWidth;
    }
    
    public double getBoardHeight(){
        return boardHeight;
    }
    
    public Color getLightColor(){
        return lightColor;
    }
    
    public Color getDarkColor(){
        return darkColor;
    }
}
    
