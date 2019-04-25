package adt.linkedList;

import java.util.ArrayList;

public class RecursiveSingleLinkedListImpl<T> implements LinkedList<T> {

	protected T data;
	protected RecursiveSingleLinkedListImpl<T> next;

	public RecursiveSingleLinkedListImpl() {
		this.data = null;
		this.next = null;

	}


	@Override
	public boolean isEmpty() {
		return this.getData() == null;
	}

	@Override
	public int size() {
		if(!this.isEmpty()){
			return 1+this.getNext().size();
		}
		return 0;
	}

	@Override
	public T search(T element) {
		if(!this.isEmpty()) {
			if (this.getData().equals(element)) {
				return element;
			}else{
				return this.getNext().search(element);
			}
		}
		return null;
	}

	@Override
	public void insert(T element) {
		if(element != null) {
			if (this.isEmpty()) {
				this.setData(element);
				this.setNext(new RecursiveSingleLinkedListImpl<T>());
			} else {
				this.getNext().insert(element);
			}
		}
	}

	@Override
	public void remove(T element) {
		if(element != null) {
			if (this.getData().equals(element)) {
				this.setData(this.getNext().getData());
				this.setNext(this.getNext().getNext());
			}else{
				this.getNext().remove(element);
			}
		}
	}

	@Override
	public T[] toArray() {
		ArrayList<T> array = new ArrayList<>();
		addArray(array, this);
		return (T[]) array.toArray();
	}

	private void addArray(ArrayList<T> array, RecursiveSingleLinkedListImpl<T> node){
		if(!node.isEmpty()){
			array.add(node.getData());
			addArray(array, node.getNext());
		}
	}

	public T getData() {
		return this.data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public RecursiveSingleLinkedListImpl<T> getNext() {
		return this.next;
	}

	public void setNext(RecursiveSingleLinkedListImpl<T> next) {
		this.next = next;
	}

}
