class Solution:
    def isPalindrome(self, x):
        strInt = str(x)

        for i in range(0, len(strInt)//2):
            if strInt[i] != strInt[len(strInt)-1-i]:
                return False
            
        return True
        