//If Knapsack C is very large and Sumof(Values) is not very large
import java.io.*;
import java.util.*;
class CLargeKnapsackArray
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
    int table[][]=new int[2][p+1];
    knapsackArray(table,wt,val,n,p);
    //printArray(table,2,p);
    int i=n%2,j=p;
    while(j>0)
    {
      if(table[i][j]<=C)
        break;
      else
        j=j-1;
    }
    System.out.println(j);
  }
  public static void knapsackArray(int table[][],int wt[],int val[],int n,int p)
  {
    int sum=0;
    for(int i=0;i<=n;i++)
    {
      if(i>0) sum+=val[i-1];
      for(int j=0;j<=p;j++)
      {
        if(i==0) table[i][j]=1000000000;
        else if(j==0) table[i%2][j]=1000000000;
        else if(val[i-1]>=j )
          table[i%2][j]=table[(i+1)%2][j]<wt[i-1]?table[(i+1)%2][j]:wt[i-1];
        else if(j<=sum)
          table[i%2][j]=(table[(i+1)%2][j]<wt[i-1]+table[(i+1)%2][j-val[i-1]])?table[(i+1)%2][j]:wt[i-1]+table[(i+1)%2][j-val[i-1]];
        else
          table[i%2][j]=table[(i+1)%2][j];
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
    for(int i=0;i<x;i++)
    {
      System.out.print(i+"   ");
      for(int j=1;j<=y;j++)
        System.out.print(a[i][j]+"  ");
      System.out.println();
    }
  }//End of PrintArray
}
