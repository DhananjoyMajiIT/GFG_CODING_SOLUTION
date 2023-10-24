//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String str = in.readLine();
            Solution ob = new Solution();
            System.out.println(ob.palindromicPartition(str));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int palindromicPartition(String str)
    {
        // code here
        int n=str.length();
        int dp[][]=new int[n][n];
        
        for(int g=1;g<n;g++){
            for(int row=0,col=g;row<n-g;row++,col++){
                if(isPalindrome(str,row,col)){
                    dp[row][col]=0;
                }else{
                    dp[row][col]=Integer.MAX_VALUE;
                    for(int i=row;i<col;i++){
                        dp[row][col]=Math.min(dp[row][col],1+dp[row][i]+dp[i+1][col]);
                    }
                }
            }
        }
        return dp[0][n-1];
    }
    static boolean isPalindrome(String s,int i,int j){
        while(i<j){
            if(s.charAt(i++)!=s.charAt(j--)){
                return false;
            }
        }
        return true;
    }
}