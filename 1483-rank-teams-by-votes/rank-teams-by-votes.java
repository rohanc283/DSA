class Solution {
    public String rankTeams(String[] votes) {
        if (votes.length == 1)
            return votes[0];

        int voteLength = votes[0].length();
        int[][] rank = new int[27][voteLength];

        for (int i = 0; i < voteLength; i++) {
            for (int j = 0; j < votes.length; j++) {
                int idx = votes[j].charAt(i) - 'A';
                rank[idx][i]++;
            }
        }

        Character[] chars = votes[0].chars().mapToObj(c -> (char) c).toArray(Character[]::new);
        Arrays.sort(chars, (a, b) -> {
            int i = 0;
            while (i < voteLength && rank[a - 'A'][i] == rank[b - 'A'][i])
                i++;
            if (i >= voteLength)
                return a - b;
            if (rank[a - 'A'][i] > rank[b - 'A'][i])
                return -1;
            else
                return 1;
        });

        StringBuilder sb = new StringBuilder();
        for (Character c : chars) {
            sb.append(c);
        }
        return sb.toString();
    }
}