//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int m = Integer.parseInt(br.readLine().trim());
            int[][] image = new int[n][m];
            for (int i = 0; i < n; i++) {
                String[] S2 = br.readLine().trim().split(" ");
                for (int j = 0; j < m; j++) image[i][j] = Integer.parseInt(S2[j]);
            }
            int sr = Integer.parseInt(br.readLine().trim());
            int sc = Integer.parseInt(br.readLine().trim());
            int newColor = Integer.parseInt(br.readLine().trim());
            Solution obj = new Solution();
            int[][] ans = obj.floodFill(image, sr, sc, newColor);
            for (int i = 0; i < ans.length; i++) {
                for (int j = 0; j < ans[i].length; j++)
                    System.out.print(ans[i][j] + " ");
                System.out.println();
            }

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        // Code here
        int oricolour = image[sr][sc];
        Queue <Pair> que = new LinkedList <Pair>();
        int n = image.length;
        int m = image[0].length;
        que.offer(new Pair(sr,sc));
        int[][]visit = new int[n][m];
        visit[sr][sc] = 1;
        image[sr][sc] = newColor;
        int[] dx = {-1 , 1 , 0 , 0 } ; 
        int[] dy = {0 , 0 , -1 , 1 } ; 
        
        
        while(!que.isEmpty()){
            Pair p = que.poll();
            int a = p.first;
            int b = p.second;
            
            for(int i=0;i<4;i++){
                int nx = a+dx[i];
                int ny = b+dy[i];
                
                if(nx>=0 && ny>=0 && nx<n && ny<m && visit[nx][ny]==0 && image[nx][ny]==oricolour){
                    que.offer(new Pair(nx,ny));
                    visit[nx][ny] = 1;
                    image[nx][ny] = newColor;
                }
            }
        }
        
        return image;
    }
    
}
class Pair{
    int first;
    int second;
    public Pair(int first,int second){
        this.first = first;
        this.second = second;
    }
}