//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            String s = br.readLine();
            String[] S = s.split(" ");
            int[] v = new int[2 * n + 2];
            for(int i = 0; i < 2 * n + 2; i++)
            {
                v[i] = Integer.parseInt(S[i]);
            }
            Solution ob = new Solution();
            int[] ans = ob.singleNumber(v);
            for(int i = 0; i < ans.length; i++)
                System.out.print(ans[i] + " ");
            System.out.println();
        }
    }
}


// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int[] singleNumber(int[] nums)
    {
        int n=nums.length;
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int ele : nums){
            if(!map.containsKey(ele))
            map.put(ele,1);
            else
            map.put(ele,map.get(ele)+1);
        }
        int m=map.size();
        int i=0;
        int[]ans=new int[2];
        for(Map.Entry<Integer,Integer>entry:map.entrySet()){
            if(entry.getValue()== 1){
                ans[i++]=entry.getKey();
                
            }
        }
        Arrays.sort(ans);
        return ans;
    }
}