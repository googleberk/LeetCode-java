
// ---------
// Licensing Information:  You are free to use or extend these
// projects for educational purposes provided that (1) you do
// not distribute or publish solutions without the permission
// from the author: Tony Li (appleearth007@gmail.com),(2) you
// retain this notice, and (3) you provide clear attribution
// to UC Berkeley, and Tony Li.

package medianOfTwoSortedArrays;

// There are two sorted arrays nums1 and nums2 of size m and n respectively.
// Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
// run time should be BIG THETA(log(min(m, n))) INSTEAD ???
// since we assume nums1.length is always <= nums2.length,
// then the run time should be BIG THETA(log(N)) where N == nums1.length
//You may assume nums1 and nums2 cannot be both empty.

// Example: nums1 = [1, 3], nums2 = [2]; The median is 2.0
// Example2: nums1 = [1, 2], nums2 = [3, 4], The median is (2 + 3)/2 = 2.5

public class Median {

    // this algorithm was hinted by person from this youtube video:
    // see the link: https://youtu.be/LPFhl65R7ww

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        // we always assume nums1.length <= nums2.length,
        // and we are going to do a binary search on the shorter array,
        // which is exactly nums1.
        // nums1 = [23, 26, 31, 35]
        // nums2 = [3, 5, 7, 9, 11, 16]


        int start = 0;
        int end = nums1.length;
        int positionX = (start + end) / 2;
        int positionY = (nums1.length + nums2.length + 1) / 2 - positionX;

        // finding/ending condition:
        // maxLeftX <= minRightY && maxLeftY <= minRightX
        // while it is NOT the above case, we should do something in the while statement,
        // so the while statement should
        // be !(maxLeftX <= minRightY) && !(maxLeftY <= minRightX),
        // and when you apply DeMorgan's Law, you will get the answer below.
        while ((nums1[positionX - 1] > nums2[positionY])
                || (nums2[positionY - 1] > nums1[positionX])) {

            // if maxLeftX > minRightY: move towards left in the X array;
            // do binary search on the left hand side
            // else if do binary search on the right hand side of the X array.
            if (nums1[positionX - 1] > nums2[positionY]) {
                end = positionX - 1;
                positionX = (start + end) / 2;
                positionY = (nums1.length + nums2.length + 1) / 2 - positionX;
                if (positionX == 0) {
                    break;
                }
            } else {
                start = positionX + 1;
                positionX = (start + end) / 2;
                positionY = (nums1.length + nums2.length + 1) / 2 - positionX;
                if (positionX == nums1.length) {
                    break;
                }
            }

        }

        // if nums1.length + nums2.length is odd, then return the else part,
        // otherwise the statement in the if part.
        if ((nums1.length + nums2.length) % 2 == 0) {
            // two corner cases
            if (positionX == 0) {
                return (nums2[positionY - 1]
                        + Math.min(nums1[positionX], nums2[positionY])) / 2.0;
            } else if (positionX == nums1.length) {
                return (Math.max(nums1[positionX - 1], nums2[positionY - 1])
                        + nums2[positionY]) / 2.0;
            }
            return (Math.max(nums1[positionX - 1], nums2[positionY - 1])
                    + Math.min(nums1[positionX], nums2[positionY])) / 2.0;
        }
        // one corner case
        if (positionX == 0 || positionX == 4) {
            return nums2[positionY - 1];
        }
        return Math.max(nums1[positionX - 1], nums2[positionY - 1]);


    }


}


