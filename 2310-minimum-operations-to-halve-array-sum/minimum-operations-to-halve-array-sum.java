class Solution {
    public int halveArray(int[] nums) {
        double sum = 0;
        PriorityQueue<Double> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int num : nums) {
            sum += 1.0 * num;
            pq.offer(1.0 * num);
        }
        double target = sum / 2;
        int op = 0;
        while (!pq.isEmpty()) {
            double top = pq.poll();
            sum -= top;
            top /= 2.0;
            sum += top;
            op++;
            if (sum <= target)
                break;
            pq.offer(top);
        }
        return op;
    }
}