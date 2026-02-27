class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> maxDq = new ArrayDeque<>();
        int n = nums.length;
        int[] res = new int[n - k + 1];
        int resIdx = 0;
        for (int i = 0; i < k; i++) {
            while (!maxDq.isEmpty() && nums[i] > nums[maxDq.peekLast()]) {
                maxDq.removeLast();
            }
            maxDq.addLast(i);
        }
        if (maxDq.size() > 0)
            res[resIdx++] = nums[maxDq.peekFirst()];

        for (int i = k; i < n; i++) {
            while (!maxDq.isEmpty() && i - k >= maxDq.peekFirst()) {
                maxDq.removeFirst();
            }
            while (!maxDq.isEmpty() && nums[i] > nums[maxDq.peekLast()]) {
                maxDq.removeLast();
            }
            maxDq.addLast(i);
            if (maxDq.size() > 0)
                res[resIdx++] = nums[maxDq.peekFirst()];
        }

        return res;
    }
}