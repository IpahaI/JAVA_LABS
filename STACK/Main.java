public class Main {
	public static void main(String[] args) {
		MyStack<Integer> stack = new MyStack<>();

		System.out.println("Добавляем элементы в стек:");
		for (int i = 1; i <= 5; i++) {
			System.out.println("Push: " + i);
			stack.push(i);
		}

		System.out.println("\nРазмер стека: " + stack.size());
		System.out.println("Верхний элемент: " + stack.peek());

		System.out.println("\nИзвлекаем элементы из стека:");
		while (!stack.isEmpty()) {
			System.out.println("Pop: " + stack.pop());
		}

		System.out.println("\nСтек пуст? " + stack.isEmpty());

		MyStack<String> stringStack = new MyStack<>();
		stringStack.push("Hello");
		stringStack.push("World");
		System.out.println("\nСтроковый стек:");
		System.out.println(stringStack.pop());
		System.out.println(stringStack.pop());
	}
}