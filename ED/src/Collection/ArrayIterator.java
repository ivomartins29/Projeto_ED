/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Collection;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author 8150121 e 8150133
 * @param <T> tipo genérico
 */
public class ArrayIterator<T> implements Iterator<T> {

    private final int count;
    private int current;
    private final T[] items;

    public ArrayIterator(T[] items, int count) {
        this.items = items;
        this.count = count;
        this.current = 0;
    }

    /**
     *
     * @return true se existe mais que um elemento do array para retornar
     */
    @Override
    public boolean hasNext() {
        return (this.current < this.count);
    }

    /**
     * Retorna o atual elemento do array, e move o cursor para o próximo
     *
     * @return o atual elemento do array
     */
    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }

        this.current++;

        return this.items[this.current - 1];
    }
}
