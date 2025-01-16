/*
ID: evantea1
LANG: JAVA
TASK: StuckInARut
*/

//   Name:              Evan Teal
//   GROUP:             APCS
//   LAST MODIFIED:     12-15-20
//   PROBLEM ID:        Stuck in a Rut
//   DESCRIPTION:       Given a number of cows and cow coordinates, finds how
//                      many moves it takes for a cow to stop when it hits a
//                      coordinate that a cow has already been on
//   SOURCES/HELPERS:   USACO

import java.util.*;
import java.io.*;

public class StuckInARut {
    // variables for the program
    static int max = 50;
    static int n = 0;
    static String[] cowDirection = new String[max];
    static int[] x = new int[max];
    static int[] y = new int[max];
    static String[] numGrass = new String[max];
    static boolean[] isDone = new boolean[max];

    public static void main(String[] args) throws IOException {
        // sets up the input and number of cows
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        // String garbage = in.nextLine();

        // gets each cows direction and coordinates in an array
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(in.nextLine(), " ");
            cowDirection[i] = st.nextToken();
            x[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());
            isDone[i] = false;
        }

        // calculates where each cow is going and when they stop
        int count = 0;
        for (int i = 0; i <= 500; i++) {
            // moves each cow one space in the direction it is facing
            for (int j = 0; j < n; j++) {
                if (isDone[j] == false) {
                    if (cowDirection[j].equals("E")) {
                        x[j] += 1;
                    }
                    if (cowDirection[j].equals("N")) {
                        y[j] += 1;
                    }
                }
            }
            // adds of spaces the cow moved before it stopped
            count++;
            for (int j = 0; j < n; j++) {
                if (isDone[j] == false) {
                    numGrass[j] = String.valueOf(count);
                }
            }
            // calculates if the cow stops
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (k == j) {
                        k++;
                    }
                    if (k < n) {
                        for (int h = 1; h <= Integer.parseInt(numGrass[k]); h++) {
                            // checks to see if the cow moved into another cows rut path
                            if (cowDirection[k].equals("E")) {
                                if (x[j] == x[k] - h && y[j] == y[k]) {
                                    isDone[j] = true;
                                }
                            } else if (cowDirection[k].equals("N")) {
                                if (x[j] == x[k] && y[j] == y[k] - h) {
                                    isDone[j] = true;
                                }
                            }
                        }
                    }
                }
            }
        }
        // if the cow went over the allowed amount of runs it goes to infinity
        for (int i = 0; i < n; i++) {
            if (numGrass[i].equals("501")) {
                numGrass[i] = "Infinity";
            }
        }

        // prints out results
        for (int i = 0; i < n; i++) {
            System.out.println(numGrass[i]);
        }
        in.close();
    }
}