import java.util.*;
import java.io.*;
class TotalNumberOfCoinsChangeTable
{
  public static void main(String args[])
  {
    int coins[]={0,1,10,7};//denomiation of Coins
    int n;
    Scanner scan=new Scanner(System.in);
    n=scan.nextInt();
    int x=n+1;int y=coins.length;
    int[][] T=new int[x][y];
    for(int j=0;j<y;j++)//make it 1 way as all payment done only then came at i==0
      T[0][j]=1;
    for(int i=1;i<x;i++)
    {
      T[i][0]=0;
      T[i][1]=1;
    }
    for(int j=2;j<y;j++)
      for(int i=1;i<x;i++)
        T[i][j]=T[i][j-1]+(i>=coins[j]?T[i-coins[j]][j]:0);

    System.out.println("Total Number of ways Coins can be distributed are : "+T[n][y-1]);

    System.out.print("    ");
    for(int j=1;j<y;j++)
      System.out.print(coins[j]+"  ");
    printArray(T,x,y);
  }
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
