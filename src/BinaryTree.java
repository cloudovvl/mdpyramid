import java.util.ArrayList;
import java.util.List;

public class BinaryTree {

    Node root;
    Maximum max = new Maximum();
    Node target_leaf = null;

    public void setRoot(Node node){
        this.root = node;
    }

    public Node getRoot(){
        return this.root;
    }

    private void printMaxSumPath() {
        List<Node> maxSumPath = max.getMaxSumPath();
        int i = 0;
        for(; i < maxSumPath.size()-1 ; i++) System.out.print(maxSumPath.get(i).value + " -> ");
        System.out.println(maxSumPath.get(i).value);
    }

    private boolean isGoodNode(int nodeValue, int childValue) {
        return (isEven(nodeValue) && !isEven(childValue)) || (!isEven(nodeValue) && isEven(childValue));
    }

    private boolean isEven(int number) {
        return number % 2 == 0;
    }



    public void getMaxSumPath(Node node, Maximum max_sum_ref,
                              int curr_sum, List<Node> currentList)
    {
        if (node == null)
            return;

        // Update current sum to hold sum of nodes on
        // path from root to this node
        curr_sum = curr_sum + node.getValue();

        currentList.add(node);

        // If this is a leaf node and path to this node
        // has maximum sum so far, the make this path max

        if (node.left == null && node.right == null && curr_sum > max_sum_ref.getMaxNo()) {
            max_sum_ref.setMaxNo(curr_sum);
            max_sum_ref.setMaxSumPath(currentList);
            return;
        }

        // If this is not a leaf node, then recur down/down right
        if(node.left != null && isGoodNode(node.value, node.left.value)){
            getMaxSumPath(node.left, max_sum_ref, curr_sum, new ArrayList<Node>(currentList));
        }
        if(node.right != null && isGoodNode(node.value, node.right.value)){
            getMaxSumPath(node.right, max_sum_ref, curr_sum, new ArrayList<Node>(currentList));
        }

    }

    // Returns the maximum sum and prints the nodes on
    // max sum path
    public int maxSumPath()
    {
        // base case
        if (root == null)
            return 0;
        // find the target leaf and maximum sum
        getMaxSumPath(root, max, 0, new ArrayList<Node>());

        // print the path from root to the target leaf
        printMaxSumPath();
        System.out.println(max.max_no);
        return max.max_no; // return maximum sum
    }
}
