//{ Driver Code Starts
// Initial Template for Java

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
            int res = new Solution().countSubarrays(arr, k);

            System.out.print(res);
            System.out.println();
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
    public int countSubarrays(int arr[], int k) {
        // code here
        
        HashMap<Integer, Integer> prefixSumMap = new HashMap<>();

        int ans = 0; // To store the count of valid subarrays
        int sum = 0; // Running prefix sum
        int n = arr.length;

        // Iterate through the array
        for (int i = 0; i < n; i++) {
            // Update the running sum
            sum += arr[i];

            // If the current prefix sum equals k, increment count
            if (sum == k) {
                ans++;
            }

            // Check if sum - k exists in the map (prefix sum logic)
            if (prefixSumMap.containsKey(sum - k)) {
                ans += prefixSumMap.get(sum - k); // Add the frequency of sum - k
            }

            // Update the current prefix sum in the map
            prefixSumMap.put(sum, prefixSumMap.getOrDefault(sum, 0) + 1);
        }

        return ans;
    }
}