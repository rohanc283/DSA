class Solution {
    public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> minDq = new ArrayDeque<>();
        Deque<Integer> maxDq = new ArrayDeque<>();

        int n = nums.length;
        int e = 0, s = 0;
        int res = 0;
        while (e < n) {
            while (!minDq.isEmpty() && minDq.peekLast() > nums[e]) {
                minDq.removeLast();
            }
            while (!maxDq.isEmpty() && maxDq.peekLast() < nums[e]) {
                maxDq.removeLast();
            }
            minDq.addLast(nums[e]);
            maxDq.addLast(nums[e]);

            while (maxDq.peekFirst() - minDq.peekFirst() > limit) {
                if (nums[s] == minDq.peekFirst())
                    minDq.removeFirst();
                if (nums[s] == maxDq.peekFirst())
                    maxDq.removeFirst();
                s++;
            }
            res = Math.max(res, e - s + 1);
            e++;
        }
        return res;
    }
}