class Solution {
    public boolean canReach(int[] arr, int start) {
        int n = arr.length;
        Queue<Integer> q = new ArrayDeque<>();
        boolean[] visited = new boolean[n];

        q.offer(start);
        visited[start] = true;
        while (!q.isEmpty()) {
            int node = q.poll();
            int nodeVal = arr[node];
            if (nodeVal == 0)
                return true;

            if (node + nodeVal < n && !visited[node + nodeVal]) {
                q.offer(node + nodeVal);
                visited[node + nodeVal] = true;
            }

            if (node - nodeVal >= 0 && !visited[node - nodeVal]) {
                q.offer(node - nodeVal);
                visited[node - nodeVal] = true;
            }
        }
        return false;
    }
}