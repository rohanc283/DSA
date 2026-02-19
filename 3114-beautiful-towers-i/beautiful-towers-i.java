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

    public long[] findPrefix(int[] nums, int[] prev) {
        int n = nums.length;
        long[] prefix = new long[n];
        for (int i = 0; i < n; i++) {
            if (prev[i] == -1) {
                long num = nums[i];
                long mul = i - prev[i];
                prefix[i] = num * mul;
            } else {
                long d = i - prev[i];
                prefix[i] = (nums[i] * d) + prefix[prev[i]];
            }
        }
        return prefix;
    }

    public long[] findSuffix(int[] nums, int[] next) {
        int n = nums.length;
        long[] suffix = new long[n];
        for (int i = n - 1; i >= 0; i--) {
            if (next[i] == n) {
                long num = nums[i];
                long mul = next[i] - i;
                suffix[i] = num * mul;
            } else {
                long d = next[i] - i;
                suffix[i] = (nums[i] * d) + suffix[next[i]];
            }
        }
        return suffix;
    }

    public long maximumSumOfHeights(int[] heights) {
        int[] next = nextSmaller(heights);
        int[] prev = prevSmaller(heights);
        long[] prefix = findPrefix(heights, prev);
        long[] suffix = findSuffix(heights, next);
        long res = 0;
        int n = heights.length;
        if (n == 1)
            return heights[0];
        for (int i = 0; i < n; i++) {
            System.out.println(prefix[i] + " " + suffix[i]);
            res = Math.max(res, prefix[i] + suffix[i] - heights[i]);
        }
        return res;
    }
}