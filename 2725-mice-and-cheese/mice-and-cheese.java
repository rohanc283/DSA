class Solution {
    public int miceAndCheese(int[] reward1, int[] reward2, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int sum = 0;
        for (int i = 0; i < reward1.length; i++) {
            pq.offer(reward1[i] - reward2[i]);
            sum += reward2[i];
        }
        for (int i = 0; i < k; i++) {
            sum += pq.poll();
        }
        return sum;
    }
}