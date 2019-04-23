package sorting.variationsOfBubblesort;

import java.util.Arrays;

public class main {
	public static void main(String[] args) {
		RecursiveBubbleSort<Integer> a = new RecursiveBubbleSort<>();
		Integer[] b = {1,1,1,1,1};
		a.sort(b);
		System.out.println(Arrays.toString(b));
	}
}
