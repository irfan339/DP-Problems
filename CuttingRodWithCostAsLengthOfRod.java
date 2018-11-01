import java.io.*;
class CuttingRodWithCostAsLengthOfRod
{
  public static void main(String args[])
  {
    //Always Cutting points Should be in increasing order only
    //Cutting poins are from L[1] to L[n-2]
    //L[0] should be "0" and L[n] is the length of the Rod
    int L[]={0,75,90,95,100};
    //int L[]={0,25,50,75,100};
    //int L[]={0, 5, 8, 9, 10, 17, 20};
    int n=L.length;
    int T[][]=new int[n][n];

    for(int l=2;l<=n;l++)
    {
      for(int i=0;i<n-l+1;i++)
      {
        int j=i+l-1;
        if(i+1==j)
          T[i][j]=0;
        else
        {
          T[i][j]=Integer.MAX_VALUE;
          for(int k=i+1;k<j;k++)
          {
            int q=L[j]-L[i]+T[i][k]+T[k][j];
            //System.out.println(i+" "+j+" "+q+" "+T[i][j]);
            if(q<T[i][j])
            {
              T[i][j]=q;
              T[j][i]=k;
              //System.out.println(i+" "+j+" "+k+" "+q+" "+T[i][j]);
            }
            //System.out.println(i+" "+j+" "+q+" "+T[i][j]);
          }//end of k
        }//end of else
      }//end of i
    }//end of l
    System.out.println("Minimum Cost for Cutting the rod at given points is : "+T[0][n-1]);
    System.out.print("Order of Cutting the rod is : ");
    printCuttingOfRod(0,n-1,T,L);
    System.out.println();
  }//end of main
  static void printCuttingOfRod(int i,int j,int[][] T,int[] L)
  {
    if(i>=j) return;
    if(i+1==j) return;
    //System.out.print("(");
    System.out.print(L[T[j][i]]+" ");
    printCuttingOfRod(i,T[j][i],T,L);
    printCuttingOfRod(T[j][i],j,T,L);
    //System.out.print(")");
  }//end of print function

}
