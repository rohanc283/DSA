/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */

class Solution {
    public int peakIndexInMountainArray(MountainArray mountainArr, int n) {
        int l = 0, h = n - 1;
        while (l < h) {
            int m = l + (h - l) / 2;
            if (mountainArr.get(m) < mountainArr.get(m + 1)) {
                l = m + 1;
            } else {
                h = m;
            }
        }
        return l;
    }

    public int leftBinarySearch(int target, MountainArray mountainArr, int l, int h) {
        int res = -1;
        while (l <= h) {
            int m = l + (h - l) / 2;
            int val = mountainArr.get(m);
            if (val >= target) {
                if (val == target)
                    res = m;
                h = m - 1;
            } else {
                l = m + 1;
            }
        }
        return res;
    }

    public int rightBinarySearch(int target, MountainArray mountainArr, int l, int h) {
        int res = -1;
        while (l <= h) {
            int m = l + (h - l) / 2;
            int val = mountainArr.get(m);
            if (val >= target) {
                if (val == target)
                    res = m;
                l = m + 1;
            } else {
                h = m - 1;
            }
        }
        return res;
    }

    public int findInMountainArray(int target, MountainArray mountainArr) {
        int n = mountainArr.length();
        int res = -1;
        int peakIdx = peakIndexInMountainArray(mountainArr, n);
        int l = leftBinarySearch(target, mountainArr, 0, peakIdx);
        if (l >= 0)
            return l;
        int r = rightBinarySearch(target, mountainArr, peakIdx, n - 1);
        if (r >= 0)
            return r;
        return -1;
    }
}