class Solution:
    def generateParenthesis(self, n):
        result = []
        self.backtracking(result, 0, 0, n, "")
        return result

    def backtracking(self, result, open, closed, n, current):
        if open == n and closed == n:
            result.append(current)
            return

        if open < n:
            self.backtracking(result, open + 1, closed, n, current + "(")

        if closed < open:
            self.backtracking(result, open, closed + 1, n, current + ")")

if __name__ == "__main__":
    solution = Solution()
    n = 3
    combinations = solution.generateParenthesis(n)

    print(f"All combinations of well-formed parentheses for n = {n} are:")
    for combination in combinations:
        print(combination)
