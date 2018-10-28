import java.io.*;
import java.util.*;
public class KnapsackArray
{
  public static void main(String args[])
  {
    Scanner scan=new Scanner(System.in);
    int n=scan.nextInt();
    int wt[]=new int[n];
    int val[]=new int[n];
    for(int i=0;i<n;i++)
      wt[i]=scan.nextInt();
    for(int i=0;i<n;i++)
      val[i]=scan.nextInt();
    int C=scan.nextInt();
    int table[][]=new int[2][C+1];
    knapsackArray(table,wt,val,n,C);
    //printArray(table,2,C);
    System.out.println(table[n%2][C]);
    System.out.println(knapsackSingleArray(val,wt,n,C));
  }
  public static void knapsackArray(int table[][],int wt[],int val[],int n,int C)
  {
    for(int i=0;i<=n;i++)
      for(int j=0;j<=C;j++)
      {
        if(i==0) table[i%2][j]=0;
        else if(j==0) table[i%2][j]=0;
        else if(j>=wt[i-1] && table[(i+1)%2][j]<val[i-1]+table[(i+1)%2][j-wt[i-1]] )
          table[i%2][j]=val[i-1]+table[(i+1)%2][j-wt[i-1]];
        else
          table[i%2][j]=table[(i+1)%2][j];
      }
  }
  public static int knapsackSingleArray(int[] val,int[] wt,int n,int C)
  {
    int dp[]=new int[C+1];
    for(int i=0;i<n;i++)
      for(int j=C;j>=wt[i];j--)
        dp[j]=Math.max(dp[j],val[i]+dp[j-wt[i]]);
    return dp[C];
  }
  public static void printArray(int[][] a,int x,int y)
  {
    System.out.println();
    System.out.println("--------------------------------------");
    System.out.print("    ");
    for(int j=1;j<=y;j++)
      System.out.print(j+"  ");
    System.out.println();

    System.out.println("--------------------------------------");
    for(int i=0;i<x;i++)
    {
      System.out.print(i+"   ");
      for(int j=1;j<=y;j++)
        System.out.print(a[i][j]+"  ");
      System.out.println();
    }
  }//End of PrintArray
}
