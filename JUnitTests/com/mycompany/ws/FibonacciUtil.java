package com.mycompany.ws;

import java.math.BigInteger;
import java.util.ArrayList;


public class FibonacciUtil {

	private static ArrayList<BigInteger> fibCache = new ArrayList<BigInteger>();
	
	static {
	      fibCache.add(BigInteger.ZERO);
	      fibCache.add(BigInteger.ONE);
	}
	
	public static BigInteger fib(int n) {
		
        if (n >= fibCache.size()) 
            fibCache.add(n, fib(n-1).add(fib(n-2)));
        
        return fibCache.get(n);
        
    }
	
	public static int fibS(int n, StringBuffer fbString) {

		int result = 1;
		
		try {
					
          if (n >= fibCache.size()) 
           fibCache.add(n, fib(n-1).add(fib(n-2)));
        
          if (n == 0)
          	    fbString.append(fibCache.get(0)).append(" "); 
          else
            for (int i = 0; i < n; i++)
    	       fbString.append(fibCache.get(i)).append(" ");          
        
		} catch (StackOverflowError so) {
			System.out.println("CODE WARNING: StackOverFlow - user input value was too large");
			//so.printStackTrace(); //Displays to the console
			result = -1;
		
		}
		
        return result;
    }
	
}
