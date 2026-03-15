class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
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
        List<Integer> res = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                res.add(i);
                queue.offer(i);
                count++;
            }
        }
        while (!queue.isEmpty()) {
            int u = queue.poll();
            for (int nei : graph.get(u)) {
                indegree[nei]--;
                if (indegree[nei] == 0) {
                    res.add(nei);
                    queue.offer(nei);
                    count++;
                }
            }
        }
        if (count != numCourses)
            return new int[] {};
        return res.stream().mapToInt(i -> i).toArray();
    }
}