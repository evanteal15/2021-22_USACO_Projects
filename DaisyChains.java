/*
ID: evantea1
LANG:	JAVA
TASK:	daisychains
*/
 
//	  Name:					Evan Teal
//	  GROUP:					APCS
//	  LAST MODIFIED:		12-15-20
//	  PROBLEM ID:			Daisy Chains
//	  DESCRIPTION:			Given a number of flowers with a certains number of pedals
//                      and calculates the number of pictures that have a flower with
//                      the average number of pedals in the picture
//	  SOURCES/HELPERS:	USACO
 
import java.util.*;
import java.io.*;

public class DaisyChains
{
   // variables for the program
   static int max = 100;
   static int n = 0;
   static int total = 0;
   static double average = 0;
   static int[] flower = new int[max +1];

	public static void main(String[]	args)	throws IOException 
	{
		//	sets up the	input
		Scanner	in	= new Scanner(System.in);
      n = in.nextInt();
      total += n;
      
      // creates an array of flower pedals
      for(int i=1; i<=n; i++)
      {
         flower[i] = in.nextInt();
      }
      
      // goes through each picture
      for(int i=1; i<=n; i++)
      {
         for(int j=i+1; j<=n; j++)
         {
            // calculates the average
            average = 0;
            for(int g=i; g<=j; g++)
            {
               average += flower[g];
            }
            average /= (j-i+1);
            
            // sees if any of the flowers in the picture have average pedals
            for(int g=i; g<=j; g++)
            {
               if(average == flower[g])
               {
                  total++;
                  break;
               }
            }
         }
      }
      
      // outputs the number of pictures with average pedals
      System.out.println(total);
      
   }
}