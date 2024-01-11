#include <unordered_set>
#include <string>
#include <iostream>
using namespace std;

class Solution {
public:
    int numTilePossibilities(string tiles) {
        unordered_set<string> solution;
        int index = 0;
        string output = "";
        Backtracking(tiles, output, index, solution);
        return solution.size();
    }

    void Backtracking(string tiles, string output, int index, unordered_set<string> &solution) {
        for(int i = 0; i < tiles.size(); i++){
            output += tiles[i];
            solution.insert(output);
            tiles.erase(tiles.begin()+i);
            Backtracking(tiles, output, index+1, solution);
            tiles.insert(tiles.begin()+i, output.back());
            output.pop_back();
        }
    }
};

int main() {
    Solution s;
    string input = "AAB";
    int result = s.numTilePossibilities(input);
    cout << "Number of tile possibilities for input 'AAB': " << result << endl;

    return 0;
}
