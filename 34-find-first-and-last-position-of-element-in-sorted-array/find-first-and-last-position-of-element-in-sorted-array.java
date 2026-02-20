class Solution {
    public int firstPos(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        int res = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                res = mid;
                r = mid - 1;
            } else if (nums[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return res;
    }

    public int lastPos(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        int res = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                res = mid;
                l = mid + 1;
            } else if (nums[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return res;
    }

    public int[] searchRange(int[] nums, int target) {
        int f = firstPos(nums, target), l = lastPos(nums, target);
        return new int[] { f, l };
    }
}