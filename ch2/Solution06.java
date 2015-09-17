/**
 * Created by perilon on 9/16/15.
 */
public class Solution06 {

    public static void main(String[] args) {

        LinkedList LL1 = new LinkedList(5);
        LL1.appendToTail(4);
        LL1.appendToTail(8);
        LL1.appendToTail(8);
        LL1.appendToTail(3);

        LinkedList LL2 = new LinkedList(1);
        LL2.appendToTail(2);
        LL2.appendToTail(6);
        LL2.appendToTail(6);
        LL2.appendToTail(2);
        LL2.appendToTail(1);

        System.out.print("Here is an example linked list: ");
        LL1.printLinkedList();

        System.out.println("\nIt is " + Boolean.toString(LL1.isLLPalindrome()) + " that this linked " +
                "list is a palindrome.\n");

        System.out.print("Here is a second example linked list: ");
        LL2.printLinkedList();

        System.out.println("\nIt is " + Boolean.toString(LL2.isLLPalindrome()) + " that this linked " +
                "list is a palindrome.");

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
        Node endNode;
        int counter = 1;

        while (currNode.next != null) {
            currNode = currNode.next;
            counter++;
        }
        return counter;
    }

//    New code
//    Simply adds the data from each linked list node to a string and checks for palindromicity
//    of the string

    boolean isLLPalindrome() {

        String LLAsString = "";

        Node currNode = head;
        while (currNode != null) {
            String digitAsString = Integer.toString(currNode.data);
            LLAsString += digitAsString;
            currNode = currNode.next;
        }

        return isStringPalindrome(LLAsString);
    }

//    Checks to see if the reverse of a string is equal in value to the string

    public static boolean isStringPalindrome(String s) {
        String stringReversed = new StringBuilder(s).reverse().toString();
        boolean answer = (stringReversed.equals(s));
        return answer;
    }

}
