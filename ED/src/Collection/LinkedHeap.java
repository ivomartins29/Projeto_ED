/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Collection;

import Exception.EmptyException;
import Interface.HeapADT;

/**
 * 
 * @author 8150121 e 8150133
 * @param <T> tipo genérico
 */

public class LinkedHeap<T> extends BinaryTree<T> implements HeapADT<T> {

    /**
     * Último nó inserido na árvore
     */
    private HeapNode<T> lastNodeInserted;

    /**
     * Criar uma árvore heap vazia
     */
    public LinkedHeap() {
        super();
    }

    /**
     * Criar uma árvore com um elemento na raiz
     *
     * @param element elemento a ser armazenado
     */
    public LinkedHeap(T element) {
        super(element);
    }

    @Override
    public void addElement(T element) {

        HeapNode<T> newNode = new HeapNode<>(element); // Novo nó

        /**
         * < Se a árvore estiver vazia>
         */
        if (isEmpty()) {

            root = newNode; // O novo nó é a raiz

        } else {

            HeapNode<T> nextParent = getNextParentAdd(); // Próximo nó pai

            if (nextParent.getLeft() == null) {
                nextParent.setLeft(newNode);
            } else {
                nextParent.setRight(newNode);
            }

            newNode.setParent(nextParent);
        }

        lastNodeInserted = newNode; // Último nó inserido
        count++;

        /**
         * < Se a árvore contiver mais do que um elemento>
         * Reordenar a árvore
         */
        if (count > 1) {
            heapifyAdd();
        }
    }

    @Override
    public T removeMin() throws EmptyException {

        if (isEmpty()) {
            throw new EmptyException("Empty heap");
        }

        T minElement = root.getElement();

        /**
         * < Se a árvore contiver apenas um elemento>
         * Apenas tem o elemento na raiz. A raiz é colocada a null
         */
        if (count == 1) {

            root = null;
            lastNodeInserted = null;

        } else {

            HeapNode<T> nextLast = getNewLastNode();

            if (lastNodeInserted.getParent().getLeft() == lastNodeInserted) {
                lastNodeInserted.getParent().setLeft(null);
            } else {
                lastNodeInserted.getParent().setRight(null);
            }

            root.setElement(lastNodeInserted.getElement());
            lastNodeInserted = nextLast;

            heapifyRemove();
        }

        count--;

        return minElement;
    }

    /**
     * Encontrar o menor elemento da árvore. O menor elemento da árvore encontra
     * se na raiz Rever Metodo
     *
     * @return o menor elemento
     */
    @Override
    public T findMin() {
        return root.getElement();
    }

    /**
     * 
     * @return um HeapNode
     */
    private HeapNode<T> getNextParentAdd() {

        HeapNode<T> result = lastNodeInserted;

        /**
         * Enquanto o nó resultante não for a raiz e não for igual ao nó
         * esquerdo do nó pai
         */
        while ((result != root) && (result.getParent().getLeft() != result)) {
            result = result.getParent();
        }

        if (result != root) {

            if (result.getParent().getRight() == null) {

                result = result.getParent();

            } else {

                result = (HeapNode<T>) result.getParent().getRight();

                while (result.getLeft() != null) {
                    result = (HeapNode<T>) result.getLeft();
                }

            }

        } else {

            while (result.getLeft() != null) {
                result = (HeapNode<T>) result.getLeft();
            }

        }

        return result;
    }

    /**
     * Reordenar a heap após a adição de um elemento
     */
    private void heapifyAdd() {

        T temp; // Elemento temporário
        HeapNode<T> next = lastNodeInserted; // Próximo nó

        temp = next.getElement();

        while ((next != root) && (((Comparable) temp).compareTo(next.getParent().getElement()) < 0)) {

            next.setElement(next.getParent().getElement());
            next = next.getParent();

        }

        next.setElement(temp);
    }

    /**
     * Obter o nó que irá ser o último nó após a remoção
     *
     * @return o próximo último nó
     */
    private HeapNode<T> getNewLastNode() {

        HeapNode<T> result = lastNodeInserted;

        while ((result != root) && (result.getParent().getLeft() == result)) {
            result = result.getParent();
        }

        if (result != root) {
            result = (HeapNode<T>) result.getParent().getLeft();
        }

        while (result.getRight() != null) {
            result = (HeapNode<T>) result.getRight();
        }

        return result;
    }

    /**
     * Reordenar a árvore após a remoção de um elemento
     */
    private void heapifyRemove() {

        T temp; // Elemento temporário

        HeapNode<T> node = (HeapNode<T>) root;
        HeapNode<T> left = (HeapNode<T>) node.getLeft();
        HeapNode<T> right = (HeapNode<T>) node.getRight();
        HeapNode<T> next;

        if ((left == null) && (right == null)) {
            next = null;
        } else if (left == null) {
            next = right;
        } else if (right == null) {
            next = left;
        } else if (((Comparable) left.getElement()).compareTo(right.getElement()) < 0) {
            next = left;
        } else {
            next = right;
        }

        temp = node.getElement();

        while ((next != null) && (((Comparable) next.getElement()).compareTo(temp) < 0)) {

            node.setElement(next.getElement());
            node = next;

            left = (HeapNode<T>) node.getLeft();
            right = (HeapNode<T>) node.getRight();

            if ((left == null) && (right == null)) {
                next = null;
            } else if (left == null) {
                next = right;
            } else if (right == null) {
                next = left;
            } else if (((Comparable) left.getElement()).compareTo(right.getElement()) < 0) {
                next = left;
            } else {
                next = right;
            }
        }

        node.setElement(temp);
    }

    /**
     * remove todos os elementos
     */
    public void removeAllElements() throws EmptyException {
        while (!isEmpty()) {
            removeMin();
        }
    }
}
