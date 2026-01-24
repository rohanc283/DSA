class Solution {
    public int removeElement(int[] nums, int val) {
        int last = 0, curr = 0, n = nums.length;
        while (curr < n) {
            if (nums[curr] == val)
                curr++;
            else {
                nums[last++] = nums[curr++];
            }
        }
        return last;
    }
}