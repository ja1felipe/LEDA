package adt.linkedList;

public class main {

	public static void main(String[] args) {
		DoubleLinkedListImpl<Integer> teste = new DoubleLinkedListImpl<>();
		teste.insertFirst(2);
		System.out.println(teste.getHead());

	}
}
