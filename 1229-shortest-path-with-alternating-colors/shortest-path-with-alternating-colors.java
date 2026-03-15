class Solution {

    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {

        List<int[]>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++)
            graph[i] = new ArrayList<>();

        for (int[] e : redEdges)
            graph[e[0]].add(new int[] { e[1], 0 });

        for (int[] e : blueEdges)
            graph[e[0]].add(new int[] { e[1], 1 });

        int[] res = new int[n];
        Arrays.fill(res, -1);

        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][2];

        queue.offer(new int[] { 0, -1 });
        int dist = 0;
        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                int node = curr[0];
                int prevColor = curr[1];

                if (res[node] == -1)
                    res[node] = dist;

                for (int[] nei : graph[node]) {
                    int nextNode = nei[0];
                    int color = nei[1];

                    if (color != prevColor && !visited[nextNode][color]) {
                        visited[nextNode][color] = true;
                        queue.offer(new int[] { nextNode, color });
                    }
                }
            }

            dist++;
        }

        return res;
    }
}