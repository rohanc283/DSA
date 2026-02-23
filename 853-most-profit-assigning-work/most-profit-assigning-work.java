class Solution {
    class Job {
        public int difficulty;
        public int profit;

        Job(int difficulty, int profit) {
            this.difficulty = difficulty;
            this.profit = profit;
        }
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

    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        Map<Integer, List<Job>> map = new HashMap<>();
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
}