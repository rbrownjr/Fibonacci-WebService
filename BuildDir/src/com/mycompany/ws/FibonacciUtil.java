/**
 * This class represents the algorithm to compute Fibonacci Sequences.
 * 
 * 
 * @author Robert Brown
 * @version 1.0
 * 
 */
package com.mycompany.ws;

import java.math.BigInteger;
import java.util.ArrayList;

import java.util.logging.Logger;
import java.util.logging.Level;

import java.beans.XMLEncoder;
import java.io.ByteArrayOutputStream;

import org.json.*;


public class FibonacciUtil {

	private static ArrayList<BigInteger> fibCache = new ArrayList<BigInteger>();
	
	//Create Logger
	//See logging details in FibonacciServlet.java
	private static Logger logger = Logger.getLogger("com.mysystem.ws.FibonacciServlet");
	
	static {
	      fibCache.add(BigInteger.ZERO);
	      fibCache.add(BigInteger.ONE);
	}
	
	public static BigInteger fib(int n) {
		
		logger.info("In fib");
		
        if (n >= fibCache.size()) 
            fibCache.add(n, fib(n-1).add(fib(n-2)));
        
        return fibCache.get(n);
        
    }
	
	public static int fibS(int n, StringBuffer fbString, String fmt) {

		int result = 1;
		
		try {
					
		  logger.info("In fibS");
		  
          if (n >= fibCache.size()) 
           fibCache.add(n, fib(n-1).add(fib(n-2)));
        
          if (n == 0)
          	    fbString.append(fibCache.get(0)).append(" "); 
          else
            for (int i = 0; i < n; i++)
    	       fbString.append(fibCache.get(i)).append(" ");          
        
          
		} catch (StackOverflowError so) {
			System.out.println("CODE WARNING: StackOverFlow - user input value was too large");
			System.out.println("See logs for Stack Trace");
			logger.log(Level.SEVERE, "CODE WARNING: StackOverFlow - user input value was too large", so);
			result = -1;
		
		}
				
		if (fmt.equals("XML"))
			toXML(fbString);
		else if (fmt.equals("JSON"))
			toJSON(fbString);
		
        return result;
    }
	
	//Convert Fibonacci sequence to XML format.
	public static void toXML(StringBuffer rst)
	{
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		FibData data = new FibData();
		
	    data.setFiboData(rst.toString());
	    XMLEncoder encdr = new XMLEncoder(out);
	    
	    encdr.writeObject(data);
	    encdr.close();
	    
	    rst.replace(0, rst.length(), out.toString());	
		
	}
	
	//Convert Fibonacci sequence to JSON format.
	public static void toJSON(StringBuffer rst)
	{		
		String jsnStr = new JSONStringer().object().key("JSON").value(rst.toString()).endObject().toString();
		
		rst.replace(0, rst.length(), jsnStr);
	}
}
