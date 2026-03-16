class Solution {
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int n = quiet.length;
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++)
            graph.add(new ArrayList<>());

        int[] indegree = new int[n];

        for (int[] r : richer) {
            int u = r[0], v = r[1];
            graph.get(u).add(v);
            indegree[v]++;
        }

        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++)
            if (indegree[i] == 0)
                queue.offer(i);

        int[] ans = new int[n];
        for (int i = 0; i < n; i++)
            ans[i] = i;

        while (!queue.isEmpty()) {
            int u = queue.poll();

            for (int v : graph.get(u)) {
                if (quiet[ans[u]] < quiet[ans[v]]) {
                    ans[v] = ans[u];
                }
                indegree[v]--;
                if (indegree[v] == 0)
                    queue.offer(v);
            }
        }

        return ans;
    }
}