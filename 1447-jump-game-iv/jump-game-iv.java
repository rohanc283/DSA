class Solution {
    public int minJumps(int[] arr) {

        int n = arr.length;

        if (n == 1)
            return 0;

        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(arr[i], v -> new ArrayList<>()).add(i);
        }

        Queue<Integer> q = new ArrayDeque<>();
        boolean[] visited = new boolean[n];

        q.offer(0);
        visited[0] = true;

        int steps = 0;

        while (!q.isEmpty()) {

            int size = q.size();
            for (int i = 0; i < size; i++) {
                int node = q.poll();

                if (node == n - 1)
                    return steps;

                int val = arr[node];

                if (node + 1 < n && !visited[node + 1]) {
                    visited[node + 1] = true;
                    q.offer(node + 1);
                }

                if (node - 1 >= 0 && !visited[node - 1]) {
                    visited[node - 1] = true;
                    q.offer(node - 1);
                }

                if (map.containsKey(val)) {
                    for (int next : map.get(val)) {
                        if (!visited[next]) {
                            visited[next] = true;
                            q.offer(next);
                        }
                    }
                    map.remove(val);
                }
            }

            steps++;
        }

        return -1;
    }
}