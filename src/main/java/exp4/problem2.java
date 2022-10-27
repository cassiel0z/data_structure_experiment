package exp4;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class problem2 {
    public static void main(String[] args) {
        AVLTree<Integer> avlt=new AVLTree<>();
        avlt.insert(1);
        avlt.insert(3);
        avlt.insert(4);
        avlt.insert(10);
        avlt.insert(7);
        avlt.insert(13);
        avlt.insert(6);
        avlt.insert(8);
        avlt.insert(14);
        avlt.printTree();

        preorderTraversal(avlt.getRoot());
        System.out.println();
        System.out.println(inorderTraversal(avlt.getRoot()));
        System.out.println(postorderTraversal(avlt.getRoot()));
        System.out.println(getLeavesNum(avlt.getRoot()));
        System.out.println(getHeight(avlt.getRoot()));
        System.out.println(getNodesNum(avlt.getRoot()));
    }


    public static int getLeavesNum(AVLTree.AVLNode<Integer> root){
        if(root==null) return 0;
        else if(root.left==null && root.right==null)
            return 1;
        else
            return getLeavesNum(root.left)+getLeavesNum(root.right);
    }

    public static int getHeight(AVLTree.AVLNode<Integer> root){
        return root.height;

    }

    public static int getNodesNum(AVLTree.AVLNode<Integer> root){
        return inorderTraversal(root).size();
    }

    public static void preorderTraversal(AVLTree.AVLNode<Integer> root) {
        if(root ==null) return;
        System.out.print(root.element+" ");
        preorderTraversal(root.left);
        preorderTraversal(root.right);
    }

    public static List<Integer> inorderTraversal(AVLTree.AVLNode<Integer> root) {
        AVLTree.AVLNode<Integer> node=root;
        ArrayList<Integer> res = new ArrayList<>();
        Stack<AVLTree.AVLNode<Integer>> stack = new Stack<>();

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

    public static List<Integer> postorderTraversal(AVLTree.AVLNode<Integer> root) {
        AVLTree.AVLNode<Integer> node=root;
        ArrayList<Integer> res = new ArrayList<>();
        Stack<AVLTree.AVLNode<Integer>> stack = new Stack<>();
        AVLTree.AVLNode<Integer> prev = null;
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
