import java.io.*;
class LongestIncresingSubsequence
{
  public static void main(String args[])
  {
    int A[]={10,1,20,3,30,2};
    //int A[] = { 10, 22, 9, 33, 21, 50, 41, 60,80 };
    int n = A.length;
    int LIS[]=new int[n];
    int K[]=new int[n];
    for(int i=0;i<n;i++)
      K[i]=-1;
    System.out.println("Length of Longest Increasing Subsequence is " + LengthofLIS(A,LIS,K) );
    backTrackLISSequece(A,LIS,K);
  }
  static int LengthofLIS(int[] a,int[] LIS,int[] K)
  {
    LIS[0]=1;
    int n=a.length;
    for(int i=1;i<n;i++)
      for(int j=0;j<i;j++)
        if(a[j]<=a[i] && LIS[i]<1+LIS[j])
        {
          LIS[i]=1+LIS[j];
          K[i]=j;
        }
    int max=Integer.MIN_VALUE;
    //Max value is our length of LIS
    for(int i=0;i<n;i++)
      if(LIS[i]>max)
        max=LIS[i];
    return max;
  }
  static void backTrackLISSequece(int[] a,int[] LIS,int[] K)
  {
    int n=a.length;
    int max=0;
    int j=0;
    for(int i=0;i<n;i++)
      if(LIS[i]>LIS[max])
      {
        max=i;
        j=K[i];
      }
    int x=LIS[max];
    int store[]=new int[x];
    System.out.println("Longest Incresing Subsequence is as follows : ");
    while(max!=-1)
    {
      store[--x]=a[max];
      //System.out.print(a[max]+" ");
      max=j;
      if(j!=-1)
        j=K[j];
    }
    for(int i=0;i<store.length;i++)
      System.out.print(store[i]+" ");
    System.out.println();
  }
}//End of class
