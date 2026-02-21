class RangeFreqQuery {

    public int firstPos(List<Integer> nums, int target) {
        int l = 0, r = nums.size() - 1;
        int res = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums.get(mid) >= target) {
                res = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return res;
    }

    public int lastPos(List<Integer> nums, int target) {
        int l = 0, r = nums.size() - 1;
        int res = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums.get(mid) <= target) {
                res = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return res;
    }

    private int lowerBound(List<Integer> list, int target) {
        int l = 0, r = list.size();
        while (l < r) {
            int mid = (l + r) / 2;
            if (list.get(mid) < target)
                l = mid + 1;
            else
                r = mid;
        }
        return l;
    }

    Map<Integer, List<Integer>> map;

    public RangeFreqQuery(int[] arr) {
        map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            map.computeIfAbsent(num, a -> new ArrayList<>());
            map.get(num).add(i);
        }
    }

    public int query(int left, int right, int value) {
        if (!map.containsKey(value))
            return 0;
        List<Integer> indexes = map.get(value);
        // int f = firstPos(indexes, left), l = lastPos(indexes, right);
        // if (f == -1 || l == -1 || f > l)
        //     return 0;
        // return l - f + 1;
        int leftIdx = lowerBound(indexes, left);
        int rightIdx = lowerBound(indexes, right + 1);
        return rightIdx - leftIdx;
    }
}

/**
 * Your RangeFreqQuery object will be instantiated and called as such:
 * RangeFreqQuery obj = new RangeFreqQuery(arr);
 * int param_1 = obj.query(left,right,value);
 */