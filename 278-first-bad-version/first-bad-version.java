/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int s = 1, e = n;
        while (s <= e) {
            int mid = s + (e - s) / 2;
            boolean isBad = isBadVersion(mid);
            if (!isBad) {
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }
        return s;
    }
}