public class MyList<T> {
	private static final int DEFAULT_CAPACITY = 10;
	private Object[] elements;
	private int size;

	public MyList() {
		this(DEFAULT_CAPACITY);
	}

	public MyList(int initialCapacity) {
		if (initialCapacity < 0) {
			throw new IllegalArgumentException("Initial capacity cannot be negative");
		}
		this.elements = new Object[initialCapacity];
		this.size = 0;
	}

	public void add(T element) {
		ensureCapacity();
		elements[size++] = element;
	}

	public void add(int index, T element) {
		checkIndexForAdd(index);
		ensureCapacity();
		
		System.arraycopy(elements, index, elements, index + 1, size - index);
		elements[index] = element;
		size++;
	}

	@SuppressWarnings("unchecked")
	public T get(int index) {
		checkIndex(index);
		return (T) elements[index];
	}

	public T set(int index, T element) {
		checkIndex(index);
		@SuppressWarnings("unchecked")
		T oldValue = (T) elements[index];
		elements[index] = element;
		return oldValue;
	}

	@SuppressWarnings("unchecked")
	public T remove(int index) {
		checkIndex(index);
		T oldValue = (T) elements[index];
		
		int numMoved = size - index - 1;
		if (numMoved > 0) {
			System.arraycopy(elements, index + 1, elements, index, numMoved);
		}
		
		elements[--size] = null; // для сборщика мусора
		return oldValue;
	}

	public boolean remove(Object o) {
		if (o == null) {
			for (int i = 0; i < size; i++) {
					if (elements[i] == null) {
						remove(i);
						return true;
					}
			}
		} else {
			for (int i = 0; i < size; i++) {
					if (o.equals(elements[i])) {
						remove(i);
						return true;
					}
			}
		}
		return false;
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public void clear() {
		for (int i = 0; i < size; i++) {
			elements[i] = null;
		}
		size = 0;
	}

	public boolean contains(Object o) {
		return indexOf(o) >= 0;
	}

	public int indexOf(Object o) {
		if (o == null) {
			for (int i = 0; i < size; i++) {
					if (elements[i] == null) {
						return i;
					}
			}
		} else {
			for (int i = 0; i < size; i++) {
					if (o.equals(elements[i])) {
						return i;
					}
			}
		}
		return -1;
	}

	private void ensureCapacity() {
		if (size == elements.length) {
			int newCapacity = elements.length + (elements.length >> 1);
			Object[] newElements = new Object[newCapacity];
			System.arraycopy(elements, 0, newElements, 0, size);
			elements = newElements;
		}
	}

	private void checkIndex(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
		}
	}

	private void checkIndexForAdd(int index) {
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
		}
	}

	@Override
	public String toString() {
		if (size == 0) {
			return "[]";
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append('[');
		for (int i = 0; i < size; i++) {
			sb.append(elements[i]);
			if (i == size - 1) {
					sb.append(']');
			} else {
					sb.append(", ");
			}
		}
		return sb.toString();
	}
}