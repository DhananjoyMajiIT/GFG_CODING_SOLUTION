//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t > 0) {
            String inputLine[] = br.readLine().trim().split(" ");
            int n = inputLine.length;
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            Solution ob = new Solution();
            int[] ans = new int[n];
            ans = ob.productExceptSelf(arr);

            for (int i = 0; i < n; i++) {
                System.out.print(ans[i] + " ");
            }
            System.out.println();
            System.out.println("~");
            t--;
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    public static int[] productExceptSelf(int arr[]) {
        // code here
        int n=arr.length;
        int[]ans=new int[n];
        int zero=0, product=1;
        for(int i:arr){
            if(zero==0 && i==0){
                zero =1;
            }
            else{
                product *=i;
            }
        }
        
        for(int i=0;i<n;i++){
            if(arr[i]==0){
                ans[i]=product;
            }else if(zero==1){
                ans[i]=0;
            }else{
                ans[i]=product/arr[i];
            }
        }
        return ans;
    }
}
