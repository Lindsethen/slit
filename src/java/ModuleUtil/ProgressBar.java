package ModuleUtil;

import java.awt.*;
import java.awt.Event.*;
import javax.swing.*;
import java.sql.*;



/**
 *
 * @author legob
 */
public class ProgressBar implements ActionListener {
    
    private Connection conn = null;
    private Statement stmt = null;
    private int maxPercentage = 100;
    private int minPercentage = 0;
    private int percentageCounter;
    
    public ProgressBar(){
        
        JProgressBar ProgressBar = new JProgressBar(0, 100);
    
    }
    
// Endre på denne slik at prosentandelen blir auka basert på mengde innleveringar.   
public void AssignmentDelivered(){

    percentageCounter++;

}    
    
public void showPercentageAmount(){
    
    while(percentageCounter < maxPercentage){


} 
    
}
    
public void raisePercentage(int percentageAmount){

int percentage = percentageAmount + percentageAmount;

}
    
    
    
}
