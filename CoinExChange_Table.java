import java.io.*;
import java.util.*;
public class CoinExChange_Table
{
  public static void main(String args[])
  {
    int coins[]={0,1,10,7};//denomiation of Coins
    int n;
    Scanner scan=new Scanner(System.in);
    n=scan.nextInt();
    int x=n+1;int y=coins.length;
    int[][] v=new int[x][y];
    for(int i=0;i<x;i++)
    {
      v[i][0]=0;
      v[i][1]=i;
    }
    for(int j=0;j<y;j++)
      v[0][j]=0;
    for(int j=2;j<y;j++)
      for(int i=1;i<x;i++)
      {
        if(i>=coins[j] && v[i][j-1]>=v[i-coins[j]][j]+1)
          v[i][j]=v[i-coins[j]][j]+1;
        else
          v[i][j]=v[i][j-1];
      }
    System.out.println("Minimum Number of Coins required are : "+v[n][y-1]);

    System.out.print("    ");
    for(int j=1;j<y;j++)
      System.out.print(coins[j]+"  ");
    printArray(v,x,y);
    
    backTrackCoins(v,coins,x,y);
  }//End of Main
  public static void backTrackCoins(int[][] a,int[] coins,int x,int y)
  {
    System.out.print("Coins Used are : ");
    int i=x-1,j=y-1;
    while(j>1)
    {
      if(a[i][j]==a[i][j-1])
        j=j-1;
      else
      {
        System.out.print("["+coins[j]+"]"+" ");
        i=i-coins[j];
      }
    }
    if(i>0)
      System.out.print("["+i+"->1's]");
    System.out.println();
  }//End of backTrackCoins
  public static void printArray(int[][] a,int x,int y)
  {
    System.out.println();
    System.out.println("--------------------------------------");
    System.out.print("    ");
    for(int j=1;j<y;j++)
      System.out.print(j+"  ");
    System.out.println();
    System.out.println("--------------------------------------");
    for(int i=1;i<x;i++)
    {
      System.out.print(i+"   ");
      for(int j=1;j<y;j++)
        System.out.print(a[i][j]+"  ");
      System.out.println();
    }
  }//End of PrintArray
}
