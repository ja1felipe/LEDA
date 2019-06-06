package adt.skipList;

public class SkipListImpl<T> implements SkipList<T> {

   protected SkipListNode<T> root;
   protected SkipListNode<T> NIL;

   protected int maxHeight;

   protected double PROBABILITY = 0.5;

   public SkipListImpl(int maxHeight) {
      this.maxHeight = maxHeight;
      root = new SkipListNode(Integer.MIN_VALUE, maxHeight, null);
      NIL = new SkipListNode(Integer.MAX_VALUE, maxHeight, null);
      connectRootToNil();
   }

   /**
    * Faz a ligacao inicial entre os apontadores forward do ROOT e o NIL Caso
    * esteja-se usando o level do ROOT igual ao maxLevel esse metodo deve
    * conectar todos os forward. Senao o ROOT eh inicializado com level=1 e o
    * metodo deve conectar apenas o forward[0].
    */
   private void connectRootToNil() {
      for (int i = 0; i < maxHeight; i++) {
         root.forward[i] = NIL;
      }
   }

   @Override
   public void insert(int key, T newValue, int height) {
      SkipListNode[] update = new SkipListNode[this.maxHeight];
      SkipListNode<T> aux = this.root;
      for (int i = this.maxHeight - 1; i > -1; i--) {
         while (aux.getForward(i).getKey() < key) {
            aux = aux.getForward(i);
         }
         update[i] = aux;
      }
      aux = aux.getForward(0);
      if (aux.getKey() == key) {
         aux.setValue(newValue);
      } else {
         aux = new SkipListNode<>(key, height, newValue);
         for (int c = 0; c < height; c++) {
            aux.forward[c] = update[c].getForward(c);
            update[c].forward[c] = aux;
         }
      }

   }

   @Override
   public void remove(int key) {
      SkipListNode[] update = new SkipListNode[this.maxHeight];
      SkipListNode<T> aux = this.root;
      for (int i = this.maxHeight - 1; i > -1; i--) {
         while (aux.getForward(i).getKey() < key) {
            aux = aux.getForward(i);
         }
         update[i] = aux;
      }
      aux = aux.getForward(0);
      if (aux.getKey() == key) {
         for (int i = 0; i < this.maxHeight; i++) {
            if (!update[i].getForward(i).equals(aux)) {
               break;
            }
            update[i].forward[i] = aux.getForward(i);
         }
      }
   }

   @Override
   public int height() {
      int maior = 0;
      SkipListNode aux = this.root;
      while (aux.getKey() != Integer.MAX_VALUE) {
         if (aux.getForward().length > maior) {
            maior = aux.getForward().length;
         }
         aux.getForward(0);
      }
      return maior;
   }

   @Override
   public SkipListNode<T> search(int key) {
      SkipListNode<T> aux = this.root;
      for (int i = this.maxHeight - 1; i > -1; i--) {
         while (aux.getForward(i).getKey() < key) {
            aux = aux.getForward(i);
         }
      }
      aux = aux.getForward(0);
      if (aux.getKey() == key) {
         return aux;
      }
      return null;

   }

   @Override
   public int size() {
      SkipListNode<T> aux = this.root.getForward(0);
      int size = 0;
      while (aux.getKey() != Integer.MAX_VALUE) {
         size += 1;
         aux = aux.getForward(0);
      }
      return size;
   }

   @Override
   public SkipListNode<T>[] toArray() {
      SkipListNode[] array = new SkipListNode[this.size() + 2];
      SkipListNode<T> aux = this.root;
      int i = 0;
      while (aux.getKey() != Integer.MAX_VALUE) {
         array[i] = aux;
         aux = aux.getForward(0);
         i++;
      }
      array[i] = aux;
      return array;
   }

}
