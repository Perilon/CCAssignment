import java.util.EmptyStackException;

/**
 * Created by perilon on 9/24/15.
 */
public class Solution05 {

    public Stack<Integer> sort(Stack<Integer> stack) {

        Stack<Integer> newStack = new Stack<Integer>();

        /*Go through the stack from top to bottom, putting each element in turn in its appropriate place
        * in the new stack*/

        while (!stack.isEmpty()) {

            /*Take off the top node of the stack and keep it handy*/

            Integer tempStackNode = stack.pop();

            /*Go through the new stack from top to bottom, looking for the right place to put the temp node*/

            while (!newStack.isEmpty()) {


                /*Pop elements with a lower value than temp off the new stack and pop them on the first
                * stack, until you either come to the bottom or you reach an element with a higher
                * value than temp*/

                while (newStack.peep() < tempStackNode) {
                    stack.push(newStack.pop());
                }

                /*Push temp onto the new stack.  Higher integers will be near the bottom, lower integers
                * near the top.  Now the first stack has more elements on it (maybe) than it did, but
                * these will be replaced in their proper place(s) above where temp has ended up because
                * the outer while loop is still going on.*/

                newStack.push(tempStackNode);

            }
        }


        return newStack;

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
