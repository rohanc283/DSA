class Solution {
    class Job {
        public int difficulty;
        public int profit;

        Job(int difficulty, int profit) {
            this.difficulty = difficulty;
            this.profit = profit;
        }
    }

    public int sol1(int[] difficulty, int[] profit, int[] worker) {
        int totalJobs = difficulty.length;
        Comparator<Job> comp = (a, b) -> Integer.compare(b.profit, a.profit);
        PriorityQueue<Job> maxHeap = new PriorityQueue<>(comp);
        for (int i = 0; i < totalJobs; i++) {
            maxHeap.add(new Job(difficulty[i], profit[i]));
        }

        Arrays.sort(worker);
        int res = 0;
        for (int i = worker.length - 1; i >= 0; i--) {
            while (!maxHeap.isEmpty() && maxHeap.peek().difficulty > worker[i]) {
                maxHeap.remove();
            }
            int currProfit = maxHeap.isEmpty() ? 0 : maxHeap.peek().profit;
            res += currProfit;
        }
        return res;
    }

    public int sol2(int[] difficulty, int[] profit, int[] worker) {
        int totalJobs = difficulty.length;
        List<Job> jobs = new ArrayList<>();
        for (int i = 0; i < totalJobs; i++) {
            jobs.add(new Job(difficulty[i], profit[i]));
        }
        Collections.sort(jobs, (a, b) -> a.profit - b.profit);
        Arrays.sort(worker);
        int res = 0;
        int jobIdx = totalJobs - 1;
        for (int i = worker.length - 1; i >= 0; i--) {
            while (jobIdx >= 0 && jobs.get(jobIdx).difficulty > worker[i]) {
                jobIdx--;
            }
            int currProfit = jobIdx < 0 ? 0 : jobs.get(jobIdx).profit;
            res += currProfit;
        }
        return res;
    }

    public int upperBound(List<Job> jobs, int tar) {
        int n = jobs.size();
        int l = 0, h = n - 1;
        int res = -1;
        while (l <= h) {
            int m = l + (h - l) / 2;
            if (jobs.get(m).difficulty <= tar) {
                res = m;
                l = m + 1;
            } else {
                h = m - 1;
            }
        }
        return res;
    }

    public int sol3(int[] difficulty, int[] profit, int[] worker) {
        int totalJobs = difficulty.length;
        List<Job> jobs = new ArrayList<>();
        for (int i = 0; i < totalJobs; i++) {
            jobs.add(new Job(difficulty[i], profit[i]));
        }
        Collections.sort(jobs, (a, b) -> a.difficulty - b.difficulty);

        int[] maxProfit = new int[totalJobs];
        maxProfit[0] = jobs.get(0).profit;
        for (int i = 1; i < totalJobs; i++) {
            maxProfit[i] = Math.max(maxProfit[i - 1], jobs.get(i).profit);
        }

        int res = 0;
        for (int w : worker) {
            int lowerBoundIdx = upperBound(jobs, w);
            System.out.println(lowerBoundIdx);
            if (lowerBoundIdx != -1) {
                res += maxProfit[lowerBoundIdx];
            }
        }
        return res;
    }

    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        return sol3(difficulty, profit, worker);
    }
}