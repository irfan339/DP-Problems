import java.io.*;
class MaximumSquareBinarySubmatrixWith1usingMArray
{
  public static void main (String[] args)
  {
      int A[][] = { {0, 1, 1, 0, 1},
                {1, 1, 0, 1, 0},
                {0, 1, 1, 1, 0},
                {1, 1, 1, 1, 0},
                {1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0}
                  };
      int R = A.length;
      int C = A[0].length;

      int M[]=new int[C];
      maxRectangle(R,C,A,M);
  }
  static void maxRectangle(int n,int m,int[][] A,int[] M)
  {
    int max=Integer.MIN_VALUE;
    int p1=0,p2=0,q1=0,q2=0;
    int result[]=new int[3];

    int i=n-1;
    for(int j=0;j<m;j++)
    {
      if(A[i][j]==1)
      {
        int k=i;
        while(k>=0 && A[k][j]==1)
        {
          M[j]=M[j]+A[k][j];
          k=k-1;
        }
      }
      else
        M[j]=A[i][j];
    }
    Findsolution(M,result);
    max=result[0];
    p2=result[1];
    q2=result[2];
    p1=i+1-(q2-p2+1);
    q1=i;
    for(i=n-2;i>-1;i--)
    {
      for(int j=0;j<m;j++)
      {
        if(M[j]>1) M[j]=M[j]-1;
        else if(A[i][j]==0) M[j]=A[i][j];
        else
        {
          int k=i;
          while(k>=0 && A[k][j]==1)
          {
            M[j]=M[j]+A[k][j];
            k=k-1;
          }
        }//else
      }// j
      Findsolution(M,result);
      if(max<result[0])
      {
        max=result[0];
        p2=result[1];
        q2=result[2];
        p1=i+1-(q2-p2+1);
        q1=i;
      }
    }// i
    System.out.println("Max sum of Submatrix is : "+max);
    System.out.println("(a,b) = ("+p1+","+p2+")");
    System.out.println("(c,d) = ("+q1+","+q2+")");
  }
  static void printArray(int a[])
  {
    System.out.println();
    for(int i=0;i<a.length;i++)
      System.out.print(a[i]+" ");
    System.out.println();
  }
  public static void Findsolution(int arr[],int result[])
  {
    printArray(arr);
    int n=arr.length;
    int LMIN[]=new int[n];
    int RMIN[]=new int[n];
    //Here we are only pushing Indexes only in the stack
    Stack s=new Stack(n);
    //RMIN implementation
    s.push(0);
    int i=-1;
    for(int j=1;j<n;j++)
    {
        i=s.top();
        while(i>=0 && arr[j]<arr[i])
        {
          RMIN[i]=j;
          s.pop();
          i=s.top();
        }
        s.push(j);
    }
    i=s.top();
    while(i>=0)
    {
      RMIN[i]=n;
      s.pop();
      i=s.top();
    }
    //LMIN implementation
    s.push(n-1);
    for(int j=n-2;j>=0;j--)
    {
        i=s.top();
        while(i>=0 && arr[j]<arr[i])
        {
          LMIN[i]=j;
          s.pop();
          i=s.top();
        }
        s.push(j);
    }
    i=s.top();
    while(i>=0)
    {
      LMIN[i]=-1;
      s.pop();
      i=s.top();
    }
    //--------------------
    int max=Integer.MIN_VALUE;
    int maxl=0,maxr=n-1;
    for(int j=0;j<n;j++)
    {
      int l=LMIN[j]+1;
      int r=RMIN[j]-1;
      int height=arr[j];
      int length=r-l+1;
      int min=(height<length)?height:length;
      int area=min*min;
      if(area>max)
      {
        max=area;
        maxl=l;
        if(height<length)
          maxr=l+height-1;
        else
          maxr=r;
      }
    }
    result[0]=max;
    result[1]=maxl;
    result[2]=maxr;
    System.out.println("Max Area of Rectangle in Histogram : "+max);
    System.out.println("Index of (l,r) : "+"("+maxl+","+maxr+")");
  }//End of Findsolution
}
class Stack
{
  int a[];
  int top=-1;
  Stack(int l)
  {
    a=new int[l];
  }
  void push(int x)
  {
      a[++top]=x;
  }
  void pop()
  {
    top--;
  }
  int top()
  {
    if(top>=0) return a[top];
    return -1;
  }
}
