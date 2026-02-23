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
        while (l <= h) {
            int m = l + (h - l) / 2;
            if (jobs.get(m).difficulty <= tar) {
                l = m + 1;
            } else {
                h = m - 1;
            }
        }
        return l;
    }

    public int sol3(int[] difficulty, int[] profit, int[] worker) {
        int totalJobs = difficulty.length;
        List<Job> jobs = new ArrayList<>();
        for (int i = 0; i < totalJobs; i++) {
            jobs.add(new Job(difficulty[i], profit[i]));
        }
        Collections.sort(jobs, (a, b) -> a.difficulty - b.difficulty);
        int res = 0;
        Arrays.sort(profit);
        for (int w : worker) {
            int upperBoundIdx = upperBound(jobs, w);
            int maxProfit = 0;
            for (int i = 0; i < upperBoundIdx; i++) {
                maxProfit = Math.max(maxProfit, jobs.get(i).profit);
            }
            res += maxProfit;
        }
        return res;
    }

    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        return sol2(difficulty, profit, worker);
    }
}