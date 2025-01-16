/*
ID: evantea1
LANG: JAVA
TASK: namenum
*/

//   Name:              Evan Teal
//   GROUP:             APCS
//   LAST MODIFIED:     11-23-2020
//   PROBLEM ID:        Name That Number
//   DESCRIPTION:       given a number, find out all the possible names a cow could
//                      have using the Touch-Tone keypad system.
//   SOURCES/HELPERS:   Mr.H, USACO, Java 8 API, 

import java.util.*;
import java.io.*;

public class namenum {

    public static void main(String[] args) throws IOException {
        // sets up the input and output
        BufferedReader in = new BufferedReader(new FileReader("namenum.in"));
        BufferedReader dict = new BufferedReader(new FileReader("dict.txt"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("namenum.out")));

        // creates variable needed for program
        String cowNum = in.readLine();
        ArrayList<String> possibleNames = new ArrayList<String>();
        String temp = "";

        // checks to see if each name in the dictionary has a Touch-Tone code
        // equal to the cow name
        while ((temp = dict.readLine()) != null) {
            // goes through each character in the string
            String dictNum = "";
            for (int i = 0; i < temp.length(); i++) {
                // creates the Touch-Tone digits of each name
                char tempChar = temp.charAt(i);
                switch (tempChar) {
                    case 'A':
                    case 'B':
                    case 'C':
                        dictNum += 2;
                        break;
                    case 'D':
                    case 'E':
                    case 'F':
                        dictNum += 3;
                        break;
                    case 'G':
                    case 'H':
                    case 'I':
                        dictNum += 4;
                        break;
                    case 'J':
                    case 'K':
                    case 'L':
                        dictNum += 5;
                        break;
                    case 'M':
                    case 'N':
                    case 'O':
                        dictNum += 6;
                        break;
                    case 'P':
                    case 'R':
                    case 'S':
                        dictNum += 7;
                        break;
                    case 'T':
                    case 'U':
                    case 'V':
                        dictNum += 8;
                        break;
                    case 'W':
                    case 'X':
                    case 'Y':
                        dictNum += 9;
                        break;
                    default:
                        dictNum += 0;
                        break;
                }
            }

            // checks to see if the dictionary digits match the cows digits
            if (dictNum.equals(cowNum)) {
                possibleNames.add(temp);
            }
        }

        // outputs all the possible names for the cow
        if (possibleNames.size() > 0) {
            for (int i = 0; i < possibleNames.size(); i++) {
                out.println(possibleNames.get(i));
            }
        } else {
            out.println("NONE");
        }

        // ends program
        dict.close();
        out.close();
        in.close();
    }
}