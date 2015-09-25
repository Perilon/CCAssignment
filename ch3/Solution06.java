import java.util.EmptyStackException;
import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * Created by perilon on 9/25/15.
 */
public class Solution06 {

    public class AnimalQueue<String> {


        private class QueueNode<String> {

            private String data;
            public boolean isDog;

            private QueueNode<String> next;

            public QueueNode(String data) {
                this.data = data;

                if (data == "dog") {
                    isDog = true;
                } else {
                    isDog = false;
                }
            }
        }

        private QueueNode<String> first;
        private QueueNode<String> last;

        public void add(String item) {

            QueueNode<String> t = new QueueNode<String>(item);
            if (last != null) {
                last.next = t;
            }
            last = t;
            if (first == null) {
                first = last;
            }
        }

        public QueueNode<String> remove() {
            if (first == null) throw new NoSuchElementException();
//            String data = first.data;
            QueueNode<String> temp = first;
            first = first.next;
            if (first == null) {
                last = null;
            }
            return temp;
        }

        public String peekValue() {
            if (first == null) throw new EmptyStackException();
            return first.data;
        }

        public boolean peekDog() {
            if (first == null) throw new EmptyStackException();
            return first.isDog;
        }

        public boolean isEmpty() {
            return first == null;
        }

        public void enqueue(String t) {
            add(t);
        }

        public String dequeueAny() {
            return remove().data;
        }

        public String dequeueDog() {

            QueueNode<String> temp = new QueueNode("There was no dog.");

            boolean dogGotten = false;
            LinkedList<QueueNode<String>> theRestOfTheAnimals = new LinkedList<QueueNode<String>>();
            while (!isEmpty() || !dogGotten) {
                if (peekDog() == false) {
                    theRestOfTheAnimals.add(remove());
                } else {            //  if you come to a dog
                    temp = remove();
                    dogGotten = true;
                }
            }
            while (!isEmpty()) {
                theRestOfTheAnimals.add(remove());
            }
            for (QueueNode<String> animal : theRestOfTheAnimals) {
                add(animal.data );

            }
            return temp.data;
        }

        public String dequeueCat() {

            QueueNode<String> temp = new QueueNode("There was no cat.");

            boolean catGotten = false;
            LinkedList<QueueNode<String>> theRestOfTheAnimals = new LinkedList<QueueNode<String>>();
            while (!isEmpty() || !catGotten) {
                if (peekDog() == true) {
                    theRestOfTheAnimals.add(remove());
                } else {            //  if you come to a cat
                    temp = remove();
                    catGotten = true;
                }
            }
            while (!isEmpty()) {
                theRestOfTheAnimals.add(remove());
            }
            for (QueueNode<String> animal : theRestOfTheAnimals) {
                add(animal.data );

            }
            return temp.data;
        }


    }

}
