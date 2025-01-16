/*
    ID: evant1
    LANG: JAVA
    PROG: pprime
*/

//   NAME:              Evan Teal
//   GROUP:             DM
//   LAST MODIFIED:     3-8-22
//   PROBLEM ID:        Prime Palindromes
//   DESCRIPTION:       Given two numbers as boundaries, finds all palindromic numbers
//                      in between the bounds that are prime.
//   SOURCES/HELPERS:   Mr.H, USACO

import java.util.*;
import java.io.*;

public class pprime {

    public static void main(String[] args) throws IOException {
        // set up input and output
        Scanner in = new Scanner(new File("pprime.in"));
        PrintWriter out = new PrintWriter(new File("pprime.out"));

        // takes input from the file and splits it into the upper and lower bound
        String nums = in.nextLine();
        StringTokenizer st = new StringTokenizer(nums, " ");
        int a = Integer.valueOf(st.nextToken());
        int b = Integer.valueOf(st.nextToken());
        in.close();

        // creates an array to measure the length (place value) of the number
        String[] arr = String.valueOf(b).split("");
        String[] arr2 = String.valueOf(a).split("");

        // creates an array to store all the prime palindromes
        List<Integer> pp = new ArrayList<Integer>();

        // loops through all possible palindromes inside the bounds
        int temp = 0;
        for (int i = 0; i <= 9; i++) {
            // if the upper bound is greater than 2 digits long
            if (arr.length > 2) {
                for (int j = 0; j <= 9; j++) {
                    // if the upper bound is greater than 4 digits long
                    if (arr.length > 4) {
                        for (int k = 0; k <= 9; k++) {
                            // if the upper bound is greater than 6 digits long
                            if (arr.length > 6) {
                                for (int l = 0; l <= 9; l++) {
                                    // if the bound allows for an 8 digit number
                                    if (arr.length == 8 && arr2.length <= 8) {
                                        temp = 10000000 * l + 1000000 * k + 100000 * j + 10000 * i + 1000 * i + 100 * j
                                                + 10 * k + l;
                                        // if the palindrome is in the bounds and is prime, add it to the array
                                        if (temp >= a && temp <= b && isPrime(temp)) {
                                            pp.add(temp);
                                        }
                                    }
                                    // if the bound allows for a 7 digit number
                                    if (arr.length >= 7 && arr2.length <= 7) {
                                        temp = 1000000 * l + 100000 * k + 10000 * j + 1000 * i + 100 * j + 10 * k + l;
                                        if (temp >= a && temp <= b && isPrime(temp)) {
                                            pp.add(temp);
                                        }
                                    }
                                    temp = 0;
                                }
                            }
                            // if the bound allows for a 6 digit number
                            if (arr.length >= 6 && arr2.length <= 6) {
                                temp = 100000 * k + 10000 * j + 1000 * i + 100 * i + 10 * j + k;
                                if (temp >= a && temp <= b && isPrime(temp)) {
                                    pp.add(temp);
                                }
                            }
                            // if the bound allows for a 5 digit number
                            if (arr.length >= 5 && arr2.length <= 5) {
                                temp = 10000 * k + 1000 * j + 100 * i + 10 * j + k;
                                if (temp >= a && temp <= b && isPrime(temp)) {
                                    pp.add(temp);
                                }
                            }
                            temp = 0;
                        }
                    }
                    // if the bound allows for a 4 digit number
                    if (arr.length >= 4 && arr2.length <= 4) {
                        temp = 1000 * j + 100 * i + 10 * i + j;
                        if (temp >= a && temp <= b && isPrime(temp)) {
                            pp.add(temp);
                        }
                    }
                    // if the bound allows for a 3 digit number
                    if (arr.length >= 3 && arr2.length <= 3) {
                        temp = 100 * j + 10 * i + j;
                        if (temp >= a && temp <= b && isPrime(temp)) {
                            pp.add(temp);
                        }
                    }
                    temp = 0;
                }
            }
            // if the bound allows for a 2 digit number
            if (arr.length >= 2 && arr2.length <= 2) {
                temp = 10 * i + i;
                if (temp >= a && temp <= b && isPrime(temp)) {
                    pp.add(temp);
                }
            }
            // if the bound allows for a 1 digit number
            if (arr2.length <= 1) {
                temp = i;
                if (temp >= a && temp <= b && isPrime(temp)) {
                    pp.add(temp);
                }
            }

            temp = 0;
        }

        // outputs the list of prime pals in sorted order
        Collections.sort(pp);
        for (int pal : pp) {
            out.println(pal);
        }
        out.close();
        System.exit(0);
    }

    // finds out if each number is prime or not
    private static boolean isPrime(int num) {
        boolean prime = true;// if the number has a factor greater than 1, it is not prime
        for (int m = 2; m <= (int) Math.sqrt(num); m++) {
            if (num % m == 0) {
                prime = false;
                break;
            }
        }
        return prime;
    }
}