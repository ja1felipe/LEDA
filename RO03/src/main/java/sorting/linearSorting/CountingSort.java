package sorting.linearSorting;

import sorting.AbstractSorting;

/**
 * Classe que implementa a estratégia de Counting Sort vista em sala. Procure
 * evitar desperdicio de memoria alocando o array de contadores com o tamanho
 * sendo o máximo inteiro presente no array a ser ordenado.
 * 
 */
public class CountingSort extends AbstractSorting<Integer> {

   @Override
   public void sort(Integer[] array, int leftIndex, int rightIndex) {

      if (this.valida(array, leftIndex, rightIndex)) {

         Integer[] novo = new Integer[array.length];
         int max = 0;
         for (Integer n : array) {
            if (n > max) {
               max = n;
            }
         }
         Integer[] freq = new Integer[max + 1];

         for (int i = 0; i < max + 1; i++) {
            freq[i] = 0;
         }

         for (int i = leftIndex; i <= rightIndex; i++) {
            freq[array[i]] += 1;
         }
         for (int j = 1; j <= max; j++) {
            freq[j] += freq[j - 1];
         }

         for (int i = rightIndex; i >= 0; i--) {
            freq[array[i]]--;
            novo[freq[array[i]]] = array[i];
         }

         for (int i = leftIndex; i <= rightIndex; i++) {
            array[i] = novo[i];
         }
      }
      return;
   }

   private boolean valida(Integer[] arr, int l, int r) {
      if (arr == null) {
         return false;
      }
      if (l < 0 || l > r) {
         return false;
      }
      if (r > arr.length) {
         return false;
      }
      return true;
   }

}
