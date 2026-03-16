class Solution {
    private List<Integer> topoSort(List<List<Integer>> graph, int[] indegree) {
        int n = graph.size();
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        List<Integer> topo = new ArrayList<>();
        while (!queue.isEmpty()) {
            int u = queue.poll();
            topo.add(u);
            for (int nei : graph.get(u)) {
                indegree[nei]--;
                if (indegree[nei] == 0) {
                    queue.offer(nei);
                }
            }
        }
        return topo;
    }

    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        for (int i = 0; i < n; i++) {
            if (group[i] == -1)
                group[i] = m++;
        }
        List<List<Integer>> itemGraph = new ArrayList<>();
        int[] itemIndegree = new int[n];
        for (int i = 0; i < n; i++) {
            itemGraph.add(new ArrayList<>());
        }

        List<List<Integer>> groupGraph = new ArrayList<>();
        int[] groupIndegree = new int[m];
        for (int i = 0; i < m; i++) {
            groupGraph.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            for (int prev : beforeItems.get(i)) {
                itemGraph.get(prev).add(i);
                itemIndegree[i]++;
                int prevItemGroup = group[prev];
                int currItemGroup = group[i];
                if (currItemGroup != prevItemGroup) {
                    groupGraph.get(prevItemGroup).add(currItemGroup);
                    groupIndegree[currItemGroup]++;
                }
            }
        }
        List<Integer> itemOrder = topoSort(itemGraph, itemIndegree);
        List<Integer> groupOrder = topoSort(groupGraph, groupIndegree);
        if (itemOrder.size() != n || groupOrder.size() != m)
            return new int[0];
        Map<Integer, List<Integer>> groupToItemOrder = new HashMap<>();
        for (int item : itemOrder) {
            int itemGroup = group[item];
            groupToItemOrder.computeIfAbsent(itemGroup, a -> new ArrayList<>()).add(item);
        }
        List<Integer> result = new ArrayList<>();
        for (int gr : groupOrder) {
            result.addAll(groupToItemOrder.getOrDefault(gr, new ArrayList<>()));
        }
        return result.stream().mapToInt(i -> i).toArray();
    }
}