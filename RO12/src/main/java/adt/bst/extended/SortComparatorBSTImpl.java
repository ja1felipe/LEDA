package adt.bst.extended;

import java.util.ArrayList;
import java.util.Comparator;

import adt.bst.BSTImpl;
import adt.bst.BSTNode;

/**
 * Implementacao de SortComparatorBST, uma BST que usa um comparator interno em suas funcionalidades
 * e possui um metodo de ordenar um array dado como parametro, retornando o resultado do percurso
 * desejado que produz o array ordenado. 
 * 
 * @author Adalberto
 *
 * @param <T>
 */
public class  SortComparatorBSTImpl<T extends Comparable<T>> extends BSTImpl<T> implements SortComparatorBST<T> {

	private Comparator<T> comparator;
	
	public SortComparatorBSTImpl(Comparator<T> comparator) {
		super();
		this.comparator = comparator;
	}

	@Override
	public T[] sort(T[] array) {
		for(T elem : array){
			this.insert(elem);
		}

		return this.order();
	}

	@Override
	public T[] reverseOrder() {
		ArrayList<T> arr = new ArrayList<T>();
		this.reverseOrder(this.root, arr);
		int size = arr.size();
		T[] res = (T[])new Comparable[size];
		for (int i = 0; i < size; i++) {
			res[i] = arr.get(i);
		}

		return res;
	}

	private void reverseOrder(BSTNode<T> node, ArrayList<T> arr){
		if (node.isEmpty()) {
			return;
		}
		this.reverseOrder((BSTNode<T>)node.getRight(), arr);
		arr.add(node.getData());
		this.reverseOrder((BSTNode<T>)node.getLeft(), arr);
	}

	@Override
	public void insert(T element) {
		if(element != null){
			insert(this.root, element);
		}
	}

	private void insert(BSTNode<T> atual, T element){
		if(atual.isEmpty()){
			atual.setData(element);
			atual.setLeft(new BSTNode.Builder<T>().data(null).left(null).right(null).parent(atual).build());
			atual.setRight(new BSTNode.Builder<T>().data(null).left(null).right(null).parent(atual).build());
		}else{
			if(comparator.compare(element, atual.getData()) < 0){
				atual = (BSTNode) atual.getLeft();
				this.insert(atual, element);
			}else if(comparator.compare(element, atual.getData()) > 0){
				atual = (BSTNode) atual.getRight();
				this.insert(atual, element);
			}
		}
	}

	@Override
	public BSTNode<T> search(T element) {
		if (!this.isEmpty()) {
			BSTNode<T> aux = this.getRoot();
			if (aux.getData().equals(element)) {
				return this.getRoot();
			} else {
				while (!aux.isEmpty() && !aux.getData().equals(element)) {
					if (comparator.compare(element, aux.getData()) < 0) {
						aux = (BSTNode<T>) aux.getLeft();
					} else if (comparator.compare(element, aux.getData()) > 0) {
						aux = (BSTNode<T>) aux.getRight();
					}
				}
				return aux;
			}
		}
		return this.getRoot();
	}

	public Comparator<T> getComparator() {
		return comparator;
	}

	public void setComparator(Comparator<T> comparator) {
		this.comparator = comparator;
	}
	
}
