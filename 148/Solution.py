class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def sortList(self, head):
        if head == None or head.next == None:
            return head

        temp = None
        slow = head
        fast = head
        
        while fast != None and fast.next != None:
            temp = slow
            slow = slow.next
            fast = fast.next.next

        temp.next = None    # separa le due parti, poiché temp punta a slow

        leftList = self.sortList(head)
        rightList = self.sortList(slow)

        return self.MergeList(leftList, rightList)

    def MergeList(self, leftList, rightList):
        newHead = ListNode(0)
        curr = newHead

        while leftList != None and rightList != None:
            if leftList.val <= rightList.val:
                curr.next = leftList
                leftList = leftList.next

            else:
                curr.next = rightList
                rightList = rightList.next

            curr = curr.next
        

        while(leftList != None):
            curr.next = leftList
            leftList = leftList.next
            curr = curr.next

        while(rightList != None):
            curr.next = rightList
            rightList = rightList.next
            curr = curr.next
        
        return newHead.next
    
# Funzione per stampare la lista
def printList(node):
    while node:
        print(node.val, end="->")
        node = node.next
    print()

# Esecuzione del programma
if __name__ == "__main__":
    s = Solution()
    
    # Creazione della lista iniziale
    head = ListNode(4)
    head.next = ListNode(2)
    head.next.next = ListNode(1)
    head.next.next.next = ListNode(3)

    # Ordinamento della lista e stampa del risultato
    sorted_list = s.sortList(head)
    print("Lista ordinata:")
    printList(sorted_list)