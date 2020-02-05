package Collection;

import Exception.ElementNotFoundException;

import Interface.UnorderedListADT;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 8150121 e 8150133
 * @param <T> tipo genérico
 */
public class ArrayUnorderedList<T> extends ArrayList<T> implements UnorderedListADT<T> {

    /**
     * Construtor vazio
     */

    public ArrayUnorderedList() {
        super();
    }

    /**
     * Construtor com tamanho definido
     *
     * @param initialCapacity tamanho inicial
     */
    public ArrayUnorderedList(int initialCapacity) {
        super(initialCapacity);
    }

    /**
     * Adiciona um elemento específico na início da lista.
     *
     * @param t elemento a ser adicionado
     */
    @Override
    public void addToFront(T t) {
        if (size() == list.length) {
            expandCapacity();
        }

        for (int i = rear; i > 0; i--) {
            list[i] = list[i - 1];
        }

        list[0] = t;
        rear++;
    }

    /**
     * Adiciona um elemento específico na fim da lista.
     *
     * @param t elemento a ser adicionado
     */
    @Override
    public void addToRear(T t) {
        if (size() == list.length) {
            expandCapacity();
        }

        list[rear] = t;
        rear++;
    }

    /**
     * Adiciona um elemento específico depois de um elemento target específico.
     * Lança a exceção ElementNotFoundException se o target não for encontrado.
     *
     * @param t elemento a ser adicionado
     * @param t1 elemento específico de referência para a adição
     */
    @Override
    public void addAfter(T t, T t1) {
        if (size() == list.length) {
            expandCapacity();
        }

        int i = 0;
        while (i < rear && !t1.equals(list[i])) {
            i++;
        }

        if (i == rear) {
            try {
                throw new ElementNotFoundException("list");
            } catch (ElementNotFoundException ex) {
                Logger.getLogger(ArrayUnorderedList.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        i++;
        for (int u = rear; u > i; u--) {
            list[u] = list[u - 1];
        }

        list[i] = t;
        rear++;
    }
}
