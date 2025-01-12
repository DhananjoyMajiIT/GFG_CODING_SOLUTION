//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Sorting {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            int arr[] = new int[str.length];
            for (int i = 0; i < str.length; i++) arr[i] = Integer.parseInt(str[i]);
            System.out.println(new Solution().maxWater(arr));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    public int maxWater(int arr[]) {
        // code here
        int n=arr.length;
        
        int []larr=new int[n];
        int []rarr=new int[n];
        
        for(int i=0;i<n;i++){
            if(i==0){
                larr[i]=arr[i];
            }
            else{
                larr[i]=Math.max(arr[i],larr[i-1]);
            }
        }
        for(int i=n-1;i>=0;i--){
            if(i==n-1){
                rarr[i]=arr[i];
            }
            else{
                rarr[i]=Math.max(arr[i],rarr[i+1]);
            }
        }
        int ans=0;
        for(int i=0;i<n;i++){
            ans+=Math.min(larr[i],rarr[i])-arr[i]; 
        }
        return ans;
        
    }
}
