package orderStatistic;

import problems.FloorCeil;
import problems.FloorCeilBinarySearch;

public class main {

	public static void main(String[] args) {
		OrderStatistics<Integer> oi = new OrderStatisticsSelectionImpl<>();
		Integer[] array = {1,2,4,5,6,7};
		FloorCeil a = new FloorCeilBinarySearch();
		System.out.println(a.floor(array, 3));
	}
}
