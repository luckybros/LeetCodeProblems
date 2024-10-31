#include <map>
#include <string>

using namespace std;

class Solution {
public:
    int romanToInt(string s) {
        map<char, int> map;

        map['I'] = 1;
        map['V'] = 5;
        map['X'] = 10;
        map['L'] = 50;
        map['C'] = 100;
        map['D'] = 500;
        map['M'] = 1000;

        int result = 0;

        for(int i = 0; i < s.length(); i++) {
            if(i + 1 < s.length() && map[s[i]] < map[s[i+1]])
                result += (map[s[i+1]] - map[s[i++]]);
            else
                result += map[s[i]];
        }

        return result;
    }
};