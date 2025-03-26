//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while (t-- > 0) {
            String s = sc.nextLine();
            String line = sc.nextLine();
            String[] dictionary = line.split(" ");

            Solution obj = new Solution();
            if (obj.wordBreak(s, dictionary)) {
                System.out.println("true");
            } else {
                System.out.println("false");
            }
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    public boolean wordBreak(String s, String[] dictionary) {
        HashSet<String> set = new HashSet<>(Arrays.asList(dictionary));
        int n = s.length();
        boolean[] dp = new boolean[n + 1];

        dp[0] = true; // Base case: empty string is always breakable
        int maxWordLength = 0;
        for (String word : dictionary) {
            maxWordLength = Math.max(maxWordLength, word.length());
        }
        for(int i=1;i<=n;i++){
            for(int j=Math.max(i-maxWordLength,0);j<i;j++){
                if(dp[j]&& set.contains(s.substring(j,i))){
                    dp[i]=true;
                    break; // No need to check further if already true
                }
            }
        }

        return dp[n];
        
    }
    // public boolean wordBreak(String s, String[] dictionary) {   
    //     //code here
    //     HashSet<String> set = new HashSet<>(Arrays.asList(dictionary));
    //     int n = s.length();
    //     boolean[] dp = new boolean[n + 1];  // Use Boolean array for memoization
    //     return solve(0, s, set, dp);
    // }
    // public static boolean solve(int idx,String A, HashSet<String>set,boolean[]dp){
    //     if (idx == A.length()) return true;  // If we reach the end, it is a valid segmentation
    //     if (dp[idx] != false) return dp[idx]; // Use memoization to avoid recomputation

    //     for (int i = idx + 1; i <= A.length(); i++) {
    //         String temp = A.substring(idx, i);
    //         if (set.contains(temp) && solve(i, A, set, dp)) {
    //             return dp[idx] = true;  // Memoize and return true immediately
    //         }
    //     }

    //     return dp[idx] = false;
    // }
}