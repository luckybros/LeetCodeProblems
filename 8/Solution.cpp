#include <string>

class Solution {
public:
    bool isPalindrome(int x) {
        string strInt = to_string(x);

        for(int i = 0; i < strInt.length()/2; i++)
            if(strInt[i] != strInt[strInt.length()-1-i])
                return false;

        return true;
    }
};