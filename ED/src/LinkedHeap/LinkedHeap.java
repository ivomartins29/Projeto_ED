/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LinkedHeap;


import Exceptions.EmptyCollectionException;
import Interfaces.HeapADT;

/**
 *
 * @author 8150121 e 8150133
 * @param <T>
 */
public class LinkedHeap<T> extends BinaryTree<T> implements HeapADT<T> {

    public HeapNode<T> lastNode;

    /**
     * Adiciona o objeto especificado à heap
     *
     * @param t O elemento a adicionar à heap
     */
    @Override
    public void addElement(T t) {
        HeapNode<T> node = new HeapNode<>(t);

        if (super.root == null) {
            super.root = node;
        } else {
            HeapNode<T> next_parent = getNextParentAdd();
            if (next_parent.left == null) {
                next_parent.left = node;
            } else {
                next_parent.right = node;
            }
            node.parent = next_parent;
        }

        this.lastNode = node;
        super.count++;

        if (super.count > 1) {
            heapifyAdd();
        }

    }

    /**
     * Retorna o node que vai ser o parente do novo node
     *
     * @return que vai ser o parente do novo node
     */
    private HeapNode<T> getNextParentAdd() {
        HeapNode<T> result = this.lastNode;

        while ((result != super.root)
                && (result.parent.left != result)) {
            result = result.parent;
        }

        if (result != super.root) {
            if (result.parent.right == null) {
                result = result.parent;
            } else {
                result = (HeapNode<T>) result.parent.right;
                while (result.left != null) {
                    result = (HeapNode<T>) result.left;
                }
            }
        } else {
            while (result.left != null) {
                result = (HeapNode<T>) result.left;
            }
        }

        return result;
    }

    /**
     * Reordena a Heap depois de ser adicionado um elemento
     */
    private void heapifyAdd() {
        T temp;
        HeapNode<T> next = this.lastNode;
        temp = next.element;

        while ((next != super.root) && (((Comparable) temp).compareTo(next.parent.element) < 0)) {
            next.element = next.parent.element;
            next = next.parent;
        }

        next.element = temp;
    }

    /**
     * Remove e devolve uma referência ao elemento com o menor valor nesta heap
     *
     * @return o menor valor na heap
     * @throws EmptyCollectionException o menor valor na heap
     */
    @Override
    public T removeMin() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("Heap Vazia.");
        }
        T minElement = super.root.element;

        if (count == 1) {
            super.root = null;
            this.lastNode = null;
        } else {
            HeapNode<T> next_last = getNewLastNode();
            if (this.lastNode.parent.left == this.lastNode) {
                this.lastNode.parent.left = null;
            } else {
                this.lastNode.parent.right = null;
            }

            super.root.element = this.lastNode.element;
            this.lastNode = next_last;
            heapifyRemove();
        }

        super.count--;
        return minElement;
    }

    /**
     * Retorna o node que vai ser o ultimo node depois de uma remoção
     *
     * @return node que vai ser o ultimo node depois de uma remoção
     */
    private HeapNode<T> getNewLastNode() {
        HeapNode<T> result = this.lastNode;

        while ((result != super.root) && (result.parent.left == result)) {
            result = result.parent;
        }
        if (result != super.root) {
            result = (HeapNode<T>) result.parent.left;
        }

        while (result.right != null) {
            result = (HeapNode<T>) result.right;
        }

        return result;
    }

    /**
     * Reordena a heap depois do root element ser removido
     */
    private void heapifyRemove() {
        T temp;
        HeapNode<T> node = (HeapNode<T>) super.root;
        HeapNode<T> left = (HeapNode<T>) node.left;
        HeapNode<T> right = (HeapNode<T>) node.right;
        HeapNode<T> next;

        if ((left == null) && (right == null)) {
            next = null;
        } else if (left == null) {
            next = right;
        } else if (right == null) {
            next = left;
        } else if (((Comparable) left.element).compareTo(right.element) < 0) {
            next = left;
        } else {
            next = right;
        }

        temp = node.element;

        while ((next != null) && (((Comparable) next.element).compareTo(temp) < 0)) {
            node.element = next.element;
            node = next;
            left = (HeapNode<T>) node.left;
            right = (HeapNode<T>) node.right;
            if ((left == null) && (right == null)) {
                next = null;
            } else if (left == null) {
                next = right;
            } else if (right == null) {
                next = left;
            } else if (((Comparable) left.element).compareTo(right.element) < 0) {
                next = left;
            } else {
                next = right;
            }
        }

        node.element = temp;
    }

    /**
     * Devolve uma referência ao elemento com o menor valor nesta heap
     *
     * @return o elemento com o menor valor nesta heap
     * @throws EmptyCollectionException o elemento com o menor valor nesta heap
     */
    @Override
    public T findMin() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("Heap Vazia.");
        }

        return super.root.element;
    }

}
