class Solution {
public:
    vector<int> relativeSortArray(vector<int>& arr1, vector<int>& arr2) {
        map<int, int> mp;
        for (auto& e : arr1)
            mp[e]++;

        int i = 0;
        for (int j = 0; j < arr2.size(); j++) {
            while (mp.count(arr2[j])) {
                arr1[i++] = arr2[j];
                mp[arr2[j]]--;
                if (mp[arr2[j]] == 0)
                    mp.erase(arr2[j]);
            }
        }
        for (auto& j : mp) {
            while (j.second--) {
                arr1[i++] = j.first;
            }
        }
        return arr1;
    }
};