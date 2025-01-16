/*
ID: evantea1
LANG: JAVA
TASK: wormhole
*/

//   Name:              Evan Teal
//   GROUP:             APCS
//   LAST MODIFIED:     12-15-20
//   PROBLEM ID:        WormHoles
//   DESCRIPTION:       Given a series of wormholes, find out how many combinations
//                      of wormholes create an infinite wormhole cycle
//   SOURCES/HELPERS:   Mr.H, USACO, Brian Dean Video

import java.util.*;
import java.io.*;

public class wormhole {
    // variables for the program
    static int max = 12;
    static int n = 0;
    static int[] x = new int[max + 1];
    static int[] y = new int[max + 1];
    static int[] partner = new int[max + 1];
    static int[] nextRight = new int[max + 1];

    public static void main(String[] args) throws IOException {
        // sets up the input and output
        Scanner in = new Scanner(new File("wormhole.in"));
        PrintWriter out = new PrintWriter(new File("wormhole.out"));
        n = in.nextInt();

        // gets input for each position array
        for (int i = 1; i <= n; i++) {
            int xPoint = in.nextInt();
            int yPoint = in.nextInt();
            x[i] = xPoint;
            y[i] = yPoint;
        }

        // sets the nextRight array
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (x[j] > x[i] && y[i] == y[j]) {
                    if (nextRight[i] == 0 || x[j] - x[i] < x[nextRight[i]] - x[i]) {
                        nextRight[i] = j;
                    }
                }
            }
        }

        out.println(count());

        // ends program
        out.close();
        in.close();
    }

    // counts all solutions
    static int count() {
        // finds first unpaired wormhole
        int i, total = 0;
        for (i = 1; i <= n; i++) {
            if (partner[i] == 0) {
                break;
            }
        }

        // checks to see if everyone is paired
        if (i > n) {
            if (cycleExists()) {
                return 1;
            } else {
                return 0;
            }
        }

        // pairs i with all pssible other wormholes
        for (int j = i + 1; j <= n; j++) {
            if (partner[j] == 0) {
                // tries pairing i and j using recursion
                partner[i] = j;
                partner[j] = i;
                total += count();
                partner[i] = partner[j] = 0;
            }
        }
        return total;
    }

    static boolean cycleExists() {
        for (int s = 1; s <= n; s++) {
            // does a cycle exist for each starting wormhole
            int pos = s;
            for (int k = 0; k < n; k++) {
                pos = nextRight[partner[pos]];
            }
            if (pos != 0) {
                return true;
            }
        }
        return false;
    }
}