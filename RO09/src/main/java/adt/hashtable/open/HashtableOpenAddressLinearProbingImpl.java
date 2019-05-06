package adt.hashtable.open;

import adt.hashtable.hashfunction.HashFunctionClosedAddressMethod;
import adt.hashtable.hashfunction.HashFunctionLinearProbing;

public class HashtableOpenAddressLinearProbingImpl<T extends Storable> extends AbstractHashtableOpenAddress<T> {

   public HashtableOpenAddressLinearProbingImpl(int size, HashFunctionClosedAddressMethod method) {
      super(size);
      hashFunction = new HashFunctionLinearProbing<T>(size, method);
      this.initiateInternalTable(size);
   }

   @Override
   public void insert(T element) {
      if (element != null) {
         int probe = 0;
         int index = ((HashFunctionLinearProbing<T>) this.hashFunction).hash(element, probe);
         while (this.table[index] != null && !this.table[index].equals(new DELETED())) {
            if (this.table[index].equals(element)) {
               return;
            }
            if (probe == this.table.length) {
               throw new HashtableOverflowException();
            }
            probe += 1;
            index = ((HashFunctionLinearProbing<T>) this.hashFunction).hash(element, probe);
         }
         this.COLLISIONS += probe;
         this.table[index] = element;
         this.elements += 1;
      }
   }

   @Override
   public void remove(T element) {
      if (element != null) {
         int probe = 0;
         int index = ((HashFunctionLinearProbing<T>) this.hashFunction).hash(element, probe);
         while (this.table[index] != null) {
            if (probe == this.table.length) {
               throw new HashtableOverflowException();
            }
            if (this.table[index].equals(element)) {
               this.table[index] = new DELETED();
               this.elements -= 1;
               this.COLLISIONS -= probe;
               return;
            }
            probe += 1;
            index = ((HashFunctionLinearProbing<T>) this.hashFunction).hash(element, probe);
         }
      }
   }

   @Override
   public T search(T element) {
      if (element != null) {
         int probe = 0;
         int index = ((HashFunctionLinearProbing<T>) this.hashFunction).hash(element, probe);
         while (this.table[index] != null) {
            if (probe == this.table.length) {
               return null;
            }
            if (this.table[index].equals(element)) {
               return (T) this.table[index];
            }
            probe += 1;
            index = ((HashFunctionLinearProbing<T>) this.hashFunction).hash(element, probe);
         }
      }
      return null;
   }

   @Override
   public int indexOf(T element) {
      if (element != null) {
         int probe = 0;
         int index = ((HashFunctionLinearProbing<T>) this.hashFunction).hash(element, probe);
         while (this.table[index] != null) {
            if (table[index].equals(element)) {
               return index;
            }
            probe += 1;
            index = ((HashFunctionLinearProbing<T>) this.hashFunction).hash(element, probe);
         }
      }
      return -1;
   }

}
