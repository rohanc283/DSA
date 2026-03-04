class Solution {
    public int mostBooked(int n, int[][] meetings) {

        int[] rooms = new int[n];

        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));

        PriorityQueue<Integer> availableRooms = new PriorityQueue<>();

        PriorityQueue<long[]> usedRooms = new PriorityQueue<>(
                (a, b) -> a[1] == b[1]
                        ? Long.compare(a[0], b[0])
                        : Long.compare(a[1], b[1]));

        for (int i = 0; i < n; i++) {
            availableRooms.offer(i);
        }

        for (int[] meeting : meetings) {

            long start = meeting[0];
            long end = meeting[1];
            long duration = end - start;

            while (!usedRooms.isEmpty() && usedRooms.peek()[1] <= start) {
                availableRooms.offer((int) usedRooms.poll()[0]);
            }

            if (!availableRooms.isEmpty()) {

                int room = availableRooms.poll();
                usedRooms.offer(new long[] { room, end });
                rooms[room]++;

            } else {

                long[] room = usedRooms.poll();
                long newEnd = room[1] + duration;
                usedRooms.offer(new long[] { room[0], newEnd });
                rooms[(int) room[0]]++;
            }
        }

        int res = 0;
        for (int i = 1; i < n; i++) {
            if (rooms[i] > rooms[res]) {
                res = i;
            }
        }

        return res;
    }
}