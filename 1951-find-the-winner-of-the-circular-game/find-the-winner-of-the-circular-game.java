class Solution {
    public int findTheWinner(int n, int k) {
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
}