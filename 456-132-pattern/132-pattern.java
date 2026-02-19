class Solution {
    public boolean find132pattern(int[] nums) {
        int n = nums.length;
        int num2 = Integer.MIN_VALUE;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] < num2)
                return true;
            while (!stack.isEmpty() && nums[i] > stack.peek()) {
                num2 = stack.pop();
            }
            stack.push(nums[i]);
        }
        return false;
    }
}