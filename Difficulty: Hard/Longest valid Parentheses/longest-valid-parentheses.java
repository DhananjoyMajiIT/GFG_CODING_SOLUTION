//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String S = in.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.maxLength(S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int maxLength(String S){
        // code here
        int n=S.length();
        Stack<Integer>st=new Stack<>();
        for(int i=0;i<n;i++){
            if(S.charAt(i)=='('){
                st.push(i);
            }else{
                if(!st.isEmpty() && S.charAt(st.peek())=='('){
                    st.pop();
                }else{
                     st.push(i);
                }
            }
        }
        int res=0;
        
        while(!st.isEmpty()){
            int top=st.peek();
            st.pop();
            res=Math.max(res,n-top-1);
            n=top;
        }
        return Math.max(res,n);
    }
}