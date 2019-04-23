package adt.queue;

import adt.linkedList.DoubleLinkedList;
import adt.linkedList.DoubleLinkedListImpl;

public class QueueDoubleLinkedListImpl<T> implements Queue<T> {

	protected DoubleLinkedList<T> list;
	protected int size;

	public QueueDoubleLinkedListImpl(int size) {
		this.size = size;
		this.list = new DoubleLinkedListImpl<T>();
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
		if(!this.isFull()){
			this.list.insert(element);
		}
		throw new QueueOverflowException();
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		if(!this.isEmpty()){
			T aux = this.head();
			this.list.removeFirst();
			return aux;
		}
		throw new QueueUnderflowException();
	}

	@Override
	public T head() {
		T head = null;
		if (!isEmpty()) {
			head = ((DoubleLinkedListImpl<T>) this.list).getHead().getData();
		}
		return head;
	}

	@Override
	public boolean isEmpty() {
		return this.list.isEmpty();
	}

	@Override
	public boolean isFull() {
		return this.list.size() == this.size;
	}

}
