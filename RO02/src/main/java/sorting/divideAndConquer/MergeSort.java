package sorting.divideAndConquer;

import sorting.AbstractSorting;

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
		if(rightIndex < 2){
			return;
		}

		int m = rightIndex / 2;
		T[] A = (T[]) new Object[m];
		T[] B = (T[]) new Object[rightIndex - m];

		for (int i = 0; i < m; i++){
			A[i] = array[i];
		}

		for (int i = m; i < rightIndex; i++){
			B[i - m] = array[i];
		}

		sort(A, 0, m);
		sort(B,rightIndex - m, rightIndex);

		merge(A, B);
	}

	public T[] merge(T[] A, T[] B){
		T[] resultado = (T[]) new Object[A.length + B.length];
		int i = 0;
		int a = 0;
		int b = 0;
		while (a < A.length && b < B.length) {
			if (A[a].compareTo(B[b]) < 0) {
				resultado[i] = A[a];
				a++;
				i++;
			} else {
				resultado[i] = B[b];
				b++;
				i++;
			}
		}
		if(a < A.length){
			for (int j = a; a < A.length; j++){
				resultado[i] = A[j];
				i++;
			}
		}
		if(b < B.length){
			for (int j = b; b < B.length; j++){
				resultado[i] = B[j];
				i++;
			}
		}
		return resultado;
	}

}
