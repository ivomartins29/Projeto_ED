/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Collection;

import java.util.Iterator;

/**
 *
 * @author 8150121 e 8150133
 * @param <T> tipo genérico
 */
public class ArrayOrderedList<T> extends ArrayList<T> {

    protected int count;
    protected T[] array;
    private final int TAM_MAX = 20;

    public ArrayOrderedList() {
        this.array = (T[]) new Object[this.TAM_MAX];
        this.count = 0;
    }

    public ArrayOrderedList(int size) {
        this.array = (T[]) new Object[size];
        this.count = 0;
    }

    /*
     Cria um novo array para armazenar um contúdo da coleção com o dobro da capacidade do array antigo.
     */
    @Override
    protected synchronized void expandCapacity() {
        T[] larger = (T[]) (new Object[this.array.length * 2]);

        System.arraycopy(this.array, 0, larger, 0, this.array.length);

        this.array = larger;
    }

    /**
     * Acrescenta um elemento comparável específico à lista, mantendo os
     * elementos pela devida ordem.
     *
     * @param element elemento a ser adicionado
     */
    public synchronized void add(T element) {
        if (!contains(element)) {
            if (size() == this.array.length) {
                expandCapacity();
            }

            Comparable<T> var = (Comparable<T>) element;

            int i = 0;

            while (i < size() && var.compareTo(this.array[i]) > 0) {
                i++;
            }

            for (int j = this.count; j > i; j--) {
                this.array[j] = this.array[j - 1];

            }

            this.array[i] = element;
            this.count++;
        }
    }

    /**
     * Imprime todos os elementos da lista
     */
    public synchronized void printAll() {
        String result = "";

        for (int i = 0; i < this.count; i++) {
            result = result + this.array[i].toString() + "\n";
        }

        System.out.println(result);
    }

    /**
     *
     * Remove o primeiro elemento do ArrayList
     *
     * @return o elemento removido do ArrayList
     */
    @Override
    public T removeFirst() {
        T tmp;
        tmp = this.array[0];
        this.array[0] = null;

        for (int i = 0; i < this.count; i++) {
            this.array[i] = this.array[i + 1];
        }

        this.count--;
        return tmp;
    }

    /**
     * Remove o último elemento do ArrayList
     *
     * @return o elemento removido do ArrayList
     */
    @Override
    public T removeLast() {
        T tmp;
        this.count--;
        tmp = this.array[this.count];
        this.array[this.count] = null;
        return tmp;
    }

    /**
     *
     * Remove um elemento numa posição específica do ArrayList.
     *
     * @param element elemento a ser removido
     * @return elemento removido do ArrayList
     */
    @Override
    public T remove(T element) {
        T tmp = null;
        int i;

        for (i = 0; i < this.count; i++) {
            if (element.equals(array[i])) {
                tmp = this.array[i];
                this.count--;
                break;
            }
        }

        for (; i < this.count + 1; i++) {
            this.array[i] = this.array[i + 1];
        }

        return tmp;
    }

    /**
     *
     * Retorna o índice da primeira ocorrência do argumento no ArrayList Returns
     * exceção quando não for encontrado.
     *
     * @return índice da primeira ocorrência
     */
    @Override
    public T first() {
        return this.array[0];
    }

    /**
     *
     * Retorna o índice da última ocorrência do argumento no ArrayList Returns
     * exceção quando não for encontrado.
     *
     * @return índice da última ocurrência
     */
    @Override
    public T last() {
        return this.array[this.count - 1];
    }

    /**
     * Retorna true se o ArrayList contém o elemento específico.
     *
     * @param target elemento a ser verifica a existência
     * @return true se encontrar
     */
    @Override
    public synchronized boolean contains(T target) {
        return (find(target) != -1);
    }

    /**
     * Pesquisa por um certo elemento no array
     */
    private synchronized int find(T target) {
        int i = 0;
        int result = -1;
        boolean found = false;

        if (!isEmpty()) {
            while (i < this.count) {
                if (target.equals(this.array[i])) {
                    found = true;
                    break;
                } else {
                    i++;
                }
            }
        }

        if (found) {
            result = i;
        }

        return result;
    }

    /**
     * Pesquisa por um certo Object no array
     *
     * @param target elemento a ser procurado
     * @return o elemento encontrado
     */
    public synchronized T findObject(T target) {
        int i = 0;

        if (!isEmpty()) {
            while (i < this.count) {
                if (target.equals(this.array[i])) {
                    return this.array[i];
                } else {
                    i++;
                }
            }
        }

        return null;
    }

    /**
     * Remove todos os elementos do array
     */
    public synchronized void clear() {

        for (int i = 0; i < this.count; i++) {
            this.array[i] = null;
        }

        this.count = 0;
    }

    /**
     * Retorna o elemento com determinado índice no array
     *
     * @param index índice do elemento
     * @return elemento
     */
    public synchronized T get(int index) {
        return this.array[index];
    }

    /**
     * Verifica se o array está vazio
     *
     * @return true se estiver vazio
     */
    @Override
    public synchronized boolean isEmpty() {
        return (this.count == 0);
    }

    /**
     * Retorna o número de elementos no ArrayList.
     *
     * @return número de elementos no ArrayList
     */
    @Override
    public synchronized int size() {
        return this.count;
    }

    /**
     * Retorna um Iterator dos elementos desta lista na sequência apropriada.
     * @return Iterador de elementos
     */
    @Override
    public synchronized Iterator<T> iterator() {
        return new ArrayIterator<>(this.array, this.count);
    }

    public class ArrayIterator<T> implements Iterator<T> {

        private int modCount;
        private final int size;
        private final T[] array;

        public ArrayIterator(T[] array, int tamanho) {
            this.modCount = 0;
            this.array = array;
            this.size = tamanho;
        }

        @Override
        public boolean hasNext() {
            return (this.modCount < count);
        }

        @Override
        public T next() {
            this.modCount++;
            return this.array[this.modCount - 1];
        }

    }

    @Override
    public String toString() {
        String str = "OrderedArray = {";

        for (int i = 0; i < this.count; i++) {
            str += "" + i + "," + this.array[i].toString();
        }

        str += "}";
        return str;
    }
}
