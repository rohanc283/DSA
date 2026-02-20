class Solution {
    public int specialArray(int[] nums) {
        Arrays.sort(nums);
        int s = 0, e = nums.length;
        while (s <= e) {
            int mid = s + (e - s) / 2;
            int count = 0;
            for (int num : nums) {
                if (num >= mid)
                    count++;
            }
            if (count == mid) {
                return mid;
            } else if (count > mid) {
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }
        return -1;
    }
}