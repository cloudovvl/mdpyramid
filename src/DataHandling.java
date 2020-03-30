import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class DataHandling {

    String sourceFilePath = "/Users/pop/dev/binary_tree/src/test.txt";

    public BinaryTree loadBinaryTree() {
        Node[][] nodes = new Node[0][];
        try {
            nodes = Files.readAllLines(Paths.get(sourceFilePath)).stream()
                    .map(line -> Arrays.stream(line.split(" ")).map(Node::new).toArray(Node[]::new))
                    .toArray(Node[][]::new);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //System.out.println(nodes[3][1].getValue());
        BinaryTree tree = new BinaryTree();
        tree.setRoot(insertLevelOrder(nodes, tree.getRoot(), 0, 0));
        tree.maxSumPath();

        //BinaryTreePrinter.printNode(tree.getRoot());
        return tree;

    }

    public Node insertLevelOrder(Node[][] matrix, Node root, int i, int j)
    {
        if (i < matrix.length) {
            root = matrix[i][j];
            // insert left child
            root.setLeft(insertLevelOrder(matrix, root.getLeft(), i+1, j));
            // insert right child
            root.setRight(insertLevelOrder(matrix, root.getRight(), i+1, j+1));
        }
        return root;
    }

    public static void main(String args[]) {
        DataHandling dh = new DataHandling();
        dh.loadBinaryTree();
    }
}

