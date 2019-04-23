package sorting.variationsOfSelectionsort;

import java.util.Arrays;

public class main {
	public static void main(String[] args) {
		RecursiveSelectionSort<Integer> a = new RecursiveSelectionSort<>();
		Integer[] b = {1,2,3,4,7,6,5,4,2};
		a.sort(b);
		System.out.println(Arrays.toString(b));
	}
}
