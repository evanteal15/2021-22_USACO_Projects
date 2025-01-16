/*
ID: evantea1
LANG:	JAVA
TASK:	gift1
*/
 
//	  Name:					Evan Teal
//	  GROUP:				APCS
//	  LAST MODIFIED:		10-23-2020
//	  PROBLEM ID:			Greed Gift Givers
//	  DESCRIPTION:			calculates how	much money each individual in a group of
//						    friends will have after	a series of	money exchanges
//	  SOURCES/HELPERS:	Mr.H, USACO, stackoverflow.com
 
import java.util.*;
import java.io.*;

public class gift1 {

	public static void main(String[] args) throws IOException 
	{
		// sets up the input and output
		BufferedReader in = new BufferedReader(new FileReader("gift1.in"));
		PrintWriter	out = new PrintWriter(new BufferedWriter(new FileWriter("gift1.out")));

		// finds the number of people and sets up the money arrays
		int numPeople = Integer.parseInt(in.readLine());
		int[] negativeMoney = new int[numPeople];
		int[] positiveMoney = new int[numPeople];
		
		// creates an array with everybodies names in it
		String[] groupNames = new String[numPeople];
		for (int k = 0; k < numPeople; k++)	
		{
			groupNames[k] = in.readLine();
		}
		
		// repeats the	giving process
		for (int k = 0; k < numPeople; k++)	
		{
			// finds out who the giver is
			String giver =	in.readLine();

			// takes away money from the giver
			StringTokenizer st = new StringTokenizer(in.readLine());
			int totalGift = Integer.parseInt(st.nextToken());
			for(int j=0; j<numPeople; j++)
			{
				if(groupNames[j].equals(giver))
				{ 
					negativeMoney[j] = totalGift;
				}
			}
			
			// finds the number of receivers
			int numReceivers = Integer.parseInt(st.nextToken());
			int giftAmount = 0 , remainder = 0;
			
			// calculates the amount each	receiver gets and the remainder
			if(numReceivers != 0)
			{
				giftAmount = totalGift/numReceivers;
				remainder =	totalGift%numReceivers;
			}
			else remainder = totalGift;

			// gives each receiver the	correct amount	of	money
			for (int x = 0; x < numReceivers; x++)	
			{
				String temp	= in.readLine();
				for (int y =0;	y < numPeople;	y++)
				{
					if(groupNames[y].equals(temp))
					{
						positiveMoney[y] += giftAmount;
					}
				}
			}
			
			// adds the remaining amount of money back to the giver
			for(int j=0; j < numPeople; j++)
			{
				if(groupNames[j].equals(giver))
				{ 
					positiveMoney[j] += remainder;
				}
			}

		}

		
		
		// outputs everyones total	amount of money
		for(int k =	0;	k < numPeople;	k++)
		{
			out.println(groupNames[k] + " " + (positiveMoney[k] - negativeMoney[k]));
		}
		
		// ends program
		out.close();
		in.close();
	}
}