class Solution {
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        int[][] board = new int[8][8];
        board[king[0]][king[1]] = 1;
        for (int i = 0; i < queens.length; i++) {
            board[queens[i][0]][queens[i][1]] = 2;
        }
        List<List<Integer>> res = new ArrayList<>();
        int[] dir = { -1, 0, 1 };
        for (int i : dir) {
            for (int j : dir) {
                if (i == 0 && j == 0)
                    continue;
                int r = king[0] + i;
                int c = king[1] + j;
                while (r >= 0 && r < 8 && c >= 0 && c < 8) {
                    if (board[r][c] == 2) {
                        res.add(new ArrayList<>(List.of(r, c)));
                        break;
                    }
                    r += i;
                    c += j;
                }
            }
        }
        return res;
    }
}