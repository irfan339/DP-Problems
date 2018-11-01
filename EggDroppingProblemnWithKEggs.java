import java.io.*;

class EggDroppingProblemnWithKEggs
{
    public static void main (String[] args)
    {
        int n = 30;//floors
        int k=4;//eggs
        int T[][]=new int[n+1][k+1];
        int P[][]=new int[n+1][k+1];
        System.out.println("Minimum number of trials required with "+n+" Floors and "+
                            k+" Eggs is : "+eggDrop(T,P,n,k) );
      //  printArray(T,n,k);
      //  printArray(P,n,k);
/*
        printArray(T,n,k);
        int[] B={
           1,
           1,1,1,1,1,1,1,1,1,1,
           -1,0,0,0,0,0,0,0,0,0,
           0,0,0,0,0,0,0,0,0,0
         };
        for(int i=1;i<=n;i++)
        {
          if(B[i]==0 && B[i-1]==1)
            P[i][1]=-1;
          else if(B[i]==1)
            P[i][1]=i+1;
        }
        System.out.println("--------------------------");
        printArray(P,n,k);
        backTrackTrials(T,P,B,n,k); */
    }
    static void printArray(int[][] T,int n,int k)
    {
      System.out.print("   ");
      for(int j=0;j<=k;j++)
        System.out.print(j+"  ");
      System.out.println();
      for(int i=0;i<=n;i++)
      {
        System.out.print(i+"  ");
        for(int j=0;j<=k;j++)
          System.out.print(T[i][j]+"  ");
        System.out.println();
      }
    }
    static int max(int a, int b) { return (a > b)? a: b; }
    static int eggDrop(int[][] T,int[][] P,int n, int k)
    {
      // We always need i trials for one egg and i floors.
      for (int i = 1; i <= n; i++)
        T[i][1] = i;

      // We need one trial for one floor and 0 trials for 0 floors
      for (int j = 1; j <= k; j++)
      {
        T[0][j] = 0;
        T[1][j] = 1;
      }
      // Fill rest of the entries in table
      for (int i = 2; i <= n; i++)
      {
        for (int j = 2; j <= k; j++)
        {
          T[i][j] = Integer.MAX_VALUE;
          for (int x = 1; x < i; x++)
          {
            int result=1+Math.max(T[x-1][j-1],T[i-x][j]);
            /*int k=-1;
            if(T[x-1][j-1]>T[i-x][j]) k=x;
            else k=i+x;
            */
            if(result<T[i][j])
            {
              T[i][j]=result;
              P[i][j]=x;
            }
          }//end of x loop
        }//end of j loop
      }//end of i loop

      // T[n][k] holds the result
      return T[n][k];
    }

}//End of Class
