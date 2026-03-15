class Solution {
    public int minimumOperations(int[] nums, int start, int goal) {
        Queue<Integer> queue = new ArrayDeque<>();
        Set<Integer> visited = new HashSet<>();

        queue.offer(start);
        visited.add(start);

        int operations = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int curr = queue.poll();

                if (curr == goal)
                    return operations;

                for (int num : nums) {
                    int[] nextVals = {
                            curr + num,
                            curr - num,
                            curr ^ num
                    };

                    for (int next : nextVals) {
                        if (next == goal)
                            return operations + 1;
                        if (next >= 0 && next <= 1000 && !visited.contains(next)) {
                            visited.add(next);
                            queue.offer(next);
                        }
                    }
                }
            }
            operations++;
        }
        return -1;
    }
}