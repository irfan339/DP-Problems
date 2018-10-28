import java.util.*;
import java.io.*;
class SubsetSumTable
{
  public static void main(String args[])
  {
    Scanner s=new Scanner(System.in);
    System.out.println("Enter the number of elements in Set : ");
    int n=s.nextInt();
    int[] set=new int[n+1];
    System.out.println("Enter elements of Set : ");
    for(int i=1;i<=n;i++)
      set[i]=s.nextInt();
    System.out.println("Enter the Sum to find : ");
    int sum=s.nextInt();
    boolean[][] Table=new boolean[n+1][sum+1];
    if(subsetSumTable(Table,set,n,sum)==true)
    {
      System.out.println("Sum is Possible");
      backTrack(Table,set,n,sum);
    }
    else
    {
        int i=n,j=sum;
        System.out.println("Sum "+sum+" is not Possible");
        System.out.print("Next Largest Sum which is Possible and less than "+sum+" is : ");
        while(j>0)
        {
          if(Table[i][j]==true) break;
          j=j-1;
        }
        System.out.println(j);
        backTrack(Table,set,n,j);
    }
  }//End of main
  static boolean subsetSumTable(boolean[][] Table,int[] set,int n,int sum)
  {
    for(int i=0;i<=n;i++) Table[i][0]=true;
    for(int j=1;j<=sum;j++) Table[0][j]=false;
    for(int i=1;i<=n;i++)
      for(int j=1;j<=sum;j++)
      {
        if(set[i]<=j)
          Table[i][j]=Table[i-1][j]||Table[i-1][j-set[i]];
        else
          Table[i][j]=Table[i-1][j];
      }
    return Table[n][sum];
  }
  static void backTrack(boolean[][] Table,int[] set,int n,int sum)
  {
    int i=n,j=sum;
    System.out.println("Elements backTracked that might be present in SubsetSum of "+sum+" are :");
    while(i>0)
    {
      if(j>=set[i] && Table[i][j]==Table[i-1][j-set[i]])
      {
        System.out.print(set[i]+" ");
        j=j-set[i];
      }
      i=i-1;
    }
    System.out.println();
  }//end of backTrack
}
