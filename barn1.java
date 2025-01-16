/*
ID: evant1
LANG: JAVA
PROG: barn1
*/

//   NAME:              Evan Teal
//   GROUP:             APCS
//   LAST MODIFIED:     3-24-21
//   PROBLEM ID:        Barn Repair
//   DESCRIPTION:       Given the maximum number of boards, the total number of stalls,
//                      the number of cows, and the occupied stalls, finds out the minimum
//                      number of stalls that must be blocked for all cos to be blocked.
//   SOURCES/HELPERS:   Mr.H, USACO,

import java.util.*;
import java.io.*;

public class barn1 {

    public static void main(String[] args) throws IOException {
        // sets up the input and output
        Scanner in = new Scanner(new File("barn1.in"));
        PrintWriter out = new PrintWriter(new File("barn1.out"));
        // Scanner in = new Scanner(System.in);

        // variables for program
        int M = in.nextInt();
        int S = in.nextInt();
        int C = in.nextInt();
        int[] stalls = new int[C];
        int minStalls = 0;

        // adds values to the array
        for (int i = 0; i < C; i++) {
            stalls[i] = in.nextInt();
        }
        Arrays.sort(stalls);

        // creates an array that measures the distance between each occupied stall
        int[] gaps = new int[C - 1];
        for (int i = 0; i < C - 1; i++) {
            gaps[i] = stalls[i + 1] - stalls[i];
        }

        // finds the largest M-1 gaps
        if (M != 1) {
            int[] largestGaps = new int[M - 1];
            for (int i = 0; i < C - 1; i++) {
                if (i < M - 1) {
                    largestGaps[i] = i;
                } else {
                    for (int j = 0; j < M - 1; j++) {
                        int key = largestGaps[j];
                        int index = j;
                        while (index > 0 && gaps[largestGaps[index - 1]] > gaps[key]) {
                            largestGaps[index] = largestGaps[index - 1];
                            index--;
                        }
                        largestGaps[index] = key;
                    }
                    /*
                     * for(int k=0; k<M-1; k++)
                     * {
                     * System.out.println(largestGaps[k]);
                     * }
                     */
                    if (gaps[largestGaps[0]] < gaps[i]) {
                        largestGaps[0] = i;
                    }
                }
            }
            Arrays.sort(largestGaps);

            /*
             * for(int k=0; k<M-1; k++)
             * {
             * System.out.println(largestGaps[k]);
             * }
             */

            // adds up the number of boards between the largest gaps
            minStalls += stalls[largestGaps[0]] - stalls[0] + 1;
            for (int i = 1; i < M - 1; i++) {
                minStalls += stalls[largestGaps[i]] - stalls[largestGaps[i - 1] + 1] + 1;
            }
            minStalls += stalls[C - 1] - stalls[largestGaps[M - 2] + 1] + 1;
        } else {
            // case if there is only 1 board available
            minStalls = stalls[C - 1] - stalls[0] + 1;
        }

        // case if max boards is greater than occupied stalls
        if (M > C) {
            minStalls = C;
        }

        // outputs minimum number of covered boards
        out.println(minStalls);

        // ends program
        in.close();
        out.close();
    }
}