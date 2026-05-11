class Solution {
    public int maximumSetSize(int[] nums1, int[] nums2) {
        int n = nums1.length;
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        Set<Integer> combined = new HashSet<>();
        for (int num : nums1) {
            set1.add(num);
            combined.add(num);
        }

        for (int num : nums2) {
            set2.add(num);
            combined.add(num);
        }

        int taken1 = Math.min(n / 2, set1.size());
        int taken2 = Math.min(n / 2, set2.size());

        return Math.min(taken1 + taken2, taken2 + (Math.min(n / 2, combined.size() - taken2)));
    }
}