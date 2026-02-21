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

    public List<Integer> targetIndices(int[] nums, int target) {
        Arrays.sort(nums);
        int s = 0, e = nums.length - 1;
        List<Integer> res = new ArrayList<>();
        int f = firstPos(nums, target), l = lastPos(nums, target);
        if (f == -1 && l == -1)
            return res;
        else if (f != -1 && l == -1) {
            res.add(f);
            return res;
        } else if (f == -1 && l != -1) {
            res.add(l);
            return res;
        }
        for (int i = f; i <= l; i++)
            res.add(i);
        return res;
    }
}