//{ Driver Code Starts
// driver

import java.io.*;
import java.util.*;


// } Driver Code Ends
/* node for linked list

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

*/

class Solution {
    static Node addTwoLists(Node num1, Node num2) {
        // code here
        num1=reverse(num1);
        num2=reverse(num2);
        Node sumnode=reverse(addnode(num1,num2));
        while(sumnode!=null && sumnode.data == 0) sumnode = sumnode.next;
        if(num1 != null && num2 != null && sumnode==null) return new Node(0); 
        return sumnode;
    }
    static Node addnode(Node num1, Node num2){
        Node temp=new Node(-1);
        Node cur=temp;
        boolean carry=false;
        
        while(num1!=null && num2!=null){
            int n1=num1.data;
            int n2=num2.data;
            int sum=n1+n2;
            
            if(carry){
                sum++;
                 carry=false;
            }
            if(sum>9)
                carry=true;
                int rem=sum%10;
                Node newnode=new Node(rem);
                cur.next=newnode;
                cur=newnode;
                num1=num1.next;
                num2=num2.next;
            
        }
        while(num1!=null ){
            int n1=num1.data;
            
            if(carry){
                n1++;
                 carry=false;
            }
            if(n1>9)
                carry=true;
                int rem=n1%10;
                Node newnode=new Node(rem);
                cur.next=newnode;
                cur=newnode;
                num1=num1.next;
            
        }
        while( num2!=null){
            int n2=num2.data;
          
            if(carry){
                n2++;
                 carry=false;
            }
            if(n2>9)
                carry=true;
                int rem=n2%10;
                Node newnode=new Node(rem);
                cur.next=newnode;
                cur=newnode;
                num2=num2.next;
            
        }
        
         if(carry){
            Node node = new Node(1);
            cur.next = node;
            cur = node;
        }
        return temp.next;
        
    }
    static Node reverse(Node num){
        Node curr=num;
        Node prev=null;
      
        while(curr!=null){
            Node next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }
}

//{ Driver Code Starts.

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

class GfG {

    static void printList(Node n) {
        while (n != null) {
            System.out.print(n.data + " ");
            n = n.next;
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(read.readLine());
        while (T-- > 0) {

            String str[] = read.readLine().trim().split(" ");
            int n = str.length;

            Node num1 = new Node(Integer.parseInt(str[0]));
            Node tail = num1;
            for (int i = 1; i < n; i++) {
                int val = Integer.parseInt(str[i]);
                tail.next = new Node(val);
                tail = tail.next;
            }

            String str2[] = read.readLine().trim().split(" ");
            int m = str2.length;

            Node num2 = new Node(Integer.parseInt(str2[0]));
            tail = num2;
            for (int i = 1; i < m; i++) {

                tail.next = new Node(Integer.parseInt(str2[i]));
                tail = tail.next;
            }

            Solution g = new Solution();
            Node res = g.addTwoLists(num1, num2);
            printList(res);

            System.out.println("~");
        }
    }
}

// } Driver Code Ends