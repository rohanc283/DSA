class Solution {
    public void update(int[] binary, int num, int val) {
        for (int i = 0; i < 32; i++) {
            if (((num >> i) & 1) > 0) {
                binary[i] += val;
            }
        }
    }

    public int getDecimalFromBinary(int[] binary) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            if (binary[i] > 0) {
                res |= (1 << i);
            }
        }
        return res;
    }

    public int minimumSubarrayLength(int[] nums, int k) {
        int res = Integer.MAX_VALUE;
        int s = 0, e = 0, n = nums.length;
        int[] binary = new int[32];
        while (e < n) {
            update(binary, nums[e], 1);
            while (s <= e && getDecimalFromBinary(binary) >= k) {
                res = Math.min(res, e - s + 1);
                update(binary, nums[s++], -1);
            }
            e++;
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}