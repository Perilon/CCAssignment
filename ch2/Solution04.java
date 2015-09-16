import java.io.*;

/**
 * Created by perilon on 9/16/15.
 */
public class Solution04 {

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

//        LinkedList LL = new LinkedList(7);
//        LL.appendToTail(2);
//        LL.appendToTail(6);
//        LL.appendToTail(1);
//        LL.appendToTail(5);

        System.out.print("Here is an example linked list: ");
        LL.printLinkedList();

        System.out.print("Enter a number N about which to partition the linked list: ");
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String inputString = input.readLine();
        int n = Integer.parseInt(inputString);

        LL.partitionList(n);

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

    public void appendToBeginning(int f) {
        Node beginNode = new Node(f);
        beginNode.next = head;
        head = beginNode;
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
        System.out.println("\n");
    }

    public boolean deleteNode(int n) {

        boolean doneCondition = false;

        Node currNode = head;
        while (currNode != null) {
            if (currNode.data == n) {
                currNode.next.data = currNode.data;
                currNode.next.next = currNode.next;
                doneCondition = true;
                return doneCondition;
            } else {
                currNode = currNode.next;
            }
        }
        return doneCondition;
    }

    public boolean deleteNode(Node f) {

        boolean doneCondition = false;

        if (f == head) {
            f.data = f.next.data;
            f.next = f.next.next;
            head = f;
            doneCondition = true;
            return doneCondition;
        } else {
            if (f.next != null) {
                f.data = f.next.data;
                f.next = f.next.next;
                doneCondition = true;
                return doneCondition;
            } else {
                return doneCondition;
            }
        }
    }

    int getLength() {
        Node currNode = head;
        Node endNode;
        int counter = 1;

        while (currNode.next != null) {
            currNode = currNode.next;
            counter++;
        }
        return counter;
    }

//    New code—puts elements higher than n at the end, and puts elements less than or equal to n
//    at the beginning.

    public void partitionList(int n) {

        Node currNode = head;
        Node newTail = currNode;

        while (currNode != null) {

            Node nextNode = currNode.next;

            if (currNode.data < n) {
                currNode.next = head;
                head = currNode;
            }
            else {
                newTail.next = currNode;
                newTail = currNode;
            }
            currNode = nextNode;
        }
        newTail.next = null;


//        My own implementation (below) wasn't quite working.  The above is adapted from the book.

//        Node currNode = head;
//        int counter = 0;
//        int listLength = getLength();
//
//        printLinkedList();

//        while (counter < listLength) {
//
//            System.out.println("currNode.data: " + currNode.data);
//
//            Node nextNode = currNode.next;
//
//            if (currNode.data >= n) {
//
//                appendToTail(currNode.data);
//
//                currNode.data = nextNode.data;
//                currNode.next = nextNode.next;
//
//                currNode = nextNode;
//                counter++;
//
//                printLinkedList();
//            }
//            else { // currNode < n
//
//                Node newHead = new Node(currNode.data);
//                System.out.println("newHead: " + newHead.data);
//                newHead.next = head.next;
//                System.out.println("newHead.next: " + newHead.next.data);
//                head = newHead;
//                System.out.println("head: " + head.data);
//
//
//                currNode.data = currNode.next.data;
//                System.out.println("currNode.data: " + currNode.data);
//                currNode.next = currNode.next.next;
//                System.out.println("currNode.next: " + currNode.next.data);
//
//                currNode = nextNode;
//                System.out.println("currNode: " + nextNode.data);
//
//                counter++;
//
//                printLinkedList();
//            }
//        }
    }
}