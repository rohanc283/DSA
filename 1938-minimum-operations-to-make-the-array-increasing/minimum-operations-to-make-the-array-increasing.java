class Solution {
    public int minOperations(int[] nums) {
        int op = 0;
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            int diff = num - nums[i - 1];
            if (diff < 1) {
                int newNum = num + Math.abs(diff) + 1;
                op += newNum - num;
                nums[i] = newNum;
            }
        }
        return op;
    }
}