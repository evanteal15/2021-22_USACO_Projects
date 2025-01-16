/*
ID: evant1
LANG: JAVA
PROG: crypt1
*/

//   NAME:              Evan Teal
//   GROUP:             APCS
//   LAST MODIFIED:     3-24-21
//   PROBLEM ID:        Prime Cryptarithm
//   DESCRIPTION:       Given a set of non zero digits, finds the number of combinations
//                      of those digits that complete the cryptarithm.
//   SOURCES/HELPERS:   Mr.H, USACO,

import java.util.*;
import java.io.*;

public class crypt1 {

    public static void main(String[] args) throws IOException {
        // sets up the input and output
        Scanner in = new Scanner(new File("crypt1.in"));
        PrintWriter out = new PrintWriter(new File("crypt1.out"));
        // Scanner in = new Scanner(System.in);

        // variables for program
        int N = in.nextInt();
        int[] digits = new int[N];
        int combos = 0;
        int abcd, abce, abcde;
        // String temp;

        // adds values to the array
        for (int i = 0; i < N; i++) {
            digits[i] = in.nextInt();
        }

        for (int abc = 100; abc < 999; abc++) {
            if (checkNum(digits, abc, 3)) {
                for (int de = 10; de < 99; de++) {
                    if (checkNum(digits, de, 2)) {
                        abcd = abc * (de % 10);
                        abce = abc * (de / 10);
                        abcde = abc * de;
                        if (checkNum(digits, abcd, 3) && checkNum(digits, abce, 3) && checkNum(digits, abcde, 4)) {
                            combos++;
                        }
                    }
                }
            }
        }

        // outputs minimum number of covered boards
        out.println(combos);

        // ends program
        in.close();
        out.close();
    }

    public static boolean checkNum(int[] arr, int num, int maxDigits) {
        int temp;
        int count = 0;
        boolean possible = true;
        while (num > 0 && possible == true) {
            possible = false;
            temp = num % 10;
            for (int i = 0; i < arr.length; i++) {
                if (temp == arr[i]) {
                    possible = true;
                }
            }
            num /= 10;
            count++;
        }

        if (count > maxDigits) {
            possible = false;
        }

        return possible;
    }
}