import java.io.*;
import java.util.*;
public class CoinExChange_Array
{
  public static void main(String args[])
  {
    int coins[]={1,10,7};//denomiation of Coins
    int n;
    Scanner scan=new Scanner(System.in);
    n=scan.nextInt();
    int x=n+1;int y=coins.length;
    int v[]=new int[x];
    for(int i=0;i<x;i++)
      v[i]=i;
    for(int j=1;j<y;j++)
      for(int i=1;i<x;i++)
        if(i>=coins[j] && v[i-coins[j]]+1<=v[i])
          v[i]=v[i-coins[j]]+1;
    System.out.println("Minimum Number of Coins required are : "+v[n]);
    printArray(v,x,coins,y);
    backTrackCoins(v,x,coins,y);
  }//End of public static void main(String[] args)
  public static void backTrackCoins(int v[],int x,int coins[],int y)
  {
    System.out.print("Coins Used are : ");
    int i=x-1,j=y-1;
    while(j>0)
    {
      if(i>=coins[j] && v[i-coins[j]]+1==v[i])
      {
        System.out.print("["+coins[j]+"]"+" ");
        i=i-coins[j];
      }
      else
        j=j-1;
    }
    if(i>0)
      System.out.print("["+i+"->1's]");
    System.out.println();
  }
  public static void printArray(int v[],int x,int coins[],int y)
  {
    System.out.println();
    System.out.print("Coins : ");
    for(int i=0;i<y;i++)
      System.out.print(coins[i]+" ");
    System.out.println();
    for(int i=1;i<x;i++)
      System.out.print(v[i]+" ");
    System.out.println();
  }//End of printArray
}
