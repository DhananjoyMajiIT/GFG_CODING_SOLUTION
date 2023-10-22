//{ Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] input = new String[2]; 
            input = br.readLine().split(" "); 
            int m = Integer.parseInt(input[0]); 
            int n = Integer.parseInt(input[1]); 
            Solution ob = new Solution();
            System.out.println(ob.numberOfPaths(m,n));
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution
{
     int x;
    int y;
    long dp[][];
    long mod=1000000007;
    long numberOfPaths(int M, int N) {
        // Code Here
        dp=new long[M][N];
        x=M;
        y=N;
        return dfs(0,0);
    }
    long dfs(int i,int j){
        if(i==x-1 || j==y-1)return 1;
        if(dp[i][j]!=0)return dp[i][j];
        long right=dfs(i,j+1);
        long left=dfs(i+1,j);
        return dp[i][j]=(left+right)%mod;
    }
}