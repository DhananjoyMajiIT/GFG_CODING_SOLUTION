//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            String[] arr1Str = sc.nextLine().split(" ");
            int[] arr = Arrays.stream(arr1Str).mapToInt(Integer::parseInt).toArray();
            Solution ob = new Solution();
            int ans = ob.getSingle(arr);
            System.out.println(ans);

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int getSingle(int[] nums) {
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
             if(map.get(ele)==1){
                 return ele;
             }
         }
       
        // for(Map.Entry<Integer,Integer>entry:map.entrySet()){
        //     if(entry.getValue()== 1){
        //         ans[i++]=entry.getKey();
                
        //     }
        // }
        // Arrays.sort(ans);
        return -1;
    }
}