package exp4;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class problem1<AnyType> {
    public static void main(String[] args) {
        BinarySearchTree<Integer> bst=new BinarySearchTree<>();
        bst.insert(1);
        bst.insert(3);
        bst.insert(4);
        bst.insert(10);
        bst.insert(7);
        bst.insert(13);
        bst.insert(6);
        bst.insert(8);
        bst.insert(14);
        bst.printTree();

        preorderTraversal(bst.getRoot());
        System.out.println();
        System.out.println(inorderTraversal(bst.getRoot()));
        System.out.println(postorderTraversal(bst.getRoot()));
        System.out.println(getLeavesNum(bst.getRoot()));
        System.out.println(getHeight(bst.getRoot()));
        System.out.println(getNodesNum(bst.getRoot()));
    }

    public static int getLeavesNum(BinarySearchTree.BinaryNode<Integer> root){
        if(root==null) return 0;
        else if(root.left==null && root.right==null)
            return 1;
        else
            return getLeavesNum(root.left)+getLeavesNum(root.right);
    }

    public static int getHeight(BinarySearchTree.BinaryNode<Integer> root){
        if(root==null) return -1;
        return getHeight(root.left)>getHeight(root.right)?+1:getHeight(root.right)+1;

    }

    public static int getNodesNum(BinarySearchTree.BinaryNode<Integer> root){
        return inorderTraversal(root).size();
    }

    public static void preorderTraversal(BinarySearchTree.BinaryNode<Integer> root) {
        if(root ==null) return;
        System.out.print(root.element+" ");
        preorderTraversal(root.left);
        preorderTraversal(root.right);
    }

    public static List<Integer> inorderTraversal(BinarySearchTree.BinaryNode<Integer> root) {
        BinarySearchTree.BinaryNode<Integer> node=root;
        ArrayList<Integer> res = new ArrayList<>();
        Stack<BinarySearchTree.BinaryNode<Integer>> stack = new Stack<>();

        while (node != null || !stack.empty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            res.add(node.element);
            node = node.right;
        }
        return res;
    }

    public static List<Integer> postorderTraversal(BinarySearchTree.BinaryNode<Integer> root) {
        BinarySearchTree.BinaryNode<Integer> node=root;
        ArrayList<Integer> res = new ArrayList<>();
        Stack<BinarySearchTree.BinaryNode<Integer>> stack = new Stack<>();
        BinarySearchTree.BinaryNode<Integer> prev = null;
        while (node != null || !stack.empty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            if (node.right == null || node.right == prev) {
                res.add(node.element);
                prev = node;
                node = null;
            } else {
                stack.push(node);
                node = node.right;
            }

        }
        return res;
    }


}
