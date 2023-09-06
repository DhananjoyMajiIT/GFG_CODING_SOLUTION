//{ Driver Code Starts
import java.io.*;
import java.util.*;
class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int r = sc.nextInt();
            int c = sc.nextInt();
            
            int matrix[][] = new int[r][c];
            
            for(int i = 0; i < r; i++)
            {
                for(int j = 0; j < c; j++)
                 matrix[i][j] = sc.nextInt();
            }
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.spirallyTraverse(matrix, r, c);
            for (Integer val: ans) 
                System.out.print(val+" "); 
            System.out.println();
        }
    }
}
// } Driver Code Ends


class Solution
{
    //Function to return a list of integers denoting spiral traversal of matrix.
    static ArrayList<Integer> spirallyTraverse(int matrix[][], int r, int c)
    {
        
        int left=0;
        int right=c-1;
        int totallen=r*c;
        ArrayList<Integer> ans=new ArrayList<Integer> ();
        int top=0;
        int bottom=r-1;
         if(matrix.length==0){
             return ans;
         }
        while(ans.size()<totallen){
            for(int i=left;i<=right && ans.size()<totallen;i++){
                ans.add(matrix[top][i]);
            }
            top++;
            for(int j=top;j<=bottom && ans.size()<totallen;j++){
                ans.add(matrix[j][right]);
            }
            right--;
            for(int k=right;k>=left && ans.size()<totallen;k--){
                ans.add(matrix[bottom][k]);
            }
            bottom--;
            for(int l=bottom;l>=top && ans.size()<totallen;l--){
                ans.add(matrix[l][left]);
            }
            left++;
            
        }
        return ans;
    }
}
