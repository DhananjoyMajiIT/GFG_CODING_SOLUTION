//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;
import java.util.HashMap;


// } Driver Code Ends

class Solution {
    public int[] singleNum(int[] nums) {
        // Code here
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


//{ Driver Code Starts.
public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

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

            // int k = Integer.parseInt(br.readLine());
            // Create Solution object and find closest sum
            Solution ob = new Solution();
            int[] ans = ob.singleNum(arr);

            // Print the result as a space-separated string
            for (int num : ans) {
                System.out.print(num + " ");
            }
            System.out.println(); // New line after printing the results
            System.out.println("~");
        }
    }
}

// } Driver Code Ends