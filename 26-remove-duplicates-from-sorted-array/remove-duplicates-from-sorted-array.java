class Solution {
    public int removeDuplicates(int[] nums) {
        int currIndex = 1, lastIndex = 0, n = nums.length;
        while (currIndex < n) {
            if (nums[currIndex] == nums[lastIndex]) {
                currIndex++;
            } else {
                nums[++lastIndex] = nums[currIndex++];
            }
        }
        return lastIndex + 1;
    }
}