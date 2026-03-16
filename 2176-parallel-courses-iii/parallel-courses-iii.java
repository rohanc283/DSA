class Solution {
    public int minimumTime(int n, int[][] relations, int[] time) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        int[] indegree = new int[n];
        for (int[] e : relations) {
            int u = e[0] - 1, v = e[1] - 1;
            graph.get(u).add(v);
            indegree[v]++;
        }
        Queue<Integer> queue = new ArrayDeque<>();
        int[] finish = new int[n];

        for (int i = 0; i < n; i++) {
            finish[i] = time[i];
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            int u = queue.poll();
            for (int nei : graph.get(u)) {
                finish[nei] = Math.max(finish[nei], finish[u] + time[nei]);
                indegree[nei]--;
                if (indegree[nei] == 0) {
                    queue.offer(nei);
                }
            }
        }
        int res = 0;
        for (int t : finish) {
            res = Math.max(res, t);
        }

        return res;
    }
}