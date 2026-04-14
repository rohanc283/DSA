class Solution {
    public String rankTeams(String[] votes) {
        if (votes.length == 1)
            return votes[0];
        Character[] teams = votes[0].chars().mapToObj(c -> (char) c).toArray(Character[]::new);
        int n = teams.length;
        int[][] rankings = new int[26][n];
        for (String vote : votes) {
            for (int i = 0; i < n; i++) {
                char team = vote.charAt(i);
                rankings[team - 'A'][i]++;
            }
        }
        Arrays.sort(teams, (a, b) -> {
            int i = 0;
            while (i < n && rankings[a - 'A'][i] == rankings[b - 'A'][i])
                i++;
            if (i < n) {
                return rankings[b - 'A'][i] - rankings[a - 'A'][i];
            }
            return Integer.compare(a - 'A', b - 'A');
        });
        return Arrays.stream(teams).map(String::valueOf).collect(Collectors.joining());
    }
}