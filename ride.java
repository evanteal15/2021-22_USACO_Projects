/*
 PROG: ride
 ID: evantea1
 LANG: JAVA
 */

//      NAME:               Evan Teal
//		GROUP:              APCS
//	    LAST MODIFIED:      9-02-2020
//	    PROBLEM ID:         Your Ride Is Here 
//	    DESCRIPTION:        Program that takes the ASCII values of characters of two strings,
//                          calculates a value for each and verifies if they are equal. 
//      SOURCES/HELPERS:    USACO website, Mr. H

import java.io.*;

public class ride {
    public static void main(String[] args) throws IOException {
        // Opening files for input and output
        BufferedReader in = new BufferedReader(new FileReader("ride.in"));
        // RandomAccessFile in = new RandomAccessFile ("ride.in", "r");
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ride.out")));

        // Declares two strings--reads and assigns them from the input file
        String cometName = in.readLine();
        String groupName = in.readLine();

        // Declares and initializes two integer variables for storing calculations as
        // well as constants
        int cometNum = 1, groupNum = 1;
        final int ASCII_VALUE = 64, MOD_VALUE = 47;

        // Translates letters to ASCII code and calculates the mod value of each
        for (int k = 0; k < cometName.length(); k++) {
            cometNum *= cometName.charAt(k) - ASCII_VALUE;
            cometNum %= MOD_VALUE;
        }
        for (int k = 0; k < groupName.length(); k++) {
            groupNum *= groupName.charAt(k) - ASCII_VALUE;
            groupNum %= MOD_VALUE;
        }

        // Checks if group and comet num are equal and prints either GO or STAY
        if (groupNum == cometNum)
            out.print("GO\n");
        else
            out.println("STAY");

        // Ensures program ends properly
        out.close();
        System.exit(0);
    }
}
