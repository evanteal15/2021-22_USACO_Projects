/*
ID: evantea1
LANG:	JAVA
TASK:	DanceMoves
*/

//	  NAME:				Evan Teal
//	  GROUP:			APCS
//	  LAST MODIFIED:	12-15-20
//	  PROBLEM ID:		Dance Moves
//	  DESCRIPTION:		Given a certain series of dance moves, it finds how many
//                      unique spaces a cow in each poition would move to if the 
//                      moves looped infinetely
//	  SOURCES/HELPERS:	USACO

import java.util.*;
import java.io.*;

public class DanceMoves {
    public static void main(String[] args) throws IOException {
        // sets up the inputs number of cows and moves
        Scanner in = new Scanner(System.in);
        int numCows = in.nextInt();
        int numMoves = in.nextInt();

        // array including all possible cow moves
        int[][] cowMoves = new int[numMoves + 1][2];
        for (int i = 1; i < numMoves + 1; i++) {
            for (int j = 0; j < 2; j++) {
                cowMoves[i][j] = in.nextInt();
            }
        }

        // array documents where each cow is and the number of spaces they visited
        String[] cows = new String[numCows + 1];
        int[] uniqueSpaces = new int[numCows + 1];
        boolean turnEnd = false;

        // goes through each cow and does moves until it finds a loop
        for (int n = 1; n < numCows + 1; n++) {
            cows[n] = Integer.toString(n);
            turnEnd = false;

            // while the cow is not in a loop it goes through and adds up all the cow's
            // moves
            while (!(String.valueOf(cows[n].charAt(cows[n].length() - 1)).equals(Integer.toString(n))
                    && turnEnd == true)) {
                for (int i = 1; i < numMoves + 1; i++) {
                    if (cowMoves[i][0] == Integer.parseInt(String.valueOf(cows[n].charAt(cows[n].length() - 1)))) {
                        cows[n] += Integer.toString(cowMoves[i][1]);
                    } else if (cowMoves[i][1] == Integer
                            .parseInt(String.valueOf(cows[n].charAt(cows[n].length() - 1)))) {
                        cows[n] += Integer.toString(cowMoves[i][0]);
                    }
                }
                turnEnd = true;
            }

            // finds how many unique spaces the cow visited
            String temp = "";
            for (int j = 0; j < cows[n].length(); j++) {
                if (!temp.contains(String.valueOf(cows[n].charAt(j)))) {
                    temp += cows[n].charAt(j);
                }
            }
            uniqueSpaces[n] = temp.length();
        }

        // outputs the number of unique spaces each cow has gone to
        for (int i = 1; i < numCows + 1; i++) {
            System.out.println(uniqueSpaces[i]);
        }

    }
}