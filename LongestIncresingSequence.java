import java.io.*;
  class LongestIncresingSequence
{
  public static void main(String args[])
  {
    int A[]={12,7,10,8,1,6,5,14,4,9,10,2};
    //int A[] = { 10, 22, 9, 33, 21, 50, 41, 60,80 };
    int n = A.length;

    int LS[]=new int[n];
    int LIS[]=new int[n];
    int LDS[]=new int[n];

    int K[]=new int[n];
    int K1[]=new int[n];
    int K2[]=new int[n];
    for(int i=0;i<n;i++)
    {
      K1[i]=-1;
      K2[i]=-1;
      LIS[i]=LDS[i]=1;
    }

    System.out.println("Length of Longest Sequence is " + LengthofLS(A,LS,LIS,LDS,K1,K2) );
    backTrackLongestSequence(A,LS,LIS,LDS,K1,K2,K);
  }
  static int LengthofLS(int[] a,int[] LS,int[] LIS,int[] LDS,int[] K1,int[] K2)
  {
    int n=a.length;
    LIS[n-1]=1;
    LDS[n-1]=1;

    for(int i=n-1;i>=0;i--)
    {
      for(int j=i+1;j<n;j++)
      {
        if(a[j]>=a[i] && LIS[i]<1+LIS[j]) { LIS[i]=1+LIS[j]; K1[i]=j; }
        if(a[j]<a[i] && LDS[i]<1+LDS[j]) { LDS[i]=1+LDS[j]; K2[i]=j; }
      }//inner for loop
      LS[i]=LIS[i]+LDS[i]-1;
    }//outer for loop
    /*
    System.out.print("LIS : ");
    printArray(LIS,n);
    System.out.print("LDS : ");
    printArray(LDS,n);
    System.out.print("LS : ");
    printArray(LS,n);
    */
    //printArray(K1,n);
    //printArray(K2,n);
    int max=Integer.MIN_VALUE;
    //Max value is our length of LS
    for(int i=0;i<n;i++)
      if(LS[i]>max)
        max=LS[i];
    return max;
  }
  static void printArray(int[] T,int n)
  {
    for(int i=0;i<n;i++)
      System.out.print(T[i]+"  ");
    System.out.println();
  }
  static void backTrackLongestSequence(int[] a,int[] LS,int[] LIS,int[] LDS,int[] K1,int[] K2,int[] K)
  {
    //Here we have only used K array as reference to indicate whether that particular indexed element
    //is present in Longest Sequence or not by 1-Present and 0-Not Present
    //but we have not used K for printing elements insetad used store array for printing elements

    //Here in backTracking we get the sequence which will come first from left to right Scan
    int n=a.length;
    int max=0;
    for(int i=0;i<n;i++)
      if(LS[i]>LS[max])
        max=i;
    System.out.println("First Included element in Longest Sequence is : "+a[max]);
    //printArray(LS,n);
    //System.out.println(max);

    int x=LS[max];
    int store[]=new int[x];
    int y=LDS[max];
    int j=max;
    while(j!=-1)//for LDS
    {
      K[j]=1;
      store[--y]=a[j];
      j=K2[j];
    }

    y=LDS[max]-1;
    j=max;
    while(j!=-1)//for LIS
    {
      K[j]=1;
      store[y++]=a[j];
      j=K1[j];
    }
    System.out.println("Longest Incresing Sequence is as follows : ");
    for(int i=0;i<store.length;i++)
      System.out.print(store[i]+" ");
    System.out.println();
  }
}//End of class
