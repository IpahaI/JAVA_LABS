import java.util.Arrays;
import java.util.Random;

public class SortingComparison {

	// Быстрая сортировка (Quick Sort)
	public static void quickSort(int[] arr, int low, int high) {
		if (low < high) {
			int pi = partition(arr, low, high);
			quickSort(arr, low, pi - 1);
			quickSort(arr, pi + 1, high);
		}
	}

	private static int partition(int[] arr, int low, int high) {
		int pivot = arr[high];
		int i = low - 1;
		
		for (int j = low; j < high; j++) {
			if (arr[j] < pivot) {
					i++;
					swap(arr, i, j);
			}
		}
		swap(arr, i + 1, high);
		return i + 1;
	}

	// Сортировка слиянием (Merge Sort)
	public static void mergeSort(int[] arr, int left, int right) {
		if (left < right) {
			int mid = left + (right - left) / 2;
			mergeSort(arr, left, mid);
			mergeSort(arr, mid + 1, right);
			merge(arr, left, mid, right);
		}
	}

	private static void merge(int[] arr, int left, int mid, int right) {
		int n1 = mid - left + 1;
		int n2 = right - mid;

		int[] L = new int[n1];
		int[] R = new int[n2];

		System.arraycopy(arr, left, L, 0, n1);
		System.arraycopy(arr, mid + 1, R, 0, n2);

		int i = 0, j = 0, k = left;
		while (i < n1 && j < n2) {
			if (L[i] <= R[j]) {
					arr[k] = L[i];
					i++;
			} else {
					arr[k] = R[j];
					j++;
			}
			k++;
		}

		while (i < n1) {
			arr[k] = L[i];
			i++;
			k++;
		}

		while (j < n2) {
			arr[k] = R[j];
			j++;
			k++;
		}
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void main(String[] args) {
		// Тестирование на небольших массивах (100 элементов)
		int[] smallArray = generateRandomArray(100);
		int[] smallArrayCopy = Arrays.copyOf(smallArray, smallArray.length);
		
		System.out.println("Сортировка небольших массивов (100 элементов):");
		
		long start = System.nanoTime();
		quickSort(smallArray, 0, smallArray.length - 1);
		long end = System.nanoTime();
		System.out.println("Быстрая сортировка: " + (end - start) + " нс");
		
		start = System.nanoTime();
		mergeSort(smallArrayCopy, 0, smallArrayCopy.length - 1);
		end = System.nanoTime();
		System.out.println("Сортировка слиянием: " + (end - start) + " нс");
		
		// Тестирование на средних массивах (10,000 элементов)
		int[] mediumArray = generateRandomArray(10_000);
		int[] mediumArrayCopy = Arrays.copyOf(mediumArray, mediumArray.length);
		
		System.out.println("\nСортировка средних массивов (10,000 элементов):");
		
		start = System.nanoTime();
		quickSort(mediumArray, 0, mediumArray.length - 1);
		end = System.nanoTime();
		System.out.println("Быстрая сортировка: " + (end - start) / 1_000_000 + " мс");
		
		start = System.nanoTime();
		mergeSort(mediumArrayCopy, 0, mediumArrayCopy.length - 1);
		end = System.nanoTime();
		System.out.println("Сортировка слиянием: " + (end - start) / 1_000_000 + " мс");
		
		// Тестирование на крупных массивах (1,000,000 элементов)
		int[] largeArray = generateRandomArray(1_000_000);
		int[] largeArrayCopy = Arrays.copyOf(largeArray, largeArray.length);
		
		System.out.println("\nСортировка крупных массивов (1,000,000 элементов):");
		
		start = System.nanoTime();
		quickSort(largeArray, 0, largeArray.length - 1);
		end = System.nanoTime();
		System.out.println("Быстрая сортировка: " + (end - start) / 1_000_000 + " мс");
		
		start = System.nanoTime();
		mergeSort(largeArrayCopy, 0, largeArrayCopy.length - 1);
		end = System.nanoTime();
		System.out.println("Сортировка слиянием: " + (end - start) / 1_000_000 + " мс");
	}

	private static int[] generateRandomArray(int size) {
		int[] arr = new int[size];
		Random random = new Random();
		for (int i = 0; i < size; i++) {
			arr[i] = random.nextInt(size * 10);
		}
		return arr;
	}
}