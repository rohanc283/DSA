class Solution {

    class Task {
        int startTime;
        int processingTime;
        int index;

        Task(int s, int p, int i) {
            startTime = s;
            processingTime = p;
            index = i;
        }
    }

    public int[] getOrder(int[][] tasks) {

        int n = tasks.length;

        Task[] taskList = new Task[n];
        for (int i = 0; i < n; i++) {
            taskList[i] = new Task(tasks[i][0], tasks[i][1], i);
        }

        Arrays.sort(taskList, (a, b) -> a.startTime - b.startTime);

        PriorityQueue<Task> pq = new PriorityQueue<>(
                (a, b) -> a.processingTime == b.processingTime
                        ? a.index - b.index
                        : a.processingTime - b.processingTime);

        int[] res = new int[n];

        long currentTime = 0;
        int taskIdx = 0;
        int resIdx = 0;

        while (taskIdx < n || !pq.isEmpty()) {

            if (pq.isEmpty() && currentTime < taskList[taskIdx].startTime) {
                currentTime = taskList[taskIdx].startTime;
            }

            while (taskIdx < n &&
                    taskList[taskIdx].startTime <= currentTime) {
                pq.offer(taskList[taskIdx++]);
            }

            Task task = pq.poll();
            res[resIdx++] = task.index;
            currentTime += task.processingTime;
        }

        return res;
    }
}