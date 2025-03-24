//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Geeks {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            int arr[] = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }
            System.out.println(new Solution().matrixMultiplication(arr));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    static int matrixMultiplication(int arr[]) {
        // code here
        int n=arr.length;
        int [][]dp=new int[n][n];
        for (int len = 0; len < n; len++) { // len is the chain length
            for (int i = len; i < n; i++) {
                dp[len][i]=-1;
            }}
        
        return solve(arr,0,n-1,dp);
    }
    public static int solve(int []arr,int st,int end,int [][]dp){
        int ans=Integer.MAX_VALUE;
        if(end-st==1)return 0;
        if(dp[st][end]!=-1)return dp[st][end];
        for(int i=st+1;i<end;i++){
            int left=solve(arr,st,i,dp);
            int right=solve(arr,i,end,dp);
            ans=Math.min(ans,left+right+arr[st]*arr[i]*arr[end]);
        }
        return dp[st][end]=ans;
    }
}