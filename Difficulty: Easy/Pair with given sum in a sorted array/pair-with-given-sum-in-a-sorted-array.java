//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;


// } Driver Code Ends
// User function Template for Java

class Solution {

    int countPairs(int arr[], int target) {
        // Complete the function
        HashMap<Integer, Integer> prefixSumMap = new HashMap<>();

        int ans = 0; // To store the count of valid subarrays
        int sum = 0; // Running prefix sum
        int n = arr.length;

        // Iterate through the array
        for (int i = 0; i < n; i++) {
           

            // Check if sum - k exists in the map (prefix sum logic)
            if (prefixSumMap.containsKey( target - arr[i])) {
                ans += prefixSumMap.get(target-arr[i]); // Add the frequency of sum - k
            }

            // Update the current prefix sum in the map
            prefixSumMap.put(arr[i], prefixSumMap.getOrDefault(arr[i], 0) + 1);
        }

        return ans;
    }
}


//{ Driver Code Starts.
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {
            String[] inputLine = br.readLine().trim().split(" ");
            int[] arr = new int[inputLine.length];
            for (int i = 0; i < inputLine.length; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            inputLine = br.readLine().trim().split(" ");
            int target = Integer.parseInt(inputLine[0]);

            Solution obj = new Solution();
            int res = obj.countPairs(arr, target);
            System.out.println(res);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends