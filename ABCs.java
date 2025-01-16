/*
ID: evantea1
LANG: JAVA
TASK: ABCs
*/
 
//   Name:              Evan Teal
//   GROUP:             APCS
//   LAST MODIFIED:     12-15-20
//   PROBLEM ID:        ABCs
//   DESCRIPTION:       Given a string of 7 separate integer values A, B, C, A+B
//                      A+C, B+C, and A+B+C in any order and finds the values of 
//                      A B and C with A<B<C.
//   SOURCES/HELPERS:   USACO
 
import java.util.*;
import java.io.*;

public class ABCs
{
   // variables for the program
   static int A = 0;
   static int B = 0;
   static int C = 0;
   static int largest = 0;
   static int[] numbers = new int[7];
   static int[] possible = new int[3];

   public static void main(String[] args) throws IOException 
   {
      // sets up the input and array of numbers
      Scanner  in = new Scanner(System.in);
      for(int i=0; i<7; i++)
      {
         numbers[i] = in.nextInt();
      }
      
      // finds the largest value which must equal A+B+C
      for(int i=0; i<7; i++)
      {
         if(numbers[i] > largest)
         {
            largest = numbers[i];
         }
      }
      
      // finds which 3 values add up to largest
      // those 3 values must be A, B, and C
      for(int i=0; i<5; i++)
      {
         for(int j=i+1; j<6; j++)
         {
            for(int k=j+1; k<7; k++)
            {
               if(numbers[i] + numbers[j] + numbers[k] == largest)
               {
                  possible[0] = numbers[i];
                  possible[1] = numbers[j];
                  possible[2] = numbers[k];
                  break;
               }
            }
         } 
      }
      
      // sorts the values so A is smallest and C is largest
      Arrays.sort(possible);
      A = possible[0];
      B = possible[1];
      C = possible[2];
      
      // outputs A, B, and C
      System.out.println(A + " " + B + " " + C);
      
   }
}