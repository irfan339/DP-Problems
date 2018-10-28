import java.io.*;
class MaxSumSubmatrixRorSwithM
{
  public static void main(String args[])
  {
    int A[][] = {  {1, 2, -1, -4, -20},
                   {-8, -3, 4, 2, 1},
                   {3, 8, 10, 1, 3},
                   {-4, -1, 1, 7, -6}
                };
    //Pre Calculating Matrix m
    int n=A.length;
    int m=A[0].length;
    int M[][]=new int[n][m];
    for(int j=0;j<m;j++)
      M[0][j]=A[0][j];
    for(int i=1;i<n;i++)
      for(int j=0;j<m;j++)
        M[i][j]=M[i-1][j]+A[i][j];
    for(int i=0;i<n;i++)
      for(int j=1;j<m;j++)
        M[i][j]=M[i][j]+M[i][j-1];

    maxSumSubmatrix(A,M);
  }
  static void maxSumSubmatrix(int[][] A,int[][] M)
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
            if(a>0 && b>0)
              sum=M[c][d]-M[a-1][d]-M[c][b-1]+M[a-1][b-1];
            else if(a>0)
              sum=M[c][d]-M[a-1][d];
            else if(b>0)
              sum=M[c][d]-M[c][b-1];
            else
              sum=sum=M[c][d];
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
