//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;


// } Driver Code Ends

// User function Template for Java
class Solution {
    // Function to return Breadth First Search Traversal of given graph.
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
        int V=adj.size();
       ArrayList<Integer>ans=new ArrayList<Integer>();
       Queue<Integer>que=new LinkedList<>();
       boolean[]visit=new boolean[V];
       que.add(0);
       visit[0]=true;
       while(!que.isEmpty()){
           int node=que.poll();
           ans.add(node);
           for(int temp:adj.get(node)){
               if(visit[temp]==false){
                   visit[temp]=true;
                   que.add(temp);
                   
               }
           }
       }
       return ans;
    }
    void solve(int idx,ArrayList<Integer> ans,ArrayList<ArrayList<Integer>> adj,
       int n, boolean[]visit){
          
           visit[idx]=true;
           ans.add(idx);
           for(int it:adj.get(idx)){
               if(visit[it]==false){
                 solve(it,ans,adj,n,visit);
               }
           }
       }
    
}


//{ Driver Code Starts.

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
            ArrayList<Integer> ans = obj.bfs(adj);
            for (int num : ans) {
                System.out.print(num + " ");
            }
            System.out.println();
            System.out.println("~");
        }
    }
}

// } Driver Code Ends