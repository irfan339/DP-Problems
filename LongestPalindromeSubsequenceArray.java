//Solving bottom up here
import java.io.*;
import java.util.*;
public class LongestPalindromeSubsequenceArray
{
  public static void main(String args[])
  {
    Scanner s=new Scanner(System.in);
    String seq=s.nextLine();
    longestPalindromeArray(seq);
  }
  static void longestPalindromeArray(String seq)
  {
    int n=seq.length();
    int a[]=new int[n];
    for(int i=n-1;i>=0;i--)
    {
      int backup=0;
      for(int j=i;j<n;j++)
      {
        if(j==i)
          a[j]=1;
        else if(seq.charAt(i)==seq.charAt(j))
        {
          int temp=a[j];
          a[j]=backup+2;
          backup=temp;
        }
        else
        {
          backup=a[j];
          a[j]=Math.max(a[j-1],a[j]);
        }
      }//inner for loop
    }//outer for loop
    System.out.println("Length of LPS is : "+a[n-1]);
  }//end of function
}
