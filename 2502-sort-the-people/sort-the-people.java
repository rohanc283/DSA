class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        int n = names.length;
        Integer[] idx = new Integer[n];

        for (int i = 0; i < n; i++)
            idx[i] = i;

        Arrays.sort(idx, (a, b) -> heights[b] - heights[a]);

        String[] res = new String[n];
        for (int i = 0; i < n; i++) {
            res[i] = names[idx[i]];
        }
        return res;
    }
}