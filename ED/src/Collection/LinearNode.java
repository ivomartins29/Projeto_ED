/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Collection;

/**
 *
 * @author 8150121 e 8150133
 * @param <T>
 */
public class LinearNode<T> {

    private LinearNode<T> next;
    private T element;

    /**
     * Permite criar um LinearNode vazio
     */
    public LinearNode() {
        this.element = null;
        this.next = null;
    }

    /**
     * Permite criar um LinearNode com informação
     *
     * @param element
     */
    public LinearNode(T element) {
        this.next = null;
        this.element = element;
    }

    /**
     * retorna o próximo LinearNode
     *
     * @return o próximo LinearNode
     */
    public LinearNode<T> getNext() {
        return next;
    }

    /**
     * Permite alterar o próximo LinearNode
     *
     * @param node alterado
     */
    public void setNext(LinearNode<T> node) {
        this.next = node;
    }

    /**
     * Permite obter o elemento do LinearNode
     *
     * @return elemento do LinearNode
     */
    public T getElement() {
        return element;
    }

    /**
     * Permite alterar o elemento do LinearNode
     *
     * @param elemento alterado do LinearNode
     */
    public void getElement(T elemento) {
        this.element = elemento;
    }
}
