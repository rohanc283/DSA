class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(0);
        visited[0] = true;
        int visitedRooms = 1;
        while (!queue.isEmpty()) {
            int f = queue.poll();
            List<Integer> neighbours = rooms.get(f);
            for (Integer neighbour : neighbours) {
                if (!visited[neighbour]) {
                    queue.offer(neighbour);
                    visited[neighbour] = true;
                    visitedRooms++;
                }
            }
        }
        return visitedRooms == n;
    }
}