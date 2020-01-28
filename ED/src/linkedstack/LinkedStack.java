package linkedstack;

public class LinkedStack<T> extends LinearNode<T> implements StackADT<T> {

	private LinearNode<T> currentElement = null;

	public LinkedStack() {
		// Construtor vazio de LinkedStack
	}

	/*
	 * Construtor de LinkedStack
	 * 
	 * @param element - primeiro elemento da stack
	 */
	public LinkedStack(T element) {
		super(element);
		currentElement = (LinearNode<T>) element;
	}

	/*
	 * Metodo para retornar o ultimo objeto inserido. ATENC�O - este metodo retorna
	 * mesmo o objeto em si e n�o os dados contidos dentro dele Para retornar o
	 * elemento dentro do objeto existe o metodo peek!
	 */
	public LinearNode<T> top() {
		if (currentElement != null) {
			return currentElement;
		} else {
			return null;
		}
	}

	@Override
	public void push(T element) {
		LinearNode<T> newNode = new LinearNode<>();
		newNode.setElement(element);
		newNode.setNext(top());
		currentElement = newNode;
	}

	@Override
	public T pop() throws EmptyCollectionException {
		if (isEmpty() == true) {
			throw new EmptyCollectionException();
		}
		if (currentElement.getNext() != null) {
			currentElement = currentElement.getNext();
			return currentElement.getElement();
		} else if (currentElement.getNext() == null) {
			currentElement = null;
			return null;
		}
		return (T) currentElement;
	}

	@Override
	public T peek() throws EmptyCollectionException {
		if (isEmpty() == true) {
			throw new EmptyCollectionException();
		}
		if (currentElement != null) {
			return currentElement.getElement();
		} else {
			return null;
		}
	}

	@Override
	public boolean isEmpty() {
		if (currentElement == null) {
			return true;
		} else {
			return false;
		}
	}

	/*
	 * Retorna o tamanho da stack
	 */
	@Override
	public int size() throws EmptyCollectionException {
		if (isEmpty() == true) {
			throw new EmptyCollectionException();
		}
		int count = 0;
		LinearNode<T> countingElement = currentElement;
		if (countingElement.getNext() == null) {
			count++;
		} else {
			while (countingElement.getNext() != null) {
				count++;
				countingElement = countingElement.getNext();
				if (countingElement.getNext() == null) {
					count++;
				}
			}
		}
		return count;
	}

	public String toString() {
		LinearNode<T> countingElement = currentElement;
		if (isEmpty() == true) {
			System.out.println("FUCK YOU! STACK IS EMPTY!");
		}
		if (countingElement.getNext() == null && countingElement.getElement() != null) {
			System.out.println(countingElement.getElement());
		} else {
			while (countingElement.getNext() != null) {
				System.out.println(countingElement.getElement());
				countingElement = countingElement.getNext();
				if (countingElement.getNext()==null) {
					System.out.println(countingElement.getElement());
				}
			}
		}
		return "|Bottom|";
	}

}
