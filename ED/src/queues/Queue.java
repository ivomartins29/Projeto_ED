package queues;

public class Queue<T> extends Queued<T> implements QueueADT<T> {

	private Queued<T> first = null;
	private Queued<T> current = null;
	private int count=0;

	/*
	public Queue(T element) {
		super(element);
		first= (Queued<T>) element;
		current=first;
		count++;
	}
	*/

	public Queue() {
		super();
	}

	@Override
	public void enqueue(T element) {
		Queued<T> newObj = new Queued(element);
		newObj.setNext(current);
		if(current!=null) {
			current.setPrevious(newObj);
			current=newObj;
		}
		else{
			first=newObj;
			current=first;
		}
		count++;
	}

	@Override
	public T dequeue() throws EmptyQueuedException{
		if(isEmpty()) {
			throw new EmptyQueuedException();
		}
		Queued<T> backup=first;
		first=first.getPrevious();
		if(first==null)
			current=null;
		count--;
		return backup.getElement();
	}

	@Override
	public T first() throws EmptyQueuedException{
		if(isEmpty()==true) {
			throw new EmptyQueuedException();
		}
		Queued<T> count = current;
		while(count.getNext()!=null) {
			count=count.getNext();
			if(count.getNext()==null) {
				return count.getElement();
			}
		}
		return null;
	}
	
	@Override
	public boolean isEmpty() {
		if(first == null) {
			return true;
		}
		return false;
	}

	@Override
	public int size() throws EmptyQueuedException{
		int size=0;
		Queued<T> count = current;
		while(count.getNext()!=null) {
			size++;
			count=count.getNext();
			if(count.getNext()==null) {
				size++;
			}
		}
		return size;
	}

	public String toString() {
		Queued<T> count = current;
		System.out.println("|LAST|");
		while(count.getNext()!=null) {
			System.out.println(count.getElement());;
			count=count.getNext();
			if(count.getNext()==null) {
				System.out.println(count.getElement());;
			}
		}
		return "|FIRST|";
	}
}
