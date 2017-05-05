import org.junit.Test;

import java.util.Arrays;

public class QueueImplementations {

    private class Node {
        String item;
        Node next;

        @Override
        public String toString() {
            return "Node{" +
                    "item='" + item + '\'' +
                    ", next=" + next +
                    '}';
        }
    }

    @Test
    public void usingLinkedListWithZeroItem() throws Exception {
        QueueUsingLinkedList queue = new QueueUsingLinkedList();

        queue.enqueue("to");
        queue.dequeue();

        System.out.println(queue.isEmpty());
        System.out.println(queue.size());
        System.out.println((queue.last == null ? "i am empty queue ":queue.last.toString()));

    }
    @Test
    public void usingLinkedListMultipleItems() throws Exception {
        QueueUsingLinkedList queue = new QueueUsingLinkedList();

        queue.enqueue("to");
        queue.enqueue("be");
        queue.enqueue("or");
        queue.enqueue("not");
        queue.enqueue("to");
        System.out.println((queue.first.toString()));
        queue.dequeue();
        System.out.println("deque-->"+(queue.first.toString()));
        queue.enqueue("be");
        System.out.println("enqueue-->"+(queue.first.toString()));
        queue.dequeue();
        System.out.println("deque-->"+(queue.first.toString()));


        System.out.println(queue.isEmpty());
        System.out.println(queue.size());
        System.out.println((queue.last == null ? "i am empty queue ":queue.last.toString()));

    }

    @Test
    public void withResizableArrayZeroItem() throws Exception {
        QueueWithResizableArray queue = new QueueWithResizableArray();
        queue.enqueue("to");
        System.out.println((Arrays.toString(queue.data)));
        queue.dequeue();
        System.out.println("deque-->"+(Arrays.toString(queue.data)));

        System.out.println(queue.isEmpty());
        System.out.println(queue.size());

    }

    @Test
    public void withResizableArrayMultipleItems() throws Exception {
        QueueWithResizableArray queue = new QueueWithResizableArray();

        queue.enqueue("to");
        queue.enqueue("be");
        queue.enqueue("or");
        queue.enqueue("not");
        queue.enqueue("to");
        System.out.println((Arrays.toString(queue.data)));
        queue.dequeue();
        System.out.println("deque-->"+(Arrays.toString(queue.data)));

        System.out.println(queue.isEmpty());
        System.out.println(queue.size());

    }

    private class QueueWithResizableArray {

        private int size = 0;
        String [] data  = new String[1];

        private void enqueue(String  item) {
            if(data.length == size){
                resizeTo(2 * data.length);
            }
            data[size] = item;
            size++;

        }

        private void resizeTo(int length) {
            //noinspection Since15
            data = Arrays.copyOf(data, length);
        }

        private String dequeue() {
            String item = data[0];
            data[0] = null;
            return item;
        }

        private int size() {
            return data.length;
        }
        private boolean isEmpty(){
            return data.length == 0;
        }

    }


    private class QueueUsingLinkedList {
        Node last, first;
        private int size = 0;

        // insert at the end
        void enqueue(String item) {

            Node oldLast = last;
            last = new Node();
            last.item = item;

            if (size++ == 0) {
                first = last;
            }
            else {
                oldLast.next = last;
            }
        }

        //remove from the front
        String dequeue() {
            if (size == 0) throw new java.util.NoSuchElementException();
            String item = first.item;
            first = first.next;

            if(--size == 0){
                last = null;
            }
            return item;
        }

        int size() {
            return size;
        }

        boolean isEmpty() {
            return last == null;
        }
    }
}
