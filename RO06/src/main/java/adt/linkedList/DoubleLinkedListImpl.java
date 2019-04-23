package adt.linkedList;

public class DoubleLinkedListImpl<T> extends SingleLinkedListImpl<T> implements
		DoubleLinkedList<T> {

	protected DoubleLinkedListNode<T> last;
	private DoubleLinkedListNode<T> head;

	public DoubleLinkedListImpl() {
		this.head = new DoubleLinkedListNode<>();
		this.last = new DoubleLinkedListNode<>();

	}

	@Override
	public void insertFirst(T element) {
		DoubleLinkedListNode<T> newHead = new DoubleLinkedListNode<>(element, this.head, new DoubleLinkedListNode<>());
		DoubleLinkedListNode<T> auxHead = this.head;
		if(this.head.isNIL()){
			this.head = newHead;
		}else{
			while(!auxHead.previous.isNIL()){
				auxHead = auxHead.previous;
			}
			auxHead.previous = new DoubleLinkedListNode<>(element, auxHead, new DoubleLinkedListNode<>());
			this.head = auxHead.previous;
		}
	}

	@Override
	public void insert(T element) {
		DoubleLinkedListNode<T> newLast = new DoubleLinkedListNode<>(element, new DoubleLinkedListNode<>(), this.last);
		DoubleLinkedListNode<T> auxLast = this.last;
		if(this.head.isNIL()){
			this.head = newLast;
			this.last = this.head;
		}else{
			while(!auxLast.next.isNIL()){
				auxLast = (DoubleLinkedListNode<T>) auxLast.next;
			}
			auxLast.next = new DoubleLinkedListNode<>(element, new DoubleLinkedListNode<>(), auxLast);
			this.last = (DoubleLinkedListNode<T>) auxLast.next;
		}
	}

	@Override
	public void removeFirst() {
		this.head = (DoubleLinkedListNode<T>) this.head.next;
		this.head.previous = new DoubleLinkedListNode<>();
	}

	@Override
	public void removeLast() {
		this.last = this.last.previous;
		this.last.next = new DoubleLinkedListNode<>();
	}

	public DoubleLinkedListNode<T> getLast() {
		return this.last;
	}

	public void setLast(DoubleLinkedListNode<T> last) {
		this.last = last;
	}

}
