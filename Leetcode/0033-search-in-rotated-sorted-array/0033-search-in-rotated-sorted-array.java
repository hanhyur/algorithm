class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) return mid;

            if (nums[left] <= nums[mid] &&
                nums[left] <= target && target < nums[mid]) {
                right = mid - 1;

                continue;
            }

            if (nums[left] > nums[mid] &&
                nums[mid] < target && target <= nums[right]) {
                left = mid + 1;

                continue;
            }

            if (nums[left] > nums[mid]) {
                right = mid - 1;

                continue;
            }

            left = mid + 1;
        }        


        return -1;
    }
}