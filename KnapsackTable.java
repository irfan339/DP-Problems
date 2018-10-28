import java.io.*;
import java.util.*;
public class KnapsackTable
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
    int table[][]=new int[n+1][C+1];
    knapsackTable(table,wt,val,n,C);
    printArray(table,n,C);
    System.out.println(table[n][C]);
    backTrack(table,n,C,wt,val);
  }
  public static void backTrack(int table[][],int n,int C,int wt[],int val[])
  {
    int i=n,j=C;
    System.out.println("Items included in Knapsack are BackTacked : ");
    while(i>=1)
    {
      if(j>=wt[i-1] && table[i][j]==val[i-1]+table[i-1][j-wt[i-1]])
      {
        System.out.println(i);
        j=j-wt[i-1];//this should be above decrement of i only
        i=i-1;
      }
      else
        i=i-1;
    }
  }
  public static void knapsackTable(int table[][],int wt[],int val[],int n,int C)
  {
    for(int i=0;i<=n;i++)
      for(int j=0;j<=C;j++)
      {
        if(i==0) table[i][j]=0;
        else if(j==0) table[i][j]=0;
        else if(j>=wt[i-1] && table[i-1][j]<val[i-1]+table[i-1][j-wt[i-1]] )
          table[i][j]=val[i-1]+table[i-1][j-wt[i-1]];
        else
          table[i][j]=table[i-1][j];
      }
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
    for(int i=1;i<=x;i++)
    {
      System.out.print(i+"   ");
      for(int j=1;j<=y;j++)
        System.out.print(a[i][j]+"  ");
      System.out.println();
    }
  }//End of PrintArray
}
