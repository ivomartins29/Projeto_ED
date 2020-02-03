package linkedstack;

import Exceptions.EmptyStackException;
import Interfaces.LinkedStackADT;
import LinkedQueue.LinearNode;





/**
 * @author Luis Pereira
 */
public class LinkedStack<T> implements LinkedStackADT<T> {

    private int count;
    private LinearNode<T> first;
    private LinearNode<T> rear;

    public LinkedStack() {
        this.count = 0;
        this.first = null;
        this.rear = null;
    }

    @Override
    public void push(LinearNode<T> node) {

        if (isEmpty()) {
            this.setFirst(node);
            this.setRear(node);
        } else {
            LinearNode<T> temp;
            temp = this.getFirst();
            first = node;
            rear.setNext(temp);
        }
        count++;
    }

    @Override
    public T pop() throws EmptyStackException {

        LinearNode<T> temp = new LinearNode();
        temp = first;
        first = first.getNext();
        count--;
        return temp.getElement();

    }

    @Override
    public T peek() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException(EmptyStackException.EMPTY_STACK);
        }
        return first.getElement();
    }

    @Override
    public boolean isEmpty() {
        if (size() == 0) {
            return true;
        } else
            return false;
    }

    @Override
    public int size() {
        return this.getCount();
    }

    /**
     * @return the count
     */
    public int getCount() {
        return count;
    }

    /**
     * @param count the count to set
     */
    public void setCount(int count) {
        this.count = count;
    }

    /**
     * @return the first
     */
    public LinearNode<T> getFirst() {
        return first;
    }

    /**
     * @param first the first to set
     */
    public void setFirst(LinearNode<T> first) {
        this.first = first;
    }

    /**
     * @return the rear
     */
    public LinearNode<T> getRear() {
        return rear;
    }

    /**
     * @param rear the rear to set
     */
    public void setRear(LinearNode<T> rear) {
        this.rear = rear;
    }

 
}
