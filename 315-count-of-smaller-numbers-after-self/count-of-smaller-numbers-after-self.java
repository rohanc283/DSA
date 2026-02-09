class Solution {
    List<Integer> res = new ArrayList<>();

    public void merge(int[][] nums, int s, int m, int e) {
        int i = s, j = m + 1;
        int[][] temp = new int[e - s + 2][2];
        int smaller = 0;
        int k = 0;
        while (i <= m && j <= e) {
            if (nums[i][0] <= nums[j][0]) {
                temp[k++] = nums[i];
                res.set(nums[i][1], res.get(nums[i][1]) + smaller);
                i++;
            } else {
                temp[k++] = nums[j++];
                smaller++;
            }
        }
        while (j <= e) {
            temp[k++] = nums[j++];
            smaller++;
        }
        while (i <= m) {
            temp[k++] = nums[i];
            res.set(nums[i][1], res.get(nums[i][1]) + smaller);
            i++;
        }
        k = 0;
        for (int z = s; z <= e; z++) {
            nums[z] = temp[k++];
        }
    }

    public void mergeSort(int[][] nums, int s, int e) {
        if (s >= e)
            return;
        int m = s + (e - s) / 2;
        mergeSort(nums, s, m);
        mergeSort(nums, m + 1, e);
        merge(nums, s, m, e);
    }

    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        int[][] numsWithIndex = new int[n][2];
        for (int i = 0; i < n; i++) {
            res.add(0);
            numsWithIndex[i][0] = nums[i];
            numsWithIndex[i][1] = i;
        }
        mergeSort(numsWithIndex, 0, n - 1);
        return res;
    }
}