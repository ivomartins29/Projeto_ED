/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapa;

import Collection.ArrayOrderedList;

/**
 *
 * @author 8150121 e 8150133
 * @param <T> tipo genérico
 */
public class ArrayOrderedUti<T> extends ArrayOrderedList<T> {

    /**
     *
     */
    public ArrayOrderedUti() {
        super();
    }

    @Override
    public synchronized void add(T element) {

        if (!contains(element)) {
            if (size() == this.array.length) {
                expandCapacity();
            }

            Comparable<Long> var = ((Jogador) element).getPontos();

            int i = 0;

            while (i < size() && var.compareTo(((Jogador) this.array[i]).getPontos()) < 0) {
                i++;
            }

            for (int j = this.count; j > i; j--) {
                this.array[j] = this.array[j - 1];

            }

            this.array[i] = element;
            this.count++;
        }
    }
}
