import com.sun.javaws.exceptions.InvalidArgumentException
import org.junit.Test

import java.util.*

import org.hamcrest.CoreMatchers.`is`
import org.junit.Assert.assertThat

class AdHocProblems {

    @Test
    @Throws(Exception::class)
    fun destinations() {
        val array = arrayOf("xx", "yy", "xx", "xx", "yy", "xx")

        var max = 0
        var result = ""

        for (i in array.indices) {
            val frequency = Collections.frequency(Arrays.asList(*array), array[i])
            if (frequency > max) {
                max = frequency
                result = array[i]
            }
        }

        assertThat(result, `is`("xx"))
    }


    @Test
    @Throws(Exception::class)
    fun sumPowerOfTwo() {

        val n = 10
        var sum = 0

        //using built in function to cal power
        for (i in 1..n) {
            sum += Math.pow(i.toDouble(), 2.0).toInt()
        }

        assertThat(sum, `is`(385))

        sum = 0

        //without using built in func

        for (i in 0..n) {
            sum += power(i, 2)

        }
        assertThat(sum, `is`(385))

        println(Math.pow(2.0, 0.0))

    }

    @Throws(InvalidArgumentException::class)
    private fun power(i: Int, p: Int): Int {
        if (p == 0) {
            return 1
        }

        if (i == 0) {
            return 0
        } else {
            return i * i
        }
    }

    @Test
    @Throws(Exception::class)
    fun test() {

    }
}
