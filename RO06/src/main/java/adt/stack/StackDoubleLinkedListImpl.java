package adt.stack;

import adt.linkedList.DoubleLinkedList;
import adt.linkedList.DoubleLinkedListImpl;

public class StackDoubleLinkedListImpl<T> implements Stack<T> {

	protected DoubleLinkedList<T> top;
	protected int size;

	public StackDoubleLinkedListImpl(int size) {
		this.size = size;
		this.top = new DoubleLinkedListImpl<T>();
	}

	@Override
	public void push(T element) throws StackOverflowException {
		if(!this.isFull()){
			this.top.insert(element);
		}
		throw new StackOverflowException();

	}

	@Override
	public T pop() throws StackUnderflowException {
		if(!isEmpty()){
			T aux = this.top();
			this.top.removeLast();
			return aux;
		}
		throw new StackUnderflowException();
	}

	@Override
	public T top() {
		return (T) ((DoubleLinkedListImpl) this.top).getLast().getData();
	}

	@Override
	public boolean isEmpty() {
		return this.top.isEmpty();
	}

	@Override
	public boolean isFull() {
		return this.top.size() == this.size;
	}

}
