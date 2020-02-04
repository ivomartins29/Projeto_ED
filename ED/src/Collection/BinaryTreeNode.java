/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Collection;

/**
 *
 * @author 8180546 && 8180159
 * @param <T>
 */
public class BinaryTreeNode<T> {

    /**
     *
     */
    protected T element;

    /**
     *
     */
    protected BinaryTreeNode<T> left,

    /**
     *
     */
    right;

    /**
     *
     * @param element
     */
    public BinaryTreeNode(T element) {
        this.element = element;
        this.left = null;
        this.right = null;
    }

    /**
     *
     * @return
     */
    public int numChildren() {
        int children = 0;

        if (this.left != null) {
            children = 1 + left.numChildren();
        }

        if (this.right != null) {
            children = children + 1 + this.right.numChildren();
        }

        return children;
    }

    /**
     *
     * @return
     */
    public T getElement() {
        return element;
    }

    /**
     *
     * @param element
     */
    public void setElement(T element) {
        this.element = element;
    }

    /**
     *
     * @return
     */
    public BinaryTreeNode<T> getLeft() {
        return left;
    }

    /**
     *
     * @param left
     */
    public void setLeft(BinaryTreeNode<T> left) {
        this.left = left;
    }

    /**
     *
     * @return
     */
    public BinaryTreeNode<T> getRight() {
        return right;
    }

    /**
     *
     * @param right
     */
    public void setRight(BinaryTreeNode<T> right) {
        this.right = right;
    }

}
