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


// User function Template for Java

class Solution {

    public int maxWater(int arr[]) {
        // Code Here
        int ans=0;
        
        int n = arr.length;
        
        int i=0;
        int j=n-1;
        
        while(i<j){
          
                int dis=j-i;
                int minval=Math.min(arr[i],arr[j]);
                int temp=minval*dis;
                
                if(ans<temp){
                    ans=temp;
                }
                if(arr[i]<arr[j]){
                    i++;
                }else{
                    j--;
                }
            
        }
        return ans;
    }
}