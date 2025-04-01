//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());

        while (tc-- > 0) {
            int V = Integer.parseInt(br.readLine().trim());
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

            for (int i = 0; i < V; i++) {
                String[] input = br.readLine().trim().split(" ");
                ArrayList<Integer> node = new ArrayList<>();
                for (String s : input) {
                    if (!s.isEmpty()) {
                        node.add(Integer.parseInt(s));
                    }
                }
                adj.add(node);
            }

            Solution obj = new Solution();
            ArrayList<Integer> ans = obj.dfs(adj);
            for (int num : ans) {
                System.out.print(num + " ");
            }
            System.out.println();
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        // Code here\
        
        int n=adj.size();
        boolean[]visit=new boolean[n];
        ArrayList<Integer> ans=new ArrayList<>();
       for(int i=0;i<n;i++){
           if(visit[i]==false){
               dfstraversel(adj,visit,i,ans);
               
           }
       }
       return ans;
    }
    public void dfstraversel(ArrayList<ArrayList<Integer>>adj,boolean[]visit,int i,ArrayList<Integer>ans){
        visit[i]=true;
        ans.add(i);
        for(int ele:adj.get(i)){
            if(visit[ele]==false){
               dfstraversel(adj,visit,ele,ans);
               
           }
        }
    }
}