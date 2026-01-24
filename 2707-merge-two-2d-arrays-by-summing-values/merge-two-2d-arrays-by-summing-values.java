class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        List<List<Integer>> idValueList = new ArrayList<>();
        int i = 0, j = 0, n1 = nums1.length, n2 = nums2.length;
        while (i < n1 && j < n2) {
            if (nums1[i][0] < nums2[j][0]) {
                idValueList.add(new ArrayList<>(List.of(nums1[i][0], nums1[i][1])));
                i++;
            } else if (nums1[i][0] > nums2[j][0]) {
                idValueList.add(new ArrayList<>(List.of(nums2[j][0], nums2[j][1])));
                j++;
            } else {
                idValueList.add(new ArrayList<>(List.of(nums1[i][0], nums1[i][1] + nums2[j][1])));
                i++;
                j++;
            }
        }
        while (i < n1) {
            idValueList.add(new ArrayList<>(List.of(nums1[i][0], nums1[i][1])));
            i++;
        }
        while (j < n2) {
            idValueList.add(new ArrayList<>(List.of(nums2[j][0], nums2[j][1])));
            j++;
        }
        int[][] ans = new int[idValueList.size()][2];
        for (i = 0; i < idValueList.size(); i++) {
            ans[i][0] = idValueList.get(i).get(0);
            ans[i][1] = idValueList.get(i).get(1);
        }
        return ans;
    }
}