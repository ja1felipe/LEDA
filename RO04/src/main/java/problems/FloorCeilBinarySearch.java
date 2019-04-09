package problems;

/**
 * Calcula o floor e ceil de um numero em um array usando a estrategia de busca
 * binaria.
 * 
 * Restricoes: 
 * - Algoritmo in-place (nao pode usar memoria extra a nao ser variaveis locais) 
 * - O tempo de seu algoritmo deve ser O(log n).
 * 
 * @author Adalberto
 *
 */
public class FloorCeilBinarySearch implements FloorCeil {

	@Override
	public Integer floor(Integer[] array, Integer x) {
		int i = 0;
		int j = (array.length - 1) / 2;
		while (i < j) {
			if (array[j] == x) {//[1, 2, 3, 4, 5, 6, 7]
				return array[j];
			}
			if (j - i == 1) {
				return array[i];
			}
			if (x > array[j]) { // x > array[j]
				i = j;
				j = ((array.length - 1) + j) / 2;
			}
			if (x < array[j]) { // x < array[j]
				i = j / 2;
			}
		}
		return null;
	}

	@Override
	public Integer ceil(Integer[] array, Integer x) {
		int i = 0;
		int j = (array.length - 1) / 2;
		while (i < j) {
			if (array[j] == x) {//[1, 2, 3, 4, 5, 6, 7]
				return array[j];
			}
			if (j - i == 1) {
				return array[j];
			}
			if (x > array[j]) { // x > array[j]
				i = j;
				j = ((array.length - 1) + j) / 2;
			}
			if (x < array[j]) { // x < array[j]
				i = j / 2;
			}
		}
		return null;
	}

}
