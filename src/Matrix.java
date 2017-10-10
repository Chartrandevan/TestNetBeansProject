/**
 * @(#)Matrix.java
 *
 *
 * @author 
 * @version 1.00 2014/10/6
 */

import java.io.*;

public class Matrix { // begin Matrix

	// *********** class constants ***********
	
	private static final int MAXROW = 5;		// max rows and cols of matrix
	private static final int MAXCOL = 5;

	int[][] table = new int[MAXROW][MAXCOL];	// matrix
	int rows, cols;								// actual rows and cols of matrix

    public Matrix() {  // begin constructor
    	rows = 0;
    	cols = 0;		// set rows and cols to 0 for empty matrix
    }  // end constructor
    
    public Matrix(BufferedReader fin, int r, int c)throws IOException{

 		rows = 	r;
 		cols = c;		// set matrix dimensions
 		String strin;	// input string
 		String delim = "[ ]+";		// delimiter for input string
 		
 		System.out.println("constructor: rows: " + rows + " cols: " + cols);
 		
 		strin = fin.readLine();
 		String[] tokens = strin.split(delim);
 		int k = 0; 		
 		for(int i = 0; i < rows; i++){
 			for(int j = 0; j < cols; j++){
 				table[i][j] = Integer.parseInt(tokens[k++]);
 			} // end for int j
 		} // end for int i	
    	
    	printMatrix();
    }  // end inited constructor
    
    // **************** observers ***********************
    /* verify the indicated operation
     * takes another Matrix object as a parameter
     * takes a char: the operator as a parameter
     * return true if operation allowed, false otherwise
     */
    public boolean verify(Matrix m, char op){
    	boolean v = true;
    	
    	if(op == '+' || op == '-'){
    		System.out.println("addition/subtraction");
    		v = (rows == m.rows && cols == m.cols);
    	} // end if add or subtract
    	else if(op == '*'){
    		System.out.println("multiplication");
    		v = cols == m.rows;
    	}  // end multiplication
    	else if(op == 't'){
    		System.out.println("transpose");
    	} // end transpose
    	else
    		System.out.println("invalid operator");
    	System.out.println("v = " + v);
    	return v;
    }  // end verify
    
    /* return the value at a specific index pair
     * needs the row and col address of the value 
     * to be returned
     */
    public int getValue(int r, int c){
    	return table[r][c];
    } // end getValue
    
    public void printMatrix(){
 /*   	for(int[] x: table){
    		for(int y: x){
    			System.out.print(y + " ");
    		}  // end for int y
    		System.out.println("");
    	} // end for int[] x
*/  
  		for(int i = 0; i < rows; i++){
  			for(int j = 0; j < cols; j++){
  				System.out.print(table[i][j] + " ");
  			} // end for int j
  			System.out.println("");
  		}  // end for int i
    } // end printMatrix
    
} // end Matrix