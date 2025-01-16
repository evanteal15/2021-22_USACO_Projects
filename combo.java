/*
ID: evant1
LANG: JAVA
PROG: combo
*/

//   NAME:              Evan Teal
//   GROUP:             APCS
//   LAST MODIFIED:     3-24-21
//   PROBLEM ID:        Combination Lock
//   DESCRIPTION:       Given two combinations and the highest possible number,
//                      the programs finds the number of all possible combinations
//                      that open the lock which has an error.
//   SOURCES/HELPERS:   Mr.H, USACO,

import java.util.*;
import java.io.*;

public class combo {

    public static void main(String[] args) throws IOException {
        // sets up the input and output
        Scanner in = new Scanner(new File("combo.in"));
        PrintWriter out = new PrintWriter(new File("combo.out"));
        // Scanner in = new Scanner(System.in);

        // variables for program
        int Max = in.nextInt();
        int[] farmer = new int[3];
        int[] master = new int[3];
        int combos = 250;
        int sameCombos = 1;
        int diff;

        // adds values to the arrays
        for (int i = 0; i < 3; i++) {
            farmer[i] = in.nextInt();
        }
        for (int i = 0; i < 3; i++) {
            master[i] = in.nextInt();
        }

        if (Max <= 5) {
            combos = (int) Math.pow(Max, 3);
        } else {
            for (int i = 0; i < 3; i++) {
                diff = Math.abs(((farmer[i] + 2) % Max) - ((master[i] + 2) % Max));
                if (diff > 4) {
                    sameCombos = 0;
                } else {
                    sameCombos *= 5 - diff;
                }
            }
            combos = combos - sameCombos;
        }

        // outputs minimum number of covered boards
        out.println(combos);

        // ends program
        in.close();
        out.close();
    }

}