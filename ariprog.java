/*
ID: evant1
LANG: JAVA
PROG: ariprog
*/

//   NAME:              Evan Teal
//   GROUP:             APCS
//   LAST MODIFIED:     3-25-21
//   PROBLEM ID:        Arithmetic Progression
//   DESCRIPTION:       Given a progression length, and maximum bi-square values
//                      finds all possible numbers a and b whose arithmetic progression
//			            only contains bi-squares under the maximum.
//   SOURCES/HELPERS:   Mr.H, USACO,

import java.util.*;
import java.io.*;

public class ariprog {

    public static void main(String[] args) throws IOException {
        // sets up the input and output
        Scanner in = new Scanner(new File("ariprog.in"));
        PrintWriter out = new PrintWriter(new File("ariprog.out"));
        // Scanner in = new Scanner(System.in);

        // variables
        int numProgs = Integer.parseInt(in.nextLine());
        int limit = Integer.parseInt(in.nextLine());
        int max = limit * limit * 2;
        boolean[] bisquares = new boolean[max + 1];
        ArrayList<int[]> progs = new ArrayList<int[]>();
        for (int i = 0; i <= limit; i++) {
            for (int j = 0; j <= limit; j++) {
                bisquares[i * i + j * j] = true;
            }
        }

        // finds out if the progression contains the bi-squares
        for (int i = 0; i < max - numProgs + 1; i++) {
            for (int j = 1; j <= (max - i) / (numProgs - 1); j++) {
                boolean isBisquare = true;
                int count = 0;
                while (isBisquare && count <= numProgs - 1) {
                    if (bisquares[i + count * j] != true) {
                        isBisquare = false;
                    }
                    count++;
                }
                if (isBisquare == true) {
                    int[] set = new int[2];
                    set[0] = i;
                    set[1] = j;
                    progs.add(set);
                }
            }
        }

        // sorts the list of progressions
        progs = quickSort(progs, 0, progs.size() - 1);

        // outputs minimum number of covered boards
        if (progs.size() == 0) {
            out.println("NONE");
        } else {
            for (int i = 0; i < progs.size(); i++) {
                out.println(progs.get(i)[0] + " " + progs.get(i)[1]);
            }
        }

        // ends program
        in.close();
        out.close();
    }

    public static ArrayList<int[]> quickSort(ArrayList<int[]> arr, int start, int end) {
        if (start < end) {
            int mid = partition(arr, start, end);
            quickSort(arr, start, mid);
            quickSort(arr, mid + 1, end);
        }
        return arr;
    }

    public static int partition(ArrayList<int[]> arr, int start, int end) {
        int pivot = arr.get(start)[1];
        int pivot2 = arr.get(start)[0];
        int in1 = start - 1;
        int in2 = end + 1;
        while (true) {
            in1 += 1;
            while (arr.get(in1)[1] < pivot || arr.get(in1)[1] == pivot && arr.get(in1)[0] < pivot2) {
                in1 += 1;
            }

            in2 -= 1;
            while (arr.get(in2)[1] > pivot || arr.get(in2)[1] == pivot && arr.get(in2)[0] > pivot2) {
                in2 -= 1;
            }

            if (in1 < in2) {
                int[] temp = arr.get(in1);
                arr.set(in1, arr.get(in2));
                arr.set(in2, temp);
            } else {
                return in2;
            }
        }
    }

}
