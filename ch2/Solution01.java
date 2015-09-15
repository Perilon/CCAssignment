import java.util.HashSet;

/**
 * Created by perilon on 9/14/15.
 */
public class Solution01 {

    public static void main(String[] args) {

        Node f = new Node(5);
        f.appendToTail(4);
        f.appendToTail(8);
        f.appendToTail(8);
        f.appendToTail(6);
        f.appendToTail(8);
        f.appendToTail(9);
        f.appendToTail(4);

        f.printList();

        f.removeDuplicates(f);

        f.printList();

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

    void removeDuplicates(Node n) {

        HashSet<Integer> nodeDataSet = new HashSet<Integer>();

        Node tempPrevNode = null;

        while (n != null) {

            if (nodeDataSet.contains(n.data)) {
                tempPrevNode.next = n.next;

            }
            else {
                nodeDataSet.add(n.data);
                tempPrevNode = n;
            }

            n = n.next;
        }
    }
}