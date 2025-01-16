//	  NAME:					Evan Teal
//	  GROUP:					APCS
//	  LAST MODIFIED:		4-3-21
//	  PROBLEM ID:			Acowdemia 2
//	  DESCRIPTION:			Given a number of papers with N authors, finds the
//                      senior most author of each using the rule of seniority
//                      which states the senior most authors are to the left
//                      and authors of the same seniority are arranged alphabetically
//	  SOURCES/HELPERS:	USACO
 
import java.util.*;
import java.io.*;

public class AcowdemiaII
{
   
	public static void main(String[]	args)	throws IOException 
	{
      Scanner in = new Scanner(System.in);
      int K = in.nextInt();
      int N = in.nextInt();
      String garbage = in.nextLine();
      String[] authors = new String[N];
      String[][] publications = new String[K][N];
      String[] output = new String[N];
      int[] seniority = new int[N];
      
      StringTokenizer st = new StringTokenizer(in.nextLine(), " ");
      for(int i=0; i<N; i++)
      {
         authors[i] = st.nextToken();
      }
      for(int i=0; i<K; i++)
      {
         StringTokenizer stk = new StringTokenizer(in.nextLine(), " ");
         for(int j=0; j<N; j++)
         {
            publications[i][j] = stk.nextToken();
         }
      }
      
      for(int i=0; i<K; i++)
      {
         for(int j=0; j<N-1; j++)
         {
            if(publications[i][j].compareTo(publications[i][j+1]) > 0)
            {
               for(int k=j+1; k<N; k++)
               {
                  seniority[find(authors, publications[i][k])]++;
               }
            }
         }
      }
      
      
      for(int i=0; i<N; i++)
      {
         output[i] = "";
         for(int j=0; j<N; j++)
         {
            if(i == j)
            {
               output[i] += "B";
            }
            else
            {
               if(seniority[i] > seniority[j])
               {
                  output[i] += "1";
               }
               else if(seniority[i] < seniority[j])
               {
                  output[i] += "0";
               }
               else
               {
                  output[i] += "?";
               }
            }
         }
      }
      
      for(int i=0; i<N; i++)
      {
         System.out.println(output[i]);
      }
	}
   
   public static int find(String[] arr, String str)
   {
      int index = 0;
      while(!str.equals(arr[index]) && index < arr.length-1)
      {
         index++;
      }
      return index;
   }
}