/*
ID: evantea1
LANG:	JAVA
TASK:	friday
*/

//	  Name:					Evan Teal
//	  GROUP:					APCS
//	  LAST MODIFIED:		11-02-2020
//	  PROBLEM ID:			Friday the 13th
//	  DESCRIPTION:			given a number of years, colculates the number of times
//                      the thirteenth of a month lands on each day of the week
//                      after
//	  SOURCES/HELPERS:	Mr.H,	USACO, stackoverflow.com

import java.io.*;

public class friday {

   public static void main(String[] args) throws IOException {
      // sets up the input and output
      BufferedReader in = new BufferedReader(new FileReader("friday.in"));
      PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("friday.out")));

      // finds out the number of years it is repeating for
      int years = Integer.parseInt(in.readLine());
      years += 1900;

      // initializes arrays and variables
      int[] week = new int[] { 0, 0, 0, 0, 0, 0, 0 };
      int[] year = new int[] { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
      // Saturday January 13th, 1900
      int day = 0;

      // repeats the program for every year
      for (int y = 1900; y < years; y++) {
         // determines if it is a leap year or not
         if (y % 100 == 0) {
            if (y % 400 == 0)
               year[1] = 29;
         } else {
            if (y % 4 == 0)
               year[1] = 29;
         }

         // finds out which days for each month are on the 13th
         for (int m = 0; m < 12; m++) {
            week[day]++;
            day += year[m];
            day %= 7;
         }

         // resets the year to a normal year
         year[1] = 28;
      }

      // outputs the number of 13thsfor each day of the week
      for (int j = 0; j < 6; j++) {
         out.print(week[j] + " ");
      }
      out.println(week[6]);

      // ends program
      out.close();
      in.close();
   }
}