class Solution {
    public int sol1(char[] tasks, int n) {
        int len = tasks.length;
        int[] counts = new int[26];
        for (char task : tasks) {
            counts[task - 'A']++;
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (char c = 'A'; c <= 'Z'; c++) {
            if (counts[c - 'A'] > 0) {
                maxHeap.offer(counts[c - 'A']);
            }
        }
        int res = 0;
        while (!maxHeap.isEmpty()) {
            List<Integer> currTasks = new ArrayList<>();
            for (int i = 1; i <= n + 1; i++) {
                if (maxHeap.isEmpty())
                    break;
                int task = maxHeap.poll();
                task--;
                currTasks.add(task);
            }
            for (Integer task : currTasks) {
                if (task > 0) {
                    maxHeap.offer(task);
                }
            }
            if (maxHeap.isEmpty()) {
                res += (currTasks.size());
            } else {
                res += (n + 1);
            }
        }
        return res;
    }

    public int sol2(char[] tasks, int n) {
        return 0;
    }

    public int leastInterval(char[] tasks, int n) {
        return sol1(tasks, n);
    }
}