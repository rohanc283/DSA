class Solution {
    public int[] countOfPairs(int n, int x, int y) {
        List<Integer>[] graph = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++)
            graph[i] = new ArrayList<>();

        for (int i = 1; i < n; i++) {
            graph[i].add(i + 1);
            graph[i + 1].add(i);
        }

        if (x != y) {
            graph[x].add(y);
            graph[y].add(x);
        }

        int[] result = new int[n];

        for (int start = 1; start <= n; start++) {

            Queue<Integer> q = new ArrayDeque<>();
            boolean[] visited = new boolean[n + 1];

            q.offer(start);
            visited[start] = true;

            int dist = 0;

            while (!q.isEmpty()) {
                int size = q.size();

                for (int i = 0; i < size; i++) {
                    int node = q.poll();
                    if (node != start)
                        result[dist - 1]++;

                    for (int next : graph[node]) {
                        if (!visited[next]) {
                            visited[next] = true;
                            q.offer(next);
                        }
                    }
                }
                dist++;
            }
        }

        return result;
    }
}