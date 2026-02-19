class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Deque<Integer> stack = new ArrayDeque<>();
        int n = nums.length;
        int[] res = new int[n];
        for (int i = 2 * n - 1; i >= 0; i--) {
            int idx = i % n;
            while (!stack.isEmpty() && nums[idx] >= nums[stack.peek()]) {
                stack.pop();
            }
            if (i < n) {
                res[i] = stack.isEmpty() ? -1 : nums[stack.peek()];
            }
            stack.push(idx);
        }
        return res;
    }
}