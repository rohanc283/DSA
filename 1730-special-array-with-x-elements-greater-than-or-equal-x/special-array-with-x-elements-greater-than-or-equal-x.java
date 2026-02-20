class Solution {
    public int lowerBound(int[] nums, int target) {
        int s = 0, e = nums.length - 1;
        while (s <= e) {
            int m = s + (e - s) / 2;
            if (nums[m] >= target) {
                e = m - 1;
            } else {
                s = m + 1;
            }
        }
        return s;
    }

    public int sol1(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int s = 0, e = n;
        while (s <= e) {
            int mid = s + (e - s) / 2;
            int count = n - lowerBound(nums, mid);
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
        return sol1(nums);
    }
}