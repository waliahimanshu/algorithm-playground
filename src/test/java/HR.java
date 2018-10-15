import org.junit.Test;

import java.util.*;

public class HR {

    @Test
    public void balanced() throws Exception {

//         boolean balanced = isBalanced("({[]})");
//         boolean balanced = isBalanced("{[}]}");
//        boolean balanced = isBalanced("{}{}{}[]{()");
        boolean balanced = isBalanced("{[}]");
//        boolean balanced = isBalanced("[{)]");

        ArrayList<String> strings = new ArrayList<>();
        if (balanced) {
            strings.add("YES");
        } else {
            strings.add("NO");

        }
        System.out.println((strings));

    }

    @Test
    public void sumOfPairs() throws Exception {


//        int k = 47;
//        int[] a = {1, 3, 46, 1, 3, 9};

        int[] a = {3, -1, 4, -2, 1, 1, 2};
        int k = 2;

        prettyPrint(a, k);

    }

    private static void noOfPairs(int[] a, int k) {

        int length = a.length;

        // complexity is O(n^2)

//        for (int i = 0; i < a.length; i++) {
//            int first = a[i];
//            for (int j = i + 1; j < a.length - 1; j++) {
//                int second = a[j];
//                if (first + second == k) {
//                    System.out.print(i + " " + j);
//                    System.out.printf("(%d, %d) %n", first, second);
//                }
//            }
//
//        }

          /*   for (int i = a.length - 1; i >= 0; i--) {
            int last = a[i];

            int secondLast = i - 1;
            for (int j = secondLast; j > 0; j--) {
                if (last + a[j] == k) {
                    System.out.printf("(%d, %d) %n", last, secondLast);
                }
            }
        }
*/
//      Set set = new HashSet();
//      for (int i = 0; i < a.length; i++) {
//          int value = a[i];
//          int target = k - value; // if target number is not in set then add
//          if (!set.contains(target)) {
//              set.add(value);
//          } else {
//              System.out.printf("(%d, %d) %n", value, target);
//          }
//      }


        // complexity is O(N)
        Arrays.sort(a);

        int left = 0;
        int right = a.length - 1;
        while (left < right) {
            int sum = a[left] + a[right];
            if (sum == k) {
                System.out.printf("(%d, %d) %n", a[left], a[right]);
                left = left + 1;
                right = right - 1;
            } else if (sum < k) {
                left = left + 1;
            } else if (sum > k) {
                right = right - 1;
            }
        }
    }

    private static void prettyPrint(int[] givenArray, int givenSum) {
        System.out.println("Given array : " + Arrays.toString(givenArray));
        System.out.println("Given sum : " + givenSum);
        System.out.println("Integer numbers, whose sum is equal to value : " + givenSum);
        noOfPairs(givenArray, givenSum);
    }

    private boolean isBalanced(String example) {
        Stack<Character> st = new Stack<>();
        ArrayList<String> result = new ArrayList<>();

        for (char chr : example.toCharArray()) {
            switch (chr) {

                case '{':
                case '(':
                case '[':
                    st.push(chr);
                    break;

                case ']':
                    if (st.isEmpty() || st.pop() != '[')
                        return false;

                    break;
                case ')':
                    if (st.isEmpty() || st.pop() != '(')
                        return false;

                    break;
                case '}':
                    if (st.isEmpty() || st.pop() != '{')
                        return false;

                    break;
            }

        }

        return st.isEmpty();
    }


    @Test
    public void concurrentModificationException() throws Exception {
        List<String> listOfBooks = new ArrayList<>();
        listOfBooks.add("Programming Pearls");
        listOfBooks.add("Clean Code");
        listOfBooks.add("Effective Java");
        listOfBooks.add("Code Complete"); // Using forEach loop to iterate and removing //
        // element during iteration will throw // ConcurrentModificationException in Java

//        for (String book : listOfBooks) {
//            if (book.contains("Code")) ;
//            {
//                listOfBooks.remove(book);
//            }
//        }

        for (int i = 0; i < listOfBooks.size(); i++) {
            String book = listOfBooks.get(i);
            if (book.contains("Programming")) {
                System.out.println("Removing " + book);
//                listOfBooks.remove(i); // will throw CME
            }
        }
        System.out.println("List after : " + listOfBooks);


//        Iterator<String> iterator = listOfBooks.iterator();
//        while (iterator.hasNext()) {
//            String book = iterator.next();
//            listOfBooks.remove(book);
//        }


        System.out.println("List before : " + listOfBooks);
        Iterator<String> iterator = listOfBooks.iterator();
        while (iterator.hasNext()) {
            String book = iterator.next();
            System.out.println("Removing " + book);
            iterator.remove();
        }
        System.out.println("List after : " + listOfBooks);
    }

    @Test
    public void zom() throws Exception {
//        int M[][] = new int[][]{
//                {1, 1, 0, 0, 0},
//                {0, 1, 0, 0, 1},
//                {1, 0, 0, 1, 1},
//                {0, 0, 0, 0, 0},
//                {1, 0, 1, 0, 1}
//        };

        int M[][] = new int[][]{
                {1, 0, 0, 0, 0},
                {0, 1, 0, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 0, 1, 0},
                {0, 0, 0, 0, 1}
        };

//        Islands I = new Islands();
//        System.out.println("Number of islands is: " + I.countIslands(M));

        String[] data = new String[]{
                "5",
                "10000",
                "01000",
                "00100",
                "00010",
                "00001"
        };

        int count = Islands.zombieCluster(data);
        System.out.println(count);
    }

}
