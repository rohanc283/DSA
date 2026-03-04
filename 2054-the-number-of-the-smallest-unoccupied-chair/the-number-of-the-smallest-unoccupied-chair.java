class Solution {
    public int smallestChair(int[][] times, int targetFriend) {

        int n = times.length;
        int[][] arr = new int[n][3];

        for (int i = 0; i < n; i++) {
            arr[i][0] = times[i][0];
            arr[i][1] = times[i][1];
            arr[i][2] = i;
        }

        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));

        PriorityQueue<Integer> available = new PriorityQueue<>();
        PriorityQueue<int[]> occupied = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        int nextChair = 0;

        for (int i = 0; i < n; i++) {

            int arrival = arr[i][0];
            int leave = arr[i][1];

            while (!occupied.isEmpty() && occupied.peek()[0] <= arrival) {
                available.offer(occupied.poll()[1]);
            }

            int assignedChair;

            if (available.isEmpty()) {
                assignedChair = nextChair++;
            } else {
                assignedChair = available.poll();
            }

            occupied.offer(new int[] { leave, assignedChair });

            if (arr[i][2] == targetFriend) {
                return assignedChair;
            }
        }

        return -1;
    }
}