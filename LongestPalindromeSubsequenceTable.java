//Solving diagonally here
import java.io.*;
import java.util.*;
public class LongestPalindromeSubsequenceTable
{
  public static void main(String args[])
  {
    Scanner s=new Scanner(System.in);
    String seq=s.nextLine();
    longestPalindromeTable(seq);
  }
  static int max(int x,int y){return (x>y)?x:y; }
  static void longestPalindromeTable(String seq)
  {
    int n=seq.length();
    int i,j,k;
    int L[][]=new int[n][n];
    for(i=0;i<n;i++)
      L[i][i]=1;
    for(k=2;k<=n;k++)
      for(i=0;i<n-k+1;i++)
      {
        j=i+k-1;
        if(seq.charAt(i)==seq.charAt(j) && k==2) L[i][j]=2;
        else if(seq.charAt(i)==seq.charAt(j) ) L[i][j]=2+L[i+1][j-1];
        else L[i][j]=max(L[i][j-1],L[i+1][j]);
      }
    System.out.println("Length of LPS is : "+L[0][n-1]);
    //we are backTracking here to get the LongestPalindromeSubsequence
    i=0;j=n-1;k=L[0][n-1];
    char[] s=new char[k+1];
    s[k]='\0';
    int p=0,q=k-1;
    while(i<=j)
    {
      if(i==j)
      {
        s[p]=seq.charAt(i);
        //System.out.println(seq.charAt(i)+" "+p+" "+s[p]);
        i=i+1;
        j=j-1;
      }
      else if(seq.charAt(i)==seq.charAt(j))
      {
        s[p++]=seq.charAt(i);
        //System.out.println(seq.charAt(i)+" "+(p-1)+" "+s[p-1]);
        s[q--]=seq.charAt(j);
        //System.out.println(seq.charAt(j)+" "+(q+1)+" "+s[q+1]);
        i=i+1;
        j=j-1;
      }
      else if(L[i][j-1]>L[i+1][j]) j=j-1;
      else i=i+1;
    }
    System.out.println("Longest Length Palindrome Subsequence is : "+new String(s));
  }
}
