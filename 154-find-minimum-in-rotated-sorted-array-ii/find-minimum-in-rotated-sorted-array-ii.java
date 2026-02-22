class Solution {
    public int findMin(int[] nums) {
        // int n = nums.length;
        // int l = 0, h = n - 1;
        // while (l < h) {
        //     while (l < h && nums[l] == nums[l + 1])
        //         l++;
        //     while (l < h && nums[h] == nums[h - 1])
        //         h--;
        //     int m = l + (h - l) / 2;
        //     if (nums[m] > nums[h]) {
        //         l = m + 1;
        //     } else {
        //         h = m;
        //     }
        // }
        // return nums[l];
        int n = nums.length;
        int l = 0, h = n - 1;
        while (l < h) {
            int m = l + (h - l) / 2;
            if (nums[m] > nums[h]) {
                l = m + 1;
            } else if (nums[m] < nums[h]) {
                h = m;
            } else {
                h--;
            }
        }
        return nums[l];
    }
}