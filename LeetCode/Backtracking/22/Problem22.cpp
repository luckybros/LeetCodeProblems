#include <iostream>
#include <vector>
using namespace std;

class Solution {
public:
    vector<string> generateParenthesis(int n) {
        // only add left parenthesis if open < n
        // only add right parenthesis if closed < open
        // valid if open == closed == n
        vector<string> result;
        backtracking(result, 0, 0, n, "");
        return result;
    }

    void backtracking(vector<string> &result, int open, int closed, int n, string current) {
        if(open == n && closed == n) {
            result.push_back(current);
            return;
        }
        if(open < n) 
            backtracking(result, open+1, closed, n, current + '(');
        if(closed < open)
            backtracking(result, open, closed+1, n, current + ')');
    }
};

int main() {
    Solution solution;
    int n = 3; 
    vector<string> combinations = solution.generateParenthesis(n);

    cout << "All combinations of well-formed parentheses for n = " << n << " are:\n";
    for (const string& combination : combinations) {
        cout << combination << endl;
    }

    return 0;
}