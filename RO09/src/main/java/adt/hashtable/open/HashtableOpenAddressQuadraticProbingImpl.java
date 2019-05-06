package adt.hashtable.open;

import adt.hashtable.hashfunction.HashFunctionClosedAddressMethod;
import adt.hashtable.hashfunction.HashFunctionQuadraticProbing;

public class HashtableOpenAddressQuadraticProbingImpl<T extends Storable>
		extends AbstractHashtableOpenAddress<T> {

	public HashtableOpenAddressQuadraticProbingImpl(int size,
			HashFunctionClosedAddressMethod method, int c1, int c2) {
		super(size);
		hashFunction = new HashFunctionQuadraticProbing<T>(size, method, c1, c2);
		this.initiateInternalTable(size);
	}

	@Override
	public void insert(T element) {
		if(element != null){
			int probe = 0;
			int index = ((HashFunctionQuadraticProbing<T>) this.hashFunction).hash(element, probe);
			while(this.table[index] != null){
				if(probe == this.table.length){
					throw new HashtableOverflowException();
				}
				probe += 1;
				this.COLLISIONS += 1;
				index = ((HashFunctionQuadraticProbing<T>) this.hashFunction).hash(element, probe);
			}
			this.table[index] = element;
			this.elements += 1;
		}
	}

	@Override
	public void remove(T element) {
		if(element != null){
			int probe = 0;
			int index = ((HashFunctionQuadraticProbing<T>) this.hashFunction).hash(element, probe);
			while(this.table[index] != null){
				if(probe == this.table.length){
					throw new HashtableOverflowException();
				}
				if(this.table[index].equals(element)){
					this.table[index] = null;
					this.elements -= 1;
					return;
				}
				probe += 1;
				this.COLLISIONS -= 1;
				index = ((HashFunctionQuadraticProbing<T>) this.hashFunction).hash(element, probe);
			}
		}
	}

	@Override
	public T search(T element) {
		if(element != null){
			int probe = 0;
			int index = ((HashFunctionQuadraticProbing<T>) this.hashFunction).hash(element, probe);
			while(this.table[index] != null){
				if(probe == this.table.length){
					return null;
				}
				if(this.table[index].equals(element)){
					return (T) this.table[index];
				}
				probe += 1;
				index = ((HashFunctionQuadraticProbing<T>) this.hashFunction).hash(element, probe);
			}
		}
		return null;
	}

	@Override
	public int indexOf(T element) {
		if(element != null){
			int probe = 0;
			int index = ((HashFunctionQuadraticProbing<T>) this.hashFunction).hash(element, probe);
			while(this.table[index] != null){
				if(table[index].equals(element)){
					return index;
				}
				probe += 1;
				index = ((HashFunctionQuadraticProbing<T>) this.hashFunction).hash(element, probe);
			}
		}
		return -1;
	}

}