class Solution {
    public boolean isPoss(int[] nums, int k, int sum) {
        int currSplit = 0;
        int currSum = 0;
        for (int num : nums) {
            if (currSum + num > sum) {
                currSplit++;
                if (currSplit >= k || num > sum)
                    return false;
                currSum = num;
            } else {
                currSum += num;
            }
        }
        return currSplit < k;
    }

    public int splitArray(int[] nums, int k) {
        int l = 0, h = 0;
        for (int num : nums)
            h += num;
        int res = 0;
        while (l <= h) {
            int m = l + (h - l) / 2;
            if (isPoss(nums, k, m)) {
                res = m;
                h = m - 1;
            } else {
                l = m + 1;
            }
        }
        return res;
    }
}