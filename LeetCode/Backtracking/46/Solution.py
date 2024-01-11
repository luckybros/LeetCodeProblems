class Solution:
    def permute(self, nums):
        def backtrack(solution, temp, used, depth):
            if depth == len(nums):
                solution.append(temp[:])
                return

            for i in range(len(nums)):
                if used[i] == 0:
                    temp.append(nums[i])
                    used[i] = 1
                    backtrack(solution, temp, used, depth + 1)
                    temp.pop()
                    used[i] = 0

        solution = []
        temp = []
        used = [0] * len(nums)
        backtrack(solution, temp, used, 0)
        return solution

def print_result(result):
    print("[", end="")
    for vec in result:
        print("[", end="")
        for i in range(len(vec)):
            print(vec[i], end="")
            if i != len(vec) - 1:
                print(",", end="")
        print("]", end="")
        if vec != result[-1]:
            print(",", end="")
    print("]", end="")

def main():
    solution = Solution()
    nums = [1, 2, 3]
    result = solution.permute(nums)

    print("Generated Output: ", end="")
    print_result(result)
    print()

if __name__ == "__main__":
    main()
