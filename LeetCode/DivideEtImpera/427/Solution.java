class Solution {
    class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;

        public Node() {
            this.val = false;
            this.isLeaf = false;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = topLeft;
            this.topRight = topRight;
            this.bottomLeft = bottomLeft;
            this.bottomRight = bottomRight;
        }
    }

    public Node construct(int[][] grid) {
        int dim = grid.length;
        return divide(grid, dim, 0, 0);
    }

    public Node divide(int[][] grid, int dim, int i, int j) {
        if (dim == 1) return new Node((grid[i][j] == 1), true);

        int elem = grid[i][j];
        Node root = new Node((elem == 1), true);

        for (int k = i; k < i + dim; k++)
            for (int l = j; l < j + dim; l++)
                if (grid[k][l] != elem) {
                    root.isLeaf = false;
                    root.topLeft = divide(grid, dim/2, i, j);
                    root.topRight = divide(grid, dim/2, i, j+dim/2);
                    root.bottomLeft = divide(grid, dim/2, i+dim/2, j);
                    root.bottomRight = divide(grid, dim/2, i+dim/2, j+dim/2);
                    return root;
                }

        return root;
    }

    public static void main(String[] args) {
        int[][] input = {
            {1, 1, 1, 1, 0, 0, 0, 0},
            {1, 1, 1, 1, 0, 0, 0, 0},
            {1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 0, 0, 0, 0},
            {1, 1, 1, 1, 0, 0, 0, 0},
            {1, 1, 1, 1, 0, 0, 0, 0},
            {1, 1, 1, 1, 0, 0, 0, 0}
        };

        Solution solution = new Solution();
        Node root = solution.construct(input);

        printTree(root, 0);
    }

    public static void printTree(Node node, int indent) {
        if (node != null) {
            for (int i = 0; i < indent; i++) {
                System.out.print("  "); 
            }

            System.out.print("Value: " + node.val + ", IsLeaf: " + node.isLeaf);
            System.out.println();

            printTree(node.topLeft, indent + 1);
            printTree(node.topRight, indent + 1);
            printTree(node.bottomLeft, indent + 1);
            printTree(node.bottomRight, indent + 1);
        }
    }
}
