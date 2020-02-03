/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LinkedHeap;

/**
 *
 * @author 8150121 e 8150133
 * @param <T>
 */
public class HeapNode<T> extends BinaryTreeNode<T> {

    protected HeapNode<T> parent;

    /**
     * Permite criar um novo HeapNode
     *
     * @param obj Informação a guardar no HeapNode
     */
    HeapNode(T obj) {
        super(obj);
        parent = null;
    }
}
