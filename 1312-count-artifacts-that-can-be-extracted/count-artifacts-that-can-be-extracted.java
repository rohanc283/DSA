class Solution {
    public int digArtifacts(int n, int[][] artifacts, int[][] dig) {

        Set<Integer> dug = new HashSet<>();
        for (int[] d : dig) {
            dug.add(d[0] * n + d[1]);
        }

        int count = 0;

        for (int[] a : artifacts) {
            int sr = a[0], sc = a[1], er = a[2], ec = a[3];
            boolean complete = true;

            for (int r = sr; r <= er && complete; r++) {
                for (int c = sc; c <= ec; c++) {
                    if (!dug.contains(r * n + c)) {
                        complete = false;
                        break;
                    }
                }
            }

            if (complete)
                count++;
        }

        return count;
    }
}
