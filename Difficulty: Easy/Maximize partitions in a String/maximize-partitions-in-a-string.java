//{ Driver Code Starts
import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();

        while (tc-- > 0) {
            String s = sc.next();
            Solution obj = new Solution();
            int ans = obj.maxPartitions(s);
            System.out.println(ans);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    public int maxPartitions(String s) {
        // code here
        Map<Character,Integer>map=new HashMap<>();
        for(char ch : s.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        int n=s.length();
        int prev=n;
        int cnt=0;
        Map<Character,Integer>temp=new HashMap<>();
        for(int i=n-1;i>=0;i--){
            char ch=s.charAt(i);
            temp.put(ch,temp.getOrDefault(ch,0)+1);
            if(valid(map,temp)){
                cnt++;
                
            }
        }
        return cnt;
    }
    public boolean valid(Map<Character,Integer>map,Map<Character,Integer>temp){
        for(Map.Entry<Character,Integer> entry:temp.entrySet()){
            if(!map.getOrDefault(entry.getKey(), 0).equals(entry.getValue())){
                return false;
            }
        }
        return true;
    }
}