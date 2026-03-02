class Solution {
    public long findScore(int[] nums) {
        int n = nums.length;
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
                (a, b) -> a[0] != b[0] ? Integer.compare(a[0], b[0]) : Integer.compare(a[1], b[1]));
        for (int i = 0; i < n; i++) {
            maxHeap.offer(new int[] { nums[i], i });
        }
        boolean[] isMarked = new boolean[n];
        long score = 0;
        while (!maxHeap.isEmpty()) {
            int[] top = maxHeap.poll();
            int val = top[0], idx = top[1];
            if (isMarked[idx]) {
                continue;
            }
            score += val;
            isMarked[idx] = true;
            if (idx - 1 >= 0) {
                isMarked[idx - 1] = true;
            }
            if (idx + 1 < n) {
                isMarked[idx + 1] = true;
            }
        }
        return score;
    }
}