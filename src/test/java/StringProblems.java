import org.junit.Test;

import java.util.Scanner;

public class StringProblems {

    @Test
    public void name() throws Exception {

        test();

    }

    private static void test() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int a=0; a<n; a++){
            int out = 0;
            String input = sc.next();
            if(palindrome(input)){
                System.out.println("-1");
            }
            else{
                for(int i=0; i<input.length(); i++){
                    StringBuilder ss = new StringBuilder(input);
                    if(input.charAt(i)!=input.charAt(input.length()-i-1)){
                        if(palindrome(ss.deleteCharAt(i).toString())){
                            System.out.println(i);
                        }
                        else System.out.println(input.length()-i-1);
                        break;
                    }
                }
            }
        }
    }

    public static boolean palindrome(String s){
        StringBuffer sb = new StringBuffer(s).reverse();
        if(sb.equals(s)){
            return true;
        }
        else return false;
    }


}
