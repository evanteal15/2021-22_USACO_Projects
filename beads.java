/*
ID: evantea1
LANG: JAVA
TASK: beads
*/

//   NAME:              Evan Teal
//   GROUP:             APCS
//   LAST MODIFIED:     11-23-2020
//   PROBLEM ID:        Broken Necklace
//   DESCRIPTION:       Given a list of beads, it finds the longest possible
//                      necklace that can be made of those beads.
//   SOURCES/HELPERS:   Mr.H, USACO, Java 8 API, 

import java.io.*;

class beads {
    public static void main(String args[]) throws Exception {
        // sets up input and output
        BufferedReader in = new BufferedReader(new FileReader("beads.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("beads.out")));

        // creates a bead array and doubles it
        int beads = Integer.parseInt(in.readLine());
        String necklace = in.readLine();
        necklace += necklace;
        int max = 0;

        // finds the longest necklace from every bead
        for (int i = 0; i < beads; i++) {
            // creates variables for program
            char[] beadedNecklace = necklace.toCharArray();
            int count = 0;
            int index = i;

            // counts until it reaches a non-white bead
            if (beadedNecklace[index] == 'w') {
                for (int j = index; j < beadedNecklace.length; j++) {
                    if (beadedNecklace[j] != 'w') {
                        break;
                    } else {
                        count++;
                        index++;
                    }
                }
            }

            // if the necklace wasnt all white...
            if (index < beadedNecklace.length) {
                // if first bead is red...
                if (beadedNecklace[index] == 'r') {
                    // adds to count until it finds a blue bead
                    for (int j = index; j < beadedNecklace.length; j++) {
                        if (beadedNecklace[j] == 'b') {
                            break;
                        } else {
                            count++;
                            index++;
                        }
                    }

                    // adds to count until it finds another red bead
                    for (int j = index; j < beadedNecklace.length; j++) {
                        if (beadedNecklace[j] == 'r') {
                            break;
                        } else {
                            count++;
                        }
                    }
                }

                // if first bead is blue...
                else if (beadedNecklace[index] == 'b') {
                    // adds to count until it finds a red bead
                    for (int j = index; j < beadedNecklace.length; j++) {
                        if (beadedNecklace[j] == 'r') {
                            break;
                        } else {
                            count++;
                            index++;
                        }
                    }

                    // adds to count until it finds another blue bead
                    for (int j = index; j < beadedNecklace.length; j++) {
                        if (beadedNecklace[j] == 'b') {
                            break;
                        } else {
                            count++;
                        }
                    }
                }
            }

            // if the count of beads is longer than previous maximum it replaces it
            if (count > max) {
                // if count is greater than ossible necklace length the max become necklace
                // length
                if (count >= beads) {
                    max = beads;
                } else {
                    max = count;
                }
            }
        }

        // outputs maximum necklace length
        out.println(max);

        // ends program
        in.close();
        out.close();
    }
}
