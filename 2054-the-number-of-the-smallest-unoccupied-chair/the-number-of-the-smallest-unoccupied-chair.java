class Solution {
    public int smallestChair(int[][] times, int targetFriend) {
        int n = times.length;
        int[][] timesWithPos = new int[n][3];
        for (int i = 0; i < n; i++) {
            timesWithPos[i][0] = times[i][0];
            timesWithPos[i][1] = times[i][1];
            timesWithPos[i][2] = i;
        }
        Arrays.sort(timesWithPos, (a, b) -> Integer.compare(a[0], b[0]));
        int timer = 0;
        int chair = 0;
        PriorityQueue<Integer> availableChairs = new PriorityQueue<>();
        PriorityQueue<int[]> takenChairs = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int i = 0; i < n; i++) {
            timer = Math.max(timer, timesWithPos[i][0]);
            availableChairs.offer(chair++);
            while (!takenChairs.isEmpty() && takenChairs.peek()[0] <= timer) {
                availableChairs.offer(takenChairs.poll()[1]);
            }
            int takenChair = availableChairs.poll();
            takenChairs.offer(new int[] { timesWithPos[i][1], takenChair });
            if (timesWithPos[i][2] == targetFriend) {
                return takenChair;
            }
        }
        return 0;
    }
}