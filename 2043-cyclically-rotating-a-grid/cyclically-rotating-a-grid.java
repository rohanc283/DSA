class Solution {
    public List<Integer> createCycle(int[][] grid, int sr, int er, int sc, int ec) {
        List<Integer> elements = new ArrayList<>();
        for (int i = sr; i < er; i++) {
            elements.add(grid[i][sc]);
        }

        for (int j = sc; j < ec; j++) {
            elements.add(grid[er][j]);
        }

        for (int i = er; i > sr; i--) {
            elements.add(grid[i][ec]);
        }

        for (int j = ec; j > sc; j--) {
            elements.add(grid[sr][j]);
        }
        return elements;
    }

    void reverse(List<Integer> list, int l, int r) {
        while (l <= r) {
            int tmp = list.get(l);
            list.set(l, list.get(r));
            list.set(r, tmp);
            l++;
            r--;
        }
    }

    public void rotateCycleByK(List<Integer> list, int k) {
        k = k % list.size();
        int n = list.size() - 1;
        reverse(list, 0, n - k);
        reverse(list, n - k + 1, list.size() - 1);
        reverse(list, 0, n);
    }

    public void populateBackInGrid(int[][] grid, int sr, int er, int sc, int ec, List<Integer> list) {
        int k = 0;
        for (int i = sr; i < er; i++) {
            grid[i][sc] = list.get(k++);
        }

        for (int j = sc; j < ec; j++) {
            grid[er][j] = list.get(k++);
        }

        for (int i = er; i > sr; i--) {
            grid[i][ec] = list.get(k++);
        }

        for (int j = ec; j > sc; j--) {
            grid[sr][j] = list.get(k++);
        }
    }

    public int[][] rotateGrid(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        List<List<Integer>> cyclicLists = new ArrayList<>();
        int sr = 0, er = m - 1;
        int sc = 0, ec = n - 1;
        while (sr < er && sc < ec) {
            cyclicLists.add(createCycle(grid, sr, er, sc, ec));
            sr++;
            er--;
            sc++;
            ec--;
        }

        for (List<Integer> cyclicList : cyclicLists) {
            for (Integer ele : cyclicList) {
                System.out.print(ele + " ");
            }
            System.out.println();
        }

        for (List<Integer> cyclicList : cyclicLists) {
            rotateCycleByK(cyclicList, k);
        }

        for (List<Integer> cyclicList : cyclicLists) {
            for (Integer ele : cyclicList) {
                System.out.print(ele + " ");
            }
            System.out.println();
        }

        sr = 0;
        er = m - 1;
        sc = 0;
        ec = n - 1;
        int ci = 0;
        while (sr < er && sc < ec) {
            populateBackInGrid(grid, sr, er, sc, ec, cyclicLists.get(ci++));
            sr++;
            er--;
            sc++;
            ec--;
        }
        return grid;
    }
}