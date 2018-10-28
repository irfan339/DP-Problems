//If Knapsack C is very large and Sumof(Values) is not very large
import java.io.*;
import java.util.*;
class CLargeKnapsackTable
{
  public static void main(String args[])
  {
    Scanner scan=new Scanner(System.in);
    int p=0;
    int n=scan.nextInt();
    int wt[]=new int[n];
    int val[]=new int[n];
    for(int i=0;i<n;i++)
      wt[i]=scan.nextInt();
    for(int i=0;i<n;i++)
    {
      val[i]=scan.nextInt();
      p+=val[i];
    }
    int C=scan.nextInt();
    int table[][]=new int[n+1][p+1];
    knapsackTable(table,wt,val,n,p);
    //printArray(table,n,p);
    int i=n,j=p;
    while(j>0)
    {
      if(table[i][j]<=C)
        break;
      else
        j=j-1;
    }
    System.out.println(j);
    backTrack(table,n,j,wt,val);
  }
  public static void knapsackTable(int table[][],int wt[],int val[],int n,int p)
  {
    int sum=0;
    for(int i=0;i<=n;i++)
    {
      if(i>0) sum+=val[i-1];
      for(int j=0;j<=p;j++)
      {
        if(i==0) table[i][j]=1000000000;
        else if(j==0) table[i][j]=1000000000;
        else if(val[i-1]>=j )
          table[i][j]=table[i-1][j]<wt[i-1]?table[i-1][j]:wt[i-1];
        else if(j<=sum)
          table[i][j]=(table[i-1][j]<wt[i-1]+table[i-1][j-val[i-1]])?table[i-1][j]:wt[i-1]+table[i-1][j-val[i-1]];
        else
          table[i][j]=table[i-1][j];
      }
    }
  }
  public static void backTrack(int table[][],int n,int C,int wt[],int val[])
  {
    int i=n,j=C;
    System.out.println("Items included in Knapsack are BackTacked : ");
    while(i>=1 && j>=1)
    {
      if(table[i][j]==table[i-1][j])
          i=i-1;
      else
      {
        System.out.println(i);
        j=j-val[i-1];//this should be above decrement of i only
        i=i-1;
      }
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
