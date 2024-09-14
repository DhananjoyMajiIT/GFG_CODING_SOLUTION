//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String input = br.readLine();
            String[] inputArray = input.split("\\s+");
            ArrayList<Integer> arr = new ArrayList<>();

            for (String s : inputArray) {
                arr.add(Integer.parseInt(s));
            }

            new Solution().rearrange(arr);
            for (int num : arr) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    void rearrange(ArrayList<Integer> arr) {
        // code here
        ArrayList<Integer> positive = new ArrayList<>();
        ArrayList<Integer> negative = new ArrayList<>();
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) >= 0) {
                positive.add(arr.get(i)); 
            } else {
                negative.add(arr.get(i)); 
            }
        }
        int j = 0;
        int k = 0; 
        int i = 0; 
        while (j < positive.size() && k < negative.size()) {
            if (i % 2 == 0) {
                arr.set(i, positive.get(j));
                j++;
            } else {
                arr.set(i, negative.get(k));
                k++;
            }
            i++;
        }
        while (j < positive.size()) {
            arr.set(i, positive.get(j));
            i++;
            j++;
        }
        while (k < negative.size()) {
            arr.set(i, negative.get(k));
            i++;
            k++;
        }
    }

    
}