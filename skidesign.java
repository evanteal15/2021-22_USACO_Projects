/*
ID: evant1
LANG: JAVA
PROG: skidesign
*/

//   NAME:              Evan Teal
//   GROUP:             APCS
//   LAST MODIFIED:     3-25-21
//   PROBLEM ID:        Ski Course Design
//   DESCRIPTION:       Given a set of hills with an elevation, find the
//                      minimum cost to make the tallest hill and the shortest
//                      hill only 17 units apart.
//   SOURCES/HELPERS:   Mr.H, USACO,

import java.util.*;
import java.io.*;

public class skidesign {

    public static void main(String[] args) throws IOException {
        // sets up the input and output
        Scanner in = new Scanner(new File("skidesign.in"));
        PrintWriter out = new PrintWriter(new File("skidesign.out"));
        // Scanner in = new Scanner(System.in);

        // variables for program
        int num = in.nextInt();
        int[] hills = new int[num];
        int cost, minCost, max, diff;

        for (int i = 0; i < num; i++) {
            hills[i] = in.nextInt();
        }
        Arrays.sort(hills);

        minCost = Integer.MAX_VALUE;

        for (int min = 0; min < 84; min++) {
            max = min + 17;
            cost = 0;
            for (int j = 0; j < num; j++) {
                if (hills[j] < min) {
                    diff = min - hills[j];
                    cost += Math.pow(diff, 2);
                } else if (hills[j] > max) {
                    diff = hills[j] - max;
                    cost += Math.pow(diff, 2);
                }
            }
            if (cost < minCost) {
                minCost = cost;
            }
        }

        // outputs minimum number of covered boards
        out.println(minCost);

        // ends program
        in.close();
        out.close();
    }

}