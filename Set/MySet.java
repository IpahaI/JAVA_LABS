import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MySet<T> implements Iterable<T> {
	private static final int DEFAULT_CAPACITY = 16;
	private static final float LOAD_FACTOR = 0.75f;
	
	private Node<T>[] buckets;
	private int size;
	
	@SuppressWarnings("unchecked")
	public MySet() {
		this.buckets = (Node<T>[]) new Node[DEFAULT_CAPACITY];
		this.size = 0;
	}
	
	@SuppressWarnings("unchecked")
	public MySet(int initialCapacity) {
		if (initialCapacity <= 0) {
			throw new IllegalArgumentException("Initial capacity must be positive");
		}
		this.buckets = (Node<T>[]) new Node[initialCapacity];
		this.size = 0;
	}
	
	private static class Node<T> {
		T data;
		Node<T> next;
		
		Node(T data) {
			this.data = data;
			this.next = null;
		}
	}
	
	public boolean add(T element) {
		if (contains(element)) {
			return false;
		}
		
		if (size >= buckets.length * LOAD_FACTOR) {
			resize();
		}
		
		int index = getIndex(element);
		Node<T> newNode = new Node<>(element);
		newNode.next = buckets[index];
		buckets[index] = newNode;
		size++;
		return true;
	}
	
	public boolean contains(Object element) {
		int index = getIndex(element);
		Node<T> current = buckets[index];
		
		while (current != null) {
			if (Objects.equals(current.data, element)) {
					return true;
			}
			current = current.next;
		}
		return false;
	}
	
	public boolean remove(Object element) {
		int index = getIndex(element);
		Node<T> current = buckets[index];
		Node<T> prev = null;
		
		while (current != null) {
			if (Objects.equals(current.data, element)) {
					if (prev == null) {
						buckets[index] = current.next;
					} else {
						prev.next = current.next;
					}
					size--;
					return true;
			}
			prev = current;
			current = current.next;
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
		Arrays.fill(buckets, null);
		size = 0;
	}
	
	private int getIndex(Object element) {
		if (element == null) {
			return 0;
		}
		return Math.abs(element.hashCode()) % buckets.length;
	}
	
	@SuppressWarnings("unchecked")
	private void resize() {
		Node<T>[] oldBuckets = buckets;
		buckets = (Node<T>[]) new Node[oldBuckets.length * 2];
		size = 0;
		
		for (Node<T> node : oldBuckets) {
			while (node != null) {
					add(node.data);
					node = node.next;
			}
		}
	}
	
	@Override
	public Iterator<T> iterator() {
		return new MySetIterator();
	}
	
	private class MySetIterator implements Iterator<T> {
		private int currentBucket = -1;
		private Node<T> currentNode = null;
		private Node<T> nextNode = null;
		private int count = 0;
		
		MySetIterator() {
			findNextNode();
		}
		
		@Override
		public boolean hasNext() {
			return count < size;
		}
		
		@Override
		public T next() {
			if (!hasNext()) {
					throw new NoSuchElementException();
			}
			
			Node<T> nodeToReturn = nextNode;
			findNextNode();
			count++;
			return nodeToReturn.data;
		}
		
		private void findNextNode() {
			if (currentNode != null && currentNode.next != null) {
					nextNode = currentNode.next;
					currentNode = currentNode.next;
					return;
			}
			
			for (currentBucket++; currentBucket < buckets.length; currentBucket++) {
					if (buckets[currentBucket] != null) {
						nextNode = buckets[currentBucket];
						currentNode = buckets[currentBucket];
						return;
					}
			}
			
			nextNode = null;
		}
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		
		boolean first = true;
		for (T element : this) {
			if (!first) {
					sb.append(", ");
			}
			sb.append(element);
			first = false;
		}
		
		sb.append("]");
		return sb.toString();
	}
}