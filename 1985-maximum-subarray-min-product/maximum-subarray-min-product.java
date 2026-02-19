class Solution {
    public int[] nextSmaller(int[] nums) {
        int n = nums.length;
        Deque<Integer> stack = new ArrayDeque<>();
        int[] res = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[i] <= nums[stack.peek()])
                stack.pop();
            res[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }
        return res;
    }

    public int[] prevSmaller(int[] nums) {
        int n = nums.length;
        Deque<Integer> stack = new ArrayDeque<>();
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && nums[i] <= nums[stack.peek()])
                stack.pop();
            res[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        return res;
    }

    public int maxSumMinProduct(int[] nums) {
        int n = nums.length;
        long[] prefix = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = 1L * prefix[i] + nums[i];
        }
        int[] next = nextSmaller(nums);
        int[] prev = prevSmaller(nums);
        long res = 0;
        int MOD = 1_000_000_007;
        for (int i = 0; i < n; i++) {
            long curr = (prefix[next[i]] - prefix[prev[i] + 1]) * nums[i];
            res = Math.max(curr, res);
        }
        return (int) (res % MOD);
    }
}