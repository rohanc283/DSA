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
            while (!stack.isEmpty() && nums[i] < nums[stack.peek()])
                stack.pop();
            res[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        return res;
    }

    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int[] next = nextSmaller(arr);
        int[] prev = prevSmaller(arr);
        long res = 0;
        for (int i = 0; i < n; i++) {
            long left = i - prev[i];
            long right = next[i] - i;
            long totalWays = left * right;
            long sum = arr[i] * totalWays;
            res += sum;
        }
        return (int) (res % 1_000_000_007);
    }
}