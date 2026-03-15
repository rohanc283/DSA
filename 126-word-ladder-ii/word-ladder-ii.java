class Solution {

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        List<List<String>> result = new ArrayList<>();

        if (!dict.contains(endWord))
            return result;

        Map<String, List<String>> parentMap = new HashMap<>();

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);

        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        boolean found = false;

        while (!queue.isEmpty() && !found) {

            int size = queue.size();
            Set<String> levelVisited = new HashSet<>();

            for (int i = 0; i < size; i++) {

                String word = queue.poll();
                char[] arr = word.toCharArray();

                for (int j = 0; j < arr.length; j++) {

                    char original = arr[j];

                    for (char c = 'a'; c <= 'z'; c++) {

                        arr[j] = c;
                        String next = new String(arr);

                        if (!dict.contains(next))
                            continue;

                        if (!visited.contains(next)) {

                            if (!levelVisited.contains(next)) {
                                queue.offer(next);
                                levelVisited.add(next);
                            }

                            parentMap
                                    .computeIfAbsent(next, k -> new ArrayList<>())
                                    .add(word);

                            if (next.equals(endWord))
                                found = true;
                        }
                    }

                    arr[j] = original;
                }
            }

            visited.addAll(levelVisited);
        }

        if (found) {
            List<String> path = new ArrayList<>();
            path.add(endWord);
            dfs(endWord, beginWord, parentMap, path, result);
        }

        return result;
    }

    private void dfs(String word, String beginWord,
            Map<String, List<String>> parentMap,
            List<String> path,
            List<List<String>> result) {

        if (word.equals(beginWord)) {
            List<String> temp = new ArrayList<>(path);
            Collections.reverse(temp);
            result.add(temp);
            return;
        }

        if (!parentMap.containsKey(word))
            return;

        for (String parent : parentMap.get(word)) {
            path.add(parent);
            dfs(parent, beginWord, parentMap, path, result);
            path.remove(path.size() - 1);
        }
    }
}