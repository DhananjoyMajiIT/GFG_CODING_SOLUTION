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
            int target = Integer.parseInt(sc.nextLine());

            Solution ob = new Solution();
            int ans = ob.countTriplets(arr, target);
            System.out.println(ans);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
  
    public int countTriplets(int[] a, int target) {
     int n=a.length;
        int count=0;
        for(int i=0;i<n;i++){
            int l=i+1;
            int r=n-1;
            int f=target-a[i];
            while(l<r){
                if(a[l]+a[r]==f){
                   int right=r;
                   while(l<right && a[right]==a[r]){
                       count++;
                       right--;
                   }
                   l++;
                }
                else if(a[l]+a[r]<f){
                    l++;
                }
                else{
                    r--;
                }
            }
        }
        return count;
    }
}