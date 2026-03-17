class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        List<List<double[]>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++)
            graph.add(new ArrayList<>());

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            double w = succProb[i];

            graph.get(u).add(new double[] { v, w });
            graph.get(v).add(new double[] { u, w });
        }

        double[] dist = new double[n];
        dist[start_node] = 1;

        PriorityQueue<double[]> pq = new PriorityQueue<>((a, b) -> Double.compare(b[1], a[1]));

        pq.offer(new double[] { start_node, 1 });

        while (!pq.isEmpty()) {
            double[] cur = pq.poll();
            int u = (int) cur[0];
            double prob = cur[1];

            for (double[] nei : graph.get(u)) {
                int v = (int) nei[0];
                double p = nei[1];

                if (prob * p > dist[v]) {
                    dist[v] = prob * p;
                    pq.offer(new double[] { v, dist[v] });
                }
            }
        }

        return dist[end_node];
    }
}