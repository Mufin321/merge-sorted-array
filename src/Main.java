import java.util.Arrays;

/**
 * Test Runner for LeetCode 88: Merge Sorted Array
 * Validates the solution against standard and hidden edge cases.
 */
public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int passed = 0;
        int total = 0;

        System.out.println("==================================================");
        System.out.println("      Running Tests for Merge Sorted Array        ");
        System.out.println("==================================================");

        // Test 1: Standard Example 1 (Interleaved)
        total++;
        if (runTest(solution, 1, 
                new int[]{1, 2, 3, 0, 0, 0}, 3, 
                new int[]{2, 5, 6}, 3, 
                new int[]{1, 2, 2, 3, 5, 6})) passed++;

        // Test 2: Standard Example 2 (nums2 is empty, n = 0)
        total++;
        if (runTest(solution, 2, 
                new int[]{1}, 1, 
                new int[]{}, 0, 
                new int[]{1})) passed++;

        // Test 3: Standard Example 3 (nums1 is empty, m = 0)
        total++;
        if (runTest(solution, 3, 
                new int[]{0}, 0, 
                new int[]{1}, 1, 
                new int[]{1})) passed++;

        // Test 4: All elements in nums2 are smaller than nums1
        total++;
        if (runTest(solution, 4, 
                new int[]{4, 5, 6, 0, 0, 0}, 3, 
                new int[]{1, 2, 3}, 3, 
                new int[]{1, 2, 3, 4, 5, 6})) passed++;

        // Test 5: All elements in nums2 are larger than nums1
        total++;
        if (runTest(solution, 5, 
                new int[]{1, 2, 3, 0, 0, 0}, 3, 
                new int[]{7, 8, 9}, 3, 
                new int[]{1, 2, 3, 7, 8, 9})) passed++;

        // Test 6: Duplicates in both arrays
        total++;
        if (runTest(solution, 6, 
                new int[]{2, 2, 2, 0, 0, 0}, 3, 
                new int[]{2, 2, 2}, 3, 
                new int[]{2, 2, 2, 2, 2, 2})) passed++;

        // Test 7: Negative numbers and zero
        total++;
        if (runTest(solution, 7, 
                new int[]{-5, -3, 0, 0, 0, 0}, 3, 
                new int[]{-4, -1, 2}, 3, 
                new int[]{-5, -4, -3, -1, 0, 2})) passed++;

        // Test 8: Single element each
        total++;
        if (runTest(solution, 8, 
                new int[]{2, 0}, 1, 
                new int[]{1}, 1, 
                new int[]{1, 2})) passed++;

        System.out.println("==================================================");
        System.out.printf("Results: %d/%d tests passed.%n", passed, total);
        if (passed == total) {
            System.out.println("All test cases passed successfully!");
        } else {
            System.out.println("Some test cases failed.");
        }
        System.out.println("==================================================");
    }

    private static boolean runTest(Solution solution, int testNum, 
                                   int[] nums1, int m, int[] nums2, int n, int[] expected) {
        int[] originalNums1 = nums1.clone();
        int[] originalNums2 = nums2.clone();

        solution.merge(nums1, m, nums2, n);
        boolean isCorrect = Arrays.equals(nums1, expected);

        System.out.printf("Test %d: %s%n", testNum, isCorrect ? "[PASS] " : "[FAIL] ");
        System.out.printf("  Input nums1 : %s (m = %d)%n", Arrays.toString(originalNums1), m);
        System.out.printf("  Input nums2 : %s (n = %d)%n", Arrays.toString(originalNums2), n);
        System.out.printf("  Actual      : %s%n", Arrays.toString(nums1));
        System.out.printf("  Expected    : %s%n%n", Arrays.toString(expected));

        return isCorrect;
    }
}
