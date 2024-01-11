class TreeNode:
    def __init__(self, val = 0, left = None, right = None):
        self.val = val
        self.left = left
        self.right = right

class Solution: 
    def averageOfSubtree(self, root):
        solution = [0]
        self.calculateSumAndCount(root, solution)
        return solution[0]

    def calculateSumAndCount(self, root, solution):
        if root is None:
            return (0,0)
        
        leftSubtree = self.calculateSumAndCount(root.left, solution)
        rightSubtree = self.calculateSumAndCount(root.right, solution)

        sum = root.val + leftSubtree[0] + rightSubtree[0]
        nodeCount = 1 + leftSubtree[1] + rightSubtree[1]

        if root.val == sum/nodeCount:
            solution[0] += 1

        return (sum, nodeCount)

# Funzione per costruire l'albero specificato
def build_tree():
    # Costruzione dell'albero secondo la specifica [4,8,5,0,1,null,6]
    root = TreeNode(4)
    root.left = TreeNode(8)
    root.right = TreeNode(5)
    root.left.left = TreeNode(0)
    root.left.right = TreeNode(1)
    root.left.right.right = TreeNode(6)

    return root

# Funzione main
def main():
    # Costruzione dell'albero
    root = build_tree()

    # Creazione di un'istanza della classe Solution
    solution = Solution()

    # Calcolo del numero di nodi dove il valore è uguale alla media dei sottoalberi
    result = solution.averageOfSubtree(root)

    # Stampare il risultato
    print("Numero di nodi in cui il valore è uguale alla media dei sottoalberi:", result)

if __name__ == "__main__":
    main()  # Chiamata alla funzione main