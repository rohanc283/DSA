class Solution {
    public int[] occurrencesOfElement(int[] nums, int[] queries, int x) {
        List<Integer> xPos = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == x)
                xPos.add(i);
        }
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            if (queries[i] > xPos.size()) {
                res[i] = -1;
            } else {
                res[i] = xPos.get(queries[i] - 1);
            }
        }
        return res;
    }
}