class Solution:
    def subsets(self, nums):
        result = []
        subvector = []
        self.Backtracking(nums, subvector, result, 0)
        return result
        
    def Backtracking(self, nums, subvector, result, count):
        if count == len(nums):
            result.append(subvector[:])
            return
        
        subvector.append(nums[count])
        self.Backtracking(nums, subvector, result, count + 1)

        subvector.pop()
        self.Backtracking(nums, subvector, result, count + 1)

def main():
    solution = Solution()
    nums = [1, 2, 3]
    output = solution.subsets(nums)
    print("Input:", nums)
    print("Output:", output)

if __name__ == "__main__":
    main()
