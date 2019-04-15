package adt.stack;

public class StackImpl<T> implements Stack<T> {

	private T[] array;
	private int top;
	private int size;

	@SuppressWarnings("unchecked")
	public StackImpl(int size) {
		this.array = (T[]) new Object[size];
		this.top = -1;
		this.size = size;
	}

	@Override
	public T top() {
		return this.array[this.top];
	}

	@Override
	public boolean isEmpty() {
		if(this.top == -1){
			return true;
		}return  false;
	}

	@Override
	public boolean isFull() {
		if(this.top == size-1){
			return true;
		}return  false;
	}

	@Override
	public void push(T element) throws StackOverflowException {
		if(!this.isFull()){
			this.top += 1;
			this.array[this.top] = element;

		}else {
			throw new StackOverflowException();
		}

	}

	@Override
	public T pop() throws StackUnderflowException {
		if(this.isEmpty()){
			throw new StackUnderflowException();
		}
		T pop = this.array[this.top];
		this.top -= 1;
		return pop;
	}

}
