public class MyQueue<T> {
	private static final int DEFAULT_CAPACITY = 10;
	private Object[] elements;
	private int front;
	private int rear;
	private int size;

	public MyQueue() {
		this(DEFAULT_CAPACITY);
	}

	public MyQueue(int initialCapacity) {
		if (initialCapacity <= 0) {
			throw new IllegalArgumentException("Initial capacity must be positive");
		}
		this.elements = new Object[initialCapacity];
		this.front = 0;
		this.rear = -1;
		this.size = 0;
	}

	public void enqueue(T element) {
		if (isFull()) {
			resize();
		}
		rear = (rear + 1) % elements.length;
		elements[rear] = element;
		size++;
	}

	@SuppressWarnings("unchecked")
	public T dequeue() {
		if (isEmpty()) {
			throw new IllegalStateException("Queue is empty");
		}
		T element = (T) elements[front];
		elements[front] = null;
		front = (front + 1) % elements.length;
		size--;
		return element;
	}

	@SuppressWarnings("unchecked")
	public T peek() {
		if (isEmpty()) {
			throw new IllegalStateException("Queue is empty");
		}
		return (T) elements[front];
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public boolean isFull() {
		return size == elements.length;
	}

	public int size() {
		return size;
	}

	private void resize() {
		int newCapacity = elements.length * 2;
		Object[] newArray = new Object[newCapacity];
		
		for (int i = 0; i < size; i++) {
			newArray[i] = elements[(front + i) % elements.length];
		}
		
		elements = newArray;
		front = 0;
		rear = size - 1;
	}
}