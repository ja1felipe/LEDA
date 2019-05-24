package adt.bst;

import java.util.ArrayList;

public class BSTImpl<T extends Comparable<T>> implements BST<T> {

	protected BSTNode<T> root;

	public BSTImpl() {
		root = new BSTNode<T>();
	}

	public BSTNode<T> getRoot() {
		return this.root;
	}

	@Override
	public boolean isEmpty() {
		return root.isEmpty();
	}

	@Override
	public int height(){
		return height(this.getRoot());
	}

	private int height(BSTNode<T> curr) {
		if (curr.isEmpty()) {
			return -1;
		} else {
			int tam;
			int r = height((BSTNode<T>) curr.getRight());
			int l = height((BSTNode<T>) curr.getLeft());
			if (r >= l) {
				tam = r;
			} else {
				tam = l;
			}
			return 1 + tam;
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
					if (aux.getData().compareTo(element) > 0) {
						aux = (BSTNode<T>) aux.getLeft();
					} else if (aux.getData().compareTo(element) < 0) {
						aux = (BSTNode<T>) aux.getRight();
					}
				}
				return aux;
			}
		}
		return this.getRoot();
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
			if(atual.getData().compareTo(element) > 0){
				atual = (BSTNode) atual.getLeft();
				this.insert(atual, element);
			}else if(atual.getData().compareTo(element) < 0){
				atual = (BSTNode) atual.getRight();
				this.insert(atual, element);
			}
		}
	}

	@Override
	public BSTNode<T> maximum() {
		return this.maximum(this.getRoot());
	}

	private BSTNode<T> maximum(BSTNode<T> atual) {
		if (this.getRoot().isEmpty()) {
			return null;
		} else if (atual.getRight().isEmpty()) {
			return atual;
		} else {
			return this.maximum((BSTNode<T>) atual.getRight());
		}
	}


	@Override
	public BSTNode<T> minimum() {
		return this.minimum(this.getRoot());
	}

	private BSTNode<T> minimum(BSTNode<T> atual) {
		if (this.getRoot().isEmpty()) {
			return null;
		} else if (atual.getLeft().isEmpty()) {
			return atual;
		} else {
			return this.minimum((BSTNode<T>) atual.getLeft());
		}
	}

	@Override
	public BSTNode<T> sucessor(T element) {
		BSTNode<T> node = this.search(element);
		if (element == null || this.getRoot().isEmpty() || node.isEmpty()) {
			return null;
		} else if (!node.getRight().isEmpty()) {
			return this.minimum((BSTNode<T>) node.getRight());
		} else {
			return this.sucessor(element, node);
		}
	}

	protected BSTNode<T> sucessor(T element, BSTNode<T> node) {
		if (node.getParent().isEmpty()) {
			return null;
		} else if (!node.getParent().isEmpty() && (node.getParent().getData().compareTo(element) < 0)) {
			return this.sucessor(element, (BSTNode<T>) node.getParent());
		} else {
			return (BSTNode<T>) node.getParent();
		}
	}

	@Override
	public BSTNode<T> predecessor(T element) {
		BSTNode<T> node = this.search(element);
		if (element == null || this.getRoot().isEmpty() || node.isEmpty()) {
			return null;
		} else if (!node.getLeft().isEmpty()) {
			return this.maximum((BSTNode<T>) node.getLeft());
		} else {
			return this.predecessor(element, node);
		}
	}

	protected BSTNode<T> predecessor(T element, BSTNode<T> node) {
		if (node.getParent() == null) {
			return null;
		} else if (node.getParent() != null && (node.getParent().getData().compareTo(element) > 0)) {
			return this.predecessor(element, (BSTNode<T>) node.getParent());
		} else {
			return (BSTNode<T>) node.getParent();
		}
	}

	@Override
	public void remove(T element) {
		BSTNode<T> node = search(element);
		if(!node.isEmpty()){
			remove(node);
		}
	}

	private void remove(BSTNode<T> node){
		if(!node.isEmpty()){
			if(node.isLeaf()){
				node.setData(null);
			}else if((node.getLeft().isEmpty() && !node.getRight().isEmpty()) || (!node.getLeft().isEmpty() && node.getRight().isEmpty())){
				if(node != root){
					if(node.getParent().getLeft().equals(node)){
						if(!node.getLeft().isEmpty()) {
							node.getParent().setLeft(node.getLeft());
							node.getLeft().setParent(node.getParent());
						}else{
							node.getParent().setLeft(node.getRight());
							node.getRight().setParent(node.getParent());
						}
					}else{
						if(!node.getLeft().isEmpty()){
							node.getParent().setRight(node.getLeft());
							node.getLeft().setParent(node.getParent());
						}else{
							node.getParent().setRight(node.getRight());
							node.getRight().setParent(node.getParent());
						}
					}
				}else {
					if(node.getRight().isEmpty()){
						root = (BSTNode<T>) node.getLeft();
					}else {
						root = (BSTNode<T>) node.getRight();
					}
				}
			}else{
				BSTNode<T> sucessor = sucessor(node.getData());
				node.setData(sucessor.getData());
				remove(sucessor);
			}
		}
	}


	@Override
	public T[] preOrder() {
		ArrayList<T> arr = new ArrayList<T>();
		this.preOrder(this.root, arr);
		int size = arr.size();
		T[] res = (T[])new Comparable[size];

		for (int i = 0; i < size; i++) {
			res[i] = arr.get(i);
		}

		return res;
	}

	private void preOrder(BSTNode<T> node, ArrayList<T> arr) {
		if (node.isEmpty()) {
			return;
		}
		arr.add(node.getData());
		this.preOrder((BSTNode<T>)node.getLeft(), arr);
		this.preOrder((BSTNode<T>)node.getRight(), arr);
	}

	@Override
	public T[] order() {
		ArrayList<T> arr = new ArrayList<T>();
		this.order(this.root, arr);
		int size = arr.size();
		T[] res = (T[])new Comparable[size];
		for (int i = 0; i < size; i++) {
			res[i] = arr.get(i);
		}

		return res;
	}

	private void order(BSTNode<T> node, ArrayList<T> arr) {
		if (node.isEmpty()) {
			return;
		}
		this.order((BSTNode<T>)node.getLeft(), arr);
		arr.add(node.getData());
		this.order((BSTNode<T>)node.getRight(), arr);
	}

	@Override
	public T[] postOrder() {
		ArrayList<T> arr = new ArrayList<T>();
		this.postOrder(this.root, arr);
		int size = arr.size();
		T[] res = (T[])new Comparable[size];

		for (int i = 0; i < size; i++) {
			res[i] = arr.get(i);
		}
		return res;
	}

	private void postOrder(BSTNode<T> node, ArrayList<T> arr) {
		if (node.isEmpty()) return;

		this.postOrder((BSTNode<T>)node.getLeft(), arr);
		this.postOrder((BSTNode<T>)node.getRight(), arr);
		arr.add(node.getData());
	}

	/**
	 * This method is already implemented using recursion. You must understand
	 * how it work and use similar idea with the other methods.
	 */
	@Override
	public int size() {
		return size(root);
	}

	private int size(BSTNode<T> node) {
		int result = 0;
		// base case means doing nothing (return 0)
		if (!node.isEmpty()) { // indusctive case
			result = 1 + size((BSTNode<T>) node.getLeft())
					+ size((BSTNode<T>) node.getRight());
		}
		return result;
	}

}
