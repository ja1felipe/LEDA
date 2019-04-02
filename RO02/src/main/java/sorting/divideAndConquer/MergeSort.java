package sorting.divideAndConquer;

import sorting.AbstractSorting;
import java.util.Arrays;

import java.util.List;

/**
 * Merge sort is based on the divide-and-conquer paradigm. The algorithm
 * consists of recursively dividing the unsorted list in the middle, sorting
 * each sublist, and then merging them into one single sorted list. Notice that
 * if the list has length == 1, it is already sorted.
 */
public class MergeSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if (leftIndex < rightIndex) {
			int m = (leftIndex + rightIndex) / 2;
			sort(array, leftIndex, m);
			sort(array, m + 1, rightIndex);
			merge(array, leftIndex, rightIndex);
		}
	}

	private void merge(T[] array, int leftIndex, int rightIndex) {
		int n = rightIndex - leftIndex;
		int m = n / 2;
		int i = 0;
		int j = m + 1;
		int k = leftIndex;

		T[] arrayAux = Arrays.copyOfRange(array, leftIndex, rightIndex + 1);
		while (i <= m && j <= n) {
			if (arrayAux[i].compareTo(arrayAux[j]) < 1) {
				array[k] = arrayAux[i];
				i++;
			} else {
				array[k] = arrayAux[j];
				j++;
			}
			k++;
		}
		while (i <= m) {
			array[k] = arrayAux[i];
			i++;
			k++;
		}
		while (j <= n) {
			array[k] = arrayAux[j];
			j++;
			k++;
		}
	}

}
