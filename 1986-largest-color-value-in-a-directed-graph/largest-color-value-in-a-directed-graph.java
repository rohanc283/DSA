class Solution {
    public int largestPathValue(String colors, int[][] edges) {
        int n = colors.length();
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        int[] indegree = new int[n];
        for (int[] e : edges) {
            int u = e[0], v = e[1];
            graph.get(u).add(v);
            indegree[v]++;
        }

        Queue<Integer> queue = new ArrayDeque<>();
        int[][] dp = new int[n][26];
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
                dp[i][colors.charAt(i) - 'a'] = 1;
                res = 1;
            }
        }
        int countNodes = 0;
        while (!queue.isEmpty()) {
            int u = queue.poll();
            countNodes++;
            res = Math.max(res, dp[u][colors.charAt(u) - 'a']);
            for (int nei : graph.get(u)) {
                for (int c = 0; c < 26; c++) {
                    dp[nei][c] = Math.max(dp[nei][c], dp[u][c] + (colors.charAt(nei) - 'a' == c ? 1 : 0));
                }
                indegree[nei]--;
                if (indegree[nei] == 0) {
                    queue.offer(nei);
                }
            }
        }
        return countNodes != n ? -1 : res;
    }
}