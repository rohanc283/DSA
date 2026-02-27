class Solution {
    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        long[] cumSum = new long[n];
        int res = Integer.MAX_VALUE;
        Deque<Integer> dq = new ArrayDeque<>();
        for (int j = 0; j < n; j++) {
            if (j == 0) {
                cumSum[j] = nums[j];
            } else {
                cumSum[j] = cumSum[j - 1] + nums[j];
            }

            if (cumSum[j] >= k) {
                res = Math.min(res, j + 1);
            }
            while (!dq.isEmpty() && cumSum[j] - cumSum[dq.getFirst()] >= k) {
                res = Math.min(res, j - dq.getFirst());
                dq.removeFirst();
            }
            while (!dq.isEmpty() && cumSum[j] <= cumSum[dq.getLast()]) {
                dq.removeLast();
            }
            dq.addLast(j);
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}