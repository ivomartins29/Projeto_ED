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
public class HeapNode<T> extends BinaryTreeNode<T> {

    private HeapNode<T> parent;

    /**
     *
     * @param element
     */
    public HeapNode(T element) {
        super(element);
        this.parent = null;
    }

    /**
     *
     * @return
     */
    public HeapNode<T> getParent() {
        return parent;
    }

    /**
     *
     * @param parent
     */
    public void setParent(HeapNode<T> parent) {
        this.parent = parent;
    }

}
