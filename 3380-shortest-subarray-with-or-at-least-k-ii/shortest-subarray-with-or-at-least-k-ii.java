class Solution {
    private void addNumToBits(int[] bits, int num, int val) {
        for (int i = 31; i >= 0; i--) {
            if (((num >> i) & 1) >= 1) {
                bits[i] += val;
            }
        }
    }

    private int getNumFromBits(int[] bits) {
        int num = 0;
        for (int i = 31; i >= 0; i--) {
            if (bits[i] > 0) {
                num |= (1 << i);
            }
        }
        return num;
    }

    public int minimumSubarrayLength(int[] nums, int k) {
        int[] bits = new int[32];
        int minLen = Integer.MAX_VALUE;
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            int num = nums[j];
            addNumToBits(bits, num, 1);
            while (getNumFromBits(bits) >= k && i <= j) {
                minLen = Math.min(minLen, j - i + 1);
                num = nums[i++];
                addNumToBits(bits, num, -1);
            }
        }
        return minLen == Integer.MAX_VALUE ? -1 : minLen;
    }
}