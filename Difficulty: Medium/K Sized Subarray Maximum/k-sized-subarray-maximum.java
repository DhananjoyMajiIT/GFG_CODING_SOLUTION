//{ Driver Code Starts
// Initial template for JAVA

import java.io.*;
import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        // taking input using class Scanner
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            // taking total number of elements
            int k = Integer.parseInt(br.readLine());
            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;
            ArrayList<Integer> res = new Solution().max_of_subarrays(k, arr);

            // printing the elements of the ArrayList
            for (int i = 0; i < res.size(); i++) System.out.print(res.get(i) + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function template for JAVA

class Solution {
    // Function to find maximum of each subarray of size k.
    public ArrayList<Integer> max_of_subarrays(int k, int arr[]) {
        ArrayList<Integer>ans=new ArrayList<>();
       int maxval=findMax(0,k-1,arr);
       ans.add(maxval);
       
       for(int i=1;i<=arr.length-k;i++){
           if(maxval==arr[i-1]){
               maxval=findMax(i,i+k-1,arr);
               ans.add(maxval);
           }
           else{
               maxval=Math.max(maxval,arr[i+k-1]);
               ans.add(maxval);
           }
       }
       return ans;
       
    }
    public int findMax(int start, int end, int arr[]){
        int max=0;
        while(start <= end){
            max = Math.max(max, arr[start]);
            start++;
        }
        return max;
    }
}