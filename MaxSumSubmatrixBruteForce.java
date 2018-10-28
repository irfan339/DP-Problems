import java.io.*;
class MaxSumSubmatrixBruteForce
{
  public static void main(String args[])
  {
    int A[][] = {  {1, 2, -1, -4, -20},
                   {-8, -3, 4, 2, 1},
                   {3, 8, 10, 1, 3},
                   {-4, -1, 1, 7, -6}
                };
    maxSumSubmatrix(A);
  }
  static void maxSumSubmatrix(int[][] A)
  {
    int n=A.length;
    int m=A[0].length;
    int max=Integer.MIN_VALUE;
    int p1=0,p2=0,q1=0,q2=0;
    for(int a=0;a<n;a++)
      for(int b=0;b<m;b++)
        for(int c=a;c<n;c++)
          for(int d=b;d<m;d++)
          {
            int sum=0;
            for(int i=a;i<=c;i++)
              for(int j=b;j<=d;j++)
                sum+=A[i][j];
            if(sum>max)
            {
              max=sum;
              p1=a;p2=b;
              q1=c;q2=d;
            }
          }
    System.out.println("Max sum of Submatrix is : "+max);
    System.out.println("(a,b) = ("+p1+","+p2+")");
    System.out.println("(c,d) = ("+q1+","+q2+")");
  }
}
