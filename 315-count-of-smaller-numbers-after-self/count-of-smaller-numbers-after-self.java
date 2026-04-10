class Solution {
    private void merge(int arr[][], int l, int m, int r, int[] res) {
        int i = l, n1 = m, j = m + 1, n2 = r;
        int[][] temp = new int[r - l + 1][2];
        int k = 0;
        int smaller = 0;
        while (i <= n1 && j <= n2) {
            if (arr[i][0] <= arr[j][0]) {
                res[arr[i][1]] += smaller;
                temp[k++] = arr[i++];
            } else {
                smaller++;
                temp[k++] = arr[j++];
            }
        }
        while (i <= n1) {
            res[arr[i][1]] += smaller;
            temp[k++] = arr[i++];
        }
        while (j <= n2) {
            temp[k++] = arr[j++];
        }
        k = 0;
        for (int s = l; s <= r; s++) {
            arr[s] = temp[k++];
        }
    }

    private void mergeSort(int arr[][], int l, int r, int[] res) {
        if (l >= r)
            return;
        int m = l + (r - l) / 2;
        mergeSort(arr, l, m, res);
        mergeSort(arr, m + 1, r, res);
        merge(arr, l, m, r, res);
    }

    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        int[][] numsWithIndex = new int[n][2];
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            numsWithIndex[i][0] = nums[i];
            numsWithIndex[i][1] = i;
        }
        mergeSort(numsWithIndex, 0, n - 1, res);
        return Arrays.stream(res).boxed().collect(Collectors.toList());
    }
}