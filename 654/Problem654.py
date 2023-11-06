
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def constructMaximumBinaryTree(self, nums):
        return self.construct(nums, 0, len(nums))
    
    def calculateMax(self, nums, l, r):
        maxIndex = l
        for i in range(l, r):
                if nums[i] > nums[maxIndex]:
                    maxIndex = i
        return maxIndex
    
    def construct(self, nums, l, r):
        if l == r:
            return None
        
        maxIndex = self.calculateMax(nums, l, r)

        root = TreeNode(nums[maxIndex])
        root.left = self.construct(nums, l, maxIndex)
        root.right = self.construct(nums, maxIndex+1, r)

        return root
    
    def printTree(self, root):
        if root:
            self.printTree(root.left)
            print(root.val, end=" ")
            self.printTree(root.right)
    
nums = [3, 2, 1, 6, 0, 5]
soluzione = Solution()
result = soluzione.constructMaximumBinaryTree(nums)
soluzione.printTree(result)


        
    