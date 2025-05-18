public class Main {
	public static void main(String[] args) {
		MySet<String> set = new MySet<>();
		
		System.out.println("Добавляем элементы в множество:");
		System.out.println("Добавлен 'Apple': " + set.add("Apple"));
		System.out.println("Добавлен 'Banana': " + set.add("Banana"));
		System.out.println("Добавлен 'Apple' (повторно): " + set.add("Apple"));
		System.out.println("Множество: " + set);
		
		System.out.println("\nПроверка содержимого:");
		System.out.println("Содержит 'Apple': " + set.contains("Apple"));
		System.out.println("Содержит 'Orange': " + set.contains("Orange"));
		
		System.out.println("\nРазмер множества: " + set.size());
		
		System.out.println("\nУдаляем элементы:");
		System.out.println("Удален 'Banana': " + set.remove("Banana"));
		System.out.println("Удален 'Mango': " + set.remove("Mango"));
		System.out.println("Множество после удаления: " + set);
		
		System.out.println("\nИтерация по множеству:");
		for (String fruit : set) {
			System.out.println(fruit);
		}
		
		System.out.println("\nОчищаем множество:");
		set.clear();
		System.out.println("Множество пусто? " + set.isEmpty());
		System.out.println("Множество: " + set);
	}
}