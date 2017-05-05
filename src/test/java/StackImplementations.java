import org.junit.Test;

import java.util.Arrays;

public class StackImplementations {


    @Test
    public void usingLinkedList() throws Exception {
        StackUsingLinkedList stack = new StackUsingLinkedList();

        stack.push(0);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.pop();

        System.out.println(stack.isEmpty());
        System.out.println(stack.size());
        System.out.println(stack.first.toString());
    }

    @Test
    public void usingArray() throws Exception {
        StackUsingArrays stack = new StackUsingArrays(3);

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.pop();

        System.out.println(stack.isEmpty());
        System.out.println(stack.size());
        System.out.println(Arrays.toString(stack.data));
    }

    @Test
    public void usingResizableArray() throws Exception {
        StackUsingResizableArray stack = new StackUsingResizableArray();

        stack.push(2);
        stack.push(4);
        stack.push(7);
        stack.push(9);
        stack.push(3);
        stack.pop();
        stack.push(1);
        stack.pop();
        stack.pop();
        stack.push(10);
        stack.pop();
        stack.pop();
        stack.pop();
        stack.push(100);

        System.out.println(stack.isEmpty());
        System.out.println(stack.size());
        System.out.println(Arrays.toString(stack.data));
    }

    /**
     * less wasted space
     * every operation take constant time 'amortized' time
     */
    class StackUsingResizableArray {
        int n = 0;
        Integer data[] = null;
        private
        Integer[] copy;

        StackUsingResizableArray() {
            this.data = new Integer[1];
        }

        void push(int item) {
            if (n == data.length) {
                resize(data.length * 2);
            }
            data[n++] = item;
        }

        private void resize(int newLen) {
            //noinspection Since15
            copy = Arrays.copyOf(data, newLen);
            data = copy;
        }


        int pop() {
            int i = --n;
            int item = data[i];
            if (n > 0 && n == data.length / 4) resize(data.length / 2);
            data[i] = null; // so that ready to be Garbage collected.
            return item;

        }

        int size() {
            return n;
        }

        boolean isEmpty() {
            return n == 0;
        }
    }

    /**
     * overflows and underflow
     * Limits clients to provide the size via consrtructor.
     */
    private class StackUsingArrays {
        Integer data[] = null;
        int n = 0;

        StackUsingArrays(int n) {
            this.data = new Integer[n];
        }

        void push(int item) {
            data[n++] = item;
        }

        int pop() {
//            return data[--n]; //if this line only its loitering
            int item = data[--n];
            data[n] = null;
            return item;
        }

        int size() {
            return n;
        }

        boolean isEmpty() {
            return data.length == 0;
        }
    }

    /**
     * Stack of Int, implement using LinkedList aka (Queue)
     *
     * Time complexity : worst case linear all operations takes constant time
     * Space complexity: N items use 40 * N bytes
     * use extra space and time to deal with the links
     */

    //16 bytes per object
    private class StackUsingLinkedList {

        //8 bytes per inner class
        private class Node {
            int item; // 8 bytes ?
            Node next; //8 bytes

            @Override
            public String toString() {
                return "Node{" +
                        "item=" + item +
                        ", next=" + next +
                        '}';
            }
        }

        Node first = null;
        private int size = 0;

        void push(int item) {
            Node oldFirst = first;
            first = new Node();
            first.item = item;
            first.next = oldFirst;
            size++;
        }

        Integer pop() {
            int item = first.item;
            first = first.next;
            size--;
            return item;
        }

        int size() {
            return size;
        }

        boolean isEmpty() {
            return first == null;
        }
    }
}

