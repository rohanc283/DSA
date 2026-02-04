class Solution {
    public int digArtifacts(int n, int[][] artifacts, int[][] dig) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < dig.length; i++) {
            String key = dig[i][0] + "," + dig[i][1];
            set.add(key);
        }
        int count = 0;
        for (int i = 0; i < artifacts.length; i++) {
            int sr = artifacts[i][0];
            int sc = artifacts[i][1];
            int er = artifacts[i][2];
            int ec = artifacts[i][3];

            int tr = er - sr + 1;
            int tc = ec - sc + 1;

            int total = tr * tc;

            for (int r = sr; r <= er; r++) {
                for (int c = sc; c <= ec; c++) {
                    String key = r + "," + c;
                    if (set.contains(key)) {
                        total--;
                    }
                }
            }

            if (total == 0)
                count++;
        }
        return count;
    }
}