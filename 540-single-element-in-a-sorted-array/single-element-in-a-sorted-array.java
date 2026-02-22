class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        int s = 0, e = n - 1;
        while (s < e) {
            int m = s + (e - s) / 2;
            boolean isEven = (e - m) % 2 == 0;
            if (nums[m] == nums[m + 1]) {
                if (isEven) {
                    s = m + 2;
                } else {
                    e = m - 1;
                }
            } else {
                if (isEven) {
                    e = m;
                } else {
                    s = m + 1;
                }
            }
        }
        return nums[s];
    }
}