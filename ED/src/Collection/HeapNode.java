/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Collection;

/**
 *
 * @author 8150121 e 8150133
 * @param <T> tipo genérico
 */
public class HeapNode<T> extends BinaryTreeNode<T> {

    private HeapNode<T> parent;

    /**
     * Criar um o heap node
     *
     * @param element elemento a ser armazenado no nó
     */
    public HeapNode(T element) {
        super(element);
        this.parent = null;
    }

    /**
     *
     * @return o parent
     */
    public HeapNode<T> getParent() {
        return parent;
    }

    /**
     *
     * @param parent novo parent
     */
    public void setParent(HeapNode<T> parent) {
        this.parent = parent;
    }
}
