class Solution {
    private int dijakstra(int n, List<List<Integer>> graph, int time, int change) {
        int[] min1 = new int[n];
        Arrays.fill(min1, Integer.MAX_VALUE);

        int[] min2 = new int[n];
        Arrays.fill(min2, Integer.MAX_VALUE);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[] { 0, 0 });
        min1[0] = 0;
        while (!pq.isEmpty()) {
            int[] f = pq.poll();
            int node = f[0], timePassed = f[1];
            if (node == n - 1 && min2[node] != Integer.MAX_VALUE)
                return min2[node];
            int div = timePassed / change;
            if (div % 2 == 1) {
                timePassed = change * (div + 1);
            }
            for (int nei : graph.get(node)) {
                if (min1[nei] > timePassed + time) {
                    min2[nei] = min1[nei];
                    min1[nei] = timePassed + time;
                    pq.offer(new int[] { nei, timePassed + time });
                } else if (min2[nei] > timePassed + time && min1[nei] != timePassed + time) {
                    min2[nei] = timePassed + time;
                    pq.offer(new int[] { nei, timePassed + time });
                }
            }
        }
        return -1;
    }

    private int BFS(int n, List<List<Integer>> graph, int time, int change) {
        int[] min1 = new int[n];
        Arrays.fill(min1, Integer.MAX_VALUE);

        int[] min2 = new int[n];
        Arrays.fill(min2, Integer.MAX_VALUE);

        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] { 0, 1 });
        min1[0] = 0;

        while (!queue.isEmpty()) {
            int[] f = queue.poll();
            int node = f[0], freq = f[1];
            int timePassed = (freq == 1) ? min1[node] : min2[node];
            if (node == n - 1 && min2[node] != Integer.MAX_VALUE)
                return min2[node];
            int div = timePassed / change;
            if (div % 2 == 1) {
                timePassed = change * (div + 1);
            }
            for (int nei : graph.get(node)) {
                if (min1[nei] == Integer.MAX_VALUE) {
                    min1[nei] = timePassed + time;
                    queue.offer(new int[] { nei, 1 });
                } else if (min2[nei] == Integer.MAX_VALUE && min1[nei] != timePassed + time) {
                    min2[nei] = timePassed + time;
                    queue.offer(new int[] { nei, 2 });
                }
            }
        }
        return -1;
    }

    public int secondMinimum(int n, int[][] edges, int time, int change) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++)
            graph.add(new ArrayList<>());

        for (int[] e : edges) {
            int u = e[0] - 1, v = e[1] - 1;
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        return BFS(n, graph, time, change);
    }
}