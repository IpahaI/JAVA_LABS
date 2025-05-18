public class Main {
	public static void main(String[] args) {
		BinaryTree<Integer> tree = new BinaryTree<>();

		// Вставка элементов
		tree.insert(50);
		tree.insert(30);
		tree.insert(20);
		tree.insert(40);
		tree.insert(70);
		tree.insert(60);
		tree.insert(80);

		// Обходы дерева
		System.out.println("In-order traversal:");
		tree.inOrderTraversal();

		System.out.println("Pre-order traversal:");
		tree.preOrderTraversal();

		System.out.println("Post-order traversal:");
		tree.postOrderTraversal();

		// Поиск элементов
		System.out.println("\nContains 40: " + tree.contains(40));
		System.out.println("Contains 90: " + tree.contains(90));

		// Размер и высота
		System.out.println("\nSize of tree: " + tree.size());
		System.out.println("Height of tree: " + tree.height());

		// Удаление элемента
		System.out.println("\nDeleting 20");
		tree.delete(20);
		System.out.println("In-order traversal after deletion:");
		tree.inOrderTraversal();
	}
}