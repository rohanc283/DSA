class Solution {
    public int countSubArr(int[] arr, int n) {
        int cons = 0, res = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0)
                cons = 0;
            else
                cons++;
            res += cons;
        }
        return res;
    }

    public int sol1(int[][] mat) {
        int res = 0;
        int m = mat.length, n = mat[0].length;
        for (int i = 0; i < m; i++) {
            int[] arr = new int[n];
            Arrays.fill(arr, 1);
            for (int j = i; j < m; j++) {
                for (int k = 0; k < n; k++) {
                    arr[k] &= mat[j][k];
                }
                res += countSubArr(arr, n);
            }
        }
        return res;
    }

    public int numSubmat(int[][] mat) {
        return sol1(mat);
    }
}