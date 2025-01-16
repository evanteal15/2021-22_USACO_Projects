
/*
ID: evant1
LANG: JAVA
PROG: dualpal
*/
 
//	  NAME:					Evan Teal
//	  GROUP:					APCS
//	  LAST MODIFIED:		2-16-21
//	  PROBLEM ID:			Dual palindromes
//	  DESCRIPTION:			Given a two numbers, finds the first n numbers after the 
//                      second number that are a palindrome in two or more bases 
//                      from 2 to 10.
//	  SOURCES/HELPERS:	Mr.H,	USACO, stackoverflow.com

import java.util.*;
import java.io.*;

public class dualpal
{

	public static void main(String[]	args)	throws IOException 
	{
		//	sets up the	input	and output
		Scanner	in	= new	Scanner(new File("dualpal.in"));
		PrintWriter	out =	new PrintWriter(new File("dualpal.out"));
      //Scanner	in	= new	Scanner(System.in);

      // variables for program
      int N = in.nextInt();
      int S = in.nextInt();
      int numDuals = 0;
      int numPals = 0;
      int nextNum = S;
      String possPal;
      int[] dualPals = new int[N];
      
      // finds teh first N number with 2 or more palindromes in bases 2-10
      while(numDuals < N)
      {
         // goes to next number and reset number of palindromes
         nextNum++;
         numPals = 0;
         
         // loops through bases 2-10
         for(int i=2; i<=10; i++)
         {
            // finds the number of the base
            possPal = Integer.toString(Integer.parseInt(Integer.toString(nextNum),10),i);
            int left = 0;
            int right = possPal.length()-1;
         
            // tests the square palindrome to see if it is a palindrome
            if(left != right)
            {
               while(possPal.charAt(left) == possPal.charAt(right) && left <= right)
               {
                  left++;
                  right--;
               }
            }
         
            // if it is a palindrome, put it in the pals list
            if(left >= right || possPal.length()==1)
            {
               numPals += 1;
            }
         }
         
         // if there are two or more pals of that number, it is added to the list
         if(numPals >= 2)
         {
            dualPals[numDuals] = nextNum;
            numDuals++;
         }
      }
            
      // outputs which transformation was used
      for(int i=0; i<N; i++)
      {
         out.println(dualPals[i]);
      }
      
		//	ends program
      in.close();
      out.close();
	}   
}