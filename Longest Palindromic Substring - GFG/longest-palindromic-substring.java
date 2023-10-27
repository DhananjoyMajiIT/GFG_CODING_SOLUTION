//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            
            String S = read.readLine().trim();
            Solution ob = new Solution();
            System.out.println(ob.longestPalindrome(S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    
    String longestPalindrome(String s){
        // code here
       if(s.length()<=1)return s;
        int maxlen=1;
        int start=0;
        int end=0;
        int n=s.length();
        //EvenString
        for(int i=0;i<n;i++){
            int l=i;
            int r=i;
            while (l>=0 && r<n){
               if(s.charAt(l)==s.charAt(r)){
                    l--;
                    r++;

               }else
               break;
            }
                 int size=r-l-1;
                if(size>maxlen){
                maxlen=size;
                start=l+1;
                end=r-1;
               }
        }

        for(int i=0;i<n;i++){
            int left=i;
            int right=i+1;
            while(left>=0 && right<n){
                if(s.charAt(left)== s.charAt(right)){
                    left--;right++;
                }else
                break;
            }
            int size=right-left-1;
            if(size>maxlen){
                maxlen=size;
                start=left+1;
                end=right-1;
            }
        }
        return s.substring(start,end+1);
    }

}