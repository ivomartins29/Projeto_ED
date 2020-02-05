/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Collection;

/**
 *
<<<<<<< HEAD
 * @author 8150121 e 8150133
=======
 * @author Sandra Fonseca
>>>>>>> 026de2582b704c9fc3ac69cc75b8d5b641e0a441
 * @param <T>
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

    public HeapNode<T> getParent() {
        return parent;
    }

    public void setParent(HeapNode<T> parent) {
        this.parent = parent;
    }

}
