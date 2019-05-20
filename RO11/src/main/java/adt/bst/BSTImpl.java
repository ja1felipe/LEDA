package adt.bst;

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
	public int height() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	private int height(BSTNode<T> atual){
		if(atual.isEmpty()){
			return 0;
		}else{
			return 1 + max(height((BSTNode<T>) atual.getLeft()), height((BSTNode<T>) atual.getRight()));
		}
	}

	private int max(int a, int b){
		return (a < b) ? b : a;
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
		return null;
	}

	@Override
	public void insert(T element) {
		BSTNode<T> aux = this.getRoot();
		if(this.isEmpty()){
			this.insert(aux, element);
		}else if(aux.getData().equals(element)){
			return;
		}else{
			if(aux.getData().compareTo(element) > 0){
				aux = (BSTNode<T>) aux.getLeft();
				this.insert(aux, element);
			}else if(aux.getData().compareTo(element) < 0){
				aux = (BSTNode<T>) aux.getRight();
				this.insert(aux, element);
			}
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
		if(!this.isEmpty()){
			BSTNode<T> aux = this.getRoot();
			while(!aux.getRight().isEmpty()){
				aux = (BSTNode<T>) aux.getRight();
			}
			return aux;
		}
		return null;
	}

	@Override
	public BSTNode<T> minimum() {
		if(!this.isEmpty()){
			BSTNode<T> aux = this.getRoot();
			while(!aux.getLeft().isEmpty()){
				aux = (BSTNode<T>) aux.getLeft();
			}
			return aux;
		}
		return null;
	}

	@Override
	public BSTNode<T> sucessor(T element) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public BSTNode<T> predecessor(T element) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public void remove(T element) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public T[] preOrder() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public T[] order() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public T[] postOrder() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
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
