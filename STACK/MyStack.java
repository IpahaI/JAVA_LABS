
public class MyStack<T> {
	private static final int DEFAULT_CAPACITY = 10;
	private Object[] elements;
	private int size;

	public MyStack() {
		this.elements = new Object[DEFAULT_CAPACITY];
		this.size = 0;
	}

	public MyStack(int initialCapacity) {
		if (initialCapacity < 0) {
			throw new IllegalArgumentException("Initial capacity cannot be negative");
		}
		this.elements = new Object[initialCapacity];
		this.size = 0;
	}

	public void push(T element) {
		ensureCapacity();
		elements[size++] = element;
	}

	@SuppressWarnings("unchecked")
	public T pop() {
		if (isEmpty()) {
			throw new IllegalStateException("Stack is empty");
		}
		T element = (T) elements[--size];
		elements[size] = null;
		return element;
	}

	@SuppressWarnings("unchecked")
	public T peek() {
		if (isEmpty()) {
			throw new IllegalStateException("Stack is empty");
		}
		return (T) elements[size - 1];
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public int size() {
		return size;
	}

	private void ensureCapacity() {
		if (size == elements.length) {
			int newCapacity = elements.length * 2;
			Object[] newElements = new Object[newCapacity];
			System.arraycopy(elements, 0, newElements, 0, size);
			elements = newElements;
		}
	}

	public void clear() {
		for (int i = 0; i < size; i++) {
			elements[i] = null;
		}
		size = 0;
	}
}