class Solution {
    public int maximumSetSize(int[] nums1, int[] nums2) {
        Set<Integer> s1 = new HashSet<>();
        Set<Integer> s2 = new HashSet<>();
        for (int x : nums1)
            s1.add(x);
        for (int x : nums2)
            s2.add(x);

        int n = nums1.length / 2;
        Set<Integer> common = new HashSet<>(s1);
        common.retainAll(s2);
        int take1 = Math.min(n, s1.size());
        int take2 = Math.min(n, s2.size());
        int c = s1.size() + s2.size() - common.size();
        int removable = Math.max(0, take1 + take2 - c);
        return take1 + take2 - removable;
    }
}