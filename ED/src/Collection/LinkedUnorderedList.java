/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Collection;

import Exception.ElementNotFoundException;
import Interface.UnorderedListADT;

/**
 *
 * @author 8150121 e 8150133
 * @param <T>
 */
public class LinkedUnorderedList<T> extends LinkedList<T> implements UnorderedListADT<T> {

    /**
     * Adiciona um elemento especifico à front da LinkedUnorderedList
     *
     * @param t elemento a ser adicionado
     */
    @Override
    public void addToFront(T t) {
        LinearNode<T> temp = new LinearNode<>(t);

        if (this.count == 0) {
            this.head = this.tail = temp;
            this.count++;
        } else {
            temp.setNext(this.head);
            this.head = temp;
            this.count++;
        }
    }

    /**
     * Adiciona um elemento especifico à rear da LinkedUnorderedList
     *
     * @param t elemento a ser adicionado
     */
    @Override
    public void addToRear(T t) {
        LinearNode<T> temp = new LinearNode<>(t);

        if (this.count == 0) {
            this.head = this.tail = temp;
            this.count++;
        } else {
            this.tail.setNext(temp);
            this.tail = temp;
            this.count++;
        }

    }

    /**
     * Adiciona um elemento especifico a seguir a um elemento especifico
     *
     * @param t o elemento a ser adiconado
     * @param t1 o elemento t (em cima) vai ser adicionado depois do elemento t1
     * @throws ElementNotFoundException se a LinkedUnorderedList estiver vazia
     */
    @Override
    public void addAfter(T t, T t1) throws ElementNotFoundException {
        LinearNode<T> tmp = this.head;
        LinearNode<T> refNode = null;

        while (true) {
            if (tmp == null) {
                break;
            }

            if (tmp.getElement().equals(t1)) {
                refNode = tmp;
                break;
            }

            tmp = tmp.getNext();
        }
        if (refNode != null) {
            LinearNode<T> nd = new LinearNode<>(t);
            nd.setNext(tmp.getNext());

            if (tmp == this.tail) {
                this.tail = nd;
            }

            tmp.setNext(nd);
        } else {
            throw new ElementNotFoundException("Elemento inexistente.");
        }

    }

}
