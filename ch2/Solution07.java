/**
 * Created by perilon on 9/16/15.
 */
public class Solution07 {

    public static void main(String[] args) {

        LinkedList LL1 = new LinkedList(5);
        LL1.appendToTail(4);
        LL1.appendToTail(8);
        LL1.appendToTail(8);
        LL1.appendToTail(3);

        LinkedList LL2 = new LinkedList(1);
        LL2.appendToTail(2);
        LL2.appendToTail(6);
        LL2.appendToTail(7);
        LL2.appendToTail(2);
        LL2.appendToTail(1);

        LinkedList LL3 = new LinkedList(5);
        LL3.appendToTail(6);
        LL3.appendToTail(7);
        LL3.appendToTail(2);
        LL3.appendToTail(1);

        System.out.print("Here is an example linked list: ");
        LL1.printLinkedList();

        System.out.print("\nHere is a second example linked list: ");
        LL2.printLinkedList();

        LinkedList.Node answer = findIntersection(LL1, LL2);
        if (answer != null) {
            System.out.print("\nThe value of the node of intersection is: " +
                    findIntersection(LL1, LL2).data);
        } else {
            System.out.println("\nThere is no intersection.");
        }

        System.out.println("\nHere is a third example linked list: ");
        LL3.printLinkedList();

        LinkedList.Node answer2 = findIntersection(LL2, LL3);
        if (answer2 != null) {
            System.out.print("\nThe value of the node of intersection between list 2 and list 3 is: " +
                    findIntersection(LL2, LL3).data);
        } else {
            System.out.println("\nThere is no intersection.");
        }

    }

    public static LinkedList.Node findIntersection(LinkedList LL1, LinkedList LL2) {
        int LL1Length = LL1.getLength();
        int LL2Length = LL2.getLength();

        int LL1FinalValue = LL1.getValueOfFinalNode();
        int LL2FinalValue = LL2.getValueOfFinalNode();

//        If the lists do not share the same final value in common, they do not intersect.

        if (LL1FinalValue != LL2FinalValue) {
            return null;
        }

//        If they do, we start comparing the values of their nodes at the same position in each
//        relative to the end.  Since the node of intersection can't be before the shorter of the
//        two lists begins, we must step forward in the longer list to the position such that the
//        remaining length of that list is equal to the remaining list of the shorter list.

        int difference;
        LinkedList longer;
        LinkedList shorter;

        if (LL1Length >= LL2Length) {
            longer = LL1;
            shorter = LL2;
            difference = LL1Length - LL2Length;
        } else {
            longer = LL2;
            shorter = LL1;
            difference = LL2Length - LL1Length;
        }

        LinkedList.Node currNodeLonger = longer.head;
        for (int i = 0; i < difference; i++) {
            currNodeLonger = currNodeLonger.next;
        }

//        Step through the two lists beginning at the correct position in each until arriving at the
//        node whose value they have in common.

        LinkedList.Node currNodeShorter = shorter.head;
        while (currNodeLonger.data != currNodeShorter.data) {
            currNodeLonger = currNodeLonger.next;
            currNodeShorter = currNodeShorter.next;
        }
        return currNodeLonger;
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
//        System.out.println("\n");
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
        int counter = 1;

        while (currNode.next != null) {
            currNode = currNode.next;
            counter++;
        }
        return counter;
    }

    int getValueOfFinalNode() {
        Node currNode = head;
        while (currNode.next != null) {
            currNode = currNode.next;
        }

        return currNode.data;
    }

}
