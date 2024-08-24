package trees;
import java.util.LinkedList;  
import java.util.Queue;  

// Definition for a binary tree node.  
class TreeNode {  
    int val;  
    TreeNode left;  
    TreeNode right;  

    TreeNode(int x) {  
        val = x;  
    }  
}  

public class BalanceBinaryTree {  

    // Main function to balance the binary tree  
    public TreeNode balanceBST(TreeNode root) {  
        // You would typically use an AVL tree or Red-Black tree for self-balancing.  
        // For demonstration, we'll just rebuild the tree as shown previously.  
        return rebuildFromInOrder(root);  
    }  

    private TreeNode rebuildFromInOrder(TreeNode root) {  
        if (root == null) {  
            return null;  
        }  
        LinkedList<Integer> nodes = new LinkedList<>();  
        inOrderTraversal(root, nodes); // Get sorted nodes via in-order traversal  
        return sortedArrayToBST(nodes, 0, nodes.size() - 1);  
    }  

    private void inOrderTraversal(TreeNode node, LinkedList<Integer> nodes) {  
        if (node != null) {  
            inOrderTraversal(node.left, nodes);  
            nodes.add(node.val);  
            inOrderTraversal(node.right, nodes);  
        }  
    }  

    private TreeNode sortedArrayToBST(LinkedList<Integer> nodes, int start, int end) {  
        if (start > end) {  
            return null;  
        }  

        // Get the middle element and make it the root  
        int mid = (start + end) / 2;  
        TreeNode node = new TreeNode(nodes.get(mid));  

        // Recursively build the left and right subtrees  
        node.left = sortedArrayToBST(nodes, start, mid - 1);  
        node.right = sortedArrayToBST(nodes, mid + 1, end);  

        return node;  
    }  

    // Display the binary tree in level order  
    public void displayTree(TreeNode root) {  
        if (root == null) {  
            System.out.println("Tree is empty.");  
            return;  
        }  
        Queue<TreeNode> queue = new LinkedList<>();  
        queue.add(root);  
        while (!queue.isEmpty()) {  
            TreeNode current = queue.poll();  
            if (current != null) {  
                System.out.print(current.val + " ");  
                queue.add(current.left);  
                queue.add(current.right);  
            } else {  
                System.out.print("null ");  
            }  
        }  
        System.out.println();  
    }  

    // Example usage  
    public static void main(String[] args) {  
        // Create an example unbalanced binary tree  
        TreeNode root = new TreeNode(3);  
        root.left = new TreeNode(2);  
        root.left.left = new TreeNode(1);  
        root.right = new TreeNode(4);  
        root.right.right = new TreeNode(5);  

        BalanceBinaryTree balancer = new BalanceBinaryTree();  

        // Display the tree before balancing  
        System.out.println("Tree before balancing:");  
        balancer.displayTree(root);  

        // Balance the tree  
        TreeNode balancedRoot = balancer.balanceBST(root);  

        // Display the balanced tree  
        System.out.println("Tree after balancing:");  
        balancer.displayTree(balancedRoot);  
    }  
}