package collections;

public interface QueueInterface<T> {

	void offer(T object);
	T poll();
	T peek();
	public T dequeue() throws Exception;
	
}
