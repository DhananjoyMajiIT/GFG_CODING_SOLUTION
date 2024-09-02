//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int[][] grid = new int[n][n];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < n; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            int ans = obj.minimumCostPath(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Solution
{
    //Function to return the minimum cost to react at bottom
	//right cell from top left cell.
    public int minimumCostPath(int[][] grid)
    {
        // Code here
        int n=grid.length;
        int m=grid[0].length;
        int[][]dir= new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        int[][]dis=new int[n][m];
        Queue<int[]>que=new PriorityQueue<>((x,y)->x[0]-y[0]);
        for(int[]arr:dis){
            Arrays.fill(arr,Integer.MAX_VALUE);
        }
        dis[0][0]=grid[0][0];
        que.add(new int[]{dis[0][0],0,0});
        
        while(!que.isEmpty()){
            int []temp=que.poll();
            int val=temp[0];
            int newi=temp[1];
            int newj=temp[2];
            
            if(newi==n-1 && newj==n-1){
                return val;
            }
            
            for(int []mov:dir){
                int ni=mov[0]+newi;
                int nj=mov[1]+newj;
                if(ni<0 || nj<0 || ni==n || nj==n) continue;
                int cost=val+grid[ni][nj];
                if(cost<dis[ni][nj]){
                    dis[ni][nj]=cost;
                    que.add(new int[]{cost,ni,nj});
                }
            }
        }
        return dis[n-1][n-1];
    }
}