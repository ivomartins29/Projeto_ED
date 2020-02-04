/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Collection;

import Exception.EmptyCollectionException;
import Interface.BinaryTreeADT;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 8180546 && 8180159
 * @param <T>
 */
public class BinaryTree<T> implements BinaryTreeADT<T> {

    /**
     *
     */
    protected int count;

    /**
     *
     */
    protected BinaryTreeNode<T> root;

    /**
     *
     */
    public BinaryTree() {
        this.count = 0;
        root = null;
    }

    /**
     *
     * @param element
     */
    public BinaryTree(T element) {
        this.count = 1;
        root = new BinaryTreeNode<>(element);
    }

    @Override
    public T getRoot() {
        if (isEmpty()) {
            return null;
        } else {
            return this.root.getElement();
        }

    }

    @Override
    public boolean isEmpty() {
        return this.count == 0;
    }

    @Override
    public int size() {
        return this.count;
    }

    @Override
    public boolean contains(T t) {
        boolean contains;

        try {
            this.find(t);
            contains = true;
        } catch (Exception ex) {
            contains = false;
        }

        return contains;
    }

    @Override
    public T find(T t) {
        BinaryTreeNode<T> current = findAgain(t, this.root);

        if (current == null) {
            try {
                throw new Exception("BinaryTree vazia");
            } catch (Exception ex) {
                Logger.getLogger(BinaryTree.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return (current.element);
    }

    private BinaryTreeNode<T> findAgain(T target, BinaryTreeNode<T> next) {
        if (next == null) {
            return null;
        }

        if (next.element.equals(target)) {
            return next;
        }

        BinaryTreeNode<T> temp = findAgain(target, next.left);

        if (temp == null) {
            temp = findAgain(target, next.right);
        }

        return temp;
    }

    @Override
    public Iterator<T> iteratorInOrder() {
        ArrayUnorderedList<T> templist = new ArrayUnorderedList<>();
        inorder(this.root, templist);
        return templist.iterator();
    }

    /**
     *
     * @param node
     * @param tempList
     */
    protected void inorder(BinaryTreeNode<T> node, ArrayUnorderedList<T> tempList) {

        if (node != null) {
            inorder(node.left, tempList);
            tempList.addToRear(node.element);
            inorder(node.right, tempList);
        }

    }

    @Override
    public Iterator<T> iteratorPreOrder() {
        ArrayUnorderedList<T> templist = new ArrayUnorderedList<>();
        preOrder(this.root, templist);
        return templist.iterator();
    }

    /**
     *
     * @param node
     * @param tempList
     */
    protected void preOrder(BinaryTreeNode<T> node, ArrayUnorderedList<T> tempList) {
        if (node != null) {
            tempList.addToRear(node.element);
            preOrder(node.left, tempList);
            preOrder(node.right, tempList);
        }

    }

    @Override
    public Iterator<T> iteratorPostOrder() {
        ArrayUnorderedList<T> templist = new ArrayUnorderedList<>();
        postOrder(this.root, templist);
        return templist.iterator();

    }

    /**
     *
     * @param node
     * @param tempList
     */
    protected void postOrder(BinaryTreeNode<T> node, ArrayUnorderedList<T> tempList) {
        if (node != null) {
            postOrder(node.left, tempList);
            postOrder(node.right, tempList);
            tempList.addToRear(node.element);
        }

    }

    @Override
    public Iterator<T> iteratorLevelOrder() throws EmptyCollectionException {
        LinkedQueue<BinaryTreeNode> nodes = new LinkedQueue<>();
        ArrayUnorderedList<T> templist = new ArrayUnorderedList<>();

        nodes.enqueue(this.root);

        while (nodes.isEmpty() == false) {
            BinaryTreeNode aux = null;
            aux = nodes.dequeue();
            if (aux != null) {
                templist.addToRear((T) aux.element);
                nodes.enqueue(aux.left);
                nodes.enqueue(aux.right);
            }
        }

        return templist.iterator();
    }
}
