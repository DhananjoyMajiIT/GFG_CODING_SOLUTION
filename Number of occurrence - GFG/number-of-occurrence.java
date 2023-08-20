//{ Driver Code Starts
//Initial Template for Java



import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int x = Integer.parseInt(inputLine[1]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().count(arr, n, x);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java



class Solution {
    int count(int[] arr, int n, int x) {
        //this is correct solution T(c)=O(N)
        // int count=0;
        // for(int i=0;i<n;i++){
        //     if(x==arr[i]){
        //         count++;
        //     }
        // }
        // if(count==0){
        //     return 0;
        // }
        // return count;
        
        //the question tell me solve the problem  T(C)=O(log N)
        
        int left_idx=binaryL(arr,0,n-1,x);
        int right_idx=binaryR(arr,0,n-1,x);
        
        
        return right_idx-left_idx;
        
        //======================================================================
        
        //  int count=0;
        //  int i=0;
         
        //  if(arr[0]>x)return 0;
        //  if(arr[n-1]<x)return 0;
         
        //  while(i<n){
        //      if(arr[i]<x){
        //          while(arr[i]==arr[i+1]){
        //              i++;
        //          }
        //      }
             
        //      if(arr[i]==x){
        //          count++;
        //      }
             
        //      if(arr[i]>x)break;
        //      i++;
        //  }
        //  return count;
    }
    
    static int binaryL(int []arr,int st,int end,int x){
        while(st<=end){
            int mid=(st+end)/2;
            
            if(arr[mid]>=x){
                end=mid-1;
            }
            else{
                st=mid+1;
            }
        }
       
        return end;
    }
    
    static int binaryR(int []arr,int st,int end,int x){
        while(st<=end){
            int mid=(st+end)/2;
            
            if(arr[mid]<=x){
                st=mid+1;
            }
            else{
                end=mid-1;
            }
        }
        
        return end;
    }
}