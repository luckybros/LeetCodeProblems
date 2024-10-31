#include <string>

using namespace std;

class Solution {
public:
    bool isSubsequence(string s, string t) {
        int s_l = s.length();
        int t_l = t.length();

        int i = 0;

        for(int j = 0; j < t_l; j++) {
            if(i == s_l) return true;
            if(s[i] == t[j]) i++;
        }
        return i == s_l;
    }
};