import java.util.*;
import java.io.*;
class SubsetSumArray
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
    boolean[][] Table=new boolean[2][sum+1];
    if(subsetSumArray(Table,set,n,sum)==true)
      System.out.println("Sum is Possible");
    else
    {
        int i=n%2,j=sum;
        System.out.println("Sum "+sum+" is not Possible");
        System.out.print("Next Largest Sum which is Possible and less than "+sum+" is : ");
        while(j>0)
        {
          if(Table[i][j]==true) break;
          j=j-1;
        }
        System.out.println(j);
     }
  }//End of main
  static boolean subsetSumArray(boolean[][] Table,int[] set,int n,int sum)
  {
    for(int i=0;i<=n;i++)
      for(int j=0;j<=sum;j++)
      {
        if(j==0) Table[i%2][j]=true;
        else if(i==0) Table[i%2][j]=false;
        else if(set[i]<=j)
          Table[i%2][j]=Table[(i+1)%2][j]||Table[(i+1)%2][j-set[i]];
        else
          Table[i%2][j]=Table[(i+1)%2][j];
      }
    return Table[n%2][sum];
  }//end of function
}
