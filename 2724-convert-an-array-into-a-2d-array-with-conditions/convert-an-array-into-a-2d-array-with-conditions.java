class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        int[] freq = new int[201];
        for (int num : nums)
            freq[num]++;

        List<List<Integer>> res = new ArrayList<>();
        int total = nums.length;
        while (total > 0) {
            List<Integer> curr = new ArrayList<>();
            for (int i = 0; i < 201; i++) {
                if (freq[i] > 0) {
                    curr.add(i);
                    freq[i]--;
                    total--;
                }
            }
            res.add(curr);
        }
        return res;
    }
}