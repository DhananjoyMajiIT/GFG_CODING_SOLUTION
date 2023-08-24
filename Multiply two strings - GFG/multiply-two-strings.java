//{ Driver Code Starts
//Initial Template for Java


import java.util.*;
import java.math.*;

class Multiply{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            String a=sc.next();
            String b=sc.next();
            Solution g=new Solution();
            System.out.println(g.multiplyStrings(a,b));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public String multiplyStrings(String s1,String s2)
    {
        int slen1=s1.length();
        int slen2=s2.length();
        boolean neg=false;
        
        if(s1.equals("0") || s2.equals("0")){
            return "0";
        }
        if(s1.charAt(0)=='-' && s2.charAt(0)=='-' ){
            s1=s1.substring(1);
            slen1--;
            s2=s2.substring(1);
            slen2--;
            
        }
        else if(s1.charAt(0)=='-'){
            s1=s1.substring(1);
            slen1--;
            neg=true;
        }
        else if(s2.charAt(0)=='-'){
            s2=s2.substring(1);
            slen2--;
            neg=true;
        }
        
        int len=slen1+slen2+1;
        int[]res=new int[len];
        
        int carry=0;
        
        for(int i=0;i<slen2;i++){
            int x=Integer.parseInt(s2.substring(slen2-1-i,slen2-i));
            for(int j=0;j<slen1;j++){
                int y=Integer.parseInt(s1.substring(slen1-1-j,slen1-j));
                res[len-i-1-j]+=x*y+carry;
                carry=res[len-i-1-j]/10;
                res[len-i-1-j]%=10;
            }
            if(carry!=0){
                res[len-i-1-slen1]=carry;
                carry=0;
            }
        }
        
        String ans="";
        if(neg==true){
            ans="-";
        }
        boolean flag=false;
        for(int i=0;i<len;i++){
            if(res[i]!=0 || flag){
                ans+=res[i]; 
                flag=true;
            }
        }
        return ans;
    }
}