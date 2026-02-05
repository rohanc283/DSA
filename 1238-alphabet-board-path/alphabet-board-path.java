class Solution {
    public String alphabetBoardPath(String target) {
        int[][] pos = new int[26][2];
        for (int i = 0; i < 26; i++) {
            int r = i / 5;
            int c = i % 5;
            pos[i][0] = r;
            pos[i][1] = c;
        }
        StringBuilder res = new StringBuilder();
        int currRow = 0, currCol = 0;
        for (int i = 0; i < target.length(); i++) {
            char c = target.charAt(i);
            int idx = c - 'a';
            int cRow = pos[idx][0];
            int cCol = pos[idx][1];

            int diffR = cRow - currRow;
            int diffC = cCol - currCol;

            System.out.println(currRow + " " + currCol);
            System.out.println(cRow + " " + cCol);
            System.out.println(diffR + " " + diffC);
            System.out.println(" ----------------- ");

            if (cRow == 5) {
                if (diffC > 0) {
                    res.repeat("R", Math.abs(diffC));
                } else {
                    res.repeat("L", Math.abs(diffC));
                }

                if (diffR > 0) {
                    res.repeat("D", Math.abs(diffR));
                } else {
                    res.repeat("U", Math.abs(diffR));
                }
            } else {

                if (diffR > 0) {
                    res.repeat("D", Math.abs(diffR));
                } else {
                    res.repeat("U", Math.abs(diffR));
                }
                if (diffC > 0) {
                    res.repeat("R", Math.abs(diffC));
                } else {
                    res.repeat("L", Math.abs(diffC));
                }
            }
            res.append("!");
            currRow += diffR;
            currCol += diffC;
        }
        return res.toString();
    }
}