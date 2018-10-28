//Here we solved Matrix table diagonally
import java.io.*;
class MatrixChainMultiply
{
  public static void main(String args[])
  {
    int a[]={40, 20, 30, 10, 30};
    //{1,2,3,4};
    //{1,10,5,2,25,4};
    matrixChainOrder(a,a.length);
  }
  static void matrixChainOrder(int p[],int n)
  {
    int m[][]=new int [n][n];
    for(int i=1;i<n;i++)
      m[i][i]=0;
    for(int l=2;l<n;l++)
    {
      for(int i=1;i<n-l+1;i++)
      {
        int j=i+l-1;
        m[i][j]=Integer.MAX_VALUE;
        for(int k=i;k<=j-1;k++)
        {
          int q=m[i][k]+m[k+1][j]+p[i-1]*p[k]*p[j];
          if(q<m[i][j]) { m[i][j]=q;m[j][i]=k;}
        }//end of outer for of k
      }//end of inner for of i
    }//end of outer for of l
    printMatrixMultiplyOrder(1,n-1,m,"A".toCharArray());
    System.out.println();
    //int i='A';
    //System.out.println(i+" "+(i+1));
    System.out.println("Minimum number of Matrix Multiplications : "+m[1][n-1]);
  }//end of matrixChainOrder
  static void printMatrixMultiplyOrder(int i,int j,int[][] m,char[] name)
  {
    if(i>j) return;
    if(i==j)
    {
      System.out.print(name[0]);
      name[0]=(char)(name[0]+1);
      return;
    }
    System.out.print("(");
    printMatrixMultiplyOrder(i,m[j][i],m, name);
    printMatrixMultiplyOrder(m[j][i]+1,j,m, name);
    System.out.print(")");
  }//end of print function
}//end of class
