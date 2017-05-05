import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class AdHocProblems {

    @Test
    public void destinations() throws Exception {


        int count = 6;
        String[] array = new String[]{"Barcelona", "Miami", "Barcelona", "Barcelona", "Miami", "Barcelona"};


        int max = 0;
        String result ="";
        for (int i = 0; i < array.length; i++) {
            int frequency = getCounter(array,array[i]);
            if(frequency > max) {
                max = frequency;
                result = array[i];
            }
        }
        System.out.println(result);

    }

    private int getCounter(String [] array, String o) {
        int count =0;
        for (String s : array) {
            if(s.equalsIgnoreCase(o)){
               return count++;
            }
        }

//        return Collections.frequency(Arrays.asList(array), o);

        return 0;
    }

    @Test
    public void hasMapOrder() throws Exception {

        /**
         *  Sarah Fred
         Sarah Paul
         Fred Hilary
         Fred Jenny
         Jenny James
         */

        HashMap<String, String> map = new HashMap<String, String>();
        map.put("Sarah","Fred");
        map.put("Fred","Hilary");
        map.put("Fred","Jenny");
        map.put("Jenny","James");


        for (Map.Entry<String, String> entries:
            map.entrySet() ) {
            System.out.println(entries.getValue());
        }
    }
}
