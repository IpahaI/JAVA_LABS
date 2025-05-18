public class Main {
	public static void main(String[] args) {
		MyQueue<String> queue = new MyQueue<>(3);
		
		System.out.println("Добавляем элементы в очередь:");
		queue.enqueue("Первый");
		queue.enqueue("Второй");
		queue.enqueue("Третий");
		
		// Очередь автоматически расширится
		queue.enqueue("Четвертый");
		
		System.out.println("\nРазмер очереди: " + queue.size());
		System.out.println("Первый элемент: " + queue.peek());
		
		System.out.println("\nИзвлекаем элементы из очереди:");
		while (!queue.isEmpty()) {
			System.out.println(queue.dequeue());
		}
		
		System.out.println("\nОчередь пуста? " + queue.isEmpty());
	}
}