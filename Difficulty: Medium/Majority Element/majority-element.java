//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class Geeks {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            int arr[] = new int[str.length];
            for (int i = 0; i < str.length; i++) arr[i] = Integer.parseInt(str[i]);
            System.out.println(new Solution().majorityElement(arr));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    static int majorityElement(int nums[]) {
        // code here
         int n=nums.length;
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int ele : nums){
            if(!map.containsKey(ele))
            map.put(ele,1);
            else
            map.put(ele,map.get(ele)+1);
        }
         for(int ele : nums){
             if(map.get(ele)>n/2){
                 return ele;
             }
         }
         return -1;
    }
}