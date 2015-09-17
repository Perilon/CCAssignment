/**
 * Created by perilon on 9/16/15.
 */
public class Solution08 {

    public static void main(String[] args) {

        LinkedList LL1 = new LinkedList(5);
        LL1.appendToTail(4);
        LL1.appendToTail(8);
        LL1.appendToTail(8);
        LL1.appendToTail(3);
        LL1.appendToTail(2);
        LL1.appendToTail(6);
        LL1.appendToTail(1);
        LL1.appendToTail(5);

        System.out.print("Here is an example linked list: ");
        LL1.printLinkedList();

        System.out.println("Let's create a loop beginning at the third node from the beginning.");

        LL1.createDemoLoop(3);

        System.out.println("\nNow let's find the beginning of the loop: ");
        LinkedList.Node loopBeginning = LL1.findBeginningOfLoop();
        System.out.print(loopBeginning.data);

        System.out.println("\n\nNow let's create a loop beginning at the sixth node from the beginning.");

        LinkedList LL2 = new LinkedList(5);
        LL2.appendToTail(4);
        LL2.appendToTail(8);
        LL2.appendToTail(8);
        LL2.appendToTail(3);
        LL2.appendToTail(2);
        LL2.appendToTail(6);
        LL2.appendToTail(1);
        LL2.appendToTail(5);

        LL2.createDemoLoop(6);

        System.out.println("\nNow let's find the beginning of the loop: ");
        LinkedList.Node loopBeginning2 = LL2.findBeginningOfLoop();
        System.out.print(loopBeginning2.data);
    }
}

class LinkedList {

    public Node head;

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

//    This is for demonstration purposes.  It allows you to start a loop in a non-loopy linked list at some
//    node that is n nodes from the start.  (This won't work if n is greater than the length of the list.)

    void createDemoLoop(int n) {
        Node currNode = head;
        while (currNode.next != null) {
            currNode = currNode.next;
        }

        Node cN2 = head;
        for (int i = 0; i < n - 1; i++) {
            cN2 = cN2.next;
        }

        currNode.next = cN2;
    }

//    New code.
//    When we set the slow runner to step forward by 1 and the slow runner to step forward by 2, and there
//    is a loop, they will meet in the loop a number of nodes before the beginning of the loop that is the
//    same number as the number of spaces that exist in the linked list before the beginning of the loop.
//    Find that spot…

    Node findBeginningOfLoop() {

        Node slowRunner = head;
        Node fastRunner = head;

        while (true) {
            slowRunner = slowRunner.next;
            fastRunner = fastRunner.next.next;
            if (fastRunner == slowRunner) {
                break;
            }
        }

//        …Then step forward at the same pace with a runner set at the head and a runner at the meeting point;
//        the node at which they meet will be the node at the beginning of the loop.

        slowRunner = head;
        while (fastRunner != slowRunner) {
            slowRunner = slowRunner.next;
            fastRunner = fastRunner.next;
        }
        return fastRunner;
    }

}