//{ Driver Code Starts
import java.util.*;


// } Driver Code Ends
class Solution {
    public ArrayList<ArrayList<String>> anagrams(String[] arr) {
        // code here
        
        ArrayList<ArrayList<String>>ans = new ArrayList<>();
        
        for(int i=0;i<arr.length;i++){
            char[]ch1=arr[i].toCharArray();
            ArrayList<String>res=new ArrayList<>();
            for(int j=i;j<arr.length;j++){
                 char[]ch2=arr[j].toCharArray();
                 Arrays.sort(ch1);
                  Arrays.sort(ch2);
                  String s1=new String(ch1);
                  String s2=new String(ch2);
                  
                 if(s1.equals(s2)){
                     res.add(arr[j]);
                     arr[j]="0";
                 }
            }
             if(!res.contains("0"))
            {
               ans.add(res);
            }
        }
        return ans;
    }
}


//{ Driver Code Starts.

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // Ignore the newline after the test case input
        while (t-- > 0) {
            String inputLine = sc.nextLine();
            String[] arr = inputLine.split(" ");

            Solution ob = new Solution();
            ArrayList<ArrayList<String>> result = ob.anagrams(arr);
            result.sort(Comparator.comparing(a -> a.get(0)));
            for (ArrayList<String> group : result) {
                for (String word : group) {
                    System.out.print(word + " ");
                }
                System.out.println();
            }
            System.out.println("~");
        }
        sc.close();
    }
}

// } Driver Code Ends