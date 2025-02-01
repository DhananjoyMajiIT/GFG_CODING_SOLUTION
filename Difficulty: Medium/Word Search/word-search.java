//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt(); // Number of test cases
        while (tc-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            char[][] mat = new char[n][m];

            // Reading the matrix
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    mat[i][j] = sc.next().charAt(0);
                }
            }

            String word = sc.next();
            Solution obj = new Solution();
            boolean ans = obj.isWordExist(mat, word);
            if (ans)
                System.out.println("true");
            else
                System.out.println("false");

            System.out.println("~");
        }
        sc.close();
    }
}
// } Driver Code Ends



class Solution {   
    private static final int[] r = {-1, 0, 1, 0}; // Row movement (up, right, down, left)
    private static final int[] c = {0, 1, 0, -1}; // Column movement (up, right, down, left)
    
    public boolean isWordExist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;
        boolean[][] vis = new boolean[rows][cols];
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == word.charAt(0)) { 
                    // Start DFS search from this cell
                    if (checkdfs(board, word, vis, 0, i, j)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean checkdfs(char[][] board, String word, boolean[][] vis, int idx, int i, int j) {
        if (idx == word.length()) return true; // Found the complete word
        
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || vis[i][j] || board[i][j] != word.charAt(idx)) {
            return false; // Out of bounds or already visited or character mismatch
        }
        
        // Mark cell as visited
        vis[i][j] = true;

        // Explore all 4 directions
        for (int k = 0; k < 4; k++) {
            int inew = i + r[k];
            int jnew = j + c[k];

            if (checkdfs(board, word, vis, idx + 1, inew, jnew)) {
                return true;
            }
        }

        // Backtrack (Unmark the cell)
        vis[i][j] = false;
        return false;
    }
}



// class Solution {
//     private static int r[]={-1,0,1,0};
//     private static int c[]={0,1,0,-1};
//     static public boolean isWordExist(char[][] mat, String word) {
//         // Code here
        
//         int n=mat.length;
//         int m=mat[0].length;
//         boolean[][]vis=new boolean[n][m];
//         for(int i=0;i<n;i++){
//             for(int j=0;j<m;j++){
//                 if(mat[i][j]==word.charAt(0))
//                 {
//                     vis[i][j]=true;
//                     if(dfs(mat,word,vis,1,i,j)==true){
//                         return true;
//                     }
//                 }
//             }
//         }
        
//         return false;
//     }
    
//     static public boolean dfs(char[][] mat, String word,boolean[][]vis,int idx,int i,int j){
//         if(idx==word.length())
//           return true;
//         int inew ,jnew ;
        
//         for(int a=0;a<4;a++){
//             inew=i+r[a];
//             jnew=j+c[a];
//             if(inew>=0 && inew<mat.length && jnew>=0 && jnew<mat[0].length
//               && vis[inew][jnew]==false && mat[inew][jnew]==word.charAt(idx)){
//                   vis[inew][jnew]=true;
//                   if(dfs(mat,word,vis,idx+1,inew,jnew))
//                     return true;
//             }
//         }
//         return false;
//     }
    
    
// }