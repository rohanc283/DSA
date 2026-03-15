class Solution {
    public int minimumOperationsToMakeEqual(int x, int y) {
        Queue<Integer> queue = new ArrayDeque<>();
        Set<Integer> visited = new HashSet<>();
        queue.offer(x);
        visited.add(x);
        int operations = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int curr = queue.poll();
                if (curr == y)
                    return operations;

                int[] nextValues = new int[] {
                        curr - 1 >= 0 ? curr - 1 : -1,
                        curr + 1,
                        curr % 11 == 0 ? curr / 11 : -1,
                        curr % 5 == 0 ? curr / 5 : -1
                };

                for (int next : nextValues) {
                    if (next == -1)
                        continue;
                    if (!visited.contains(next)) {
                        queue.offer(next);
                        visited.add(next);
                    }
                }
            }
            operations++;
        }
        return -1;
    }
}