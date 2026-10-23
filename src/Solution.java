/**
 * LeetCode 88: Merge Sorted Array
 * Difficulty: Easy
 *
 * Problem:
 * Given two integer arrays nums1 and nums2, sorted in non-decreasing order,
 * and two integers m and n, representing the number of elements in nums1 and nums2 respectively.
 * Merge nums1 and nums2 into a single array sorted in non-decreasing order inside nums1 in-place.
 */
public class Solution {

    /**
     * Merges nums2 into nums1 in-place in non-decreasing sorted order.
     *
     * @param nums1 The destination array with capacity m + n. First m elements are valid.
     * @param m     The number of valid elements in nums1.
     * @param nums2 The source array with n elements.
     * @param n     The number of elements in nums2.
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // Pointer to the last valid element in nums1
        int p1 = m - 1;
        // Pointer to the last element in nums2
        int p2 = n - 1;
        // Pointer to the last position in nums1 (where elements will be placed)
        int p = m + n - 1;

        // Traverse from the back while elements remain in nums2
        while (p2 >= 0) {
            // If nums1 has elements remaining and its element is larger, place it at p
            if (p1 >= 0 && nums1[p1] > nums2[p2]) {
                nums1[p] = nums1[p1];
                p1--;
            } else {
                // Otherwise place nums2's element at p
                nums1[p] = nums2[p2];
                p2--;
            }
            p--;
        }
        // Note: Any elements remaining in nums1 are already in their correct places!
    }
}
