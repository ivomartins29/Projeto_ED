package LinkedQueue;

import linkedstack.LinearNode;


/**
 * @author Luis Pereira
 */
public class LinkedQueue<T> implements QueueADT<T> {

    private LinearNode<T> front;
    private LinearNode<T> rear;
    private int count = 0;

    @Override
    public void enqueue(T element) {
        LinearNode<T> newnode = new LinearNode<>(element);

        if (count != 0) {
            rear.setNext(newnode);
            rear = newnode;
        } else {
            front = newnode;
            rear = newnode;
        }
        count++;
    }

    @Override
    public T dequeue() {
        T copy = front.getElement();
        front = front.getNext();
        count--;
        return copy;
    }

    @Override
    public T first() {
        return front.getElement();
    }

    public T last() {
        return rear.getElement();
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public int size() {
        return count;
    }
}
