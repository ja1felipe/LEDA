package adt.queue;

public class QueueImpl<T> implements Queue<T> {

	private T[] array;
	private int tail;

	@SuppressWarnings("unchecked")
	public QueueImpl(int size) {
		this.array = (T[]) new Object[size];
		this.tail = -1;
	}

	@Override
	public T head() {
		if(!this.isEmpty()){
			return this.array[0];
		}return null;
	}

	@Override
	public boolean isEmpty() {
		if(this.tail == -1){
			return true;
		}return false;
	}

	@Override
	public boolean isFull() {
		if(this.tail == array.length-1){
			return true;
		}return false;
	}

	private void shiftLeft() {
		for (int i = 1; i < this.tail; i++){
			this.array[i-1] = this.array[i];
		}
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
		if(!this.isFull()){
			this.tail += 1;
			this.array[this.tail] = element;
		}else {
			throw new QueueOverflowException();
		}
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		if(!this.isEmpty()) {
			T dequeue = array[0];
			this.shiftLeft();
			return dequeue;
		}
		throw new QueueUnderflowException();
	}


}
