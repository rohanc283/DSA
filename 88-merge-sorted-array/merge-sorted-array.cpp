class Solution {
public:
    void merge(vector<int>& nums1, int m, vector<int>& nums2, int n) {
        int s1 = m - 1, s2 = n - 1;
        int l = m + n - 1;
        while (s1 >= 0 || s2 >= 0) {
            if (s1 >= 0 && s2 < 0) {
                nums1[l--] = nums1[s1--];
            } else if (s1 < 0 && s2 >= 0) {
                nums1[l--] = nums2[s2--];
            } else if (nums1[s1] > nums2[s2]) {
                nums1[l--] = nums1[s1--];
            } else {
                nums1[l--] = nums2[s2--];
            }
        }
    }
};