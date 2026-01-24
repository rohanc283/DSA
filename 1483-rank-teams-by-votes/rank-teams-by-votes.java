class Solution {
    public String rankTeams(String[] votes) {
        if (votes.length == 1)
            return votes[0];

        int voteLength = votes[0].length();
        int[][] rank = new int[26][voteLength];

        for (String vote : votes) {
            for (int i = 0; i < voteLength; i++) {
                rank[vote.charAt(i) - 'A'][i]++;
            }
        }

        Character[] teams = votes[0].chars()
                .mapToObj(c -> (char) c)
                .toArray(Character[]::new);

        Arrays.sort(teams, (a, b) -> {
            for (int i = 0; i < voteLength; i++) {
                if (rank[a - 'A'][i] != rank[b - 'A'][i]) {
                    return rank[b - 'A'][i] - rank[a - 'A'][i];
                }
            }
            return a - b;
        });

        StringBuilder sb = new StringBuilder();
        for (char c : teams)
            sb.append(c);
        return sb.toString();
    }
}
