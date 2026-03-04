class Solution {
    public int halveArray(int[] nums) {
        double sum = 0;
        PriorityQueue<Double> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int num : nums) {
            sum += 1.0 * num;
            pq.offer(1.0 * num);
        }
        double target = sum / 2;
        int operations = 0;
        while (sum > target) {
            double top = pq.poll();
            double half = top / 2.0;
            sum -= half;
            pq.offer(half);
            operations++;
        }
        return operations;
    }
}