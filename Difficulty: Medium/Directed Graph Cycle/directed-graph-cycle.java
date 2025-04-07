//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        while (tc-- > 0) {
            int V = sc.nextInt();
            int E = sc.nextInt();
            int[][] edges = new int[E][2];
            for (int i = 0; i < E; i++) {
                edges[i][0] = sc.nextInt();
                edges[i][1] = sc.nextInt();
            }

            Solution obj = new Solution();
            boolean ans = obj.isCyclic(V, edges);
            System.out.println(ans ? "true" : "false");
        }
        sc.close();
    }
}
// } Driver Code Ends


class Solution {
    public boolean isCyclic(int V, int[][] edges) {
        // code here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0 ;i<V;i++){
           adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
        }
        int visit[]=new int[V];
        int visited[] = new int[V];
        for(int i=0;i<V;i++){
            if(visit[i]==0){
               if(dfs(i,adj,visit,visited)==true)return true; 
            }
        }
        return false;
    }
    private static boolean dfs(int idx,  ArrayList<ArrayList<Integer>> adj, int visit[], int visited[]) {
        visit[idx]=1;
        visited[idx]=1;
        for(int ele:adj.get(idx)){
            if(visit[ele]==0)
            {
                if(dfs(ele,adj,visit,visited)==true)return true; 
            }else if(visited[ele]==1){
                return true;
                
            }
        }
        
        visited[idx]=0;
        return false;
    }
}