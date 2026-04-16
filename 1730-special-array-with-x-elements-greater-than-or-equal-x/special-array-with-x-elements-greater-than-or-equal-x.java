class Solution {
    public int specialArray(int[] nums) {
        int n = nums.length;
        int[] freq = new int[n + 1];
        for (int num : nums) {
            if (num >= n)
                freq[n]++;
            else {
                freq[num]++;
            }
        }
        int suffix = 0;
        for (int i = n; i >= 0; i--) {
            suffix += freq[i];
            if (suffix == i)
                return i;
        }
        return -1;
    }
}