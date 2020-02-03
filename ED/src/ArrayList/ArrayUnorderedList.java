package ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

<<<<<<< HEAD:ED/src/ArrayList/ArrayUnorderedList.java

import Interfaces.UnorderedListADT;
=======
import Interface.UnorderedListADT;
>>>>>>> 7c787e34aef72037979f2bfaeb12c363751373d7:ED/src/ed_t/ArrayUnorderedList.java
import Exceptions.NotFoundException;
import Exceptions.EmptyElementException;

/**
 *
 * @author fabio
 */
public class ArrayUnorderedList<T> extends ArrayList<T> implements UnorderedListADT<T> {

    public ArrayUnorderedList(int capacity) {
        super(capacity);
    }

    public ArrayUnorderedList() {
    }

    @Override
    public void addToFront(T element) {
        if (this.rear == this.list.length) {
            expandCapacity();
        }
        
        for (int i = rear - 1; i >= 0; i--) {
            list[i + 1] = list[i];
        }
        
        list[0] = element;
        rear++;
    }

    @Override
    public void addToRear(T element) {
        if (this.rear == this.list.length) {
            expandCapacity();
        }

        this.list[this.rear] = element;
        rear++;
    }

    @Override
    public void addAfter(T element, T target) throws EmptyElementException, NotFoundException {
        int posicao = 0;
        boolean found = false;

        if (this.rear == this.list.length) {
            expandCapacity();
        }

        for (int i = 0; i < this.rear && !found; i++) {
            if (this.list[i].equals(target)) {
                posicao = i;
                found = true;
            }
        }

        if (!found) {
            throw new NotFoundException("Esse elemento não existe");
        }
        
        if (posicao == this.rear - 1) {
            this.list[rear] = element;
        } else {
            for (int i = this.rear - 1; i >= posicao + 1; i--) {
                list[i + 1] = list[i];
            }
            this.list[posicao+1]=element;
        }
        
        rear++;
    }

}
