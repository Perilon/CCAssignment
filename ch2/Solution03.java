import java.io.*;

/**
 * Created by perilon on 9/16/15.
 */
public class Solution03 {

    public static void main(String[] args) throws IOException {

        LinkedList LL = new LinkedList(5);
        LL.appendToTail(4);
        LL.appendToTail(8);
        LL.appendToTail(8);
        LL.appendToTail(3);
        LL.appendToTail(6);
        LL.appendToTail(8);
        LL.appendToTail(9);
        LL.appendToTail(4);
        LL.appendToTail(10);

        System.out.print("Here is an example linked list: ");
        LL.printLinkedList();

        System.out.print("\nEnter a node N to delete from the middle of the example linked list: ");
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String inputString = input.readLine();
        int n = Integer.parseInt(inputString);



        LL.deleteNodeFromMiddle(n);

        System.out.print("The new linked list is: ");
        LL.printLinkedList();

    }

}

// I made a class LinkedList that wraps Node for this exercise, so that I don't have to explicitly
// pass the value of the head node in to the function I'm writing.

class LinkedList {

    private Node head;

    public LinkedList(int p) {
        head = new Node(p);
    }

    public void appendToTail(int f) {
        Node currNode = head;
        Node endNode = new Node(f);
        while (currNode.next != null) {
            currNode = currNode.next;
        }
        currNode.next = endNode;
    }

    public class Node {

        Node next = null;
        int data;

        public Node(int d) {
            data = d;
        }
    }

    public void printLinkedList() {
        Node currNode = head;
        System.out.print(currNode.data + " ");
        while (currNode.next != null) {
            currNode = currNode.next;
            System.out.print(currNode.data + " ");
        }
    }

    // New code

    boolean deleteNodeFromMiddle(int n) {

//        Go through the linked list and determine whether a node's data matches the parameter of the function.
//        If so, set that node's data to the data of the "next" node and link its "next" node to the "next" node's
//        "next" node.  If the parameter doesn't match any elements in the list, that is caught.  This function
//        does access the head of the LinkedList data structure, but does not require the head to be entered as
//        a parameter.

        boolean doneCondition = false;

        Node currNode = head;

        while (doneCondition == false) {
            if (currNode == null || currNode.next == null) {
                System.out.println("That's no good; that element is at the end of the list or doesn't exist" +
                        " in the list.");
                return doneCondition;
            }
            if (currNode.data == n) {
                currNode.data = currNode.next.data;
                currNode.next = currNode.next.next;
                doneCondition = true;
            } else {
                currNode = currNode.next;
            }
        }
        return doneCondition;
    }
}
