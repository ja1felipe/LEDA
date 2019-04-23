package sorting.divideAndConquer;

import java.util.Arrays;

public class main {
	public static void main(String[] args) {
		QuickSortComMediana<Integer> a = new QuickSortComMediana<>();
		Integer[] b = {6,5,4,3,2,1,4};
		a.sort(b);
		System.out.println(Arrays.toString(b));
	}
}
