package sorting.linearSorting;

import sorting.AbstractSorting;

/**
 * Classe que implementa do Counting Sort vista em sala. Desta vez este
 * algoritmo deve satisfazer os seguitnes requisitos: - Alocar o tamanho minimo
 * possivel para o array de contadores (C) - Ser capaz de ordenar arrays
 * contendo numeros negativos
 */
public class ExtendedCountingSort extends AbstractSorting<Integer> {

	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {

		if (this.valida(array,leftIndex,rightIndex)) {

			Integer[] novo = new Integer[array.length];

			int max = Integer.MIN_VALUE;
			int min = Integer.MAX_VALUE;
			for (Integer n : array) {
				if (n > max) {
					max = n;
				}
				if(n < min){
					min = n;
				}
			}

			if(min > 0){
				min = 0;
			}else{
				min = Math.abs(min);
			}

			Integer[] freq = new Integer[max + min + 1];

			for (int i = 0; i < max + min + 1; i++) {
				freq[i] = 0;
			}

			for (int i = leftIndex; i <= rightIndex; i++) {
				freq[array[i]+min] += 1;
			}
			for (int j = 1; j <= max + min; j++) {
				freq[j] += freq[j - 1];
			}

			for (int i = rightIndex; i >= 0; i--) {
				freq[array[i]+min]--;
				novo[freq[array[i]+min]] = array[i];
			}

			for (int i = leftIndex; i <= rightIndex; i++) {
				array[i] = novo[i];
			}
		}
		return;
	}

	private boolean valida(Integer[] arr, int l, int r){
		if(arr == null){return false;}
		if(l < 0 || l > r){return false;}
		if(r > arr.length){return false;}
		return true;
	}

}
