class Solution {
    public int sol1(int n, int k) {
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i <= n; i++)
            queue.offer(i);
        while (queue.size() > 1) {
            int s = 1;
            while (s < k && !queue.isEmpty()) {
                queue.offer(queue.poll());
                s++;
            }
            queue.poll();
        }
        return queue.peek();
    }

    public int findWinnerIdx(int n, int k) {
        if (n == 1) {
            return 0;
        }

        int idx = findWinnerIdx(n - 1, k);
        idx = (idx + k) % n;
        return idx;
    }

    public int sol2(int n, int k) {
        int winnerIdx = findWinnerIdx(n, k);
        return winnerIdx + 1;
    }

    public int findTheWinner(int n, int k) {
        return sol2(n, k);
    }
}