class Solution {
    public int[][] sol1(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        List<List<Integer>> diagList = new ArrayList<>();
        int r = m - 1, c = 0;
        while (r >= 0 && c < n) {
            List<Integer> diag = new ArrayList<>();
            int i = r, j = c;
            while (i < m && j < n) {
                diag.add(mat[i][j]);
                i++;
                j++;
            }
            if (diag.size() > 0)
                diagList.add(diag);
            if (r - 1 < 0) {
                c++;
            } else {
                r--;
            }
        }
        for (List<Integer> diag : diagList) {
            Collections.sort(diag);
        }

        r = m - 1;
        c = 0;
        int diagIndex = 0;
        while (r >= 0 && c < n) {
            int i = r, j = c, k = 0;
            while (i < m && j < n) {
                mat[i++][j++] = diagList.get(diagIndex).get(k++);
            }
            if (r - 1 < 0) {
                c++;
            } else {
                r--;
            }
            diagIndex++;
        }
        return mat;
    }

    public int[][] sol2(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        Map<Integer, List<Integer>> diagMap = new TreeMap<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                diagMap.computeIfAbsent(i - j, k -> new ArrayList<>())
                        .add(mat[i][j]);
            }
        }

        for (List<Integer> list : diagMap.values()) {
            Collections.sort(list);
        }

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                List<Integer> list = diagMap.get(i - j);
                mat[i][j] = list.remove(list.size() - 1);
            }
        }

        return mat;
    }

    public int[][] sol3(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        Map<Integer, PriorityQueue<Integer>> diagMap = new TreeMap<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                diagMap.computeIfAbsent(i - j, k -> new PriorityQueue<>())
                        .offer(mat[i][j]);
            }
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                mat[i][j] = diagMap.get(i - j).poll();
            }
        }

        return mat;
    }

    public int[][] diagonalSort(int[][] mat) {
        return sol3(mat);
    }
}