class TopVotedCandidate {

    int[] persons, times, maxVoted;
    int n = 0;

    public TopVotedCandidate(int[] persons, int[] times) {
        n = persons.length;
        this.persons = persons;
        this.times = times;
        maxVoted = new int[n];

        int[] votes = new int[n];
        int maxVote = 0, maxVotedPerson = -1;
        for (int i = 0; i < n; i++) {
            votes[persons[i]]++;
            if (votes[persons[i]] >= maxVote) {
                maxVote = votes[persons[i]];
                maxVotedPerson = persons[i];
            }
            maxVoted[i] = maxVotedPerson;
        }
    }

    public int q(int t) {
        int s = 0, e = n - 1;
        int res = -1;
        while (s <= e) {
            int m = s + (e - s) / 2;
            if (times[m] == t) {
                return maxVoted[m];
            } else if (times[m] > t) {
                e = m - 1;
            } else {
                res = maxVoted[m];
                s = m + 1;
            }
        }
        return res;
    }
}

/**
 * Your TopVotedCandidate object will be instantiated and called as such:
 * TopVotedCandidate obj = new TopVotedCandidate(persons, times);
 * int param_1 = obj.q(t);
 */