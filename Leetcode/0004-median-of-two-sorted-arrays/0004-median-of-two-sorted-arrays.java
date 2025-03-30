class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        if (m > n) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int sum = m + n;
        int left = (sum + 1) / 2;
        int low = 0;
        int high = m;

        while (low <= high) {
            int mid1 = (low + high) / 2;
            int mid2 = left - mid1;

            int left1 = (mid1 - 1 < 0) ? Integer.MIN_VALUE : nums1[mid1 - 1];
            int right1 = (mid1 >= m) ? Integer.MAX_VALUE : nums1[mid1];

            int left2 = (mid2 - 1 < 0) ? Integer.MIN_VALUE : nums2[mid2 - 1];
            int right2 = (mid2 >= n) ? Integer.MAX_VALUE : nums2[mid2];

            if (left1 <= right2 && left2 <= right1) {
                if (sum % 2 == 0) {
                    return (Math.max(left1, left2) + Math.min(right1, right2)) / 2.0;
                } else {
                    return Math.max(left1, left2);
                }
            }
            
            if (left1 > right2) {
                high = mid1 - 1;
            } else {
                low = mid1 + 1;
            }
        }

        return 0;
    }
}