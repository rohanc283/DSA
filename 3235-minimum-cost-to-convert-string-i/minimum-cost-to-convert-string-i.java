class Solution {
    private void flyodWarshall(long[][] graph) {
        for (int via = 0; via < 26; via++) {
            for (int i = 0; i < 26; i++) {
                for (int j = 0; j < 26; j++) {
                    if (graph[i][via] == Long.MAX_VALUE || graph[via][j] == Long.MAX_VALUE)
                        continue;
                    graph[i][j] = Math.min(graph[i][j], graph[i][via] + graph[via][j]);
                }
            }
        }
    }

    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        long[][] graph = new long[26][26];
        for (int i = 0; i < 26; i++) {
            Arrays.fill(graph[i], Long.MAX_VALUE);
            graph[i][i] = 0;
        }
        for (int i = 0; i < original.length; i++) {
            int s = original[i] - 'a', t = changed[i] - 'a';
            graph[s][t] = Math.min(graph[s][t], cost[i]);
        }
        flyodWarshall(graph);
        long res = 0;
        for (int i = 0; i < source.length(); i++) {
            char a = source.charAt(i), b = target.charAt(i);
            if (a == b)
                continue;
            if (graph[a - 'a'][b - 'a'] == Long.MAX_VALUE)
                return -1;
            res += graph[a - 'a'][b - 'a'];
        }
        return res;
    }
}