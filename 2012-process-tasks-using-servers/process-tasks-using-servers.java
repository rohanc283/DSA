class Solution {
    public int[] assignTasks(int[] servers, int[] tasks) {

        PriorityQueue<int[]> available = new PriorityQueue<>(
                (a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);

        PriorityQueue<int[]> busy = new PriorityQueue<>(
                (a, b) -> Long.compare(a[2], b[2]));

        int n = servers.length;
        int m = tasks.length;

        for (int i = 0; i < n; i++) {
            available.offer(new int[] { i, servers[i], 0 });
        }

        int[] result = new int[m];
        long time = 0;

        for (int i = 0; i < m; i++) {

            time = Math.max(time, i);

            while (!busy.isEmpty() && busy.peek()[2] <= time) {
                available.offer(busy.poll());
            }

            if (available.isEmpty()) {
                time = busy.peek()[2];

                while (!busy.isEmpty() && busy.peek()[2] <= time) {
                    available.offer(busy.poll());
                }
            }

            int[] server = available.poll();
            result[i] = server[0];

            server[2] = (int) time + tasks[i];
            busy.offer(server);
        }

        return result;
    }
}