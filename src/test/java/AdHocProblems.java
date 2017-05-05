import com.sun.javaws.exceptions.InvalidArgumentException;
import org.junit.Test;

import java.util.*;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class AdHocProblems {

    @Test
    public void destinations() throws Exception {
        String[] array = new String[]{"xx", "yy", "xx", "xx", "yy", "xx"};

        int max = 0;
        String result = "";

        for (int i = 0; i < array.length; i++) {
            int frequency = Collections.frequency(Arrays.asList(array), array[i]);
            if (frequency > max) {
                max = frequency;
                result = array[i];
            }
        }

        assertThat(result, is("xx"));
    }


    @Test
    public void sum_of_first_N_powers_of_2_starting_from_1() throws Exception {

        int n = 10;
        int sum = 0;

        //using built in function to cal power
        for (int i = 1; i <= n; i++) {
            sum += Math.pow(i, 2);
        }

        assertThat(sum, is(385));

        sum = 0;

        //without using built in func

        for (int i = 0; i <= n; i++) {
            sum += power(i, 2);

        }
        assertThat(sum, is(385));

        System.out.println(Math.pow(2, 0));

    }

    private int power(int i, int p) throws InvalidArgumentException {
        if(p == 0)
        {
            return 1;
        }

        if (i == 0) {
            return 0;
        }
        else {
            return i * i;
        }
    }

    @Test
    public void test() throws Exception {

    }
}
