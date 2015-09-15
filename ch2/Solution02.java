import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by perilon on 9/15/15.
 */

class Whoops extends Exception {
    public Whoops(String message) {
        super(message);
    }
}

public class Solution02 {

    public static void main(String[] args) throws IOException, Whoops {

        System.out.print("Enter a number k where k will be the kth-to-last element of " +
                "a linked list (the default one provided has 8 nodes): ");
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String inputString = input.readLine();
        int k = Integer.parseInt(inputString);

        Node f = new Node(5);
        f.appendToTail(4);
        f.appendToTail(8);
        f.appendToTail(8);
        f.appendToTail(6);
        f.appendToTail(8);
        f.appendToTail(9);
        f.appendToTail(4);

        f.printList();

        Node kthToLast = f.findKthToLast(f, k);

        System.out.println("The kth-to-last element is: " + kthToLast.data);

    }

}

class Node {

    // This element was given in the book

    Node next = null;
    Node previous = null;
    int data;

    public Node(int d) {
        data = d;
    }

    void appendToTail(int d) {

        Node end = new Node(d);
        Node n = this;
        while (n.next != null) {
            n = n.next;
        }
        n.next = end;
    }

    // Added this print method

    void printList() {

        Node n = this;
        while (n != null) {
            System.out.print(n.data + " ");
            n = n.next;
        }
        System.out.print("\n");

    }

    // This element was also given in the book

    Node deleteNode(Node head, int d) {
        Node n = head;

        if (n.data == d) {
            return head.next;  // deleting the head node in this case, returning new head
        }

        while (n.next != null) {
            if (n.next.data == d) {
                n.next = n.next.next;
                return head;  // head doesn't change in this case
            }
            n = n.next;
        }
        return head;
    }

    // New code

    Node findKthToLast(Node n, int k) throws Whoops {

        Node runnerAhead = n;
        Node runnerBehind = n;

        for (int i = 0; i < k; i++) {

            if (runnerAhead != null) {
                runnerAhead = runnerAhead.next;
            }
            else {
                throw new Whoops("That element doesn't exist!");
            }
        }

        while (runnerAhead != null) {
            runnerAhead = runnerAhead.next;
            runnerBehind = runnerBehind.next;
        }

        return runnerBehind;
    }
}
