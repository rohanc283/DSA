class Solution {
    public int minOperations(int[] nums, int k) {
        int totalXor = nums[0];
        for (int i = 1; i < nums.length; i++)
            totalXor ^= nums[i];

        int num = totalXor ^ k;
        int count = 0;
        while (num > 0) {
            count++;
            num = num & (num - 1);
        }
        return count;
    }
}