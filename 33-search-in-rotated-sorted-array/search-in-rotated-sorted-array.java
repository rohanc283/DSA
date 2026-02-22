class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int l = 0, h = n - 1;
        while (l < h) {
            int m = l + (h - l) / 2;
            if (nums[m] > nums[n - 1]) {
                l = m + 1;
            } else {
                h = m;
            }
        }
        return l;
    }

    public int search(int[] nums, int target) {
        int n = nums.length;
        int peakIdx = findMin(nums);
        System.out.println(peakIdx);
        if (target >= nums[peakIdx] && target <= nums[n - 1]) {
            int idx = Arrays.binarySearch(nums, peakIdx, n, target);
            if (idx < 0)
                return -1;
            return idx;
        }
        int idx = Arrays.binarySearch(nums, 0, peakIdx, target);
        if (idx < 0)
            return -1;
        return idx;
    }
}