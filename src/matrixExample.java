// **********************************************************************
// Programmer:	Rob Sveinson
// Class:		CS20S
//
// Assignment:	aX qy
//
// Description:	a brief description of the program goes here
//
//
//	Input:		describe any input from keyboard or file
//
//  Output:		describe the result of your program
// ***********************************************************************

import javax.swing.*;
import java.text.DecimalFormat;
import java.io.*;

public class matrixExample
{  // begin class
	public static void main(String args[])throws IOException
	{  // begin main
	// ***** declaration of constants *****
		
		final String FILENAME = "matrixMathData.txt";
	// ***** declaration of variables *****
	
		String strin;				// input string
		String strout;				// output strint
		String delim = "[ ]+";		// delimiter for input string
		
		char operator;				// operator read from file
		int r1, c1;					// dimensions of matrix 1
		int r2, c2;					// dimensions of matrix 2
		
		
		
	// ***** create objects *****
	
		BufferedReader fin = new BufferedReader(new FileReader(FILENAME));
		
	// ***** create input stream *****
	
		//ConsoleReader console = new ConsoleReader(System.in);
		
		
	// ***** Print Banner *****
	
		System.out.println("**********************************");
		System.out.println("NAME:        Your Name Here");
		System.out.println("Class:       CS30S");
		System.out.println("Assignment:  Ax Qy");
		System.out.println("**********************************");
		
	// ***** get input *****
	
		// all input is gathered in this section
		// remember to put ConsoleReader.class into the
		// same folder.
		
		strin = fin.readLine();
		//System.out.println(strin);
		
		while(strin != null){
			//String[] tokens = strin.split(delim);
			//read operator
			//operator = tokens[0].charAt(0);
			operator = strin.charAt(0);
			System.out.println(operator);
			
			// read matrix dimensions
			strin = fin.readLine();
			System.out.println("this is the matrix dimensions " + strin);
			
			String[] tokens = strin.split(delim);
			r1 = Integer.parseInt(tokens[0]);
			c1 = Integer.parseInt(tokens[1]);
			r2 = Integer.parseInt(tokens[2]);
			c2 = Integer.parseInt(tokens[3]);
			System.out.println("matrix 1: " + r1 + " x " + c1);
			System.out.println("matrix 2: " + r2 + " x " + c2);	
						
			// load first matrix
			
			Matrix m1 = new Matrix(fin, r1, c1);
			
			if(!(r2 == 0 || c2 == 0)){
				Matrix m2 = new Matrix(fin, r2, c2);	
			
			
			boolean valid = m1.verify(m2, operator);
			if(valid){
				System.out.println("do operation " + operator + ".");
			}  // end if verify
			} // end if
		
			
			strin = fin.readLine();
			System.out.println("update while loop " + strin);
		}  // end strin != null
	
	// ***** processing *****
	
		
	// ***** output *****
	
		// all formatted ouput is printed in this section

	// ***** closing message *****
	
		System.out.println("end of processing");
	
	}  // end main	
}  // end class