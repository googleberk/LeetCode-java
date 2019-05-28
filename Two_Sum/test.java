package Two_Sum;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.Arrays;


public class test {

    // note: this test is not(far from) complete, you can add y our own tests if you want
    @Test
    public void testFirstMethod() {

        int[] nums = {2, 7, 11, 15};
        twosum ts = new twosum();
        int[] result1 = ts.first_method(nums, 9);
        int[] result2 = ts.second_method(nums, 26);
        // I am using the built-in library of Arrays.toString() to compare two int arrays, which isn't really cool.
        assertEquals(Arrays.toString(new int[]{0, 1}), Arrays.toString(result1));
        // should put expected to the first argument of assertEquals, and your actual value at the second argument.
        assertEquals(Arrays.toString(new int[]{2, 3}), Arrays.toString(result2));
    }


}

