import java.io.*;
class MaximumRectangleBinarySubmatrixWith1usingMTable
{
  public static void main (String[] args)
  {
      int A[][] = { {0, 1, 1, 0},
                    {1, 1, 1, 1},
                    {1, 1, 1, 1},
                    {1, 1, 0, 0},
                  };
      int R = A.length;
      int C = A[0].length;

      int M[][]=new int[R][C];
      for(int j=0;j<C;j++)
        M[0][j]=A[0][j];
      for(int i=1;i<R;i++)
        for(int j=0;j<C;j++)
          M[i][j]=M[i-1][j]+A[i][j];
      for(int i=0;i<R;i++)
        for(int j=1;j<C;j++)
          M[i][j]=M[i][j]+M[i][j-1];


      maxRectangle(R,C,A,M);
  }
  static void maxRectangle(int n,int m,int[][] A,int[][] M)
  {
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
            if(sum>max && sum==(c-a+1)*(d-b+1))
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
