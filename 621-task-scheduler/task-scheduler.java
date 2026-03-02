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
        int len = tasks.length;
        int[] counts = new int[26];
        int maxi = 0, count = 0;
        for (char task : tasks) {
            counts[task - 'A']++;
            if (counts[task - 'A'] > maxi) {
                maxi = counts[task - 'A'];
                count = 1;
            } else if (counts[task - 'A'] == maxi) {
                count++;
            }
        }
        return Math.max(len, (maxi - 1) * (n + 1) + count);
    }

    public int leastInterval(char[] tasks, int n) {
        return sol2(tasks, n);
    }
}