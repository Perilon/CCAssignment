import java.util.ArrayList;
import java.util.EmptyStackException;

/**
 * Created by perilon on 9/24/15.
 */
public class Solution03 {

    class MultipleStacks {
        ArrayList<Stack> multipleStacks = new ArrayList<Stack>();

        public int capacity;

        public MultipleStacks(int capacity) {
            this.capacity = capacity;
        }

        public void push(Object x) {

            int numStacks = multipleStacks.size();

            if (numStacks > 0) {
                Stack lastStack = multipleStacks.get(numStacks);
                if (!lastStack.atCapacity()) {
                    lastStack.push(x);
                } else {
                    Stack newStack = new Stack(capacity);
                    multipleStacks.add(newStack);
                    newStack.push(x);
                }
            } else {
                Stack newStack = new Stack(capacity);
                multipleStacks.add(newStack);
                newStack.push(x);
            }
        }

        public Object pop() {

            int numStacks = multipleStacks.size();

            if (numStacks > 0) {
                Stack lastStack = multipleStacks.get(numStacks);
                if (lastStack.isEmpty()) {
                    throw new EmptyStackException();
                } else {

                    Object answer = lastStack.pop();

                    if (lastStack.isEmpty()) {
                        multipleStacks.remove(multipleStacks.get(numStacks));
                    }

                    return answer;
                }

            } else {
                throw new EmptyStackException();
            }


        }

    }


    /*Book provides some of this code*/
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
            size--;
            return item;
        }

        public boolean push(T item) {
            if (size < capacity) {
                StackNode<T> t = new StackNode<T>(item);
                t.next = top;
                top = t;
                size++;
                return true;
            } else {
                return false;
            }
        }

        public T peep() {
            if (top == null) throw new EmptyStackException();
            return top.data;
        }

        public boolean isEmpty() {
            return top == null;
        }

        private int capacity;

        public int size = 0;

        public Stack(int capacity) {
            this.capacity = capacity;
        }

        public boolean atCapacity() {
            return size == capacity;
        }

    }

}
