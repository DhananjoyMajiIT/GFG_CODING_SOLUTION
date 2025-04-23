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
            int ans = ob.findUnique(arr);
            System.out.println(ans);

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    public int findUnique(int[] arr) {
        // code here
         Map<Integer, Integer> groups = new HashMap<>();
           for (int i = 0; i <arr.length; i++) {
                groups.put(arr[i], groups.getOrDefault(arr[i], 0) + 1);
               
           }
          
            for (int num : arr) {
                if (groups.get(num) < 2) {
                    return num;
                }
             }
            return -1;
        }
       
    
}