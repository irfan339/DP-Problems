import java.io.*;
import java.util.*;
class LongestCommonSubsequenceArray
{
  public static void main(String args[])
  {
    LongestCommonSubsequenceArray lcs = new LongestCommonSubsequenceArray();
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
  int lcs( char[] X, char[] Y, int m, int n )
  {
    int L[][] = new int[2][n+1];

   /* Following steps build L[m+1][n+1] in bottom up fashion. Note
        that L[i][j] contains length of LCS of X[0..i-1] and Y[0..j-1] */
    for (int i=0; i<=m; i++)
      for (int j=0; j<=n; j++)
      {
        if (i == 0 || j == 0)
            L[i%2][j] = 0;
        else if (X[i-1] == Y[j-1])
            L[i%2][j] = L[(i+1)%2][j-1] + 1;
        else
            L[i%2][j] = max(L[(i+1)%2][j], L[i%2][j-1]);
      }
     return L[m%2][n];
    }//end of lcs function
}
