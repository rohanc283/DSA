class Solution {
    public String alphabetBoardPath(String target) {
        StringBuilder res = new StringBuilder();
        int currRow = 0, currCol = 0;

        for (char ch : target.toCharArray()) {
            int idx = ch - 'a';
            int targetRow = idx / 5;
            int targetCol = idx % 5;

            while (currCol > targetCol) {
                res.append('L');
                currCol--;
            }
            while (currRow > targetRow) {
                res.append('U');
                currRow--;
            }
            while (currRow < targetRow) {
                res.append('D');
                currRow++;
            }
            while (currCol < targetCol) {
                res.append('R');
                currCol++;
            }

            res.append('!');
        }

        return res.toString();
    }
}