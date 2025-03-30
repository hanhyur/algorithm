class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        

        int sum1 = 0;
        int sum2 = 0;

        for (int i = 0; i < m; i++) {
            sum1 += nums1[i];
        }

        for (int i = 0; i < n; i++) {
            sum2 += nums2[i];
        }

        int total = sum1 + sum2;

        return total / (double) (m + n);
    }
}