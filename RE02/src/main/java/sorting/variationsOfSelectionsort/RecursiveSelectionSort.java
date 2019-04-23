package sorting.variationsOfSelectionsort;

import sorting.AbstractSorting;

public class RecursiveSelectionSort<T extends Comparable<T>> extends
		AbstractSorting<T> {

	/**
	 * Implementação recursiva do selection sort. Você deve implementar apenas
	 * esse método sem usar nenhum outro método auxiliar (exceto
	 * Util.swap(array,int,int)). Para isso, tente definir o caso base do
	 * algoritmo e depois o caso indutivo, que reduz o problema para uma entrada
	 * menor em uma chamada recursiva. Seu algoritmo deve ter complexidade
	 * quadrática O(n^2).
	 */
	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		this.ordena(array,leftIndex,rightIndex,0);
	}

	private void ordena(T[] array, int index, int k, int menor){
		if(k == 0){
			return;
		}
		if(index == array.length){
			this.swap(array, menor, array.length - k - 1);
			this.ordena(array, array.length -k, k-1, array.length - k);
		}else {
			if (array[index].compareTo(array[menor]) < 0) {
				menor = index;
			}
			this.ordena(array, ++index, k, menor);
		}
	}

	private void swap(T[] array, int i, int i1) {
		T temp = array[i];
		array[i] = array[i1];
		array[i1] = temp;
	}
}
