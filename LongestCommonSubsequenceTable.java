import java.io.*;
import java.util.*;
class LongestCommonSubsequenceTable
{
  public static void main(String args[])
  {
    LongestCommonSubsequenceTable lcs = new LongestCommonSubsequenceTable();
    String s1 = "ABCBDAB";
    String s2 = "BDCABA";

    char[] X=s1.toCharArray();
    char[] Y=s2.toCharArray();
    int m = X.length;
    int n = Y.length;

    System.out.println("Length of LCS is" + " " +
                               lcs.lcs( X, Y, m, n ) );

  }
  int max(int a, int b)
  {
    return (a > b)? a : b;
  }
  /* Returns length of LCS for X[0..m-1], Y[0..n-1] */
  int lcs( char[] X, char[] Y, int m, int n )
  {
    int L[][] = new int[m+1][n+1];

   /* Following steps build L[m+1][n+1] in bottom up fashion. Note
        that L[i][j] contains length of LCS of X[0..i-1] and Y[0..j-1] */
    for (int i=0; i<=m; i++)
      for (int j=0; j<=n; j++)
      {
        if (i == 0 || j == 0)
            L[i][j] = 0;
        else if (X[i-1] == Y[j-1])
            L[i][j] = L[i-1][j-1] + 1;
        else
            L[i][j] = max(L[i-1][j], L[i][j-1]);
      }

      System.out.print("Longest Common Subsequence is : ");
      int i=m,j=n,k=L[m][n];
      char[] s=new char[k];
      while(i>0 && j>0)
      {
        if(X[i-1]==Y[j-1])
        {
          s[--k]=X[i-1];
          i=i-1;
          j=j-1;
        }
        else if(L[i-1][j]<L[i][j-1]) j=j-1;
        else i=i-1;
      }
      System.out.println(s);
     return L[m][n];
    }//end of lcs function

}
