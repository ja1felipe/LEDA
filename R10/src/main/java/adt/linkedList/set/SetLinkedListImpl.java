package adt.linkedList.set;

import adt.linkedList.SingleLinkedListImpl;

public class SetLinkedListImpl<T> extends SingleLinkedListImpl<T> implements SetLinkedList<T> {

	@Override
	public void removeDuplicates() {
		T[] aux = this.toArray();
		int i = aux.length-1;
		int j = i-1;
		while(i > 0){
			while(j > 0){
				if(aux[i].equals(aux[j])){
					this.remove(aux[i]);
					break;
				}
				j--;
			}
			i--;
			j = i-1;
		}
	}

	@Override
	public SetLinkedList<T> union(SetLinkedList<T> otherSet) {
		SetLinkedListImpl<T> aux = new SetLinkedListImpl<>();
		T[] a = this.toArray();
		for(T elem : a){
			aux.insert(elem);
		}

		T[] b = otherSet.toArray();
		for(T elem : b){
			if(aux.search(elem) == null){
				aux.insert(elem);
			}
		}
		return aux;
	}

	@Override
	public SetLinkedList<T> intersection(SetLinkedList<T> otherSet) {
		SetLinkedListImpl<T> aux = new SetLinkedListImpl<>();
		T[] a = this.toArray();
		for(T elem : a){
			if(otherSet.search(elem) != null){
				aux.insert(elem);
			}
		}

		T[] b = otherSet.toArray();
		for(T elem : b){
			if(this.search(elem) != null && aux.search(elem) == null){
				aux.insert(elem);
			}
		}
		return aux;
	}

	@Override
	public void concatenate(SetLinkedList<T> otherSet) {
		T[] a = otherSet.toArray();
		for(T elem : a){
			if(this.search(elem) == null){
				this.insert(elem);
			}
		}
	}

}
