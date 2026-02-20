class Solution {
    public int sol1(int[] nums) {
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

    public int sol2(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n + 1];
        for (int num : nums) {
            if (num >= n) {
                arr[n]++;
            } else {
                arr[num]++;
            }
        }
        int sum = 0;
        for (int i = n; i >= 0; i--) {
            sum += arr[i];
            if (sum == i)
                return i;
        }
        return -1;
    }

    public int specialArray(int[] nums) {
        return sol2(nums);
    }
}