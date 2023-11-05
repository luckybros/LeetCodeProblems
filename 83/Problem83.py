class ListNode:
    def __init__(self, val = 0, next = None):
        self.val = val
        self.next = next

class Solution:
    def deleteDuplicates(self, head):
        headCopy = head
        while headCopy and headCopy.next:
            if headCopy.val == headCopy.next.val:
                headCopy.next = headCopy.next.next
            else:
                headCopy = headCopy.next
        return head

# Creazione di una lista collegata con valori [1, 1, 2]
head = ListNode(1)
head.next = ListNode(1)
head.next.next = ListNode(2)

# Chiamata della funzione deleteDuplicates
solution = Solution()
result = solution.deleteDuplicates(head)

# Stampa del risultato
while result:
    print(result.val, end=" -> ")
    result = result.next
print("None")

