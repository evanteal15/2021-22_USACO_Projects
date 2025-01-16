
/*
ID: evant1
LANG: JAVA
PROG: frac1
*/

//   NAME:              Evan Teal
//   GROUP:             DM
//   LAST MODIFIED:     4-5-22
//   PROBLEM ID:        Ordered Fractions
//   DESCRIPTION:       The maximum denominator or a fraction, finds all fractions
//                      with a demoninator less than that and puts them in order.
//   SOURCES/HELPERS:   Mr.H, USACO

import java.util.*;
import java.io.*;

public class frac1 {

  static PrintWriter out;

  public static void main(String[] args) throws IOException {
    // set up input and output
    Scanner in = new Scanner(new File("frac1.in"));
    out = new PrintWriter(new File("frac1.out"));

    // output the ends
    int max = in.nextInt();
    out.println("0/1");
    // recurse through and find each fraction
    recursive(0, 1, 1, 1, max);
    out.println("1/1");

    // end the program
    in.close();
    out.close();
  }

  // uses recursion to find the fractions in order

  public static void recursive(int n1, int d1, int n2, int d2, int max) {
    // if the denominator is too big
    if (d1 + d2 > max) {
      return;
    }

    // find the fraction to the left
    recursive(n1, d1, n2 + n1, d2 + d1, max);

    // output the fraction in the middle of the two fractions
    out.println((n1 + n2) + "/" + (d1 + d2));

    // find the fraction to the right
    recursive(n1 + n2, d1 + d2, n2, d2, max);
  }
}