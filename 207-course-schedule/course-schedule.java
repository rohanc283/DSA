class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] indegree = new int[numCourses];
        for (int i = 0; i < numCourses; i++)
            graph.add(new ArrayList<>());

        for (int[] e : prerequisites) {
            int u = e[0], v = e[1];
            graph.get(v).add(u);
            indegree[u]++;
        }

        Queue<Integer> queue = new ArrayDeque<>();
        int count = 0;
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
                count++;
            }
        }
        while (!queue.isEmpty()) {
            int u = queue.poll();
            for (int nei : graph.get(u)) {
                indegree[nei]--;
                if (indegree[nei] == 0) {
                    queue.offer(nei);
                    count++;
                }
            }
        }
        return count == numCourses;
    }
}