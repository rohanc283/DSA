class Solution {
    public int[] canSeePersonsCount(int[] heights) {
        int n = heights.length;
        Deque<int[]> stack = new ArrayDeque<>();
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && stack.peek()[0] < heights[i]) {
                res[stack.pop()[1]]++;
            }
            if (!stack.isEmpty()) {
                res[stack.peek()[1]]++;
            }
            stack.push(new int[] { heights[i], i });
        }
        return res;
    }
}