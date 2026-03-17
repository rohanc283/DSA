class Solution {
    public List<Boolean> sol1(int numCourses, int[][] prerequisites, int[][] queries) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        int[] indegree = new int[numCourses];

        for (int[] pre : prerequisites) {
            int u = pre[0], v = pre[1];
            graph.get(u).add(v);
            indegree[v]++;
        }

        Queue<Integer> queue = new ArrayDeque<>();
        Map<Integer, Set<Integer>> map = new HashMap<>();

        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
            map.put(i, new HashSet<>());
        }

        while (!queue.isEmpty()) {
            int curr = queue.poll();

            for (int nei : graph.get(curr)) {

                map.get(nei).add(curr);

                map.get(nei).addAll(map.get(curr));

                indegree[nei]--;

                if (indegree[nei] == 0) {
                    queue.offer(nei);
                }
            }
        }

        List<Boolean> res = new ArrayList<>();
        for (int[] q : queries) {
            int u = q[0], v = q[1];
            res.add(map.get(v).contains(u));
        }

        return res;
    }

    public List<Boolean> sol2(int numCourses, int[][] prerequisites, int[][] queries) {

        boolean[][] reach = new boolean[numCourses][numCourses];

        for (int[] pre : prerequisites) {
            reach[pre[0]][pre[1]] = true;
        }

        for (int k = 0; k < numCourses; k++) {
            for (int i = 0; i < numCourses; i++) {
                for (int j = 0; j < numCourses; j++) {
                    if (reach[i][k] && reach[k][j]) {
                        reach[i][j] = true;
                    }
                }
            }
        }

        List<Boolean> res = new ArrayList<>();
        for (int[] q : queries) {
            res.add(reach[q[0]][q[1]]);
        }

        return res;
    }

    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        return sol2(numCourses, prerequisites, queries);
    }
}