//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main (String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            String s = sc.next ();
            int k = sc.nextInt();
    		System.out.println (new Solution().substrCount (s, k));
        }
        
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    long substrCount (String S, int K) {
        return distinctcnt(S,K)-distinctcnt(S,K-1);
    }
    static long distinctcnt(String S,int K){
        // your code here
        int n=S.length();
        int i=0;
        int j=0;
        int distcnt=0;
        long ans=0;
        int[]freq=new int[26];
        while(j<n){
            freq[S.charAt(j)-'a']++;
            if(freq[S.charAt(j)-'a']==1){
                distcnt++;
            }
            
            while(distcnt>K){
                freq[S.charAt(i)-'a']--;
                if(freq[S.charAt(i)-'a']==0){
                    distcnt--;
                }
                i++;
            }
            ans+=j-i+1;
            j++;
        }
        return ans;
    }
}