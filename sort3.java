/*
    ID: evant1
    LANG: JAVA
    PROG: sort3
*/

//   NAME:              Evan Teal
//   GROUP:             Adv CS
//   LAST MODIFIED:     4-5-22
//   PROBLEM ID:        Sorting a Three-Valued Sequence
//   DESCRIPTION:       Finds the number of minimum switches needed to
//                      sort of list of 3 numbers is ascending order
//   SOURCES/HELPERS:   Mr.H, USACO

import java.util.*;
import java.io.*;

public class sort3 {
    static PrintWriter out;

    public static void main(String[] args) throws IOException {
        // set up input and output
        Scanner in = new Scanner(new File("sort3.in"));
        out = new PrintWriter(new File("sort3.out"));

        // adds the numbers to an array
        int len = in.nextInt();
        int[] nums = new int[len];
        int[] sorted = new int[len];
        for (int i = 0; i < len; i++) {
            int temp = in.nextInt();
            nums[i] = temp;
            sorted[i] = temp;
        }
        // sorts on of the arrays to the final state
        Arrays.sort(sorted);

        // initializes the count for the numbers of numbers in each spot
        // ex. n12 is the number of 1s where the 2s should be in the sorted
        int n12 = 0;
        int n21 = 0;
        int n23 = 0;
        int n32 = 0;
        int n13 = 0;
        int n31 = 0;

        // finds the number of swaps for each number set
        for (int i = 0; i < len; i++) {
            if (nums[i] != sorted[i]) {
                if (nums[i] == 2 && sorted[i] == 1) {
                    n21++;
                } else if (nums[i] == 1 && sorted[i] == 2) {
                    n12++;
                } else if (nums[i] == 3 && sorted[i] == 2) {
                    n32++;
                } else if (nums[i] == 2 && sorted[i] == 3) {
                    n23++;
                } else if (nums[i] == 3 && sorted[i] == 1) {
                    n31++;
                } else {
                    n13++;
                }
            }
        }
        System.out.println(n12 + " " + n21 + " " + n23 + " " + n32 + " " + n13 + " " + n31);

        // for each number duo, adds the number of swaps that can be made between them
        int diff = 0;
        diff += Math.min(n21, n12) + Math.min(n32, n23) + Math.min(n13, n31);

        // the leftover numbers are sorted on the order of 2^n where n is the
        // number of leftover numbers for each set each set has an equal number
        // of leftover numbers that cannot be swapped witht the same number of that set
        n21 = Math.abs(n21 - n12);
        if (n21 != 0) {
            diff += Math.pow(2, n21);
        }
        out.println(diff);

        // end the program
        in.close();
        out.close();
    }
}