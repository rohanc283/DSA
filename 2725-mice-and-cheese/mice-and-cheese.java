class Solution {
    public int miceAndCheese(int[] reward1, int[] reward2, int k) {
        int n = reward1.length;
        Integer[] diff = new Integer[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            diff[i] = reward1[i] - reward2[i];
            sum += reward2[i];
        }
        Arrays.sort(diff, Collections.reverseOrder());
        for (int i = 0; i < k; i++) {
            sum += diff[i];
        }
        return sum;
    }
}