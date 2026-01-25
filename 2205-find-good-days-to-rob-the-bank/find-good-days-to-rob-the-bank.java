class Solution {
    public List<Integer> goodDaysToRobBank(int[] security, int time) {
        int n = security.length;
        int[] leftDecreasing = new int[n];
        int[] rightIncreasing = new int[n];
        int count = 0;
        for (int i = 1; i < n; i++) {
            if (security[i - 1] >= security[i]) {
                count++;
            } else {
                count = 0;
            }
            leftDecreasing[i] = count;
        }
        count = 0;
        for (int i = n - 2; i >= 0; i--) {
            if (security[i] <= security[i + 1]) {
                count++;
            } else {
                count = 0;
            }
            rightIncreasing[i] = count;
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (leftDecreasing[i] >= time && rightIncreasing[i] >= time)
                ans.add(i);
        }
        return ans;
    }
}