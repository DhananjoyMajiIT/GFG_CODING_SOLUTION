//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}

public class LinkedList {
    public static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void makeLoop(Node head, Node tail, int x) {
        if (x == 0) return;

        Node curr = head;
        for (int i = 1; i < x; i++) curr = curr.next;

        tail.next = curr;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            ArrayList<Integer> arr = new ArrayList<>();
            String input = br.readLine();
            StringTokenizer st = new StringTokenizer(input);
            while (st.hasMoreTokens()) {
                arr.add(Integer.parseInt(st.nextToken()));
            }
            int k = Integer.parseInt(br.readLine());
            Node head = new Node(arr.get(0));
            Node tail = head;
            for (int i = 1; i < arr.size(); ++i) {
                tail.next = new Node(arr.get(i));
                tail = tail.next;
            }
            makeLoop(head, tail, k);
            Solution ob = new Solution();
            Node ans = ob.findFirstNode(head);
            System.out.println(ans == null ? -1 : ans.data);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

/* class Node
{
    int data;
    Node next;

    Node(int x)
    {
        data = x;
        next = null;
    }
}*/

class Solution {
    public static Node findFirstNode(Node head) {
    if (head == null) return null;

    Node slow = head;
    Node fast = head;
    boolean flag = false;

    // Step 1: Detect the cycle using slow and fast pointers
    while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;
        if (slow == fast) {
            flag = true;
            break;
        }
    }

    // Step 2: If no cycle is found, return null
    if (!flag) {
        return null;
    }

    // Step 3: Find the starting node of the cycle
    slow = head; // Move one pointer to the head
    while (slow != fast) {
        slow = slow.next;
        fast = fast.next;
    }

    return slow; // This is the starting node of the cycle
}

}