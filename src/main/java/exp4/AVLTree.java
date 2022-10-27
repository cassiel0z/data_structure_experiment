package exp4;

import java.nio.BufferUnderflowException;


public class AVLTree<AnyType extends Comparable<? super AnyType>> {
    static class AVLNode<AnyType> {
        //Constructors

        AVLNode(AnyType theElement) {
            this(theElement, null, null);
        }

        AVLNode(AnyType theElement, AVLNode<AnyType> lt, AVLNode<AnyType> rt) {
            element = theElement;
            left = lt;
            right = rt;
        }

        AnyType element;
        AVLNode<AnyType> left;
        AVLNode<AnyType> right;
        int height;
    }

    private AVLNode<AnyType> root;

    private static final int ALLOWED_IMBALANCE=1;

    public AVLNode<AnyType> getRoot(){
        return root;
    }

    public AVLTree() {
        root = null;
    }



    public void makeEmpty() {
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public boolean contains(AnyType x) {
        return contains(x, root);
    }

    public AnyType findMin() {
        if (isEmpty()) throw new BufferUnderflowException();
        return findMin(root).element;
    }

    public AnyType findMax() {
        if (isEmpty()) throw new BufferUnderflowException();
        return findMax(root).element;
    }

    public void insert(AnyType x) {
        root = insert(x, root);
    }


    public int height(AVLNode<AnyType> t){
        return t==null?-1:t.height;
    }

    public void remove(AnyType x) {
        root = remove(x, root);
    }

    public void printTree() {
        if (isEmpty())
            System.out.println("Empty tree");
        else
            printTree(root);
    }

    private AVLNode<AnyType> balance(AVLNode<AnyType> t){
        if(t==null) return t;
        if(height(t.left)-height(t.right)>ALLOWED_IMBALANCE)
            if(height(t.left.left)>=height(t.left.right))
                t=rotateWithLeftChild(t);
            else
                t=doubleWithLeftChild(t);
        else
            if(height(t.right)-height(t.left)>ALLOWED_IMBALANCE)
                if(height(t.right.right)>=height(t.right.left))
                    t=rotateWithRightChild(t);
                else
                    t=doubleWithRightChild(t);
        t.height=Math.max(height(t.left),height(t.right))+1;
        return t;
    }

    private boolean contains(AnyType x, AVLNode<AnyType> t) {
        if (t == null)
            return false;

        int compareResult = x.compareTo(t.element);

        if (compareResult < 0)
            return contains(x, t.left);
        else if (compareResult > 0)
            return contains(x, t.right);
        else
            return true;
    }

    private AVLNode<AnyType> findMin(AVLNode<AnyType> t) {
        if (t == null)
            return null;
        else if (t.left == null)
            return t;
        return findMin(t.left);
    }

    private AVLNode<AnyType> findMax(AVLNode<AnyType> t) {
        if (t == null)
            return null;
        else if (t.right == null)
            return t;
        return findMin(t.right);
    }

    private AVLNode<AnyType> insert(AnyType x, AVLNode<AnyType> t) {
        if (t == null){
            return new AVLNode<>(x, null, null);
        }
        int compareResult = x.compareTo(t.element);

        if (compareResult < 0)
            t.left = insert(x, t.left);
        else if (compareResult > 0)
            t.right = insert(x, t.right);

        return balance(t);
    }

    private AVLNode<AnyType> remove(AnyType x, AVLNode<AnyType> t) {
        if (t == null)
            return null;

        int compareResult = x.compareTo(t.element);

        if (compareResult < 0)
            t.left = remove(x, t.left);
        else if (compareResult > 0)
            t.right = remove(x, t.right);
        else if (t.left != null && t.right != null) {
            t.element = findMin(t.right).element;
            t.right = remove(t.element, t.right);
        } else
            t = (t.left != null) ? t.left : t.right;
        return balance(t);
    }

    private void printTree(AVLNode<AnyType> t) {
        if (t != null) {

            printTree(t.left);
            System.out.println(t.element);
            printTree(t.right);

        }
    }

    private AVLNode<AnyType> rotateWithLeftChild(AVLNode<AnyType> k2)
    {
        AVLNode<AnyType> k1=k2.left;
        k2.left=k1.right;
        k1.right=k2;
        k2.height=Math.max(height(k2.left),height(k2.right))+1;
        k1.height=Math.max(height(k1.left),k2.height)+1;
        return k1;
    }

    private AVLNode<AnyType> doubleWithLeftChild(AVLNode<AnyType> k3)
    {
        k3.left=rotateWithRightChild(k3.left);
        return rotateWithLeftChild(k3);
    }

    private AVLNode<AnyType> rotateWithRightChild(AVLNode<AnyType> k2)
    {
        AVLNode<AnyType> k1=k2.right;
        k2.right=k1.left;
        k1.left=k2;
        k2.height=Math.max(height(k2.left),height(k2.right))+1;
        k1.height=Math.max(height(k1.right),k2.height)+1;
        return k1;
    }

    private AVLNode<AnyType> doubleWithRightChild(AVLNode<AnyType> k3)
    {
        k3.right=rotateWithLeftChild(k3.right);
        return rotateWithRightChild(k3);
    }
}
