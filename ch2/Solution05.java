/**
 * Created by perilon on 9/16/15.
 */
public class Solution05 {

    public static void main(String[] args) {

        LinkedList LL1 = new LinkedList(5);
        LL1.appendToTail(4);
        LL1.appendToTail(8);
        LL1.appendToTail(8);
        LL1.appendToTail(3);

        LinkedList LL2 = new LinkedList(7);
        LL2.appendToTail(2);
        LL2.appendToTail(6);
        LL2.appendToTail(1);
        LL2.appendToTail(5);

        System.out.print("Here is an example linked list: ");
        LL1.printLinkedList();

        System.out.print("Here is a second example linked list: ");
        LL2.printLinkedList();

        System.out.print("Here's the sum, followed by the linked list representing that sum: ");
        LinkedList answer = sumTwoLinkedLists(LL1, LL2);
        answer.printLinkedList();

    }

//    For each element in each linked list in turn, we turn that data into an int
//    by multiplying it by the appropriate power of ten depending on how many decimal places we've progressed
//    into the number represented by the linked list.  Then we add those two numbers together and iterate
//    through a string representation of that total, from back to front, adding the int at each index to a
//    new linked list node.

    public static LinkedList sumTwoLinkedLists(LinkedList LL1, LinkedList LL2) {

        int multiplier = 1;
        int total = 0;

        LinkedList.Node currNodeLL1 = LL1.head;

        while (currNodeLL1 != null) {
            int subtotal = multiplier * currNodeLL1.data;
            total += subtotal;
            multiplier *= 10;
            currNodeLL1 = currNodeLL1.next;
        }

        LinkedList.Node currNodeLL2 = LL2.head;

        multiplier = 1;

        while (currNodeLL2 != null) {
            int subtotal = multiplier * currNodeLL2.data;
            total += subtotal;
            multiplier *= 10;
            currNodeLL2 = currNodeLL2.next;
        }

        String totalString = Integer.toString(total);

        System.out.println(totalString);

        int lenTotal = totalString.length();

//        Initiate the new linked list, with the data of the head node being the last digit in the total
//        that we've calculated.

        LinkedList LLsum = new LinkedList(getIntAt(total, lenTotal - 1));

//        Add the other nodes in turn, going backwards through the digits of the total.

        for (int i = lenTotal - 2; i >= 0; i--) {
            LLsum.appendToTail(getIntAt(total, i));
        }

        return LLsum;
    }

//    Returns as an int the digit of a number that is at a particular index of that number (by type casting
//    around some)

    public static int getIntAt(int number, int index){

        String numberString = Integer.toString(number);
        int digitAtIndex = Integer.parseInt(Character.toString(numberString.charAt(index)));
        return digitAtIndex;
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
}