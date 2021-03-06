
package collections;

public class Queue<T>{
	
	/**
	 *	represents the first element in the stack
	 */
	private Node<T> first;
	/**
	 *	represents the first element in the stack
	 */
	private Node<T> laters;
	
	private int size;
	
	
	/**
	 *	Creates an object of Queue type that can contains elements of T type
	 */
	public Queue() {
		first = null;
		laters = null;
		size = 0;
	}

	public void offer(T object) {
		if(first==null) {
			first = new Node<T>(object);
			laters = first;
		}else {
			laters.setNext(new Node<T>(object));
			laters.getNext().setPrior(laters);
			laters = laters.getNext();
		}
		size++;
		//System.out.println("Queue of type: " + object.toString() +", size = " + size);
	}

	public T peek() {
		return first != null ? first.getElement() : null;
	}
	
	public T poll() {
		T temp = null;
		if(first != null) {
			temp = first.getElement();
			first = first.getNext();
			if(first!= null) {
				first.setPrior(null);
			}
			size--;
		}
		return temp;
	}
	
	public int getSize() {
		return size;
	}
	
	@Override
	public String toString() {
		Node<T> temp = first;
		String s = "";
		while(temp != null) {
			s += temp.toString() + "-";
			temp = temp.getNext();
		}
		return s;
	}
	public T dequeue() throws Exception {
		if (isEmpty()) {
			throw new Exception("The queue is empty");
		}
		size--;
		T element = first.getElement();
		first = first.getNext();
		return element;
	}
	
	public boolean isEmpty() {
		return first == null;
	}
	
}
