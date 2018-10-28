import java.util.*;
import java.io.*;
class TotalNumberOfCoinsChangeArray
{
  public static void main(String args[])
  {
    int coins[]={0,1,10,7};//denomiation of Coins
    int n;
    Scanner scan=new Scanner(System.in);
    n=scan.nextInt();
    int x=n+1;int y=coins.length;
    int[] T=new int[x];
    for(int i=0;i<x;i++)
      T[i]=1;
    for(int j=2;j<y;j++)
      for(int i=1;i<x;i++)
        T[i]=T[i]+(i>=coins[j]?T[i-coins[j]]:0);

    System.out.println("Total Number of ways Coins can be distributed are : "+T[n]);

    printArray(T,x,coins,y);
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
