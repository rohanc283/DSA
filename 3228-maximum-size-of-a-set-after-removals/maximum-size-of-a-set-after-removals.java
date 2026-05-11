class Solution {
    public int maximumSetSize(int[] nums1, int[] nums2) {
        int n = nums1.length;
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int num : nums1) {
            set1.add(num);
        }

        for (int num : nums2) {
            set2.add(num);
        }
        Set<Integer> common = new HashSet<>(set1);
        common.retainAll(set2);

        int taken1 = Math.min(n / 2, set1.size());
        int taken2 = Math.min(n / 2, set2.size());
        int c = set1.size() + set2.size() - common.size();
        int removable = Math.max(0, taken1 + taken2 - c);
        return taken1 + taken2 - removable;
    }
}