public class BinaryTree<T extends Comparable<T>> {
	private Node root;

	private class Node {
		T data;
		Node left;
		Node right;

		Node(T data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}

	public void insert(T data) {
		root = insertRec(root, data);
	}

	private Node insertRec(Node root, T data) {
		if (root == null) {
			root = new Node(data);
			return root;
		}

		if (data.compareTo(root.data) < 0) {
			root.left = insertRec(root.left, data);
		} else if (data.compareTo(root.data) > 0) {
			root.right = insertRec(root.right, data);
		}

		return root;
	}

	public boolean contains(T data) {
		return containsRec(root, data);
	}

	private boolean containsRec(Node root, T data) {
		if (root == null) {
			return false;
		}

		if (data.equals(root.data)) {
			return true;
		}

		return data.compareTo(root.data) < 0 
			? containsRec(root.left, data) 
			: containsRec(root.right, data);
	}

	public void delete(T data) {
		root = deleteRec(root, data);
	}

	private Node deleteRec(Node root, T data) {
		if (root == null) {
			return null;
		}

		if (data.compareTo(root.data) < 0) {
			root.left = deleteRec(root.left, data);
		} else if (data.compareTo(root.data) > 0) {
			root.right = deleteRec(root.right, data);
		} else {
			// Узел с одним потомком или без потомков
			if (root.left == null) {
					return root.right;
			} else if (root.right == null) {
					return root.left;
			}

			// Узел с двумя потомками
			root.data = minValue(root.right);
			root.right = deleteRec(root.right, root.data);
		}

		return root;
	}

	private T minValue(Node root) {
		T min = root.data;
		while (root.left != null) {
			min = root.left.data;
			root = root.left;
		}
		return min;
	}

	public void inOrderTraversal() {
		inOrderRec(root);
		System.out.println();
	}

	private void inOrderRec(Node root) {
		if (root != null) {
			inOrderRec(root.left);
			System.out.print(root.data + " ");
			inOrderRec(root.right);
		}
	}

	public void preOrderTraversal() {
		preOrderRec(root);
		System.out.println();
	}

	private void preOrderRec(Node root) {
		if (root != null) {
			System.out.print(root.data + " ");
			preOrderRec(root.left);
			preOrderRec(root.right);
		}
	}

	public void postOrderTraversal() {
		postOrderRec(root);
		System.out.println();
	}

	private void postOrderRec(Node root) {
		if (root != null) {
			postOrderRec(root.left);
			postOrderRec(root.right);
			System.out.print(root.data + " ");
		}
	}

	public int height() {
		return heightRec(root);
	}

	private int heightRec(Node root) {
		if (root == null) {
			return 0;
		}
		return 1 + Math.max(heightRec(root.left), heightRec(root.right));
	}

	public int size() {
		return sizeRec(root);
	}

	private int sizeRec(Node root) {
		if (root == null) {
			return 0;
		}
		return 1 + sizeRec(root.left) + sizeRec(root.right);
	}
}