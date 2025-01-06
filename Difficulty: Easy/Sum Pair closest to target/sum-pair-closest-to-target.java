//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            String line = br.readLine();
            String[] tokens = line.split(" ");

            ArrayList<Integer> array = new ArrayList<>();

            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;

            int target = Integer.parseInt(br.readLine());

            Solution ob = new Solution();
            List<Integer> res = ob.sumClosest(arr, target);
            if (res.isEmpty()) {
                System.out.print("[]");
            } else {
                for (Integer num : res) {
                    System.out.print(num + " ");
                }
            }
            System.out.println();
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public List<Integer> sumClosest(int[] arr, int target) {
        // code here
        Arrays.sort(arr);
        int n=arr.length;
        
        List<Integer>result=new ArrayList<>();
        int minDiff = Integer.MAX_VALUE;
        int st=0;
        int end=n-1;
        while(st<end){
            int sum =arr[st]+arr[end];
            
             int diff = Math.abs(target - sum);

            if (diff < minDiff) {
                minDiff = diff;
                result = List.of(arr[st], arr[end]);
            } else if (diff == minDiff && Math.abs(arr[st] - arr[end]) > (result.get(1) - result.get(0))) {
                result = List.of(arr[st], arr[end]);
            }
            if(sum>target){
                end--;
            }else{
                st++;
            }
        }
        return result;
    }
}