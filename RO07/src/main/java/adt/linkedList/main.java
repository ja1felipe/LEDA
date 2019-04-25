package adt.linkedList;

public class main {
    public static void main(String[] args) {
        RecursiveSingleLinkedListImpl<Integer> a = new RecursiveSingleLinkedListImpl<>();
        System.out.println(a.isEmpty());
        a.insert(5);
        a.insert(4);
        a.insert(3);
        System.out.println(a.search(5));
        System.out.println(a.size());
        System.out.println(a.toArray());
    }
}
