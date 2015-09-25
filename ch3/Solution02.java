import java.util.EmptyStackException;

/**
 * Created by perilon on 9/24/15.
 */
public class Solution02 {


    class StackWithMinimum extends Stack<Integer> {

        Stack<Integer> stackWithMinima;

        public StackWithMinimum() {
            stackWithMinima = new Stack<Integer>();
        }

        public int getCurrentMinimum() {

            if (stackWithMinima.isEmpty()) {
                return Integer.MAX_VALUE;
            } else {
                return stackWithMinima.peep();
            }
        }

        public Integer pop() {
            int value = super.pop();
            if (value == getCurrentMinimum()) {
                stackWithMinima.pop();
            }
            return value;
        }

        public void push(int value) {
            if (value <= getCurrentMinimum()) {
                stackWithMinima.push(value);
            }
            super.push(value);
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