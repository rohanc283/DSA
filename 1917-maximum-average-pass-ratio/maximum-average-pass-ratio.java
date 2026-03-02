class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {

        int n = classes.length;

        PriorityQueue<double[]> maxHeap = new PriorityQueue<>(
                (a, b) -> Double.compare(b[0], a[0]));

        for (int i = 0; i < n; i++) {
            double curr = (double) classes[i][0] / classes[i][1];
            double next = (double) (classes[i][0] + 1) / (classes[i][1] + 1);
            maxHeap.offer(new double[] { next - curr, i });
        }

        while (extraStudents > 0) {
            double[] top = maxHeap.poll();
            int idx = (int) top[1];

            classes[idx][0]++;
            classes[idx][1]++;

            double curr = (double) classes[idx][0] / classes[idx][1];
            double next = (double) (classes[idx][0] + 1) / (classes[idx][1] + 1);
            maxHeap.offer(new double[] { next - curr, idx });
            extraStudents--;
        }

        double res = 0.0;

        for (int i = 0; i < n; i++) {
            res += (double) classes[i][0] / classes[i][1];
        }
        return res / n;
    }
}