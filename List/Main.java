public class Main {
	public static void main(String[] args) {
		MyList<String> list = new MyList<>();
		
		System.out.println("Добавляем элементы в список:");
		list.add("Первый");
		list.add("Второй");
		list.add("Третий");
		System.out.println("Список: " + list);
		
		System.out.println("\nДобавляем элемент по индексу 1:");
		list.add(1, "Новый элемент");
		System.out.println("Список: " + list);
		
		System.out.println("\nПолучаем элемент по индексу 2: " + list.get(2));
		
		System.out.println("\nЗаменяем элемент по индексу 0:");
		String oldValue = list.set(0, "Замененный");
		System.out.println("Старое значение: " + oldValue);
		System.out.println("Список: " + list);
		
		System.out.println("\nУдаляем элемент по индексу 3:");
		String removed = list.remove(3);
		System.out.println("Удаленный элемент: " + removed);
		System.out.println("Список: " + list);
		
		System.out.println("\nУдаляем элемент по значению 'Второй':");
		boolean isRemoved = list.remove("Второй");
		System.out.println("Элемент удален? " + isRemoved);
		System.out.println("Список: " + list);
		
		System.out.println("\nРазмер списка: " + list.size());
		System.out.println("Список пуст? " + list.isEmpty());
		System.out.println("Содержит 'Третий'? " + list.contains("Третий"));
		System.out.println("Индекс 'Новый элемент': " + list.indexOf("Новый элемент"));
		
		System.out.println("\nОчищаем список:");
		list.clear();
		System.out.println("Список: " + list);
		System.out.println("Размер списка: " + list.size());
	}
}