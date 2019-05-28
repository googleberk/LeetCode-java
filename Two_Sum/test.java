package Two_Sum;

// ---------
// Licensing Information:  You are free to use or extend these projects for
// educational purposes provided that (1) you do not distribute or publish
// solutions without the permission from the author, (2) you retain this notice,
// and (3) you provide clear attribution to UC Berkeley, and me. // email Shuowei Li
// (appleearth007@gmail.com) for more information.

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

