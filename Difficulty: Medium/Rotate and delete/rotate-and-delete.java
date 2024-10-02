//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.lang.*;
import java.util.*;


// } Driver Code Ends

class Solution {
    public static int rotateDelete(ArrayList<Integer> arr) {
        // code here
        int n=arr.size();
        int kth=1;
        while(arr.size()>1){
           // int m=arr.size();
            rotaedlist(arr);
            int remidx=arr.size()-kth;
            if(remidx>=0){
                arr.remove(remidx);
            }
            else{
                arr.remove(0);
            }
            kth++;
        }
        return arr.get(0);
    }
    public static void rotaedlist(ArrayList<Integer> arr){
        int n=arr.remove(arr.size()-1);
        arr.add(0,n);
    }
}


//{ Driver Code Starts.

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> arr = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                arr.add(Integer.parseInt(token));
            }

            Solution obj = new Solution();
            int res = obj.rotateDelete(arr);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends