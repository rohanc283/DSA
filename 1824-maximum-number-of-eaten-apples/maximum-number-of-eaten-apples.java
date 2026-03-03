class Solution {
    public int eatenApples(int[] apples, int[] days) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> a[1] - b[1]);

        int n = apples.length;
        int res = 0;
        int day = 0;

        while (day < n || !pq.isEmpty()) {
            if (day < n && apples[day] > 0) {
                pq.offer(new int[] {
                        apples[day],
                        day + days[day] - 1
                });
            }

            while (!pq.isEmpty() && pq.peek()[1] < day) {
                pq.poll();
            }

            if (!pq.isEmpty()) {
                int[] top = pq.poll();
                res++;
                top[0]--;
                if (top[0] > 0) {
                    pq.offer(top);
                }
            }

            day++;
        }

        return res;
    }
}