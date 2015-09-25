import java.util.ArrayList;
import java.util.EmptyStackException;

/**
 * Created by perilon on 9/24/15.
 */
public class Solution04 {

    class MyQueue<T> {

        Stack<T> regStack;
        Stack<T> invertedStack;

        public MyQueue() {
            Stack<T> regStack = new Stack<T>();
            Stack<T> invertedStack = new Stack<T>();
        }

        public void add(T x) {
            regStack.push(x);
        }

        /*This can be visualized as turning the stack over; original stack A becomes inverted stack B.
        * Then what was at the bottom of A (the oldest element) is available to be popped from the top
        * of B, and thus the FIFO requirement of a queue is realized.  Then the stack is turned back
        * over to its original orientation.  Same thing goes for peeking.*/

        public void flipStackOver(Stack<T> A, Stack<T> B) {
            while (!A.isEmpty()) {
                B.push(A.pop());
            }
        }

        public T remove(T x) {
            flipStackOver(regStack, invertedStack);
            T item = invertedStack.pop();
            flipStackOver(invertedStack, regStack);
            return item;
        }

        public T peep(T x) {
            flipStackOver(regStack, invertedStack);
            T item = invertedStack.peep();
            flipStackOver(invertedStack, regStack);
            return item;
        }

    }




    /*Book provides this code*/
    class Stack<T> {
        private class StackNode<T> {
            private T data;
            private StackNode<T> next;

            public StackNode(T data) {
                this.data = data;
            }
        }

        private StackNode<T> top;

        public T pop() {
            if (top == null) throw new EmptyStackException();
            T item = top.data;
            top = top.next;
            return item;
        }

        public void push(T item) {
            StackNode<T> t = new StackNode<T>(item);
            t.next = top;
            top = t;
        }

        public T peep() {
            if (top == null) throw new EmptyStackException();
            return top.data;
        }

        public boolean isEmpty() {
            return top == null;
        }

    }

}
