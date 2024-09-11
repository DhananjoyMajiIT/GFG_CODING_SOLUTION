//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); // Number of test cases

        while (t-- > 0) {
            String[] input = br.readLine().split(" ");
            long[] a = new long[input.length];

            for (int i = 0; i < input.length; i++) {
                a[i] = Long.parseLong(input[i]);
            }

            Solution ob = new Solution();
            System.out.println(ob.minCost(a));
        }
    }
}

// } Driver Code Ends


//Back-end complete function Template for Java
class Solution {
    // Function to return the minimum cost of connecting the ropes.
    public long minCost(long[] arr) {
        // code here
        PriorityQueue<Long>que=new PriorityQueue();
        
        for(int i=0;i<arr.length;i++){
            que.add(arr[i]);
        }
        
        long sum=0;
        
        while(!que.isEmpty()){
            long num1=que.poll();
            if(!que.isEmpty()){
                long num2=que.poll();
                sum+=num1+num2;
                que.add(num1+num2);
            }else{
                return sum;
            }
        }
        return sum;
        
    }
}