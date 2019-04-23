package sorting.variationsOfBubblesort;

import sorting.AbstractSorting;

public class RecursiveBubbleSort<T extends Comparable<T>> extends
		AbstractSorting<T> {

	/**
	 * Implementação recursiva do bubble sort. Você deve implementar apenas esse
	 * método sem usar nenhum outro método auxiliar (exceto
	 * Util.swap(array,int,int)). Para isso, tente definir o caso base do
	 * algoritmo e depois o caso indutivo, que reduz o problema para uma entrada
	 * menor em uma chamada recursiva. Seu algoritmo deve ter complexidade
	 * quadrática O(n^2).
	 */
	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		this.ordena(array, leftIndex, rightIndex);
	}

	private void ordena(T[] array, int i, int x){
		if(x == 0){
			return;
		}
		if(array[i].compareTo(array[i+1]) > 0){
			this.swap(array, i, i+1);
		}
		if(i+1 == x){
			this.ordena(array, 0, x-1);
		}else{
			this.ordena(array, i+1, x);
		}
	}

	private void swap(T[] array, int i, int j){
		T temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
}
