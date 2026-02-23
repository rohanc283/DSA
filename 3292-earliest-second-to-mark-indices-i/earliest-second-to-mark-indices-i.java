class Solution {
    int m, n;

    public boolean allIndexMarked(int seconds, int[] changeIndices, int[] nums) {
        int[] lastPos = new int[n + 1];
        Arrays.fill(lastPos, -1);
        for (int i = 0; i <= seconds; i++) {
            int idx = changeIndices[i];
            lastPos[idx] = i + 1;
        }

        for (int i = 1; i <= n; i++) {
            if (lastPos[i] == -1)
                return false;
        }

        Map<Integer, Integer> posMap = new TreeMap<>();
        for (int i = 1; i <= n; i++) {
            int pos = lastPos[i];
            posMap.put(pos, i);
        }

        int time_passed = 0;
        for (Integer pos : posMap.keySet()) {
            int idx = posMap.get(pos);
            int req_time = nums[idx - 1] + 1;
            if (time_passed + req_time > pos)
                return false;
            time_passed += req_time;
        }
        return true;
    }

    public int earliestSecondToMarkIndices(int[] nums, int[] changeIndices) {
        m = changeIndices.length;
        n = nums.length;
        for (int time = 0; time < m; time++) {
            if (allIndexMarked(time, changeIndices, nums)) {
                return time + 1;
            }
        }
        return -1;
    }
}