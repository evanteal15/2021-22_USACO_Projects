/*
ID: evant1
LANG: JAVA
PROG: transform
*/

//   NAME:              Evan Teal
//   GROUP:             APCS
//   LAST MODIFIED:     1-21-21
//   PROBLEM ID:        Transformations
//   DESCRIPTION:       Given a square of either black or white pieces and another
//                      square that could be a transformation of the original
//                      square. it finds what type of transformation is needed for
//                      the original square to become the transformed square.
//   SOURCES/HELPERS:   Mr.H, USACO, stackOverflow.com, Java 8 API

import java.util.*;
import java.io.*;

public class transform {

    public static void main(String[] args) throws IOException {
        // sets up the input and output
        Scanner in = new Scanner(new File("transform.in"));
        PrintWriter out = new PrintWriter(new File("transform.out"));

        // finds the 2d array size and creates all 2d arrays needed for program
        int squareSize = Integer.parseInt(in.nextLine());
        String[][] original = new String[squareSize][squareSize];
        String[][] finalPattern = new String[squareSize][squareSize];
        String[][] temp = new String[squareSize][squareSize];
        int transformation = 7;
        String tempInput;
        String[] inputArray = new String[squareSize];

        // creates the original pattern 2d array
        for (int i = 0; i < squareSize; i++) {
            tempInput = in.nextLine();
            inputArray = tempInput.split("");
            for (int j = 0; j < squareSize; j++) {
                original[i][j] = inputArray[j];
            }
        }

        // creates the final pattern 2d array
        for (int i = 0; i < squareSize; i++) {
            tempInput = in.nextLine();
            inputArray = tempInput.split("");
            for (int j = 0; j < squareSize; j++) {
                finalPattern[i][j] = inputArray[j];
            }
        }

        // checks to see if the array was rotated 90 degrees
        temp = original.clone();
        temp = rotate90(temp);
        if (Arrays.deepEquals(temp, finalPattern)) {
            transformation = 1;
        }
        // if it wasn't rotated 90, checks if it was rotated 180
        temp = rotate90(temp);
        if (Arrays.deepEquals(temp, finalPattern) && transformation == 7) {
            transformation = 2;
        }
        // if it wasn't rotated 180, checks if it was rotated 270
        temp = rotate90(temp);
        if (Arrays.deepEquals(temp, finalPattern) && transformation == 7) {
            transformation = 3;
        }
        // if it wasn't rotated, put array back to original and reflects it
        temp = original.clone();
        temp = reflect(temp);
        if (Arrays.deepEquals(temp, finalPattern) && transformation == 7) {
            transformation = 4;
        }
        // if it wasn't reflected, checks if it was a combination
        temp = rotate90(temp);
        if (Arrays.deepEquals(temp, finalPattern) && transformation == 7) {
            transformation = 5;
        }
        temp = rotate90(temp);
        if (Arrays.deepEquals(temp, finalPattern) && transformation == 7) {
            transformation = 5;
        }
        temp = rotate90(temp);
        if (Arrays.deepEquals(temp, finalPattern) && transformation == 7) {
            transformation = 5;
        }
        // if it wasn't a combination, checks to see if there was no change
        if (Arrays.deepEquals(original, finalPattern) && transformation == 7) {
            transformation = 6;
        }
        // if it was none of those, the transformation is invalid

        // outputs which transformation was used
        out.println(transformation);

        // ends program
        in.close();
        out.close();
    }

    public static String[][] rotate90(String[][] arr) {
        String[][] tem = new String[arr.length][arr.length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                tem[i][j] = arr[arr.length - 1 - j][i];
            }
        }
        return tem;
    }

    public static String[][] reflect(String[][] arr) {
        String[][] tem = new String[arr.length][arr.length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                tem[i][j] = arr[i][arr.length - 1 - j];
            }
        }
        return tem;
    }

}