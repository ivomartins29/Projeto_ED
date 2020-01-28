package queues;

public class Queued<T> {
	private T element;
	private Queued<T> next;
	private Queued<T> previous;

	public Queued(T element) {
		this.element=element;
		this.next=null;
	}

    public Queued() {
        this.element=null;
        this.next=null;
    }

	public void setElement(T element) {
		this.element = element;
	}
	
	public void setNext(Queued<T> next) {
		this.next=next;
	}
	
	public void setPrevious(Queued<T> previous) {
		this.previous=previous;
	}
	
	public T getElement() {
		return this.element;
	}
	
	public Queued<T> getNext(){
		return this.next;
	}
	
	public Queued<T> getPrevious(){
		return this.previous;
	}
	
}
