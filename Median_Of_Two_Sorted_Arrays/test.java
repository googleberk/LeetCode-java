// ---------
// Licensing Information:  You are free to use or extend these projects for
// educational purposes provided that (1) you do not distribute or publish
// solutions without the permission from the author: Shuowei Li(appleearth007@gmail.com),
// (2) you retain this notice, and (3) you provide clear attribution to UC Berkeley, and me.

package Median_Of_Two_Sorted_Arrays;
import static org.junit.Assert.*;
import org.junit.Test;

public class test {

    // note: this test is not(far from) complete, you can add y our own tests if you want
    @Test
    public void testMethod() {
        median m = new median();
        // even length and x can be on both sides
        int[] nums11 = {1, 3, 5, 7};
        int[] nums12 = {2, 4, 6, 8, 9, 16};
        double result6 = m.findMedianSortedArrays(nums11, nums12);
        assertEquals(5.5, result6,0.001);

        // even length and all x on the right side
        int[] nums1 = {23, 26, 31, 35};
        int[] nums2 = {3, 5, 7, 9, 11, 16};
        double result1 = m.findMedianSortedArrays(nums1, nums2);
        assertEquals(13.5, result1,0.001);


        // even length and all x on the left side
        int[] nums5 = {1, 3, 8, 9};
        int[] nums6 = {11, 18, 19, 21, 25, 36};
        double result3 = m.findMedianSortedArrays(nums5, nums6);
        assertEquals(14.5, result3,0.001);


        // odd length and x can be on both sides
        int[] nums3 = {1, 3, 8, 9, 15};
        int[] nums4 = {7, 11, 18, 19, 21, 25};
        double result2 = m.findMedianSortedArrays(nums3, nums4);
        assertEquals(11, result2,0.001);


        // odd length and all x on the right side:
        int[] nums7 = {23, 26, 31, 35};
        int[] nums8 = {3, 5, 7, 9, 11};
        double result4 = m.findMedianSortedArrays(nums7, nums8);
        assertEquals(11, result4,0.001);


        // odd length and all x on the left side
        int[] nums9 = {1, 3, 8, 9};
        int[] nums10 = {17, 18, 19, 21, 25};
        double result5 = m.findMedianSortedArrays(nums9, nums10);
        assertEquals(17, result5,0.001);

    }


}

