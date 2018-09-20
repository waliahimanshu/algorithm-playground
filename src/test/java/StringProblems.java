import org.junit.Test;

import java.util.Scanner;

public class StringProblems {

    private int[][] prices;

    @Test
    public void name() throws Exception {

        test();

    }

    @Test
    public void Matrix() throws Exception {

        prices = new int[][]{{-1, 42, 13, 17, 23}, {2, 5, 7, 7, 1}, {7, 6, 7, 8, 6}};

        int sum = 0;
        int targerSeats = 3;
        int max_ending_here = 0;
        int max_so_far = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++) {

            for (int j = i; j < prices[i].length; j++) {
                if (prices[i][j] != -1) {

                    max_ending_here = Math.min(prices[i][j], max_ending_here + prices[i][j]);
                    max_so_far = Math.min(max_so_far, max_ending_here);


                }


            }
        }
        System.out.print(max_so_far);

    }


    @Test
    public void f() throws Exception {
        int[] ints = {-1, 42, 13, 17, 23};

        int i = maxSubArray(ints);
    }

    public int maxSubArray(int[] A) {
        int newsum = A[0];
        int max = A[0];

        for (int i = 1; i < A.length; i++) {
            if (A[i] != -1) {
                newsum = Math.min(newsum + A[i], A[i]);
                max = Math.min(max, newsum);
            }
        }
        return max;
    }

    static int maxSubArraySum(int a[]) {
        int size = a.length;
        int max_so_far = Integer.MIN_VALUE, max_ending_here = 0;

        for (int i = 0; i < size; i++) {
            max_ending_here = max_ending_here + a[i];
            if (max_so_far < max_ending_here)
                max_so_far = max_ending_here;
            if (max_ending_here < 0)
                max_ending_here = 0;
        }
        return max_so_far;
    }

    @Test
    public void searchInMatrix() throws Exception {

        searchMatrix(prices, 7);
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int start = 0, rows = matrix.length, cols = matrix[0].length;
        int end = rows * cols - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (matrix[mid / cols][mid % cols] == target) {
                return true;
            }
            if (matrix[mid / cols][mid % cols] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return false;
    }

    private static void test() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int a = 0; a < n; a++) {
            int out = 0;
            String input = sc.next();
            if (palindrome(input)) {
                System.out.println("-1");
            } else {
                for (int i = 0; i < input.length(); i++) {
                    StringBuilder ss = new StringBuilder(input);
                    if (input.charAt(i) != input.charAt(input.length() - i - 1)) {
                        if (palindrome(ss.deleteCharAt(i).toString())) {
                            System.out.println(i);
                        } else System.out.println(input.length() - i - 1);
                        break;
                    }
                }
            }
        }
    }

    public static boolean palindrome(String s) {
        StringBuffer sb = new StringBuffer(s).reverse();
        if (sb.equals(s)) {
            return true;
        } else return false;
    }


}
